package mobi.xdsp.tracking.core.job;

import com.alibaba.fastjson.JSONObject;
import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.repositories.AerospikeClickRepository;
import mobi.xdsp.tracking.service.TrackingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.aerospike.repository.AerospikeRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

@Component
public class CounterJob {

    @Autowired
    Mailer mailer;
    @Autowired
    private AerospikeClickRepository repository;

    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger clicklog = LoggerFactory.getLogger("click");
    private static final Logger logger = LoggerFactory.getLogger(CounterJob.class);


    @Scheduled(cron = "1 0,10,20,30,40,50 * * * ?")
    public void setCurrentHour() {

    }


    @Scheduled(cron = "*/2 * * * * ?")
    public void job() {
    }
    @PostConstruct
    public void AeroSpike(){
        Click click = new Click();
        String id = String.valueOf("mytestclick");
        click.setId(id);
        click.setAppN("Test Name");
        repository.save(click);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(repository.findById(id).toString());
        logger.info(repository.findById(id).toString());
    }

}
