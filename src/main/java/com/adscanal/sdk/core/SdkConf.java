package com.adscanal.sdk.core;

import com.adscanal.sdk.dto.GeoProxy;
import com.adscanal.sdk.dto.OsE;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

public class SdkConf {
    public static Map<Integer, ScheduledExecutorService> OFFER_SCHED = new HashMap<>();

    public static Map<String, ArrayBlockingQueue> GEO_OS_QUE = Maps.newHashMap();
    public static Set<String> ACTI_GEO = Sets.newHashSet();
    public static Set<String> RUNPRODUCERS = Sets.newHashSet();

    public static void setGeoOsQue(List<GeoProxy> list) {
        list.forEach(o -> {
            ACTI_GEO.add(o.getGeo());
            if (!GEO_OS_QUE.containsKey(o.getGeo() + OsE.IOS.name)) {

                GEO_OS_QUE.put(o.getGeo() + OsE.IOS.name, new ArrayBlockingQueue<String>(1000));
            }
            if (!GEO_OS_QUE.containsKey(o.getGeo() + OsE.AOS.name)) {

                GEO_OS_QUE.put(o.getGeo() + OsE.AOS.name, new ArrayBlockingQueue<String>(1000));
            }
        });
    }


}
