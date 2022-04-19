package mobi.xdsp.tracking.core;

import com.google.common.collect.Maps;
import mobi.xdsp.tracking.entity.Affiliate;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.Publisher;
import mobi.xdsp.tracking.entity.PublisherOffer;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class CacheData {
    /*key+id*/
    public static Map<Integer, Integer> OFF_SYCN_LOCK = Maps.newConcurrentMap();
    public static Map<String, Integer> PUBOFF_SYCN_LOCK = Maps.newConcurrentMap();

    /*key 前缀*/
    public static String AFF = "aff";
    public static String PUBLISHER = "pub";
    public static String OFFER = "off";
    public static String PUBLISHER_OFFER = "puo";
    public static String PUBLISHER_SUB = "psb";
    /*增量缓存*/
    public static Map<Integer, Affiliate> AFF_CACHE = Maps.newConcurrentMap();
    public static Map<Integer, Offer> OFF_CACHE = Maps.newConcurrentMap();
    public static Map<Integer, Set<Integer>> OFF_TARGET_CACHE = Maps.newConcurrentMap();
    public static Map<Integer, Publisher> PUB_CACHE = Maps.newConcurrentMap();
    public static Map<String, Publisher> PUB_TOKEN = Maps.newConcurrentMap();

    public static Map<String, PublisherOffer> PUB_OFF_CACHE = Maps.newConcurrentMap();
    public static Map<String, Integer> PUB_OFF_CLICKCAP_CACHE = Maps.newConcurrentMap();

    public static Map<Integer, PublisherOffer> SUB_CACHE = Maps.newConcurrentMap();
    /*affiliate & publisher 初始化就加载*/


    public static Map<String, AtomicInteger> DAILY_CAP_CACHE = Maps.newConcurrentMap();


}
