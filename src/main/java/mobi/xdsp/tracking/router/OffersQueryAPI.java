package mobi.xdsp.tracking.router;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import mobi.xdsp.tracking.common.HttpClientUtil;
import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.dto.enums.OfferApplyStatusEnum;
import mobi.xdsp.tracking.dto.enums.OsE;
import mobi.xdsp.tracking.dto.enums.StateE;
import mobi.xdsp.tracking.dto.offerapi.OfferApiResponse;
import mobi.xdsp.tracking.dto.offerapi.Offers;
import mobi.xdsp.tracking.entity.*;
import mobi.xdsp.tracking.mapper.AffiliateMapper;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PublisherOfferMapper;
import mobi.xdsp.tracking.service.DataService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class OffersQueryAPI {
    private String trackDomain = "http://tracking.pubearn.com";

    /**
     * 每20分钟查询一次 ,20分钟之内.返回缓存
     */
    private Map<String, Date> QUERY_LOCK = Maps.newHashMap();
    private Map<String, OfferApiResponse> QUERY_CACHE = Maps.newHashMap();

    private boolean isCache(String token) {
        boolean returnCache = false;
        if (QUERY_LOCK.containsKey(token)) {
            Date queryDate = new Date();
            Date oldDate = QUERY_LOCK.get(token);
            int minutes = (int) ((queryDate.getTime() - oldDate.getTime()) / (1000 * 60));
            if (minutes < 20) {
                returnCache = true;
            }
        }
        return returnCache;

    }

    @Autowired
    private WebApplicationContext applicationContext;
    @Autowired
    private OfferMapper offerMapper;
    @Autowired
    private AffiliateMapper affiliateMapper;

    @Autowired
    private PublisherOfferMapper publisherOfferMapper;

    @Autowired
    private DataService dataService;
    @GetMapping("/offers")
    public Object offers(@RequestParam(value = "token", required = true) String token) {
        if (StringUtils.isBlank(token)) {
            return new OfferApiResponse(false, "Invalid token", null, false);
        }
        Publisher publisher = null;
        if(!CacheData.PUB_TOKEN.containsKey(token)){
            publisher = dataService.cachePublisherByToken(token);
            if(publisher!=null){

                CacheData.PUB_TOKEN.put(token, publisher);
            }
        }else{
            publisher = CacheData.PUB_TOKEN.get(token);
        }
        if(publisher ==null){
            return new OfferApiResponse(false, "Invalid token", null, false);
        }
        if (isCache(token)) {
            return QUERY_CACHE.get(token);
        }
        OfferApiResponse response = null;

        PublisherOfferExample example = new PublisherOfferExample();
        example.createCriteria().andPublisheridEqualTo(publisher.getId()).andStateEqualTo(OfferApplyStatusEnum.APPROVED.getCode());

        AffiliateExample affiliateExample = new AffiliateExample();
        affiliateExample.createCriteria().andStatusEqualTo(StateE.VALID.name);

        List<PublisherOffer> list = publisherOfferMapper.selectByExample(example);

        if (!CollectionUtils.isEmpty(list)) {
            List<Affiliate> affiliateList = affiliateMapper.selectByExample(affiliateExample);
            List<Short> affids = affiliateList.stream().map(n -> n.getId().shortValue()).collect(Collectors.toList());

            List<Integer> offerids = list.stream().map(n -> n.getOfferid()).collect(Collectors.toList());

            OfferExample offerExample = new OfferExample();
            offerExample.createCriteria().andAffiliateidIn(affids).andIdIn(offerids).andStatusEqualTo(StateE.VALID.name);

            List<Offer> offers = offerMapper.selectByExample(offerExample);
            Map<Integer, List<PublisherOffer>> puboffmap = list.stream().collect(Collectors.groupingBy(PublisherOffer::getOfferid));
            if (!CollectionUtils.isEmpty(offers)) {
                response = new OfferApiResponse();
                List<Offers> resoffs = Lists.newLinkedList();
                offers.forEach(n -> {
                    Offers respO = new Offers();
                    if (StringUtils.isBlank(n.getOs()) || StringUtils.isBlank(n.getCountries())) {
                        return;
                    }
                    if (puboffmap.containsKey(n.getId())) {
                        PublisherOffer publisherOffer = puboffmap.get(n.getId()).get(0);
                        respO.setAppId(n.getAppid());
                        respO.setIosATT(n.getIsattrs());
                        respO.setClickCap(publisherOffer.getClickcap());
                        respO.setBlacklist("");
                        respO.setWhitelist("");
                        respO.setCurrency(StringUtils.isBlank(n.getCurrency()) ? "USD" : n.getCurrency());
                        respO.setDailyCap(publisherOffer.getDailycap());
                        respO.setDescription(n.getDescription());
                        respO.setRestrictions(n.getRestrictions());
                        respO.setGeo(n.getCountries());
                        respO.setId(n.getId());
                        respO.setIncent(false);
                        respO.setKpis(n.getKpis());
                        respO.setMinOsVersion(n.getMinos());
                        respO.setOs(n.getOs().toLowerCase(Locale.ROOT));
                        respO.setMonthlyCap(publisherOffer.getMonthcap());
                        respO.setPayout(publisherOffer.getPayout().floatValue());
                        respO.setName(n.getOffername());
                        respO.setPreviewUrl(n.getPreviewurl());
                        respO.setAppName(n.getAppname());
                        if (respO.getPreviewUrl() == null || "null".equalsIgnoreCase(respO.getPreviewUrl())) {
                            if ("ios".equalsIgnoreCase(n.getOs())) {
                                respO.setPreviewUrl("https://apps.apple.com/app/id" + n.getAppid());
                            } else {
                                respO.setPreviewUrl("https://play.google.com/store/apps/details?id=" + n.getAppid());
                            }
                        }
                        respO.setPayoutType(n.getPayouttype());
                        respO.setCategory(n.getCategoryname());
                        if (n.getOffername().indexOf(" CPA") > -1) {
                            respO.setPayoutType("CPA");
                        }
                        if (n.getOffername().indexOf(" CPI") > -1) {
                            respO.setPayoutType("CPI");
                        }
                        if (n.getOffername().indexOf(" CPR") > -1) {
                            respO.setPayoutType("CPR");
                        }
                        if (n.getOffername().indexOf(" CPE") > -1) {
                            respO.setPayoutType("CPE");
                        }
                        if (n.getOffername().indexOf(" CPO") > -1) {
                            respO.setPayoutType("CPO");
                        }
                        if (n.getOffername().indexOf(" CPS") > -1) {
                            respO.setPayoutType("CPS");
                        }
                        if (n.getOffername().indexOf(" CPL") > -1) {
                            respO.setPayoutType("CPL");
                        }
                        /*直接走上游链接*/
                        if (publisherOffer.getTrackingtype() != null && publisherOffer.getTrackingtype() == 1) {
                            String p = "DI" + publisher.getId() + "-" + n.getId() + "-{click_id}";
                            String track = n.getTrackurl();

                            if (track.indexOf("{click_id}") > -1) {
                                track = StringUtils.replaceAll(track, "\\{click_id}", p);
                            }
                            if (track.indexOf("{clickid}") > -1) {
                                track = StringUtils.replaceAll(track, "\\{clickid}", p);
                            }
                            if (track.indexOf("{pub_subid}") > -1) {
                                track = StringUtils.replaceAll(track, "\\{pub_subid}", "{pub_sub}");
                            }
                            if (OsE.iOS.key.equalsIgnoreCase(n.getOs())) {
                                if (track.indexOf("{device_id}") > -1) {
                                    track = StringUtils.replaceAll(track, "\\{device_id}", "{idfa}");
                                }
                            } else {
                                if (track.indexOf("{device_id}") > -1) {
                                    track = StringUtils.replaceAll(track, "\\{device_id}", "{gaid}");
                                }
                                if (track.indexOf("{advertiser_id}") > -1) {
                                    track = StringUtils.replaceAll(track, "\\{advertiser_id}", "{gaid}");
                                }
                            }
                            if (track.indexOf("{store_appid}") > -1) {
                                track = StringUtils.replaceAll(track, "\\{store_appid}", "{appid}");
                            }

                            respO.setTrackingUrl(track);
                            respO.setS2sLink(true);

                        } else {
                            /*走平台链接*/
                            StringBuilder track = new StringBuilder(trackDomain + "/click?");

                            track.append("pid=" + publisher.getId());
                            track.append("&offer=" + respO.getId());
                            track.append("&pub_sub={pub_sub}&");
                            if ("ios".equalsIgnoreCase(n.getOs())) {

                                track.append("idfa={idfa}&");
                            } else {

                                track.append("gaid={gaid}&");
                            }
                            track.append("click_id={click_id}&");
                            track.append("lang={lang}&");
                            track.append("ua={ua}&");
                            track.append("ip={ip}&");
                            track.append("appid={appid}&");
                            track.append("sub1={sub1}&");
                            track.append("sub2={sub2}");
                            respO.setTrackingUrl(track.toString());
                            respO.setS2sLink(false);
                        }


                        resoffs.add(respO);
                    }
                });

                response.setOffers(resoffs);
                response.setSuccess(true);
                response.setNext(false);

                QUERY_CACHE.put(token, response);
                QUERY_LOCK.put(token, new Date());


            }

        }

        if (response == null) {
            response = new OfferApiResponse(true, "No available offers", Lists.newLinkedList(), false);
        }
        return response;
    }

    public static void main(String[] args) {
/*
        &deviceid=&subid=&event=
*/

        try {
            Files.lines(Paths.get("/Users/huangyongchao/Downloads/click.log")).parallel().forEach(n -> {
                try {
                    System.out.println(HttpClientUtil.get("http://callback.adscanal.com/mafcons?offerid=&clickid=" + URLEncoder.encode(n, "utf-8")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
