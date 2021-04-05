package com.adscanal.sdk.core.job;

import org.apache.http.Consts;
import org.apache.http.HttpRequest;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class LumiJob {

    @Scheduled(cron = "0 0/20 * * * ?")
    public void getZoneInfo() {
        try {
            String cost = Request.Get("https://luminati.io/api/zone/cost?zone=static").addHeader("Authorization", "Bearer f1290b71a089b5d803cdf6304fb1076f").execute().returnContent().asString(Consts.UTF_8);
            String zone = Request.Get("https://luminati.io/api/zone?zone=static").addHeader("Authorization", "Bearer f1290b71a089b5d803cdf6304fb1076f").execute().returnContent().asString(Consts.UTF_8);
            System.out.println(cost);
            System.out.println(zone);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @PostConstruct
    public void init(){
        getZoneInfo();
    }
}
