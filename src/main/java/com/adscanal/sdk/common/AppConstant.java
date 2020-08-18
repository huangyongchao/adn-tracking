package com.adscanal.sdk.common;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppConstant {
    public static final Set<String> ACTI_GEOS = Sets.newHashSet( "IND");
    public static final List<String> ACTI_OS = Lists.newArrayList( "ios");
    public static final String NEWL = "\r\n";
    public static final String IOS = "ios";
    public static final String ANDROID = "android";
    public static Path uapath = Paths.get("/Users/huangyongchao/newprj/src/main/java/com/adscanal/sdk/datafile/ua");
    public static Map<String, List<String>> GEO_UA = Maps.newHashMap();


    public static void initGua() {
        try {
            Files.lines(uapath).forEach(ua -> {
                String[] uary = ua.split("\\|");
                ACTI_GEOS.forEach(geo -> {
                    if (ua.startsWith(geo)) {
                        if (!GEO_UA.containsKey(uary[0])) {
                            GEO_UA.put(uary[0], Lists.newArrayList());
                        }
                        GEO_UA.get(uary[0]).add(uary[1]);
                    }
                });

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        initGua();
        System.out.println(1);
    }

}
