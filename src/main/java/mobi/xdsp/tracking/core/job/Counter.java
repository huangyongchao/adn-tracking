package mobi.xdsp.tracking.core.job;

import com.google.common.collect.Maps;
import mobi.xdsp.tracking.dto.ClickCount;

import java.util.Map;

public class Counter {
/*

    public static String SPE = "";
    public static Map<String, ClickCount> COUNTER_HOUR_TODAY = Maps.newConcurrentMap();
    public static Map<String, ClickCount> COUNTER_HOUR_YESTERDAY = Maps.newConcurrentMap();

    public static void increaseClick(Integer publisherid, Integer offerid, Integer hour, String pub_sub, int type) {

    }
*/


    //publisherid ,offerid,hour,subid,计数器
    public static Map<Integer, Map<Integer, Map<Integer, Map<String, ClickCount>>>> COUNTER_HOUR_TODAY = Maps.newConcurrentMap();
    public static Map<Integer, Map<Integer, Map<Integer, Map<String, ClickCount>>>> COUNTER_HOUR_YESTERDAY = Maps.newConcurrentMap();

    public static void increaseClick(Integer publisherid, Integer offerid, Integer hour, String pub_sub, int type) {

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
            COUNTER_HOUR_TODAY.get(publisherid).get(offerid).get(hour).get(pub_sub).total.increment();
        }
        if (type == 1) {
            COUNTER_HOUR_TODAY.get(publisherid).get(offerid).get(hour).get(pub_sub).success.increment();
        }
        if (type == 2) {
            COUNTER_HOUR_TODAY.get(publisherid).get(offerid).get(hour).get(pub_sub).error.increment();
        }

    }
}
