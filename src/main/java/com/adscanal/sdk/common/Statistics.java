package com.adscanal.sdk.common;

import com.adscanal.sdk.dto.OfferCounter;
import com.adscanal.sdk.dto.Tracker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    public static Map<String, Map<Integer, Map<String, OfferCounter>>> statistics = new HashMap();
    public static Map<String, List<Tracker>> offer_tracker = new HashMap();



}
