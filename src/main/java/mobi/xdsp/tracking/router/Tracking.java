package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.common.AddressUtils;
import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.dto.ResponseModel;
import mobi.xdsp.tracking.dto.enums.OfferApplyStatusEnum;
import mobi.xdsp.tracking.dto.enums.StateE;
import mobi.xdsp.tracking.dto.enums.SychLockE;
import mobi.xdsp.tracking.entity.Affiliate;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.Publisher;
import mobi.xdsp.tracking.entity.PublisherOffer;
import mobi.xdsp.tracking.service.DataService;
import mobi.xdsp.tracking.service.TrackingHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
public class Tracking {
    @Value("${clickcapweight}")
    private float clickcapweight;
    @Autowired
    private DataService dataService;


    @Autowired
    private TrackingHandler handler;


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
                            @RequestParam(value = "appid", defaultValue = "") String appid,
                            @RequestParam(value = "appname", defaultValue = "") String appname,
                            HttpServletRequest request, HttpServletResponse response) throws Exception {


        /**
         * 目前请求的url 允许出现{} 符号的设置是在tomcat 目录 conf 下的 catalina.properties文件内部的如下参数
         * tomcat.util.http.parser.HttpParser.requestTargetAllow={}
         */
        //http://127.0.0.1:9192/click?pid=4&offer=2176&pub_sub=xxxxsss&idfa=testidfa&click_id=testclick&lang={lang}&ua={ua}&ip={ip}&appid={appid}&sub1={sub1}&sub2={sub2}



        final String clientip = AddressUtils.getClientIpAddr(request);

        if (publisherid == null || !CacheData.PUB_CACHE.containsKey(publisherid)) {
            return new ResponseModel(HttpStatus.SC_BAD_REQUEST, "Publisher not activate");
        }
        Publisher publisher = CacheData.PUB_CACHE.get(publisherid);
        if (StateE.INVALID.code == publisher.getState()) {
            return new ResponseModel(HttpStatus.SC_BAD_REQUEST, "Publisher not activate");
        }

        /**
         * 首次装载offer
         */
        if (offerid == null) {
            return new ResponseModel(HttpStatus.SC_BAD_REQUEST, "Offer was expired(-1)");

        }
        Offer offer = CacheData.OFF_CACHE.get(offerid);

        if (offer == null && !CacheData.OFF_SYCN_LOCK.containsKey(offerid)) {
            offer =  dataService.cacheOfferFirst(offerid);
        }
        if (!CacheData.OFF_SYCN_LOCK.containsKey(offerid) || CacheData.OFF_SYCN_LOCK.get(offerid) != SychLockE.LOCKED.code) {
            return new ResponseModel(HttpStatus.SC_BAD_REQUEST, "Offer was expired(0)");
        }

        if (StateE.INVALID.name.equals(offer.getStatus())) {
            return new ResponseModel(HttpStatus.SC_BAD_REQUEST, "Offer was expired(1)");
        }

        Affiliate affiliate = CacheData.AFF_CACHE.get(offer.getAffiliateid().intValue());
        if (affiliate == null || !StateE.VALID.name.equals(affiliate.getStatus())) {
            return new ResponseModel(HttpStatus.SC_BAD_REQUEST, "Offer was expired(2)");
        }


        String pokey = publisherid + "_" + offerid;
        PublisherOffer publisherOffer = CacheData.PUB_OFF_CACHE.get(pokey);
        /**
         * 首次装载PublisherOffer
         */
        if (publisherOffer == null && !CacheData.PUBOFF_SYCN_LOCK.containsKey(pokey)) {
            publisherOffer = dataService.cachePublisherOfferFirst(pokey, publisherid, offerid);
        }
        if (publisherOffer == null ||
                (!CacheData.PUBOFF_SYCN_LOCK.containsKey(pokey) || CacheData.PUBOFF_SYCN_LOCK.get(pokey) != SychLockE.LOCKED.code) ||
                OfferApplyStatusEnum.APPROVED.getCode() != publisherOffer.getState()) {
            return new ResponseModel(HttpStatus.SC_BAD_REQUEST, "Offer was expired(3)");
        }

        if(publisherOffer.getClickcap()>0){

        }

        Click click = new Click();

        click.setOid(offerid);
        click.setPid(publisherid);
        click.setPubSub(pubSub);
        click.setAppId(appid);
        click.setAppN(appname);
        click.setClickId(pubClickid);
        click.setIp(ip);
        click.setLang(lang);
        click.setCip(clientip);
        click.setGaid(gaid);
        click.setIdfa(idfa);
        click.setS1(sub1);
        click.setS2(sub2);
        Date clickDate = new Date();
        click.setCt(clickDate);
        click.setUa(ua);
        /*
        生成clickid
         */
        click.setId(handler.getClickId(click));
        /*
         * 混量
         */
        handler.mixSub(click, offer, publisherOffer);
        /*
        包装跳转链接
         */
        String finalTrackingUrl = handler.makeURL(click, offer);
        /*
       记录点击
         */
        handler.writeClicks(click,finalTrackingUrl, offer, publisherOffer);
        handler.countClicks(click, offer, publisherOffer);

        response.sendRedirect(finalTrackingUrl);
        return new ResponseModel(HttpStatus.SC_MOVED_TEMPORARILY, "success ");
    }
}
