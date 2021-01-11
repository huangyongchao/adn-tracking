package com.adscanal.sdk.dto;

import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangyongchao
 */

public class Counter {
    public static volatile int CURRENT_HOUR = 0;
    public static volatile int DAY = 1;
    public static AtomicBoolean EXCHANGE_LOCK = new AtomicBoolean(false);
    public static Map<Integer, AtomicInteger> DAILY_CLICKS = new HashMap<>();
    public static Map<Integer, AtomicInteger> SUB_CLICKS = new HashMap<>();

    public static Map<Integer, Map<Integer, OfferCounter>> TODAY_COUNTER = null;

    public static Map<Integer, Map<Integer, OfferCounter>> YESDAY_COUNTER = null;

    public static Map<Integer, Map<Integer, OfferCounter>> initToday() {
        Map<Integer, Map<Integer, OfferCounter>> t = new ConcurrentHashMap<>();
        t.put(0, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(1, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(2, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(3, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(4, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(5, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(6, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(7, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(8, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(9, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(10, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(11, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(12, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(13, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(14, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(15, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(16, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(17, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(18, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(19, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(20, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(21, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(22, new ConcurrentHashMap<Integer, OfferCounter>());
        t.put(23, new ConcurrentHashMap<Integer, OfferCounter>());

        return t;
    }

    public static Map<Integer, OfferCounter> counterMap() {
        if (TODAY_COUNTER == null) {
            TODAY_COUNTER = initToday();
        }
        return TODAY_COUNTER.get(CURRENT_HOUR);
    }
    /*每天凌晨初始化一次*/
    public static synchronized boolean exchange() {
        if (EXCHANGE_LOCK.get()) {
            return false;
        }
        YESDAY_COUNTER = TODAY_COUNTER;
        TODAY_COUNTER = initToday();
        SimpleData.PAUSE_OFFERS = Sets.newHashSet();
        DAILY_CLICKS = new HashMap<>();
        EXCHANGE_LOCK.set(true);
        return true;
    }


    public static void increaseSuccess(int offerid) {
        if (!counterMap().containsKey(offerid)) {
            counterMap().put(offerid, new OfferCounter());
        }
        counterMap().get(offerid).success.increment();
        counterMap().get(offerid).total.increment();
    }


    public static void increaseError(int offerid) {
        if (!counterMap().containsKey(offerid)) {
            counterMap().put(offerid, new OfferCounter());
        }
        counterMap().get(offerid).error.increment();
        counterMap().get(offerid).total.increment();
    }

    public static void increaseSuccess1(int offerid) {
        if (!counterMap().containsKey(offerid)) {
            counterMap().put(offerid, new OfferCounter());
        }
        counterMap().get(offerid).success1.increment();
        counterMap().get(offerid).total.increment();
    }

    public static void increaseError1(int offerid) {
        if (!counterMap().containsKey(offerid)) {
            counterMap().put(offerid, new OfferCounter());
        }
        counterMap().get(offerid).error1.increment();
        counterMap().get(offerid).total.increment();
    }

}
