package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.common.AdTool;
import mobi.xdsp.tracking.common.AddressUtils;
import mobi.xdsp.tracking.common.HttpClientUtil;
import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.core.ShutdownHookEvent;
import mobi.xdsp.tracking.core.job.CacheDataJob;
import mobi.xdsp.tracking.core.rtcr.RtCrMonitor;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.dto.MixTrack;
import mobi.xdsp.tracking.dto.ResponseModel;
import mobi.xdsp.tracking.dto.enums.OfferApplyStatusEnum;
import mobi.xdsp.tracking.dto.enums.RiskLevelE;
import mobi.xdsp.tracking.dto.enums.StateE;
import mobi.xdsp.tracking.entity.Affiliate;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.Publisher;
import mobi.xdsp.tracking.entity.PublisherOffer;
import mobi.xdsp.tracking.service.DataService;
import mobi.xdsp.tracking.service.TrackingHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Enumeration;
import java.util.Set;

@RestController
public class TrackingAPI {
    @Value("${clickcapweight}")
    private float clickcapweight;
    @Autowired
    private DataService dataService;
    @Autowired
    private TrackingHandler handler;

    private static final Logger testlog = LoggerFactory.getLogger("test");

    @CrossOrigin
    @GetMapping("/clicktest")
    public Object clicktest(@RequestParam(value = "pid", required = true) Integer publisherid,
                            @RequestParam(value = "offer", required = true) Integer offerid,
                            @RequestParam(value = "pub_sub", defaultValue = "") String pubSub,
                            @RequestParam(value = "idfa", defaultValue = "") String idfa,
                            @RequestParam(value = "gaid", defaultValue = "") String gaid,
                            @RequestParam(value = "click_id", defaultValue = "") String pubClickid,
                            @RequestParam(value = "postback_url", defaultValue = "") String postback_url,
                            HttpServletRequest request, HttpServletResponse response) throws Exception {
        Enumeration pNames = request.getParameterNames();
        while (pNames.hasMoreElements()) {
            String name = (String) pNames.nextElement();
            String value = request.getParameter(name);
            System.out.println(name + "=" + value);
        }
        String postback = "http://vapinteg.prod.sift.co/install?provider=PUBEARN+LIMITED1&provider_id=700&payout=0.01&mapped_params=" + pubClickid;
        System.out.println(postback);
        System.out.println(AdTool.urlEncode(postback));
        System.out.println(HttpClientUtil.get(AdTool.urlEncode(postback)));
        System.out.println(1);
        return "ok";


    }

    private static final Logger logger = LoggerFactory.getLogger(ConversionAPI.class);

