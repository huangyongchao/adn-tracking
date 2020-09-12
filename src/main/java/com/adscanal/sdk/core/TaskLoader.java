package com.adscanal.sdk.core;

import com.adscanal.sdk.common.ExecutorPool;
import com.adscanal.sdk.dto.LiveOffer;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
public class TaskLoader {
    private static int BASE = 1000 * 60 * 60 * 24;


    // 加载offer
    //拆分系统
    //装配文件路径
    //基于offer计算点击 记录文件和当前行号
    //重新调整timer

    public static void startVN_IOS() {
        ArrayBlockingQueue q = SdkConf.GEO_OS_QUE.get("VNios");
        ExecutorPool.getExecutor().execute(() -> {
            String path = "/opt/did/VNMios.log.dist";
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
        startVN_IOS();
    }

    public static void rebuildCustomer(LiveOffer offer) {
        int period = 0;
        if (offer.getDailyMaxClicks() <= 0) {
            period = Integer.MIN_VALUE;
        } else {
            period = BASE / offer.getDailyMaxClicks();
        }

        int coresize = 20;
        SdkConf.OFFER_SCHED_NEW.put(offer.getId(), Executors.newScheduledThreadPool(coresize));
        SdkConf.OFFER_SCHED_NEW.get(offer.getId()).scheduleAtFixedRate(new OfferTask(offer, offer.getCountry().toUpperCase() + offer.getOsName().toLowerCase(), offer.getCountry().toUpperCase(), offer.getOsName().toLowerCase()), 1000, period, TimeUnit.MILLISECONDS);
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
