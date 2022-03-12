package mobi.xdsp.tracking.service;

import afu.org.checkerframework.checker.oigj.qual.O;
import com.aerospike.client.AerospikeClient;
import mobi.xdsp.tracking.common.AdTool;
import mobi.xdsp.tracking.common.ExecutorPool;
import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.core.job.Counter;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.PublisherOffer;
import mobi.xdsp.tracking.repositories.AerospikeClickRepository;
import mobi.xdsp.tracking.router.ConversionAPI;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TrackingHandler {
    private static final Logger clicklog = LoggerFactory.getLogger("click");

    @Autowired
    private AerospikeClickRepository repository;
    @Autowired
    Mailer mailer;

    @Autowired
    private DataService dataService;
    public Random r = new Random();
    private static final Logger logger = LoggerFactory.getLogger(ConversionAPI.class);

    public Offer checkRedictOffer(Offer oriOffer) {
        if (oriOffer.getTrackurl().indexOf("@@") > 0) {
            String[] ids = oriOffer.getTrackurl().split("@@");
            String oriTrack = ids[0];
            ids[0] = oriOffer.getId().toString();

            List<Integer> idds = Arrays.stream(ids).filter(n -> StringUtils.isNotBlank(n)).map(n -> Integer.parseInt(n.trim())).collect(Collectors.toList());
            int newOid = 0;

            int s = idds.size();
            if (s == 0) {
                newOid = idds.get(0);
            } else {
                int i = r.nextInt(s);
                newOid = idds.get(i);

            }
            Offer offer = CacheData.OFF_CACHE.get(newOid);

            if (offer == null) {
                offer = dataService.cacheOfferFirst(newOid);
            }
            logger.warn(newOid + ":" + offer.getOffername());

            if (offer == null) {
                offer = oriOffer;
            }

            return offer;
        }
        return oriOffer;

    }

    public void mixSub(Click click, Offer offer, PublisherOffer publisherOffer) {


        if ( (offer.getAutomonitor() != null && offer.getAutomonitor() == 1) || (offer.getAutoadjust() != null && offer.getAutoadjust() == 1)) {
            String pls = offer.getPlacements();
            String[] plsa = pls.split(",");
            if (plsa.length > 0) {
                /*从offer默认子站里随机选择一个子站作为真实子站*/
                String subid = plsa[r.nextInt(plsa.length)];
                String track = offer.getTrackurl();
                try {
                    if (track.indexOf("{pub_subid}") > -1 && StringUtils.isNotBlank(subid)) {
                        track = StringUtils.replaceAll(track, "\\{pub_subid}", subid);
                    } else {
                        track = StringUtils.replaceAll(track, "\\{pub_subid}", subid);
                    }
                    /*设置混量子站*/
                    click.setMixSub(subid);
                    /*原始子站放到AF额外参数,如果是AF链接*/
                    if (track.indexOf("appsflyer.com") > 0) {
                        if (track.indexOf("af_sub3") < 0) {
                            track = track + "&af_sub3=" + click.getPubSub();
                        } else if (track.indexOf("af_sub2") < 0) {
                            track = track + "&af_sub2=" + click.getPubSub();
                        } else if (track.indexOf("af_sub1") < 0) {
                            track = track + "&af_sub1=" + click.getPubSub();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                offer.setTrackurl(track);

            }

        }else {
            click.setMixSub(click.getPubSub());
        }
    }

    public String makeURL(Click click, Offer offer) {
        String url = AdTool.trackurl(click, offer);
        url = AdTool.urlEncode(url);
        return url;
    }

    public void writeClicks(Click click, String realTrackLink, Offer offer, PublisherOffer publisherOffer) {
        ExecutorPool.getExecutor().execute(() -> {
            try {

                click.setLink(realTrackLink);
                clicklog.info(click.toString());
                click.setUa("");
                click.setLink("");
                repository.save(click);
            } catch (Exception e) {
                Random r = new Random();
                int i = r.nextInt(1000);
                if (i == 0) {
                    mailer.sendErrorMail("Tracking Error: saveClickToAerospike", Mailer.e2s(e));
                }
                e.printStackTrace();
            }
        });

    }
    //http://tracking.pubearn.com/click?pid=6&offer=2157&pub_sub=testsub&gaid={gaid}&click_id={click_id}&lang={lang}&ua={ua}&ip={ip}&appid={appid}&sub1={sub1}&sub2={sub2}

    //http://localhost:9192/click?pid=6&offer=2157&pub_sub=testsub&gaid={gaid}&click_id={click_id}&lang={lang}&ua={ua}&ip={ip}&appid={appid}&sub1={sub1}&sub2={sub2}

    public void countClicks(Click click, Offer offer, PublisherOffer publisherOffer) {
        Counter.increaseClick(click.getPid(), click.getOid(), new Date().getHours(), click.getPubSub(), 1, 1);
    }


/*
    验证参数
    验证渠道状态
    验证Affiliate状态
    检查Offer缓存
    加载Offer缓存
    验证Offer状态
    检查PublisherOffer缓存
    加载PublisherOffer缓存
    验证Publisher状态
    验证子站
    验证cap(PB)
    是否重定向
    获取重定向Offer
    拼装点击id(本地版本和传输版本)
    装载宏参数
    记录点击
    记录log
    重定向
    定时上报点击数据

    */

}
