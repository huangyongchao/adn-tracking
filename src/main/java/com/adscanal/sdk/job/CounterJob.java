package com.adscanal.sdk.job;

import com.adscanal.sdk.dto.Counter;
import com.alibaba.fastjson.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class CounterJob {

    @Scheduled(cron = "1 0,10,20,30,40,50 * * * ?")
    public void setCurrentHour() {
        Counter.CURRENT_HOUR = new Date().getHours();
    }


    @Scheduled(cron = "0 0,5,15,35,55 0 */1 * ?")
    public void exchangeCounter() {
        Counter.exchange();
    }


    @Scheduled(cron = "0 0,5,15,35,55 21,22,23 */1 * ?")
    public void resetExchangeLock() {
        Counter.EXCHANGE_LOCK.set(false);
    }


    @Scheduled(cron = "0 0,5,15,35,55 * * * ?")
    public void saveCounter() {
        System.out.println(JSONObject.toJSONString(Counter.counterMap()));
    }


    @PostConstruct
    public void autoStart() {
        setCurrentHour();
    }
}
