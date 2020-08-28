package com.adscanal.sdk.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Counter {
    public static int chour;
    public static AtomicBoolean lock = new AtomicBoolean(false);

    public static Map<Integer, Map<String, OfferCounter>> today = new HashMap<>();
    public static Map<Integer, Map<String, OfferCounter>> yesday = new HashMap<>();

    public static Map<Integer, Map<String, OfferCounter>> initToday() {
        Map<Integer, Map<String, OfferCounter>> t = new HashMap<>();
        t.put(0, new HashMap<String, OfferCounter>());
        t.put(1, new HashMap<String, OfferCounter>());
        t.put(2, new HashMap<String, OfferCounter>());
        t.put(3, new HashMap<String, OfferCounter>());
        t.put(4, new HashMap<String, OfferCounter>());
        t.put(5, new HashMap<String, OfferCounter>());
        t.put(6, new HashMap<String, OfferCounter>());
        t.put(7, new HashMap<String, OfferCounter>());
        t.put(8, new HashMap<String, OfferCounter>());
        t.put(9, new HashMap<String, OfferCounter>());
        t.put(10, new HashMap<String, OfferCounter>());
        t.put(11, new HashMap<String, OfferCounter>());
        t.put(12, new HashMap<String, OfferCounter>());
        t.put(13, new HashMap<String, OfferCounter>());
        t.put(14, new HashMap<String, OfferCounter>());
        t.put(15, new HashMap<String, OfferCounter>());
        t.put(16, new HashMap<String, OfferCounter>());
        t.put(17, new HashMap<String, OfferCounter>());
        t.put(18, new HashMap<String, OfferCounter>());
        t.put(19, new HashMap<String, OfferCounter>());
        t.put(20, new HashMap<String, OfferCounter>());
        t.put(21, new HashMap<String, OfferCounter>());
        t.put(22, new HashMap<String, OfferCounter>());
        t.put(23, new HashMap<String, OfferCounter>());
        t.put(24, new HashMap<String, OfferCounter>());

        return t;
    }

    public Map<String, OfferCounter> getCounterMap() {
        return today.get(chour);
    }

    public static void exchange() {
        if(lock.get()){
            return;
        }
        yesday = today;
        today = initToday();
        lock.set(true);
    }

}
