package com.adscanal.sdk;

import com.adscanal.sdk.datafile.Collecter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.adscanal.sdk.mapper")
public class SdkApplication {

    public static void main(String[] args) {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2,TLSv3");
        System.setProperty("domainId", "colour.mobi");
        Collecter.initGua();
        System.out.println("UA init success!!!!!!");
        SpringApplication.run(SdkApplication.class, args);
    }

}
