package com.adscanal.sdk.core;

import com.adscanal.sdk.dto.OsE;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

public class SdkConf {
    public static Map<String, ScheduledExecutorService> OFFER_SCHED_STABLE = new HashMap<>();
    public static Map<String, ScheduledExecutorService> OFFER_SCHED_NEW = new HashMap<>();

    public static Map<String, ArrayBlockingQueue> GEO_OS_QUE = Maps.newHashMap();
    public static List<String> ACTI_GEO = Lists.newArrayList("VN", "CA", "IL", "MY", "KW", "CO", "CL");
    static {
        ACTI_GEO.forEach(geo -> {
            GEO_OS_QUE.put(geo + OsE.IOS.name, new ArrayBlockingQueue<String>(1000));
            GEO_OS_QUE.put(geo + OsE.AOS.name, new ArrayBlockingQueue<String>(1000));
        });
    }

}
