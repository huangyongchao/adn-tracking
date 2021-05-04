package mobi.xdsp.tracking.service;

import mobi.xdsp.tracking.entity.Affiliate;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.Publisher;
import mobi.xdsp.tracking.entity.PublisherOffer;

import java.util.List;

public interface DataService {

    public List<Affiliate> cacheAffiliate();
    public List<Publisher> cachePublisher();
    public Offer cacheOffer(Integer id);
    public PublisherOffer cachePublisherOffer(Integer offerid, Integer publisherid);

}