    @CrossOrigin
    @GetMapping("/click")
    public Object tracklist(@RequestParam(value = "pid", required = true) Integer publisherid,
                            @RequestParam(value = "offer", required = true) Integer offerid,
                            @RequestParam(value = "pub_sub", defaultValue = "") String pubSub,
                            @RequestParam(value = "idfa", defaultValue = "") String idfa,
                            @RequestParam(value = "gaid", defaultValue = "") String gaid,
                            @RequestParam(value = "lang", defaultValue = "") String lang,
                            @RequestParam(value = "ip", defaultValue = "") String ip,
                            @RequestParam(value = "ua", defaultValue = "") String ua,
                            @RequestParam(value = "click_id", defaultValue = "") String pubClickid,
                            @RequestParam(value = "sub1", defaultValue = "") String sub1,
                            @RequestParam(value = "sub2", defaultValue = "") String sub2,
                            @RequestParam(value = "sub3", defaultValue = "") String sub3,
                            @RequestParam(value = "sub4", defaultValue = "") String sub4,
                            @RequestParam(value = "sub5", defaultValue = "") String sub5,
                            @RequestParam(value = "sub6", defaultValue = "") String sub6,
                            @RequestParam(value = "appid", defaultValue = "") String appid,
                            @RequestParam(value = "appname", defaultValue = "") String appname,
                            HttpServletRequest request, HttpServletResponse response) throws Exception {


        /**
         * ???????????????url ????????????{} ?????????????????????tomcat ?????? conf ?????? catalina.properties???????????????????????????
         * tomcat.util.http.parser.HttpParser.requestTargetAllow={}
         */
        //http://127.0.0.1:9192/click?pid=4&offer=2176&pub_sub=xxxxsss&idfa=testidfa&click_id=testclick&lang={lang}&ua={ua}&ip={ip}&appid={appid}&sub1={sub1}&sub2={sub2}

        //http://127.0.0.1:9192/click?pid=1005&offer=2311784&pub_sub=814434508&idfa=2012A207-2D15-4090-A0FB-F557DAF2BD25&click_id=270441375

        String t = request.getParameter("t");
        if (t != null && "1".equals(t)) {
            testlog.info(request.getQueryString());
            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String key = (String) headerNames.nextElement();
                String value = request.getHeader(key);
                testlog.info(key + " : " + value);
            }
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    testlog.info(cookie.getName() + " : " + cookie.getValue());

                }
            }

        }
        if (ShutdownHookEvent.SHUTDOWN) {
            return new ResponseModel(HttpStatus.SC_INTERNAL_SERVER_ERROR, "Shutdown Server");

        }
        final String clientip = AddressUtils.getClientIpAddr(request);
        if (publisherid == null || !CacheData.PUB_CACHE.containsKey(publisherid)) {
            return new ResponseModel(HttpStatus.SC_FORBIDDEN, "Publisher not activate");
        }
        Publisher publisher = CacheData.PUB_CACHE.get(publisherid);
        if (StateE.INVALID.code == publisher.getState()) {
            return new ResponseModel(HttpStatus.SC_BAD_REQUEST, "Publisher not activate");
        }

        /**
         * ????????????offer
         */
        if (offerid == null) {
            return new ResponseModel(HttpStatus.SC_FORBIDDEN, "Offer was expired(-1)");

        }
        if (!CacheDataJob.LIVE_OFFER_ID.contains(offerid)) {
            CacheDataJob.LIVE_OFFER_ID.add(offerid);
        }
        Offer offer = CacheData.OFF_CACHE.get(offerid);
        if (offer == null) {
            offer = dataService.cacheOfferFirst(offerid);
        }
        if (offer == null) {
            return new ResponseModel(HttpStatus.SC_FORBIDDEN, "Offer was expired(0)");
        }
        offer = handler.checkRedictOffer(offer);

        if (StateE.INVALID.name.equals(offer.getStatus())) {
            return new ResponseModel(HttpStatus.SC_FORBIDDEN, "Offer was expired(1)");
        }

        if (offer.getRisklevel() != null && offer.getRisklevel() == RiskLevelE.CRHIGH.code) {
            //CR??? ????????????
           // return new ResponseModel(HttpStatus.SC_FORBIDDEN, "Offer was limited requst now .please request later");
        }

        //target hour
        Set<Integer> off_tars = CacheData.OFF_TARGET_CACHE.get(offer.getId());
        if (!CollectionUtils.isEmpty(off_tars)) {
            int hour = LocalDateTime.now(ZoneOffset.UTC).getHour();
            if (!off_tars.contains(hour)) {
                return new ResponseModel(HttpStatus.SC_FORBIDDEN, "Offer Target Hour Error");
            }
        }
        //target hour end
        Affiliate affiliate = CacheData.AFF_CACHE.get(offer.getAffiliateid().intValue());
        if (affiliate == null || !StateE.VALID.name.equals(affiliate.getStatus())) {
            return new ResponseModel(HttpStatus.SC_FORBIDDEN, "Offer was expired(2)");
        }


        String pokey = publisherid + "_" + offerid;
        PublisherOffer publisherOffer = CacheData.PUB_OFF_CACHE.get(pokey);
        /**
         * ????????????PublisherOffer
         */
        if (publisherOffer == null) {
            publisherOffer = dataService.cachePublisherOfferFirst(pokey, publisherid, offerid);
        }


        if (publisherOffer.getClickcap() > 0) {

        }

        //????????????????????? offer ???????????????offer
        if (CacheData.PUB_OFF_SMT_CACHE_OFFERS.containsKey(pokey)) {
            MixTrack oriTrack = new MixTrack(offer, pokey, publisherOffer);

            MixTrack selectTrack = handler.selectRedirect(CacheData.PUB_OFF_SMT_CACHE_OFFERS.get(pokey), oriTrack);

            if (selectTrack != null
                    && selectTrack.getPublisherOffer() != null
                    && selectTrack.getOffer() != null
                    && selectTrack.getPoKey() != null
            ) {
                publisherOffer = selectTrack.getPublisherOffer();
                offer = selectTrack.getOffer();
                pokey = selectTrack.getPoKey();
            } else {
                return new ResponseModel(HttpStatus.SC_FORBIDDEN, "Offer cap full or Offer paused (3)");

            }

        }

        // end

        if (publisherOffer != null && (publisherOffer.getState() == OfferApplyStatusEnum.HOURCAPFULL.getCode())) {
            return new ResponseModel(HttpStatus.SC_FORBIDDEN, "hours cap  is full,please request on the next hours");
        }

        if (publisherOffer == null ||
                OfferApplyStatusEnum.APPROVED.getCode() != publisherOffer.getState()) {
            return new ResponseModel(HttpStatus.SC_FORBIDDEN, "Offer was expired(3)");
        }
        if (dataService.capFull(publisherOffer, pokey)) {
            return new ResponseModel(HttpStatus.SC_FORBIDDEN, "Offer daiy Cap was full ");
        }

        if (StringUtils.isBlank(pubClickid) && StringUtils.isNotBlank(sub3)) {
            pubClickid = sub3;
        }
        if (StringUtils.isBlank(pubSub) && StringUtils.isNotBlank(sub4)) {
            pubSub = sub4;
        }
        if (StringUtils.isBlank(idfa) && StringUtils.isNotBlank(sub5)) {
            idfa = sub5;
        }
        if (StringUtils.isBlank(gaid) && StringUtils.isNotBlank(sub6)) {
            gaid = sub6;
        }

        String rua = request.getHeader("User-Agent");
        Click click = new Click();

        click.setOid(publisherOffer.getOfferid());
        click.setPid(publisherOffer.getPublisherid());
        click.setPubSub(pubSub);
        click.setAppId(appid);
        click.setAppN(appname);
        click.setClickId(pubClickid);
        click.setIp(ip);
        click.setLang(lang);
        click.setCip(clientip);
        click.setGaid(gaid);
        click.setIdfa(idfa);
        click.setUa(rua);
        click.setS1(sub1);
        click.setS2(sub2);
        Date clickDate = new Date();
        click.setCt(clickDate);
        /*
        ??????clickid
         */
        click.setId(AdTool.createClickIdByPlatform(click));
        /*
         * ??????
         */
        handler.mixSub(click, offer, publisherOffer);
        /*
        ??????????????????
         */
        String finalTrackingUrl = handler.makeURL(click, offer);
        /*
       ????????????
         */
        handler.writeClicks(click, finalTrackingUrl, offer, publisherOffer);
        handler.countClicks(click, offer, publisherOffer);
        RtCrMonitor.increaseClicks(pokey, click.getPid(), click.getOid());
        response.sendRedirect(finalTrackingUrl);
        return new ResponseModel(HttpStatus.SC_MOVED_TEMPORARILY, "success ");
    }
}
