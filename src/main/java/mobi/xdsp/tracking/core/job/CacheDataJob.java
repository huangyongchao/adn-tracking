package mobi.xdsp.tracking.core.job;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.dto.enums.SychLockE;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.OfferExample;
import mobi.xdsp.tracking.entity.PublisherOffer;
import mobi.xdsp.tracking.entity.PublisherOfferExample;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PublisherOfferMapper;
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
import java.util.Set;

@Component
public class CacheDataJob {
    @Autowired
    OfferMapper offerMapper;
    @Autowired
    PublisherOfferMapper publisherOfferMapper;
    @Autowired
    Mailer mailer;

    private static final Logger clicklog = LoggerFactory.getLogger("click");


    @Scheduled(cron = "*/20 * * * * ?")
    public void updateOfferCacheJob() {
        try {
            Set<Integer> setids = CacheData.OFF_SYCN_LOCK.keySet();
            if(setids.size()==0){
                return;
            }
            List<Integer> offids = Lists.newLinkedList();
            offids.addAll(setids);
            OfferExample example = new OfferExample();
            example.createCriteria().andIdIn(offids);
            List<Offer> list = offerMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(list)) {
                Map<Integer, Integer> lock = Maps.newConcurrentMap();
                Map<Integer, Offer> cache = Maps.newConcurrentMap();

                list.forEach(n -> {
                    lock.put(n.getId(), SychLockE.LOCKED.code);
                    cache.put(n.getId(), n);
                });
                CacheData.OFF_SYCN_LOCK = lock;
                CacheData.OFF_CACHE = cache;
            }
        } catch (Exception e) {
            mailer.sendErrorMail("Tracking Error: updateOfferCacheJob", e.getMessage() + "\n" + e.getLocalizedMessage());

            e.printStackTrace();
        }


    }

    @Scheduled(cron = "*/25 * * * * ?")
    public void updatePublisherOfferCacheJob() {
        try {
            Set<String> setids = CacheData.PUBOFF_SYCN_LOCK.keySet();
            if(setids.size()==0){
                return;
            }

            List<Integer> offids = Lists.newLinkedList();
            List<Integer> publishers = Lists.newLinkedList();
            CacheData.PUBOFF_SYCN_LOCK.keySet().forEach(n -> {
                try {
                    String[] ids = n.split("_");
                    publishers.add(Integer.parseInt(ids[0]));
                    offids.add(Integer.parseInt(ids[1]));
                } catch (Exception e) {
                    mailer.sendErrorMail("Tracking Error: updatePublisherOfferCacheJob", e.getMessage() + "\n" + e.getLocalizedMessage());

                    e.printStackTrace();
                }
            });
            PublisherOfferExample example = new PublisherOfferExample();
            example.createCriteria().andOfferidIn(offids).andPublisheridIn(publishers);

            List<PublisherOffer> list = publisherOfferMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(list)) {
                Map<String, Integer> lock = Maps.newConcurrentMap();
                Map<String, PublisherOffer> cache = Maps.newConcurrentMap();

                list.forEach(n -> {
                    String pokey = n.getPublisherid() + "_" + n.getOfferid();

                    lock.put(pokey, SychLockE.LOCKED.code);
                    cache.put(pokey, n);
                });
                CacheData.PUBOFF_SYCN_LOCK = lock;
                CacheData.PUB_OFF_CACHE = cache;
            }
        } catch (Exception e) {
            mailer.sendErrorMail("Tracking Error: updatePublisherOfferCacheJob", e.getMessage() + "\n" + e.getLocalizedMessage());

            e.printStackTrace();
        }


    }


}
