package com.adscanal.sdk.dto;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author huangyongchao
 */

public class Counter {
    public static volatile int CURRENT_HOUR = 0;
    public static AtomicBoolean EXCHANGE_LOCK = new AtomicBoolean(false);

    public static Map<Integer, Map<String, OfferCounter>> TODAY_COUNTER = null;
    public static Map<Integer, Map<String, OfferCounter>> YESDAY_COUNTER = null;

    public static Map<Integer, Map<String, OfferCounter>> initToday() {
        Map<Integer, Map<String, OfferCounter>> t = new ConcurrentHashMap<>();
        t.put(0, new ConcurrentHashMap<String, OfferCounter>());
        t.put(1, new ConcurrentHashMap<String, OfferCounter>());
        t.put(2, new ConcurrentHashMap<String, OfferCounter>());
        t.put(3, new ConcurrentHashMap<String, OfferCounter>());
        t.put(4, new ConcurrentHashMap<String, OfferCounter>());
        t.put(5, new ConcurrentHashMap<String, OfferCounter>());
        t.put(6, new ConcurrentHashMap<String, OfferCounter>());
        t.put(7, new ConcurrentHashMap<String, OfferCounter>());
        t.put(8, new ConcurrentHashMap<String, OfferCounter>());
        t.put(9, new ConcurrentHashMap<String, OfferCounter>());
        t.put(10, new ConcurrentHashMap<String, OfferCounter>());
        t.put(11, new ConcurrentHashMap<String, OfferCounter>());
        t.put(12, new ConcurrentHashMap<String, OfferCounter>());
        t.put(13, new ConcurrentHashMap<String, OfferCounter>());
        t.put(14, new ConcurrentHashMap<String, OfferCounter>());
        t.put(15, new ConcurrentHashMap<String, OfferCounter>());
        t.put(16, new ConcurrentHashMap<String, OfferCounter>());
        t.put(17, new ConcurrentHashMap<String, OfferCounter>());
        t.put(18, new ConcurrentHashMap<String, OfferCounter>());
        t.put(19, new ConcurrentHashMap<String, OfferCounter>());
        t.put(20, new ConcurrentHashMap<String, OfferCounter>());
        t.put(21, new ConcurrentHashMap<String, OfferCounter>());
        t.put(22, new ConcurrentHashMap<String, OfferCounter>());
        t.put(23, new ConcurrentHashMap<String, OfferCounter>());

        return t;
    }

    public static Map<String, OfferCounter> counterMap() {
        if (TODAY_COUNTER == null) {
            TODAY_COUNTER = initToday();
        }
        return TODAY_COUNTER.get(CURRENT_HOUR);
    }

    public static synchronized boolean exchange() {
        if (EXCHANGE_LOCK.get()) {
            return false;
        }
        YESDAY_COUNTER = TODAY_COUNTER;
        TODAY_COUNTER = initToday();
        EXCHANGE_LOCK.set(true);
        return true;
    }


    public static void increaseSuccess(String offerid) {
        if (!counterMap().containsKey(offerid)) {
            counterMap().put(offerid, new OfferCounter());
        }
        counterMap().get(offerid).success.increment();
        counterMap().get(offerid).total.increment();
    }

    public static void increaseError(String offerid) {
        if (!counterMap().containsKey(offerid)) {
            counterMap().put(offerid, new OfferCounter());
        }
        counterMap().get(offerid).error.increment();
        counterMap().get(offerid).total.increment();
    }

    public static void increaseSuccess1(String offerid) {
        if (!counterMap().containsKey(offerid)) {
            counterMap().put(offerid, new OfferCounter());
        }
        counterMap().get(offerid).success1.increment();
        counterMap().get(offerid).total.increment();
    }

    public static void increaseError1(String offerid) {
        if (!counterMap().containsKey(offerid)) {
            counterMap().put(offerid, new OfferCounter());
        }
        counterMap().get(offerid).error1.increment();
        counterMap().get(offerid).total.increment();
    }

}
