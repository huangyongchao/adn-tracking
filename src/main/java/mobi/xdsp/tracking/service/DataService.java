package mobi.xdsp.tracking.service;

import mobi.xdsp.tracking.entity.Affiliate;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.Publisher;
import mobi.xdsp.tracking.entity.PublisherOffer;

import java.util.List;

public interface DataService {

    public List<Affiliate> cacheAffiliateAll();
    public List<Publisher> cachePublisherAll();
    public Offer cacheOfferFirst(Integer id);
    public PublisherOffer cachePublisherOfferFirst(String key,Integer offerid, Integer publisherid);

    public Offer cachePubliserOffer(Publisher publisher);


}
