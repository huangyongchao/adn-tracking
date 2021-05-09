package mobi.xdsp.tracking.core.job;

import com.google.common.collect.Lists;
import mobi.xdsp.tracking.service.DataService;
import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.entity.Affiliate;
import mobi.xdsp.tracking.entity.Publisher;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Component
public class BaseDataLoadJob {
    @Autowired
    DataService dataService;

    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger logger = LoggerFactory.getLogger(BaseDataLoadJob.class);

    @Scheduled(cron = "1 0,30 * * * ?")
    public void cacheAffiliate(){

        try {
            List<Affiliate> list =dataService.cacheAffiliateAll();
            Optional.ofNullable(list).orElse(Lists.newLinkedList()).forEach(n->{
                CacheData.AFF_CACHE.put(n.getId(), n);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Scheduled(cron = "1 1,31 * * * ?")
    public void cachePublisher(){
        try {

            List<Publisher> list =dataService.cachePublisherAll();
            Optional.ofNullable(list).orElse(Lists.newLinkedList()).forEach(n->{
                if(StringUtils.isNotBlank(n.getToken())){
                    CacheData.PUB_CACHE.put(n.getId(), n);
                    CacheData.PUB_TOKEN.put(n.getToken(), n);
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void init(){
        cacheAffiliate();
        cachePublisher();
    }
}
