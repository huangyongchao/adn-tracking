package mobi.xdsp.tracking.core.job;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import mobi.xdsp.tracking.common.AdTool;
import mobi.xdsp.tracking.common.DateTimeUtil;
import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.dto.SmartLinkDto;
import mobi.xdsp.tracking.dto.enums.PBStateE;
import mobi.xdsp.tracking.dto.enums.SychLockE;
import mobi.xdsp.tracking.entity.*;
import mobi.xdsp.tracking.mapper.ActivateMapper;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PublisherOfferMapper;
import mobi.xdsp.tracking.service.DataService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class CacheDataJob {
    @Autowired
    private OfferMapper offerMapper;
    @Autowired
    private ActivateMapper activateMapper;
    @Autowired
    private PublisherOfferMapper publisherOfferMapper;
    @Autowired
    private DataService dataService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${clickcapweight}")
    private float clickcapweight;
    @Autowired
    Mailer mailer;

    private static final Logger logger = LoggerFactory.getLogger(CacheDataJob.class);

    public static Set<Integer> LIVE_OFFER_ID = Sets.newHashSet();


    @Scheduled(cron = "* */3 * * * ?")
    public void cachePublisherOfferCap() {
        String start = DateTimeUtil.getDayStartStr();
        String end = DateTimeUtil.getDayEndStr();
        String sql = "select s.channelId as pid ,s.offerUId as oid ,count(*) convs  from activate s where s.status =1 and  s.channelId>3 and  s.insertTime between  '" + start + "' and  '" + end + "'  group by  s.channelId,s.offerUId";
        logger.warn("CACHECAP:" + sql);

        List<Map<String, Object>> DAY_CONVS = jdbcTemplate.queryForList(sql);
        logger.warn("CACHECAP:" + JSONObject.toJSONString(DAY_CONVS));

    }

    @Scheduled(cron = "* */2 * * * ?")
    public void updateOfferCacheJob() {
        try {
            if (CollectionUtils.isEmpty(CacheData.OFF_CACHE.keySet()) && LIVE_OFFER_ID.size() == 0) {
                return;
            }
            List<Integer> offids = Lists.newLinkedList();
            LIVE_OFFER_ID.addAll(CacheData.OFF_CACHE.keySet());

            offids.addAll(LIVE_OFFER_ID);
            OfferExample example = new OfferExample();
            example.createCriteria().andIdIn(offids);
            List<Offer> list = offerMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(list)) {

                Map<Integer, Offer> cache = Maps.newConcurrentMap();

                list.forEach(n -> {
                    cache.put(n.getId(), n);
                    AdTool.cacheOfferTargetHour(n);

                });
                CacheData.OFF_CACHE = cache;
            }
        } catch (Exception e) {
            mailer.sendErrorMail("Tracking Error: updateOfferCacheJob", e.getMessage() + "\n" + e.getLocalizedMessage());

            e.printStackTrace();
        }


    }

    /**
     * 更新缓存数据
     * <p>
     * 更新分机ClickCap
     */
    @Scheduled(cron = "* */2 * * * ?")
    public void updatePublisherOfferCacheJob() {
        try {

            if (CacheData.PUB_OFF_CACHE.size() == 0) {
                return;
            }
            List<Integer> offids = Lists.newLinkedList();
            List<Integer> publishers = Lists.newLinkedList();


            CacheData.PUB_OFF_CACHE.keySet().forEach(n -> {
                try {
                    String[] ids = n.split("_");
                    publishers.add(Integer.parseInt(ids[0]));
                    offids.add(Integer.parseInt(ids[1]));
                } catch (Exception e) {
                    mailer.sendErrorMail("Tracking Error: updatePublisherOfferCacheJob", e.getMessage() + "\n" + e.getLocalizedMessage());

                    e.printStackTrace();
                }
            });
            PublisherOfferExample example = new PublisherOfferExample();
            example.createCriteria().andOfferidIn(offids).andPublisheridIn(publishers);

            List<PublisherOffer> list = publisherOfferMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(list)) {
                Map<String, PublisherOffer> cache = Maps.newConcurrentMap();

                list.forEach(n -> {
                    String pokey = n.getPublisherid() + "_" + n.getOfferid();
                    cache.put(pokey, n);
                    if (n.getClickcap() > 0) {
                        Float clickCap = n.getClickcap() * clickcapweight;
                        CacheData.PUB_OFF_CLICKCAP_CACHE.put(pokey, clickCap.intValue());
                    }


                    // end
                    /*//配置了SMT
                    try {
                        if (StringUtils.isNotBlank(n.getRedirectids()) && n.getRedirectids().indexOf("#") > 0) {

                            Arrays.stream(n.getRedirectids().split(",")).forEach(cf -> {

                                cf = cf.replaceAll(" ", "");
                                String[] smts = cf.split("#");
                                if (smts.length > 1) {
                                    String oid = smts[0];
                                    String wei = smts[1];
                                    Offer offer = CacheData.OFF_CACHE.get(Integer.parseInt(oid));
                                    if (offer != null) {
                                        CacheData.PUB_OFF_SMT_CACHE.put(pokey, new SmartLinkDto(Integer.parseInt(wei), offer.getId(), n.getPublisherid(), offer.getTrackurl()));
                                    }
                                }


                            });
                        } else {
                            CacheData.PUB_OFF_SMT_CACHE.remove(pokey);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }*/

                    // 10196581#1,10196574#1,10196555#6


                });
                CacheData.PUB_OFF_CACHE = cache;
            }
        } catch (Exception e) {
            mailer.sendErrorMail("Tracking Error: updatePublisherOfferCacheJob", e.getMessage() + "\n" + e.getLocalizedMessage());

            e.printStackTrace();
        }
        // 更新 重定向
        CacheData.PUB_OFF_CACHE.values().forEach(v -> {
            try {
                String pokey = v.getPublisherid() + "_" + v.getOfferid();

                if (StringUtils.isNotBlank(v.getRedirectids()) && !"-1".equalsIgnoreCase(v.getRedirectids())) {

                    String[] redirects = v.getRedirectids().split(",");
                    if (redirects != null && redirects.length > 0) {
                        List<Offer> offers = Lists.newLinkedList();
                        List<Integer> ids = Arrays.stream(redirects).map(id -> id.trim().replaceAll(" ", "")).map(id -> Integer.parseInt(id)).collect(Collectors.toList());
                        if (!CollectionUtils.isEmpty(ids)) {
                            ids.forEach(id -> {
                                Offer offer = dataService.cacheOfferFirst(id);
                                if (offer != null) {
                                    offers.add(offer);
                                }
                            });
                        }

                        CacheData.PUB_OFF_SMT_CACHE_OFFERS.put(pokey, offers);
                    } else {
                        CacheData.PUB_OFF_SMT_CACHE_OFFERS.remove(pokey);
                    }
                } else {
                    CacheData.PUB_OFF_SMT_CACHE_OFFERS.remove(pokey);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        logger.warn("OFFERREDIRECTS:{}", JSONObject.toJSONString(CacheData.PUB_OFF_SMT_CACHE_OFFERS));


    }


    //@Scheduled(cron = "* 29,59 * * * ?")
    public void capCache() {
        ActivateExample example = new ActivateExample();

        example.createCriteria().andStatusEqualTo(PBStateE.VALID.code).andChannelidGreaterThan(0)
                .andInserttimeBetween(
                        DateTimeUtil.getDayStart(), DateTimeUtil.getDayEnd());

        List<Activate> list = activateMapper.selectByExample(example);
        Map<String, AtomicInteger> capMap = Maps.newConcurrentMap();

        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(n -> {
                String key = n.getChannelid() + "-" + n.getOfferuid();
                if (capMap.containsKey(key)) {
                    capMap.get(key).incrementAndGet();
                } else {
                    capMap.put(key, new AtomicInteger(1));
                }
            });

            CacheData.DAILY_CAP_CACHE = capMap;

        }
    }


    public static void main(String[] args) {
        Date day = new Date();
        System.out.println(DateUtils.addDays(day, -1));
        System.out.println(DateUtils.addDays(day, 1));
    }

}
