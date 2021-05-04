package mobi.xdsp.tracking.core;

import com.google.common.collect.Maps;
import mobi.xdsp.tracking.entity.Affiliate;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.Publisher;
import mobi.xdsp.tracking.entity.PublisherOffer;

import java.util.Map;

public class CacheData {
    /*key+id*/
    public static Map<String, Boolean> SYCN_LOCK = Maps.newHashMap();

    /*key 前缀*/
    public static String AFF = "aff";
    public static String PUBLISHER = "pub";
    public static String OFFER = "off";
    public static String PUBLISHER_OFFER = "puo";
    public static String PUBLISHER_SUB = "psb";
    /*增量缓存*/
    public static Map<Integer, Affiliate> AFF_CACHE = Maps.newConcurrentMap();
    public static Map<Integer, Offer> OFF_CACHE = Maps.newConcurrentMap();
    public static Map<Integer, Publisher> PUB_CACHE = Maps.newConcurrentMap();
    public static Map<String, PublisherOffer> PUB_OFF_CACHE = Maps.newConcurrentMap();
    public static Map<Integer, PublisherOffer> SUB_CACHE = Maps.newConcurrentMap();
    /*affiliate & publisher 初始化就加载*/


}
