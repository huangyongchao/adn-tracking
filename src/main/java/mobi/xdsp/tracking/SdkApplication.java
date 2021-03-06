package mobi.xdsp.tracking;

import mobi.xdsp.tracking.common.Mailer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableScheduling
@EnableAutoConfiguration
@MapperScan("mobi.xdsp.tracking.mapper")
public class SdkApplication{
    @Autowired
    Mailer mailer;

    public static void main(String[] args) {
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", "$|{}[]()><");
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2,TLSv3");
        SpringApplication.run(SdkApplication.class, args);


    }

}
