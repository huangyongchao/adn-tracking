package com.adscanal.sdk.common;

import com.adscanal.sdk.datafile.Collecter;
import com.adscanal.sdk.dto.*;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangyongchao
 */
public class AdTool {
    public static String urlEncode(String url,String deviceid,String os) {
        if (url.indexOf("{") > -1) {
            url = StringUtils.replaceAll(url, "\\{", "%7B");
        }
        if (url.indexOf("}") > -1) {
            url = StringUtils.replaceAll(url, "\\}", "%7D");
        }
        if(url.indexOf("appsflyer.com")>0){
            if (OsE.IOS.name.equalsIgnoreCase(os) && url.indexOf("idfa") == -1) {
                url = url + "&idfa=" + deviceid;
            }
            if (OsE.AOS.name.equalsIgnoreCase(os) && url.indexOf("advertising_id") == -1) {
                url = url + "&advertising_id=" + deviceid;
            }

            url = url + "&redirect=false";
        }else if(url.indexOf(".adjust.")>0){
            if (OsE.IOS.name.equalsIgnoreCase(os) && url.indexOf("idfa") == -1) {
                url = url + "&idfa=" + deviceid;
            }
            if (OsE.AOS.name.equalsIgnoreCase(os) && url.indexOf("gps_adid") == -1) {
                url = url + "&gps_adid=" + deviceid;
            }

          //  url = url + "&redirect=none";
        }
        if (url.indexOf("{idfa}") > -1 && StringUtils.isNotBlank(deviceid)) {
            url = StringUtils.replaceAll(url, "\\{idfa}", deviceid);
        }
        if (url.indexOf("{gaid}") > -1 && StringUtils.isNotBlank(deviceid)) {
            url = StringUtils.replaceAll(url, "\\{gaid}", deviceid);
        }


        return url;
    }

    static Random random100 = new Random();
    static Random random5 = new Random();
    static Random random1000 = new Random();
    static List<String> subprefix = Lists.newArrayList("K", "D", "B", "V");
    static int r = subprefix.size();

    public static String trackurl(String os, String track, String pubsub, String deviceid, String clickid, String appname) {
        if (track.indexOf("{pub_subid}") > -1 && StringUtils.isNotBlank(pubsub)) {
            track = StringUtils.replaceAll(track, "\\{pub_subid}", pubsub);
        }
        if (track.indexOf("{hour}") > -1) {
            track = StringUtils.replaceAll(track, "\\{hour}", "" + Counter.CURRENT_HOUR);
        }
        if (track.indexOf("{click_id}") > -1 && StringUtils.isNotBlank(clickid)) {
            track = StringUtils.replaceAll(track, "\\{click_id}", clickid);
        }
        if (track.indexOf("{campaign100}") > -1) {
            track = StringUtils.replaceAll(track, "\\{campaign100}", String.valueOf(random100.nextInt(100)));
        }
        if (track.indexOf("{campaign1000}") > -1) {
            track = StringUtils.replaceAll(track, "\\{campaign100}", String.valueOf(random1000.nextInt(1000)));
        }
        if (track.indexOf("{campaign10}") > -1) {
            track = StringUtils.replaceAll(track, "\\{campaign10}", String.valueOf(random100.nextInt(10)));
        }
        if (track.indexOf("{ios}") > -1) {
            track = StringUtils.replaceAll(track, "\\{ios}", OsE.IOS.name);
        }
        if (track.indexOf("{android}") > -1) {
            track = StringUtils.replaceAll(track, "\\{android}", OsE.AOS.name);
        }
        int s = random5.nextInt(r);
        if (track.indexOf("{pubid}") > -1) {
            track = StringUtils.replaceAll(track, "\\{pubid}", "" + (1500 + random100.nextInt(100) + s));
        }
        if (track.indexOf("{subid}") > -1) {

            track = StringUtils.replaceAll(track, "\\{subid}", subprefix.get(s) + (100 + s));
        }
        if (track.indexOf("{device_id}") > -1 && StringUtils.isNotBlank(deviceid)) {
            track = StringUtils.replaceAll(track, "\\{device_id}", deviceid);
        }
        if (OsE.IOS.name.equalsIgnoreCase(os) && track.indexOf("{idfa}") == -1) {
            track = track + "&idfa=" + deviceid;
        }
        if (OsE.AOS.name.equalsIgnoreCase(os) && track.indexOf("{gaid}") == -1) {
            track = track + "&gaid=" + deviceid;
        }
        if (track.indexOf("{idfa}") > -1 && StringUtils.isNotBlank(deviceid)) {
            track = StringUtils.replaceAll(track, "\\{idfa}", deviceid);
        }
        if (track.indexOf("{gaid}") > -1 && StringUtils.isNotBlank(deviceid)) {
            track = StringUtils.replaceAll(track, "\\{gaid}", deviceid);
        }
        if (track.indexOf("{store_appid}") > -1 && StringUtils.isNotBlank(appname)) {
            track = StringUtils.replaceAll(track, "\\{store_appid}", appname);
        }

        return track;

    }

