package com.adscanal.sdk;

import com.adscanal.sdk.datafile.Collecter;
import com.adscanal.sdk.proxy.ShifterProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SdkApplication {

    public static void main(String[] args) {
        Collecter.initGua();
        System.out.println("UA init success!!!!!!");
        SpringApplication.run(SdkApplication.class, args);
    }

}
