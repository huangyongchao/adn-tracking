package mobi.xdsp.tracking.service;

import mobi.xdsp.tracking.entity.*;
import mobi.xdsp.tracking.mapper.AffiliateMapper;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PublisherMapper;
import mobi.xdsp.tracking.mapper.PublisherOfferMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Affiliate> cacheAffiliate() {
        AffiliateExample example = new AffiliateExample();
        return affiliateMapper.selectByExample(example);
    }

    @Override
    public List<Publisher> cachePublisher() {
        PublisherExample example = new PublisherExample();
        return publisherMapper.selectByExample(example);
    }

    @Override
    public Offer cacheOffer(Integer id) {
        OfferExample offerExample = new OfferExample();
        offerExample.createCriteria().andIdEqualTo(id);
        List<Offer> list = offerMapper.selectByExample(offerExample);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public PublisherOffer cachePublisherOffer(Integer offerid, Integer publisherid) {
        PublisherOfferExample publisherOfferExample = new PublisherOfferExample();
        publisherOfferExample.createCriteria().andOfferidEqualTo(offerid).andPublisheridEqualTo(publisherid);

        List<PublisherOffer> list = publisherOfferMapper.selectByExample(publisherOfferExample);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