    public static Map<String, String> PUBSUB_RANDOM_STR = new HashMap<>();
    public static Map<String, AtomicInteger> PUBSUB_CLICKS = new HashMap<>();


    /**
     * geo char3
     * os 1 as ios  2 as android
     *
     * @param os
     * @return
     */
    public static String randomUA(String os) {

        List<String> uas = Collecter.OS_UA.get(OsE.IOS.name.equalsIgnoreCase(os) ? OsE.IOS.v : OsE.AOS.v);
        int le = uas.size();
        int i = new Random().nextInt(le);
        return uas.get(i);
    }


    /**
     * @return
     */
    public static LiveOffer randomOffers(List<LiveOffer> offers) {

        if (offers == null) {
            return null;
        }
        int le = offers.size();
        int i = new Random().nextInt(le);
        return offers.get(i);
    }

    public static String randomSub(LiveOffer offer) {
        if (StringUtils.isBlank(offer.getPlacements()) || SubidTypeE.AUTO_P360.code == offer.getAutosubid()) {
            Date date = new Date();
            int i = Counter.SUB_CLICKS.get(offer.getUid()).incrementAndGet();
            int seed = i / 3500;
            String h = (1000 + seed) + "_" + DateFormatUtils.format(date, "HHddMM");
            return h;
        } else {
            String[] pls = offer.getPlacements().split(",");
            int le = pls.length;
            if (le > 3) {
                le = 4;
            }
            int i = new Random().nextInt(le);
            return pls[i];

        }

    }


    public static String geClickid(LiveOffer offer) {

        return RandomStringUtils.randomAlphabetic(4) + DateFormatUtils.format(new Date(), "MMddHHmmss") + offer.getUid();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100001; i++) {
            ExecutorPool.getExecutor().execute(() -> {
            });
        }
        System.out.println(111);

    }
    public static boolean isStore(String url) {
        if (url.indexOf("apple.com") > 0 || url.indexOf("google.com") > 0) {
            return true;
        }
        return false;
    }
    public static boolean is3pt(String url) {
        if (url.indexOf(".adjust.") > 0 || url.indexOf(".appsflyer.com") > 0|| url.indexOf(".app.link") > 0) {
            return true;
        }
        return false;
    }


    public static void saveLand(LiveOffer offer, String url) {

        if (!SimpleData.OFFER_LAND.containsKey(offer.getUid())) {
            SimpleData.OFFER_LAND.put(offer.getUid(), url);
        }
    }


    public static boolean isTargetTimeByGeo2word(String geo) {
        if (StringUtils.isBlank(geo)) {
            return false;
        }
        LocalDateTime reqTime = LocalDateTime.now(Ctz.of(GeoMap.word2Map.get(geo.toUpperCase())));
        int h = reqTime.getHour();
        int d = reqTime.getDayOfWeek().getValue();
        if (d == 6 || d == 7) {
            if (h >= 9 && h <= 23) {
                return true;
            }
        } else {
            if (h == 11 || h == 12 || h == 13  || h == 17 || h == 18 || h == 19 || h == 20 || h == 21 || h == 22 || h == 23) {
                return true;
            }
        }
        return false;
    }


}
