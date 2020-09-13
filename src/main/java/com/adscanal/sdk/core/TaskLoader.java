package com.adscanal.sdk.core;

import com.adscanal.sdk.common.ExecutorPool;
import com.adscanal.sdk.dto.LiveOffer;
import com.adscanal.sdk.dto.SimpleData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class TaskLoader {
    private static final Logger logger = LoggerFactory.getLogger(TaskLoader.class);

    private static int BASE = 1000 * 60 * 60 * 24;


    // 加载offer
    //拆分系统
    //装配文件路径
    //基于offer计算点击 记录文件和当前行号
    //重新调整timer

    public static void loadDevid(String filepath, String key) {
        ArrayBlockingQueue q = SdkConf.GEO_OS_QUE.get(key);
        ExecutorPool.getExecutor().execute(() -> {
            String path = filepath;
            if (!Files.exists(Paths.get(path))) {
                logger.error("Not exists:" + path);
                return;
            }
            try {
                Files.lines(Paths.get(path)).forEach(n -> {
                    try {
                        q.put(n);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    public static void producers() {
        loadDevid("/opt/did/IDNios.log.dist", "ID");
        loadDevid("/opt/did/KORios.log.dist", "KR");
        loadDevid("/opt/did/PHLios.log.dist", "PH");
        loadDevid("/opt/did/SGPios.log.dist", "SG");
        loadDevid("/opt/did/THAios.log.dist", "TH");
        loadDevid("/opt/did/TWNios.log.dist", "TW");
        loadDevid("/opt/did/VNMios.log.dist", "VN");

    }

    public static void rebuildCustomer(LiveOffer offer) {
        int period = 0;
        int coresize = 20;

        boolean rebuild = false;
        if (!SimpleData.OFFER_CLICKS.containsKey(offer.getId())) {
            rebuild = true;
        } else {
            int clicks = offer.getDailyMaxClicks();
            int oldclicks = SimpleData.OFFER_CLICKS.get(offer.getId());
            if (Math.abs(clicks - oldclicks) > 20000) {
                rebuild = true;
            }
        }
        if (rebuild) {

            if (offer.getDailyMaxClicks() <= 0) {
                period = Integer.MIN_VALUE;
            } else {
                period = BASE / offer.getDailyMaxClicks();
            }

            SdkConf.OFFER_SCHED_NEW.put(offer.getId(), Executors.newScheduledThreadPool(coresize));
            SdkConf.OFFER_SCHED_NEW.get(offer.getId()).scheduleAtFixedRate(new OfferTask(offer, offer.getCountry().toUpperCase() + offer.getOsName().toLowerCase(), offer.getCountry().toUpperCase(), offer.getOsName().toLowerCase()), 1000, period, TimeUnit.MILLISECONDS);
            SimpleData.OFFER_CLICKS.put(offer.getId(), offer.getDailyMaxClicks());
        } else {
            if (SdkConf.OFFER_SCHED_STABLE.containsKey(offer.getId())) {
                SdkConf.OFFER_SCHED_NEW.put(offer.getId(), SdkConf.OFFER_SCHED_STABLE.get(offer.getId()));
                SimpleData.OFFER_CLICKS.put(offer.getId(), offer.getDailyMaxClicks());
            }else{
                SdkConf.OFFER_SCHED_NEW.put(offer.getId(), Executors.newScheduledThreadPool(coresize));
                SdkConf.OFFER_SCHED_NEW.get(offer.getId()).scheduleAtFixedRate(new OfferTask(offer, offer.getCountry().toUpperCase() + offer.getOsName().toLowerCase(), offer.getCountry().toUpperCase(), offer.getOsName().toLowerCase()), 1000, period, TimeUnit.MILLISECONDS);
                SimpleData.OFFER_CLICKS.put(offer.getId(), offer.getDailyMaxClicks());
            }
        }
    }


    public static void main(String[] args) {
        producers();
        LiveOffer offer = new LiveOffer();
        offer.setId("test");
        offer.setCountry("VN");
        offer.setOsName("iOS");
        offer.setDailyMaxClicks(1000000);
        rebuildCustomer(offer);

    }
}
