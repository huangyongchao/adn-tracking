package com.adscanal.sdk.dto;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class SimpleData {
    public static Map<String, List<LiveOffer>> GOFFERS = new HashMap();
    public static Map<Integer, LiveOffer> LIVEOFFERS = new HashMap();
    public static Map<Integer, Integer> OFFER_CLICKS = new HashMap();
    public static Map<String, ProducerCounter> PRODUCERCOUNTER = new HashMap();
    public static Set<Integer> BLACK_OFFERS = new HashSet<>();
    public static Map<String, String> OFFER_LAND = new HashMap();
    public static Map<String, AtomicLong> OFFERERROR = new HashMap();
    public static Map<Integer, Map<String, AtomicLong>> LIVEOFFERSR_EDIRECT = new HashMap();
    public static Set<Integer> PAUSE_OFFERS = new HashSet<>();


}
