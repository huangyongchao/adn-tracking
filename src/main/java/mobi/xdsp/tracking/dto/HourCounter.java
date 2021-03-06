package mobi.xdsp.tracking.dto;

import mobi.xdsp.tracking.core.job.ClickCount;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangyongchao
 */

public class HourCounter {
    public static volatile int CURRENT_HOUR = 0;
    public static volatile int DAY = 1;
    public static AtomicBoolean EXCHANGE_LOCK = new AtomicBoolean(false);
    public static Map<Integer, AtomicInteger> DAILY_CLICKS = new HashMap<>();

    public static Map<Integer, Map<Integer, ClickCount>> TODAY_HOUR_COUNTER = null;

    public static Map<Integer, Map<Integer, ClickCount>> YESDAY_HOUR_COUNTER = null;

    public static Map<Integer, Map<Integer, ClickCount>> initToday() {
        Map<Integer, Map<Integer, ClickCount>> t = new ConcurrentHashMap<>();
        t.put(0, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(1, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(2, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(3, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(4, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(5, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(6, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(7, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(8, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(9, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(10, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(11, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(12, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(13, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(14, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(15, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(16, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(17, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(18, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(19, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(20, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(21, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(22, new ConcurrentHashMap<Integer, ClickCount>());
        t.put(23, new ConcurrentHashMap<Integer, ClickCount>());

        return t;
    }

    public static Map<Integer, ClickCount> counterMap() {
        if (TODAY_HOUR_COUNTER == null) {
            TODAY_HOUR_COUNTER = initToday();
        }
        return TODAY_HOUR_COUNTER.get(CURRENT_HOUR);
    }
    /*???????????????????????????*/
    public static synchronized boolean exchange() {
        if (EXCHANGE_LOCK.get()) {
            return false;
        }
        YESDAY_HOUR_COUNTER = TODAY_HOUR_COUNTER;
        TODAY_HOUR_COUNTER = initToday();
        DAILY_CLICKS = new HashMap<>();
        EXCHANGE_LOCK.set(true);
        return true;
    }


    public static void increaseSuccess(int offerid) {
        if (!counterMap().containsKey(offerid)) {
            counterMap().put(offerid, new ClickCount());
        }
        counterMap().get(offerid).success.increment();
        counterMap().get(offerid).total.increment();
    }


    public static void increaseError(int offerid) {
        if (!counterMap().containsKey(offerid)) {
            counterMap().put(offerid, new ClickCount());
        }
        counterMap().get(offerid).error.increment();
        counterMap().get(offerid).total.increment();
    }

    public static void increaseSuccess1(int offerid) {
        if (!counterMap().containsKey(offerid)) {
            counterMap().put(offerid, new ClickCount());
        }
        counterMap().get(offerid).total.increment();
    }

    public static void increaseError1(int offerid) {
        if (!counterMap().containsKey(offerid)) {
            counterMap().put(offerid, new ClickCount());
        }
        counterMap().get(offerid).total.increment();
    }

}
