package mobi.xdsp.tracking.common;

import com.google.common.collect.Lists;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.dto.OsE;
import mobi.xdsp.tracking.entity.Offer;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Random;

/**
 * @author huangyongchao
 */
public class AdTool {
    public static String urlEncode(Offer offer, String url) {

        if (url.indexOf("{") > -1) {
            url = StringUtils.replaceAll(url, "\\{", "%7B");
        }
        if (url.indexOf("}") > -1) {
            url = StringUtils.replaceAll(url, "\\}", "%7D");
        }
        if (url.indexOf("[") > -1) {
            url = StringUtils.replaceAll(url, "\\[", "%5b");
        }
        if (url.indexOf("]") > -1) {
            url = StringUtils.replaceAll(url, "\\]", "%5d");
        }
        if (url.indexOf("|") > -1) {
            url = StringUtils.replaceAll(url, "\\|", "%7c");
        }
        if (url.indexOf("$") > -1) {
            url = StringUtils.replaceAll(url, "$", "%24");
        }
        if (url.indexOf(">") > -1) {
            url = StringUtils.replaceAll(url, ">", "%3E");
        }
        if (url.indexOf("<") > -1) {
            url = StringUtils.replaceAll(url, "<", "%3C");
        }

        return url;
    }


    public static String trackurl(Click click, Offer offer) {
        String track = offer.getTrackurl();
        try {
            if (track.indexOf("{pub_subid}") > -1 && StringUtils.isNotBlank(click.getMixSub())) {
                track = StringUtils.replaceAll(track, "\\{pub_subid}", click.getPid() + "_" + URLEncoder.encode(click.getMixSub(), "utf-8"));
            } else {
                track = StringUtils.replaceAll(track, "\\{pub_subid}", click.getPid() + "_" + URLEncoder.encode(click.getPubSub(), "utf-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (track.indexOf("{click_id}") > -1 && StringUtils.isNotBlank(click.getId())) {
            track = StringUtils.replaceAll(track, "\\{click_id}", click.getId());
        }

        if (OsE.AOS.name.equalsIgnoreCase(offer.getOs())) {
            if (track.indexOf("{device_id}") > -1 && StringUtils.isNotBlank(click.getGaid())) {
                track = StringUtils.replaceAll(track, "\\{device_id}", click.getGaid());
            }
            if (track.indexOf("{gaid}") > -1 && StringUtils.isNotBlank(click.getGaid())) {
                track = StringUtils.replaceAll(track, "\\{gaid}", click.getGaid());
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

    public static String createClickIdByMMP(Integer publisherid,Integer offerid) {
        return  "DI" + publisherid + "-" + offerid + "-{click_id}";
    }

    public static  Click unpackClickId(String clickid) {
        Click click = new Click();
/*
        DI1001-2311671-{click_id}
*/

        return click;
    }

}
