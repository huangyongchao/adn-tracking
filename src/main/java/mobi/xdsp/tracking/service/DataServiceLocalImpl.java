package mobi.xdsp.tracking.service;

import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.dto.enums.SychLockE;
import mobi.xdsp.tracking.entity.*;
import mobi.xdsp.tracking.mapper.AffiliateMapper;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PublisherMapper;
import mobi.xdsp.tracking.mapper.PublisherOfferMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class DataServiceLocalImpl implements DataService {

    @Autowired
    AffiliateMapper affiliateMapper;
    @Autowired
    OfferMapper offerMapper;
    @Autowired
    PublisherMapper publisherMapper;
    @Autowired
    PublisherOfferMapper publisherOfferMapper;

    @Override
    public List<Affiliate> cacheAffiliateAll() {
        AffiliateExample example = new AffiliateExample();
        return affiliateMapper.selectByExample(example);
    }

    @Override
    public List<Publisher> cachePublisherAll() {
        PublisherExample example = new PublisherExample();
        return publisherMapper.selectByExample(example);
    }

    @Override
    public Offer cacheOfferFirst(Integer id) {
        CacheData.OFF_SYCN_LOCK.put(id, SychLockE.TAKING.code);
        OfferExample offerExample = new OfferExample();
        offerExample.createCriteria().andIdEqualTo(id);
        List<Offer> list = offerMapper.selectByExample(offerExample);
        if (list != null && list.size() > 0) {
            CacheData.OFF_SYCN_LOCK.put(id, SychLockE.LOCKED.code);
            Offer offer = list.get(0);
            CacheData.OFF_CACHE.put(offer.getId(), offer);
            return offer;
        }
        return null;
    }

    @Override
    public PublisherOffer cachePublisherOfferFirst(String key, Integer publisherid, Integer offerid) {

        CacheData.PUBOFF_SYCN_LOCK.put(key, SychLockE.TAKING.code);

        PublisherOfferExample publisherOfferExample = new PublisherOfferExample();
        publisherOfferExample.createCriteria().andOfferidEqualTo(offerid).andPublisheridEqualTo(publisherid);

        List<PublisherOffer> list = publisherOfferMapper.selectByExample(publisherOfferExample);
        if (list != null && list.size() > 0) {

            PublisherOffer offer = list.get(0);
            CacheData.PUB_OFF_CACHE.put(key, offer);
            CacheData.PUBOFF_SYCN_LOCK.put(key, SychLockE.LOCKED.code);

            return offer;
        }
        return null;
    }

    @Override
    public Offer cachePubliserOffer(Publisher publisher) {
        return null;
    }

    @Override
    public Publisher cachePublisherByToken(String token) {

        PublisherExample example = new PublisherExample();
        example.createCriteria().andTokenEqualTo(token);
        List<Publisher> list = publisherMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(list)){
            return list.get(0);
        }
        return null;
    }
}
