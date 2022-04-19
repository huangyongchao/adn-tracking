package mobi.xdsp.tracking.core.job;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import mobi.xdsp.tracking.common.AdTool;
import mobi.xdsp.tracking.common.DateTimeUtil;
import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.dto.enums.PBStateE;
import mobi.xdsp.tracking.dto.enums.SychLockE;
import mobi.xdsp.tracking.entity.*;
import mobi.xdsp.tracking.mapper.ActivateMapper;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PublisherOfferMapper;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CacheDataJob {
    @Autowired
    private OfferMapper offerMapper;
    @Autowired
    private ActivateMapper activateMapper;
    @Autowired
    private PublisherOfferMapper publisherOfferMapper;
    @Value("${clickcapweight}")
    private float clickcapweight;
    @Autowired
    Mailer mailer;

    private static final Logger clicklog = LoggerFactory.getLogger("click");

    public static Set<Integer> LIVE_OFFER_ID = Sets.newHashSet();

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
    @Scheduled(cron = "* */25 * * * ?")
    public void updatePublisherOfferCacheJob() {
        try {
            Set<String> setids = CacheData.PUBOFF_SYCN_LOCK.keySet();
            if (setids.size() == 0) {
                return;
            }

            List<Integer> offids = Lists.newLinkedList();
            List<Integer> publishers = Lists.newLinkedList();
            CacheData.PUBOFF_SYCN_LOCK.keySet().forEach(n -> {
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
                Map<String, Integer> lock = Maps.newConcurrentMap();
                Map<String, PublisherOffer> cache = Maps.newConcurrentMap();

                list.forEach(n -> {
                    String pokey = n.getPublisherid() + "_" + n.getOfferid();

                    lock.put(pokey, SychLockE.LOCKED.code);
                    cache.put(pokey, n);
                    if (n.getClickcap() > 0) {
                        Float clickCap = n.getClickcap() * clickcapweight;
                        CacheData.PUB_OFF_CLICKCAP_CACHE.put(pokey, clickCap.intValue());
                    }
                });
                CacheData.PUBOFF_SYCN_LOCK = lock;
                CacheData.PUB_OFF_CACHE = cache;
            }
        } catch (Exception e) {
            mailer.sendErrorMail("Tracking Error: updatePublisherOfferCacheJob", e.getMessage() + "\n" + e.getLocalizedMessage());

            e.printStackTrace();
        }


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
