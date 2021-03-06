package mobi.xdsp.tracking.common;

import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.core.job.CounterJob;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.dto.OsE;
import mobi.xdsp.tracking.dto.enums.ExchangesE;
import mobi.xdsp.tracking.entity.Offer;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huangyongchao
 */
public class AdTool {
    private static final Logger logger = LoggerFactory.getLogger(AdTool.class);

    public static boolean isStore(String url) {
        if (url.indexOf("apple.com") > 0 || url.indexOf("google.com") > 0) {
            return true;
        }
        return false;
    }

    public static boolean is3pt(String url) {
        if (url.indexOf(".adjust.") > 0 || url.indexOf(".appsflyer.com") > 0 || url.indexOf(".app.link") > 0) {
            return true;
        }
        return false;
    }

    public static Set<Integer> getTargetHours(String schedule) {

        if (StringUtils.isNotBlank(schedule) && schedule.indexOf("-1") < 0) {
            schedule = (schedule.replaceAll("null", ""));
            if (StringUtils.isNotBlank(schedule)) {
                Set<Integer> targrtH = Arrays.stream(schedule.split(",")).filter(hs -> StringUtils.isNotBlank(hs.trim())).map(h -> Integer.parseInt(h.trim().trim())).collect(Collectors.toSet());
                if (targrtH != null && targrtH.size() > 0) {
                    return targrtH;
                }

            }

        }
        return null;
    }

    public static Offer cacheOfferTargetHour(Offer offer) {

        Set<Integer> tar = AdTool.getTargetHours(offer.getSchedule());
        if (tar != null && tar.size() > 0) {
            CacheData.OFF_TARGET_CACHE.put(offer.getId(), tar);
        } else {
            CacheData.OFF_TARGET_CACHE.remove(offer.getId());
        }
        return offer;
    }


    public static String urlEncode(String oriUrl) {


        int i = oriUrl.indexOf("?");
        String host = "";
        String querystr = "";
        if (i > 0) {
            host = oriUrl.substring(0, i + 1);
            querystr = oriUrl.substring(i + 1);
        } else {
            querystr = oriUrl;
        }


        if (querystr.indexOf("{") > -1) {
            querystr = StringUtils.replaceAll(querystr, "\\{", "%7B");
        }
        if (querystr.indexOf("}") > -1) {
            querystr = StringUtils.replaceAll(querystr, "\\}", "%7D");
        }
        if (querystr.indexOf("[") > -1) {
            querystr = StringUtils.replaceAll(querystr, "\\[", "%5b");
        }
        if (querystr.indexOf("]") > -1) {
            querystr = StringUtils.replaceAll(querystr, "\\]", "%5d");
        }
        if (querystr.indexOf("|") > -1) {
            querystr = StringUtils.replaceAll(querystr, "\\|", "%7c");
        }
        if (querystr.indexOf("$") > -1) {
            querystr = StringUtils.replaceAll(querystr, "$", "%24");
        }
        if (querystr.indexOf("==") > -1) {
            querystr = StringUtils.replaceAll(querystr, "==", "=");
        }
        if (querystr.indexOf(">") > -1) {
            querystr = StringUtils.replaceAll(querystr, ">", "%3E");
        }
        if (querystr.indexOf("<") > -1) {
            querystr = StringUtils.replaceAll(querystr, "<", "%3C");
        }
        if (querystr.indexOf("\\") > -1) {
            querystr = StringUtils.replaceAll(querystr, "\\", "%5C");
        }
        if (querystr.indexOf("\"") > -1) {
            querystr = StringUtils.replaceAll(querystr, "\"", "%22");
        }
        if (querystr.indexOf(" ") > -1) {
            querystr = StringUtils.replaceAll(querystr, " ", "");
        }
        if (querystr.indexOf(":") > -1) {
            querystr = StringUtils.replaceAll(querystr, ":", "%3A");
        }

        return host + querystr;

    }

