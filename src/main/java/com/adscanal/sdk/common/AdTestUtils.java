package com.adscanal.sdk.common;

import com.adscanal.sdk.datafile.Collecter;
import com.adscanal.sdk.dto.LiveOffer;
import com.adscanal.sdk.dto.OsE;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Random;

/**
 * @author huangyongchao
 */
public class AdTestUtils {
    public static String urlEncode(String url) {
        if (url.indexOf("{") > -1) {
            url = StringUtils.replaceAll(url, "\\{", "%7B");
        }
        if (url.indexOf("}") > -1) {
            url = StringUtils.replaceAll(url, "\\}", "%7D");
        }
        return url;
    }

    public static String trackurl(String os, String track, String pubsub, String deviceid, String clickid, String appname) {
        if (track.indexOf("{pub_subid}") > -1 && StringUtils.isNotBlank(pubsub)) {
            track = StringUtils.replaceAll(track, "\\{pub_subid}", pubsub);
        }
        if (track.indexOf("{click_id}") > -1 && StringUtils.isNotBlank(clickid)) {
            track = StringUtils.replaceAll(track, "\\{click_id}", clickid);
        }
        if (track.indexOf("{device_id}") > -1 && StringUtils.isNotBlank(deviceid)) {
            track = StringUtils.replaceAll(track, "\\{device_id}", deviceid);
        }
        if (track.indexOf("{idfa}") > -1 && StringUtils.isNotBlank(deviceid)) {
            track = StringUtils.replaceAll(track, "\\{idfa}", deviceid);
        }
        if (track.indexOf("{store_appid}") > -1 && StringUtils.isNotBlank(appname)) {
            track = StringUtils.replaceAll(track, "\\{store_appid}", appname);
        }
        if (OsE.IOS.v.equalsIgnoreCase(os) && track.indexOf("{idfa}") == -1) {
            track = track + "&idfa=" + deviceid;
        }
        if (OsE.AOS.v.equalsIgnoreCase(os) && track.indexOf("{gaid}") == -1) {
            track = track + "&gaid=" + deviceid;
        }
        return track;

    }

    /**
     * geo char3
     * os 1 as ios  2 as android
     *
     * @param os
     * @return
     */
    public static String randomUA(String os) {

        List<String> uas = Collecter.OS_UA.get(os);
        int le = uas.size();
        int i = new Random().nextInt(le);
        return uas.get(i);
    }


    /**
     *
     * @param offers
     * @return
     */
    public static LiveOffer randomOffers(List<LiveOffer> offers) {
        if(offers ==null ){
            return null;
        }
        int le = offers.size();
        int i = new Random().nextInt(le);
        return offers.get(i);
    }


}
