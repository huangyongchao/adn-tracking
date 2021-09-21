package mobi.xdsp.tracking.router;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import mobi.xdsp.tracking.common.AdTool;
import mobi.xdsp.tracking.common.HttpClientUtil;
import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.dto.affise.*;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 每20分钟查询一次 ,20分钟之内.返回缓存
     */
    public static Map<String, Date> QUERY_LOCK = Maps.newHashMap();
    public static Map<String, OfferApiResponse> QUERY_CACHE = Maps.newHashMap();

    @Autowired
    Mailer mailer;

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

    @RequestMapping(path = "affiseoffers", method = {RequestMethod.POST, RequestMethod.GET})
    public Object offersaffise(HttpServletRequest request) {
        String apikey = request.getHeader("API-Key");

        if (StringUtils.isBlank(apikey)) {
            String apikey1 = request.getParameter("API-Key");
            if (StringUtils.isBlank(apikey1)) {
                apikey = apikey1;
            } else {
                apikey = request.getParameter("token");
            }

        }
        if (StringUtils.isBlank(apikey)) {
            return new AffiseResponse(2, "Invalid Token");
        } else {
            OfferApiResponse response = offers(apikey);
            if (!response.isSuccess()) {
                return new AffiseResponse(3, response.getMsg());

            } else {
                if (CollectionUtils.isEmpty(response.getOffers())) {
                    return new AffiseResponse(4, Lists.newLinkedList(), new Pagination(1000, 0, 1));
                } else {
                    List<AffiseOffer> offers = Lists.newLinkedList();
                    response.getOffers().forEach(offers1 -> {
                        AffiseOffer o = new AffiseOffer();
                        o.setId(offers1.getId());
                        o.setOffer_id(offers1.getId() + offers1.getGeo());
                        o.setCategories(Lists.newArrayList(offers1.getCategory()));
                        Kpi kpi = new Kpi();
                        kpi.setEn(offers1.getKpis());

                        o.setKpi(kpi);
                        Links links = new Links();
                        links.setTitle("click");
                        links.setUrl(offers1.getTrackingUrl());
                        o.setLinks(Lists.newArrayList(links));
                        o.setTitle(offers1.getName());
                        Description_lang description_lang = new Description_lang();
                        description_lang.setEn(offers1.getDescription());
                        o.setDescription_lang(description_lang);

                        o.setPreview_url(offers1.getPreviewUrl());
                        Caps cap = new Caps();
                        cap.setPeriod("day");
                        cap.setGoal_type("all");
                        cap.setValue(offers1.getDailyCap());
                        cap.setCountry_type(offers1.getGeo());
                        cap.setType("2");
                        o.setCaps(Lists.newArrayList(cap));
                        Payments payments = new Payments();
                        payments.setOs(Lists.newArrayList(offers1.getOs()));
                        payments.setRevenue(offers1.getPayout());
                        payments.setCurrency(offers1.getCurrency());
                        payments.setCountries(Lists.newArrayList(offers1.getGeo()));
                        payments.setDevices(Lists.newArrayList("Mobile"));
                        payments.setGoal(offers1.getPayEvent());
                        payments.setType("fixed");
                        payments.setTitle(offers1.getPayoutType());

                        o.setPayments(Lists.newArrayList(payments));
                        o.setStrictly_country(1);
                        Strictly_os strictly_os = new Strictly_os();
                        Items items = new Items();
                        if (OsE.iOS.name().equalsIgnoreCase(offers1.getOs())) {

                            items.setIOS(Lists.newArrayList(StringUtils.isBlank(offers1.getMinOsVersion()) ? "13.0" : offers1.getMinOsVersion()));
                        } else {
                            items.setAndroid(Lists.newArrayList(StringUtils.isBlank(offers1.getMinOsVersion()) ? "13.0" : offers1.getMinOsVersion()));

                        }
                        strictly_os.setItems(items);
                        o.setStrictly_os(strictly_os);
                        if ("cpi".equalsIgnoreCase(offers1.getPayoutType())) {
                            o.setIs_cpi(true);
                        } else {
                            o.setIs_cpi(false);
                        }
                        o.setUse_http(true);
                        o.setUse_https(false);
                        Targeting targeting = new Targeting();
                        Os os = new Os();
                        Allow allow = new Allow();
                        allow.setName(offers1.getOs());
                        allow.setComparison("GTE");
                        allow.setVersion(offers1.getMinOsVersion());
                        os.setAllow(Lists.newArrayList(allow));
                        targeting.setOs(os);
                        Country country = new Country();
                        country.setAllow(Lists.newArrayList(offers1.getGeo()));

                        targeting.setCountry(country);
                        o.setTargeting(Lists.newArrayList(targeting));
                        o.setConsider_personal_targeting_only(false);
                        o.setCountries(Lists.newArrayList(offers1.getGeo()));
                        o.setHosts_only(false);
                        o.setUniq_ip_only(true);
                        o.setReject_not_uniq_ip(1);
                        offers.add(o);

                    });
                    return new AffiseResponse(1, offers, new Pagination(1000, offers.size(), 1));

                }

            }
        }
    }

    @RequestMapping(path = "offers", method = {RequestMethod.POST, RequestMethod.GET})
    public OfferApiResponse offers(@RequestParam(value = "token", required = true) String token) {


        if (StringUtils.isBlank(token)) {
            return new OfferApiResponse(false, "Invalid token", null, false);
        }
        Publisher pub = CacheData.PUB_TOKEN.get(token);
        if (pub == null) {
            pub = dataService.cachePublisherByToken(token);
            if (pub != null) {
                CacheData.PUB_TOKEN.put(token, pub);
            }
        }
        if (pub == null) {
            return new OfferApiResponse(false, "Invalid token", null, false);
        }
        final Publisher publisher = pub;
        if (StateE.INVALID.code == publisher.getState()) {
            return new OfferApiResponse(false, "Publisher have been stop.", null, false);

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
                        respO.setPayEvent(n.getCreatives());
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
                            String p = AdTool.createClickIdByMMP(publisher.getId(), n.getId());
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
                            String trackDomain = "http://tracking.pubearn.com";
                            if (publisher.getInnercompany() != null && publisher.getInnercompany() == 3) {
                                trackDomain = "http://tracking.snailmedia.cn";
                            }
                            StringBuilder track = new StringBuilder(trackDomain + "/click?");

                            track.append("pid=" + publisher.getId());
                            track.append("&offer=" + respO.getId());
                            track.append("&pub_sub={pub_sub}&");
                            if ("ios".equalsIgnoreCase(n.getOs())) {

                                track.append("idfa={idfa}&");
                            } else {

                                track.append("gaid={gaid}&");
                            }
                            track.append("click_id={click_id}");
                            if (n.getTrackurl().indexOf("store_appid") > 0) {
                                track.append("&appid={appid}");
                            }
                            if (n.getIsattrs()) {
                                track.append("&lang={lang}");
                                track.append("&ua={ua}");
                                track.append("&ip={ip}");
                            }
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