    public static String chooseTrackUrl(Click click, Offer offer) {
        String url = offer.getTrackurl();
        if (url.indexOf("@@") > 0) {
            String[] urls = url.split("@@");
            return urls[0];
        }

        if (url.indexOf("##") > 0) {
            String[] urls = url.split("##");
            int l = urls.length;
            Random r = new Random();
            int seed = r.nextInt(l);
            return urls[seed];
        }
        return url;
    }


    public static String trackurl(Click click, Offer offer) {
        //String track = chooseTrackUrl(click, offer);
        String track = offer.getTrackurl();
        try {
            if (track.indexOf("{pub_subid}") > -1 && StringUtils.isNotBlank(click.getMixSub())) {
                track = StringUtils.replaceAll(track, "\\{pub_subid}", URLEncoder.encode(click.getMixSub(), "utf-8"));
            } else {
                track = StringUtils.replaceAll(track, "\\{pub_subid}", URLEncoder.encode(click.getPubSub(), "utf-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            if (track.indexOf("{af_siteid}") > -1 && StringUtils.isNotBlank(click.getMixSub())) {
                track = StringUtils.replaceAll(track, "\\{af_siteid}", URLEncoder.encode(click.getMixSub(), "utf-8"));
            } else {
                track = StringUtils.replaceAll(track, "\\{af_siteid}", URLEncoder.encode(click.getPubSub(), "utf-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            if (track.indexOf("{af_siteid1}") > -1 && StringUtils.isNotBlank(click.getMixSub())) {
                track = StringUtils.replaceAll(track, "\\{af_siteid1}", URLEncoder.encode(click.getMixSub(), "utf-8"));
            } else {
                track = StringUtils.replaceAll(track, "\\{af_siteid1}", URLEncoder.encode(click.getPubSub(), "utf-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (track.indexOf("{ymd}") > -1) {
            track = StringUtils.replaceAll(track, "\\{ymd}", DateTimeUtil.getStringDateNoDash());
        }

        if (track.indexOf("{date}") > -1) {
            track = StringUtils.replaceAll(track, "\\{date}", DateTimeUtil.getStringMD());
        }
        if (track.indexOf("{click_id}") > -1 && StringUtils.isNotBlank(click.getId())) {
            track = StringUtils.replaceAll(track, "\\{click_id}", click.getId());
        }
        if (track.indexOf("{clickid}") > -1 && StringUtils.isNotBlank(click.getId())) {
            track = StringUtils.replaceAll(track, "\\{clickid}", click.getId());
        }

        if (OsE.AOS.name.equalsIgnoreCase(offer.getOs())) {
            if (track.indexOf("{device_id}") > -1 && StringUtils.isNotBlank(click.getGaid())) {
                track = StringUtils.replaceAll(track, "\\{device_id}", click.getGaid());
            }
            if (track.indexOf("{gaid}") > -1 && StringUtils.isNotBlank(click.getGaid())) {
                track = StringUtils.replaceAll(track, "\\{gaid}", click.getGaid());
            }

            if (track.indexOf("{advertising_id}") > -1 && StringUtils.isNotBlank(click.getGaid())) {
                track = StringUtils.replaceAll(track, "\\{advertising_id}", click.getGaid());
            }

        } else {
            if (track.indexOf("{device_id}") > -1 && StringUtils.isNotBlank(click.getIdfa())) {
                track = StringUtils.replaceAll(track, "\\{device_id}", click.getIdfa());
            }
            if (track.indexOf("{idfa}") > -1 && StringUtils.isNotBlank(click.getIdfa())) {
                track = StringUtils.replaceAll(track, "\\{idfa}", click.getIdfa());
            }
        }

        if (track.indexOf("{store_appid}") > -1 && StringUtils.isNotBlank(click.getAppId())) {
            track = StringUtils.replaceAll(track, "\\{store_appid}", click.getAppId());
        }
        if (track.indexOf("{oid}") > -1) {
            track = StringUtils.replaceAll(track, "\\{oid}", offer.getId().toString());
        }

        if (track.indexOf("appsflyer.com") > 0) {
            track = track + "&af_sub1=" + click.getPid();
        }

        return track;

    }

    public static String createClickIdByPlatform(Click click) {
        StringBuilder clickid = new StringBuilder("PE");
        clickid.append(DateFormatUtils.format(click.getCt(), "MMddHHmmss"));
        clickid.append(click.getPid());
        clickid.append("N");
        clickid.append(click.getOid());
        clickid.append(RandomStringUtils.randomAlphabetic(3));

        return clickid.toString();
    }

    public static String createClickIdByMMP(Integer publisherid, Integer offerid) {
        return "DI" + publisherid + "-" + offerid + "-{click_id}";
    }

    public static Click unpackClickId(String clickid) {
        Click click = new Click();

        try {
            if (clickid != null && clickid.startsWith("PE")) {
                int idx = clickid.indexOf("N");
                String pubid = clickid.substring(12, idx);
                String offerid = clickid.substring(idx + 1, clickid.length() - 3);
                click.setOid(Integer.parseInt(offerid));
                click.setPid(Integer.parseInt(pubid));
                click.setId(clickid);
                click.setFullClick(true);

            } else if (clickid.startsWith("DI")) {
                click.setFullClick(false);

                String[] ss = clickid.split("-");
                if (ss.length >= 2) {
                    String pubid = ss[0].substring(2);
                    String offerid = ss[1];
                    click.setOid(Integer.parseInt(offerid));
                    click.setPid(Integer.parseInt(pubid));
                    click.setId(clickid);
                    String encode = ss[2];
                    if (encode.startsWith("FK") || encode.startsWith("DK") || encode.startsWith("SK") || encode.startsWith("SS")) {
                        encode = new String(Base64Utils.decodeFromString(encode.substring(4)), Charset.defaultCharset());
                        encode = LocalDateTime.now(ZoneOffset.UTC).getYear() + encode;
                        String[] infos = encode.split("\\|");
                        String clickdate = infos[0];
                        click.setCt(DateUtils.parseDate(clickdate, "yyyyMMddHHmmss"));
                        if (infos.length > 3) {
                            try {
                                click.getDeviceInfo().setSsp(Integer.parseInt(infos[3]));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            click.getDeviceInfo().setAppid(infos[2]);

                        }
                        if (infos.length > 7) {
                            click.setIdfa(infos[7]);
                            click.getDeviceInfo().setDevid(infos[7]);
                            click.getDeviceInfo().setPub(infos[4]);
                            click.getDeviceInfo().setGeo(infos[5]);
                            click.getDeviceInfo().setOs(infos[6]);
                        }
                        if (OsE.IOS.v.equalsIgnoreCase(click.getDeviceInfo().getOs())) {
                            if (click.getDeviceInfo().getAppid() != null && !click.getDeviceInfo().getAppid().startsWith("id")) {
                                click.getDeviceInfo().setAppid("id" + click.getDeviceInfo().getAppid());
                            }

                        }

                    }
                    click.setS1(encode);
                    click.setClickId(click.getClickId());
                }

            }
            if (click.getCt() == null) {
                click.setCt(new Date());
            }
        } catch (Exception e) {
            logger.info(clickid);
            e.printStackTrace();
        }
/*
        PE05140930241005N2311784IRu
        DI1001-2311671-{click_id}
*/

        return click;
    }

    public static void main(String[] args) {
/*
        String clickid = "SKpjMDMyMjAwNTEyMHwxMDE5NTQ5NXxjb20ubW9iaWxpdHl3YXJlLnNvbGl0YWlyZXwyfDYwMjgwfEdCUnwyfDhiZjA2Yjc5LTlmYjMtNDVlYi04M2ZiLWI1MzY3NzMzZTFjZA%3D%3D";

        clickid = new String(Base64Utils.decodeFromString(clickid), Charset.defaultCharset());


        System.out.println(unpackClickId(clickid));*//*
        System.out.println(getTargetHours("1 , 2 , 4"));

        int hour = LocalDateTime.now(ZoneOffset.UTC).getHour();

        System.out.println(hour);*/
        String s = "SSSSSFFFDDDDD";
        System.out.println(s.split("FFF")[0]);
        System.out.println(s.split("FFF")[1]);
    }

}
