package com.adscanal.sdk;

import com.adscanal.sdk.proxy.ShifterProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SdkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SdkApplication.class, args);

        ShifterProxy.launch();
    }

}
