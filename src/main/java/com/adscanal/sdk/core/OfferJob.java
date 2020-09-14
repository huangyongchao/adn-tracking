package com.adscanal.sdk.core;

import com.adscanal.sdk.common.HttpClientUtil;
import com.adscanal.sdk.dto.LiveOffer;
import com.adscanal.sdk.dto.SimpleData;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Component
public class OfferJob {
    private static final Logger logger = LoggerFactory.getLogger(OfferTask.class);
    private static final Logger errorlog = LoggerFactory.getLogger("error");

    @Scheduled(cron = "0 0/30 * * * ?")
    public void sychOffers() {

        SdkConf.ACTI_GEO.forEach(n -> {
            List<LiveOffer> list = getOffers(n);
            list.forEach(offer -> {
                TaskLoader.rebuildCustomer(offer);
            });
            errorlog.info(JSONObject.toJSONString(list));

        });

        SdkConf.OFFER_SCHED_STABLE.forEach((k, v) -> {
            v.shutdown();
        });
        errorlog.info("Old task shutdown done");

        SdkConf.OFFER_SCHED_STABLE = SdkConf.OFFER_SCHED_NEW;
        SdkConf.OFFER_SCHED_NEW = new HashMap<>();
        errorlog.info("New task start done");

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

    @PostConstruct
    public void init() {
        sychOffers();
    }
}
