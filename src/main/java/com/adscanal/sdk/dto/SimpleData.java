package com.adscanal.sdk.dto;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class SimpleData {
    public static Map<String, List<LiveOffer>> GOFFERS = new HashMap();
    public static Map<String, Integer> OFFER_CLICKS = new HashMap();
    public static Set<String> BLACK_OFFERS = new HashSet<>();
    public static Map<String, String> OFFER_LAND = new HashMap();
    public static Map<String, AtomicLong> OFFERERROR = new HashMap();

}
