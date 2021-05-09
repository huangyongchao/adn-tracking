package mobi.xdsp.tracking.core.job;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.dto.enums.SychLockE;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.OfferExample;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.service.TrackingHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class CacheDataJob {
    @Autowired
    OfferMapper offerMapper;
    private static final Logger clicklog = LoggerFactory.getLogger("click");


    @Scheduled(cron = "*/10 * * * * ?")
    public void checkLock() {
        try {
            List<Integer> offids = Lists.newLinkedList();
            offids.addAll(CacheData.OFF_SYCN_LOCK.keySet());
            OfferExample example = new OfferExample();
            example.createCriteria().andIdIn(offids);
            List<Offer> list = offerMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(list)){
                Map<Integer, Integer> lock = Maps.newConcurrentMap();
                Map<Integer, Offer> cache = Maps.newConcurrentMap();

                list.forEach(n->{
                    lock.put(n.getId(), SychLockE.LOCKED.code);
                    cache.put(n.getId(), n);
                });
                CacheData.OFF_SYCN_LOCK = lock;
                CacheData.OFF_CACHE = cache;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
