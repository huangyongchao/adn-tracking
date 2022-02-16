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
import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Random;

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
        String track = chooseTrackUrl(click, offer);
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
                    if(pubid.endsWith("==")){
                        pubid = Base64Utils.encodeToString(pubid.getBytes());
                    }
                    String offerid = ss[1];
                    click.setOid(Integer.parseInt(offerid));
                    click.setPid(Integer.parseInt(pubid));
                    click.setId(clickid);
                    click.setClickId(pubid);
                    click.setS1(clickid);

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
