package com.adscanal.sdk.job;

import com.adscanal.sdk.common.HttpClientUtil;
import com.adscanal.sdk.dto.LiveOffer;
import com.adscanal.sdk.dto.OsE;
import com.adscanal.sdk.proxy.LumProxy;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Component
public class Starter {
    private static final Logger logger = LoggerFactory.getLogger(Starter.class);

    @Scheduled(initialDelay = 1000, fixedRate = Long.MAX_VALUE)
    public void proxyVN() {
        logger.warn("Start Proxy at " + new Date());
        List<LiveOffer> offers = Lists.newArrayList();
        String geo = "VN";
        try {
            //http://54.218.163.206:5080/openapi/test
            String respj = HttpClientUtil.get("http://44.235.122.213:8080/liveoffers?auth=18&type=3&location=" + geo.toLowerCase());

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
        if (offers.size() == 0) {
            return;
        }
        LumProxy.launch(geo, OsE.IOS.name, offers, 200);

    }
}
