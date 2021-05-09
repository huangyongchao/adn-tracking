package mobi.xdsp.tracking.core.job;

import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.service.TrackingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CounterJob {

    @Autowired
    Mailer mailer;

    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger clicklog = LoggerFactory.getLogger("click");
    private static final Logger logger = LoggerFactory.getLogger(CounterJob.class);


    @Scheduled(cron = "1 0,10,20,30,40,50 * * * ?")
    public void setCurrentHour() {

    }


    @Scheduled(cron = "*/2 * * * * ?")
    public void testjob() {
        System.out.println(new Date());
        clicklog.info(new Date().toString());

    }

}
