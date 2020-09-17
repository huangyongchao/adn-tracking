package com.adscanal.sdk.core.job;

import com.adscanal.sdk.common.HttpClientUtil;
import com.adscanal.sdk.core.OfferTask;
import com.adscanal.sdk.core.SdkConf;
import com.adscanal.sdk.dto.LiveOffer;
import com.adscanal.sdk.dto.SimpleData;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@Order(1)
public class LoadOfferJob {
    private static final Logger logger = LoggerFactory.getLogger(OfferTask.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static int BASE = 1000 * 60 * 60 * 24;

    @Scheduled(cron = "0 0/30 * * * ?")
    public void sychOffers() {

        SdkConf.ACTI_GEO.forEach(n -> {
            List<LiveOffer> list = getOffers(n);
            list.forEach(offer -> {
                rebuildCustomer(offer);
            });
            errorlog.info(JSONObject.toJSONString(list));

        });


        errorlog.info("Old task shutdown done");

        SdkConf.OFFER_SCHED_STABLE.forEach((k, v) -> {
            v.shutdown();
        });

        SdkConf.OFFER_SCHED_STABLE = SdkConf.OFFER_SCHED_NEW;
        SdkConf.OFFER_SCHED_NEW = new HashMap<>();
        errorlog.info("New task start done" + JSONObject.toJSONString(SdkConf.OFFER_SCHED_STABLE));

    }

    public List getOffers(String geo) {

        List<LiveOffer> offers = Lists.newArrayList();
        try {
            //http://54.218.163.206:5080/openapi/test
            String offerapi = "http://api.colour.mobi/liveoffers?auth=18&type=3&location=" + geo.toLowerCase();
            System.out.println(offerapi);
            String respj = HttpClientUtil.get(offerapi);

            JSONArray respja = JSONArray.parseArray(respj);
            if (respja != null && respja.size() > 0) {
                respja.forEach(n -> {
                    JSONObject o = (JSONObject) n;
                    LiveOffer offer = o.toJavaObject(LiveOffer.class);
                    offers.add(offer);
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        SimpleData.GOFFERS.remove(geo);
        SimpleData.GOFFERS.put(geo, offers);

        return offers;

    }


    public static void rebuildCustomer(LiveOffer offer) {
        int period = 0;
        int coresize = 100;

        int clicks = offer.getDailyMaxClicks();
        Integer oldclicks = SimpleData.OFFER_CLICKS.get(offer.getUid() + "");
        if (oldclicks == null || Math.abs(clicks - oldclicks) > 20000) {

            if (offer.getDailyMaxClicks() <= 0) {
                period = Integer.MAX_VALUE;
            } else {
                period = BASE / offer.getDailyMaxClicks();
            }

            SdkConf.OFFER_SCHED_NEW.put(offer.getUid() + "", Executors.newScheduledThreadPool(coresize));
            SdkConf.OFFER_SCHED_NEW.get(offer.getUid() + "").scheduleAtFixedRate(new OfferTask(offer, offer.getCountry().toUpperCase() + offer.getOsName().toLowerCase(), offer.getCountry().toUpperCase(), offer.getOsName().toLowerCase()), new Random().nextInt(1000), period, TimeUnit.MILLISECONDS);
            SimpleData.OFFER_CLICKS.put(offer.getUid() + "", offer.getDailyMaxClicks());
            logger.info("LOADOFFER:" + offer.getName() + " " + offer.getDailyMaxClicks());
        } else {
            SdkConf.OFFER_SCHED_NEW.put(offer.getUid() + "", SdkConf.OFFER_SCHED_STABLE.get(offer.getUid() + ""));
            SdkConf.OFFER_SCHED_STABLE.remove(offer.getUid() + "");
            SimpleData.OFFER_CLICKS.put(offer.getUid() + "", offer.getDailyMaxClicks());
        }


    }

    @PostConstruct
    public void init() {
        sychOffers();
    }
}
