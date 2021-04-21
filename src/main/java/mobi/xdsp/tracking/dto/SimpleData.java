package mobi.xdsp.tracking.dto;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class SimpleData {
    public static Map<Integer, Integer> OFFER_CLICKS = new HashMap();
    public static Map<String, AtomicLong> OFFERREQCOUNTER = new HashMap();
    public static Set<Integer> BLACK_OFFERS = new HashSet<>();
    public static Map<Integer, String> OFFER_LAND = new HashMap();
    public static Map<String, AtomicLong> OFFERERROR = new HashMap();
    public static Map<Integer, Map<String, AtomicLong>> LIVEOFFERSR_EDIRECT = new HashMap();
    public static Set<Integer> PAUSE_OFFERS = new HashSet<>();


}
