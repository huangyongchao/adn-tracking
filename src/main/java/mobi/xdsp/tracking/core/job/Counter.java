package mobi.xdsp.tracking.core.job;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Counter {
    //publisherid ,offerid,hour,subid,计数器
    public static Map<Integer, Map<Integer, Map<Integer, Map<String, ClickCount>>>> COUNTER_HOUR_TODAY = Maps.newConcurrentMap();
    public static Map<Integer, Map<Integer, Map<Integer, Map<String, ClickCount>>>> COUNTER_HOUR_YESTERDAY = Maps.newConcurrentMap();

    public static void increaseClick(Integer publisherid, Integer offerid, Integer hour, String pub_sub, int type, int amount) {

        if (!COUNTER_HOUR_TODAY.containsKey(publisherid)) {
            COUNTER_HOUR_TODAY.put(publisherid, Maps.newConcurrentMap());
        }
        if (!COUNTER_HOUR_TODAY.get(publisherid).containsKey(offerid)) {
            COUNTER_HOUR_TODAY.get(publisherid).put(offerid, Maps.newConcurrentMap());
        }
        if (!COUNTER_HOUR_TODAY.get(publisherid).get(offerid).containsKey(hour)) {
            COUNTER_HOUR_TODAY.get(publisherid).get(offerid).put(hour, Maps.newConcurrentMap());
        }
        if (!COUNTER_HOUR_TODAY.get(publisherid).get(offerid).get(hour).containsKey(pub_sub)) {
            COUNTER_HOUR_TODAY.get(publisherid).get(offerid).get(hour).put(pub_sub, new ClickCount());
        }
        if (type == 0) {
            for (int i = 0; i < amount; i++) {

                COUNTER_HOUR_TODAY.get(publisherid).get(offerid).get(hour).get(pub_sub).total.increment();
            }

        } else if (type == 1) {
            for (int i = 0; i < amount; i++) {

                COUNTER_HOUR_TODAY.get(publisherid).get(offerid).get(hour).get(pub_sub).success.increment();
            }
        } else if (type == 2) {
            for (int i = 0; i < amount; i++) {

                COUNTER_HOUR_TODAY.get(publisherid).get(offerid).get(hour).get(pub_sub).error.increment();
            }
        }

    }

    public static AtomicBoolean EXCHANGE_LOCK = new AtomicBoolean(false);

    /*每天凌晨初始化一次*/
    public static synchronized boolean exchange() {
        if (EXCHANGE_LOCK.get()) {
            return false;
        }
        COUNTER_HOUR_YESTERDAY = COUNTER_HOUR_TODAY;
        COUNTER_HOUR_TODAY = Maps.newConcurrentMap();
        EXCHANGE_LOCK.set(true);
        return true;
    }

}
