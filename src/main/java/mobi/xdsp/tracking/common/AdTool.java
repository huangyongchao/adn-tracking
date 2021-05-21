package mobi.xdsp.tracking.common;

import mobi.xdsp.tracking.core.job.CounterJob;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.dto.OsE;
import mobi.xdsp.tracking.entity.Offer;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
        if (url.indexOf("\\") > -1) {
            url = StringUtils.replaceAll(url, "\\", "%5C");
        }
        if (url.indexOf("\":\"") > -1) {
            url = StringUtils.replaceAll(url, "\":\"", "%22%3A%22");
        }
        if (url.indexOf("\"") > -1) {
            url = StringUtils.replaceAll(url, "\"", "%22");
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

            } else if (clickid.startsWith("DI")) {
                String[] ss = clickid.split("-");
                if (ss.length >= 2) {
                    String pubid = ss[0].substring(2);
                    String offerid = ss[1];
                    click.setOid(Integer.parseInt(offerid));
                    click.setPid(Integer.parseInt(pubid));
                    click.setId(clickid);
                    click.setClickId(clickid.substring(clickid.indexOf(offerid)+offerid.length()+1));

                }

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

        String clickid = "PE05140930241005N2311784IRu";
        String clickid1 = "DI1001-2311671-{click_id}";
        System.out.println(unpackClickId(clickid));
        System.out.println(unpackClickId(clickid1));

    }

}
