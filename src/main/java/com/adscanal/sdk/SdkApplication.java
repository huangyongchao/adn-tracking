package com.adscanal.sdk;

import com.adscanal.sdk.datafile.Collecter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SdkApplication {

    public static void main(String[] args) {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2,TLSv3");
        Collecter.initGua();
        System.out.println("UA init success!!!!!!");
        SpringApplication.run(SdkApplication.class, args);
    }

}
