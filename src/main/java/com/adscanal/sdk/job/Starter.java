package com.adscanal.sdk.job;

import com.adscanal.sdk.proxy.ShifterProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Starter {
    private static final Logger logger = LoggerFactory.getLogger(Starter.class);

    @Scheduled(fixedDelay = 600)
    public void proxy() {
        logger.warn("Start Proxy at " + new Date());
        ShifterProxy.launch();


    }
}
