package mobi.xdsp.tracking.common;

import com.google.common.collect.Lists;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.dto.OsE;
import mobi.xdsp.tracking.entity.Offer;
import org.apache.commons.lang3.StringUtils;

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
        if (track.indexOf("{pub_subid}") > -1 && StringUtils.isNotBlank(click.getMixSub())) {
            track = StringUtils.replaceAll(track, "\\{pub_subid}", click.getPid() + "_" + click.getMixSub());
        } else {
            track = StringUtils.replaceAll(track, "\\{pub_subid}", click.getPid() + "_" + click.getPubSub());
        }

        if (track.indexOf("{click_id}") > -1 && StringUtils.isNotBlank(click.getClickId())) {
            track = StringUtils.replaceAll(track, "\\{click_id}", click.getClickId());
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
}
