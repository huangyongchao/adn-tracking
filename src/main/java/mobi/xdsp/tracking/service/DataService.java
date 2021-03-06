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
    public PublisherOffer cachePublisherOfferFirst(String key, Integer publisherid,Integer offerid);
    public Publisher cachePublisherByToken(String token);

    public Offer cachePubliserOffer(Publisher publisher);


    public Offer getOfferCache(Integer offerid);
    public Publisher getPublisherCache(Integer publisherid);

    public PublisherOffer getPubOfferCache(Integer pubid, Integer offid);
    public PublisherOffer getPubOffer(Integer pubid, Integer offid);

    public int capAction(Integer pubid, Integer offid, PublisherOffer publisherOffer);

    public boolean capFull(PublisherOffer publisherOffer,String pokey);
    public boolean redirectError(PublisherOffer publisherOffer,String pokey);
}
