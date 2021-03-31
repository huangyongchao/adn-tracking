package com.adscanal.sdk.conf;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.Ssl;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class EnableAPR implements WebServerFactoryCustomizer<WebServerFactory> {

    @Override
    public void customize(WebServerFactory factory) {
        TomcatServletWebServerFactory containerFactory = (TomcatServletWebServerFactory) factory;
        containerFactory.setProtocol("org.apache.coyote.http11.Http11AprProtocol");
        Ssl ssl = new Ssl();
        ssl.setEnabled(false);
        containerFactory.setSsl(ssl);
    }
}