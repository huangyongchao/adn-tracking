package com.adscanal.sdk.conf;


import org.apache.catalina.LifecycleListener;
import org.apache.catalina.core.AprLifecycleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties(APRTomcatProperties.class)
@Profile("prod")
public class APRconf {

    @Bean
    public ServletWebServerFactory servletWebServerFactory(APRTomcatProperties configProperties) {
        APRTomcatProperties.Tomcat tomcat = configProperties.getTomcat();

        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
        tomcatServletWebServerFactory.setProtocol(tomcat.getProtocol());

        tomcatServletWebServerFactory.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            Field[] fields = tomcat.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    connector.setAttribute(field.getName(), field.get(tomcat));
                } catch (IllegalAccessException e) {
                    continue;
                }
            }

        });
        //避免出现 ssl=on 的报错
        AprLifecycleListener aprLifecycleListener = new AprLifecycleListener();
        aprLifecycleListener.setSSLEngine("off");
        List<LifecycleListener> listeners = new ArrayList<LifecycleListener>();
        listeners.add(aprLifecycleListener);
        tomcatServletWebServerFactory.setContextLifecycleListeners(listeners);
        return tomcatServletWebServerFactory;
    }

}