package mobi.xdsp.tracking.service;

import mobi.xdsp.tracking.common.AdTool;
import mobi.xdsp.tracking.core.CacheData;
import mobi.xdsp.tracking.dto.enums.OfferApplyStatusEnum;
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
import java.util.Set;

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


        try {
            OfferExample offerExample = new OfferExample();
            offerExample.createCriteria().andIdEqualTo(id);
            List<Offer> list = offerMapper.selectByExample(offerExample);
            if (list != null && list.size() > 0) {
                Offer offer = list.get(0);
                CacheData.OFF_CACHE.put(offer.getId(), offer);
                AdTool.cacheOfferTargetHour(offer);
                return offer;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PublisherOffer cachePublisherOfferFirst(String key, Integer publisherid, Integer offerid) {

        if (CacheData.PUB_OFF_CACHE.containsKey(key)) {
            return CacheData.PUB_OFF_CACHE.get(key);
        }

        PublisherOfferExample publisherOfferExample = new PublisherOfferExample();
        publisherOfferExample.createCriteria().andOfferidEqualTo(offerid).andPublisheridEqualTo(publisherid);

        List<PublisherOffer> list = publisherOfferMapper.selectByExample(publisherOfferExample);
        if (list != null && list.size() > 0) {

            PublisherOffer offer = list.get(0);
            CacheData.PUB_OFF_CACHE.put(key, offer);

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
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Publisher getPublisherCache(Integer publisherid) {
        Publisher publisher = CacheData.PUB_CACHE.get(publisherid);
        if (publisher == null) {
            publisher = publisherMapper.selectByPrimaryKey(publisherid);
            if (publisher != null) {

                CacheData.PUB_CACHE.put(publisherid, publisher);
            }

        }
        return publisher;
    }

    @Override
    public Offer getOfferCache(Integer id) {
        if (id == null) {
            return null;
        }
        Offer offer = CacheData.OFF_CACHE.get(id);
        if (offer == null) {
            OfferExample example = new OfferExample();
            example.createCriteria().andIdEqualTo(id);
            List<Offer> offers = offerMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(offers)) {
                offer = offers.get(0);
                CacheData.OFF_CACHE.put(id, offer);
                AdTool.cacheOfferTargetHour(offer);

            }

        }
        return offer;
    }

    @Override
    public PublisherOffer getPubOfferCache(Integer pubid, Integer offid) {
        String pokey = pubid + "_" + offid;

        PublisherOffer po = CacheData.PUB_OFF_CACHE.get(pokey);
        if (po == null) {
            PublisherOfferExample example = new PublisherOfferExample();
            example.createCriteria().andPublisheridEqualTo(pubid).andOfferidEqualTo(offid);

            List<PublisherOffer> publisherOfferList = publisherOfferMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(publisherOfferList)) {
                po = publisherOfferList.get(0);
                CacheData.PUB_OFF_CACHE.put(pokey, po);

            }
        }
        return po;
    }

    @Override
    public PublisherOffer getPubOffer(Integer pubid, Integer offid) {
        String pokey = pubid + "_" + offid;

        PublisherOfferExample example = new PublisherOfferExample();
        example.createCriteria().andPublisheridEqualTo(pubid).andOfferidEqualTo(offid);

        List<PublisherOffer> publisherOfferList = publisherOfferMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(publisherOfferList)) {
            PublisherOffer po = publisherOfferList.get(0);
            CacheData.PUB_OFF_CACHE.put(pokey, po);
            return po;

        }
        return null;
    }

    @Override
    public boolean capFull(PublisherOffer publisherOffer, String pokey) {
        if (CacheData.PUB_OFF_CAP_CACHE.containsKey(pokey)) {
            int cuccentCap = CacheData.PUB_OFF_CAP_CACHE.get(pokey);
            int dayCap = publisherOffer.getDailycap();
            if (cuccentCap > (dayCap - 2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean redirectError(PublisherOffer publisherOffer, String pokey) {
        return false;
    }

    @Override
    public int capAction(Integer pubid, Integer offid, PublisherOffer publisherOffer) {
        try {
            String key = pubid + "-" + offid;
            if (CacheData.PUB_OFF_CAP_CACHE.containsKey(key)) {
                int cap = CacheData.PUB_OFF_CAP_CACHE.get(key);
                int limit = 50;
                if (publisherOffer != null && publisherOffer.getDailycap() != null) {
                    limit = publisherOffer.getDailycap();
                }

                if (cap >= limit) {

                    return 1;

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        Offer offer = new Offer();
        System.out.println(offer);
        Offer oriOffer = offer;
        System.out.println(oriOffer);

        offer = new Offer();

        System.out.println(offer);
        offer = oriOffer;
        System.out.println(offer);


    }
}
