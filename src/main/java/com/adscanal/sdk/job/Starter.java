package com.adscanal.sdk.job;

import com.adscanal.sdk.core.TaskLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Component
public class Starter {

    private static final Logger logger = LoggerFactory.getLogger(Starter.class);
    private static ScheduledExecutorService timeExecutor = new ScheduledThreadPoolExecutor(100);

    @Scheduled(initialDelay = 1000, fixedRate = Long.MAX_VALUE)
    public void proxyVN() {
        logger.warn("Start Proxy at " + new Date());

        TaskLoader.startVN_IOS();

        // LumProxy.launch(geo, OsE.IOS.name, 100);

    }
}
