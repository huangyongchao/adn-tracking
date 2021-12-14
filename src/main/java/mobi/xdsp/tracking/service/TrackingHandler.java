package mobi.xdsp.tracking.service;

import com.aerospike.client.AerospikeClient;
import mobi.xdsp.tracking.common.AdTool;
import mobi.xdsp.tracking.common.ExecutorPool;
import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.core.job.Counter;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.PublisherOffer;
import mobi.xdsp.tracking.repositories.AerospikeClickRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Random;

@Service
public class TrackingHandler {
    private static final Logger clicklog = LoggerFactory.getLogger("click");

    @Autowired
    private AerospikeClickRepository repository;
    @Autowired
    Mailer mailer;


    public Random r = new Random();

    public void mixSub(Click click, Offer offer, PublisherOffer publisherOffer) {

        if (offer.getPriority() != null && offer.getPriority().intValue() == 4) {
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
