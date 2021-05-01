package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.common.AddressUtils;
import mobi.xdsp.tracking.dto.ResponseModel;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Tracking {

    @RequestMapping(value = "/click")
    @ResponseBody
    public Object tracklist(@RequestParam(value = "a", required = true) Integer publisherid,
                            @RequestParam(value = "c", required = true) Integer offerid,
                            @RequestParam(value = "affsub", defaultValue = "") String affsub,
                            @RequestParam(value = "pub_subid", defaultValue = "") String pub_subid,
                            @RequestParam(value = "idfa", defaultValue = "") String idfa,
                            @RequestParam(value = "gaid", defaultValue = "") String gaid,
                            @RequestParam(value = "clickid", defaultValue = "") String pubClickId,
                            @RequestParam(value = "click_id", defaultValue = "") String pubClickId1,
                            @RequestParam(value = "deviceid", defaultValue = "") String deviceId,
                            @RequestParam(value = "device_id", defaultValue = "") String deviceId1,
                            @RequestParam(value = "sub1", defaultValue = "") String sub1,
                            @RequestParam(value = "sub2", defaultValue = "") String sub2,
                            @RequestParam(value = "appid", defaultValue = "") String appname,
                            String sub3, String sub4, String sub5,
                            HttpServletRequest request, HttpServletResponse response) throws Exception {

        /**
         * 目前请求的url 允许出现{} 符号的设置是在tomcat 目录 conf 下的 catalina.properties文件内部的如下参数
         * tomcat.util.http.parser.HttpParser.requestTargetAllow={}
         */
        //long startTimes = System.currentTimeMillis();
        //http://localhost:8081//a/c?a=1111&c=2222&device_id=sssss&click_id=ssss&affsub=aaa
        //http://tracking.startmobi.com/a/c?a={publisher_id}&c={offer_id}&device_id={device_id}&click_id=&affsub=
        //http://track.mobfireentertainment.com/data/click?cid=0BEuTsXMTwmMidnzq50U7A&affid=ycg0H0p-R6SVvnyqo-SXow&idfa=aaa&sub_aff=&sub_param1=iFM1V-2Bz-2Bl-ab2e0-11111111111111223123123123123123
        final String ip = AddressUtils.getClientIpAddr(request);

           /* //final String userAgent = request.getHeader("User-Agent");
            //子渠道ID不为空且子渠道ID长度等于64 则截取前64位,长度小于等于64位 则直接使用
            if (affsub == null) {
                affsub = "";
            }
            if (StringUtils.isEmpty(affsub) && !StringUtils.isEmpty(pub_subid)) {
                affsub = pub_subid;
            }
            if (!affsub.equals("")) {
                String oriAffsub = affsub;
                affsub = affsub.substring(0, DefaultCapConstant.PUBSUBID_SPLIT_LENGTH);
                logger.info("PUBSUBID SPLIT OPERATE: publisherid {},offerid {},original affsub {},after split affsub {}", publisherid, offerid, oriAffsub, affsub);
            }

            //subid 以渠道id开头 不要轻易修改,如果修改请将黑名单加载任务 一起修改
            String orisubid = affsub;

            if (StringUtils.isEmpty(deviceId)) {
                deviceId = deviceId1;
            }
            if (StringUtils.isEmpty(pubClickId)) {
                pubClickId = pubClickId1;
            }

            //SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //调节date格式
            //final String toDate = fmt.format(new Date());

            *//*验证publisher*//*
            Map<String, String> publisherMap = this.getMapFromCache(AppConstant.REDIS_KEY_PREFIX_PUBLISHER_MAP.concat(publisherid.toString()));
            if (!publisherMap.containsKey(AppConstant.STATUS_FIELD)) {
                logger.warn("BAD_REQUEST:{},{},{},{}", "publisher id error !", offerid, publisherid, pubClickId);
                return new ResponseModel(HttpStatus.SC_BAD_REQUEST, "publisher id error !");
            }
            String publisherStatus = publisherMap.get(AppConstant.STATUS_FIELD);

            if (!"1".equalsIgnoreCase(publisherStatus)) {
                logger.warn("BAD_REQUEST:{},{},{},{}", "publisher status error !", offerid, publisherid, pubClickId);
                return new ResponseModel(HttpStatus.SC_BAD_REQUEST, "publisher status error !");
            }

            //记录subid  为空则不处理
            if (!StringUtils.isEmpty(orisubid)) {
                Integer savePublisherId = publisherid;
                ExecutorPool.getExecutor().execute(() -> {
                    subIdService.saveSubidLog(savePublisherId, orisubid);
                });
            }

            *//*验证offer*//*
            Map<String, String> offerMap = this.getMapFromCache(AppConstant.REDIS_KEY_PREFIX_OFFER_MAP.concat(offerid.toString()));
            if (!offerMap.containsKey(AppConstant.STATUS_FIELD)) {
                logger.warn("BAD_REQUEST:{},{},{},{}", "offer offline !", offerid, publisherid, pubClickId);
                return new ResponseModel(HttpStatus.SC_BAD_REQUEST, "offer offline !");
            }

            String offerStatus = offerMap.get(AppConstant.STATUS_FIELD);
            if (!"1".equalsIgnoreCase(offerStatus)) {
                logger.warn("BAD_REQUEST:{},{},{},{}", "offer cap limit!", offerid, publisherid, pubClickId);
                return new ResponseModel(HttpStatus.SC_BAD_REQUEST, "offer cap limit!");
            }

            *//*   *//**//*如果offer不需要申请就直接跳转*//**//*
            if (offer.getApplytype() == OfferApplyEnum.NEEDLESS.getCode()) {
                long endTimes = System.currentTimeMillis();
                return redirect(clickid, publisherid, offerid, deviceId, response, trackurl, offer);
            }*//*

         *//*     *//**//*如果该广告主所有offer都不需要申请，也直接跳转*//**//*
            if (advertiser.getApplytype() == OfferApplyEnum.NEEDLESS.getCode()) {
                long endTimes = System.currentTimeMillis();

                return redirect(clickid, publisherid, offerid, deviceId, response, trackurl, offer);
            }*//*

         *//*验证offerApply信息*//*
            Map<String, String> OAMap = this.getMapFromCache(AppConstant.REDIS_KEY_PREFIX_OFFER_APPLY_MAP.concat(offerid.toString()));

            if (!OAMap.containsKey(publisherid.toString())) {
                logger.warn("BAD_REQUEST:{},{},{},{}", "unauthorized error 1 ,need apply", offerid, publisherid, pubClickId);
                return new ResponseModel(HttpStatus.SC_UNAUTHORIZED, " unauthorized error 1 ,need apply ");
            }*/
        response.sendRedirect("");
        return new ResponseModel(HttpStatus.SC_MOVED_TEMPORARILY, "success ");
    }
}
