package com.adscanal.sdk.common;

import com.google.common.collect.Maps;

import java.time.ZoneId;
import java.util.Map;

/**
 * country  timezone
 */
public class Ctz {

    private final static Map<String, String> COUNTRY_TIMEZONE = Maps.newHashMap();

    static {
        COUNTRY_TIMEZONE.put("ARE", "+04:00");
        COUNTRY_TIMEZONE.put("ARG", "-03:00");
        COUNTRY_TIMEZONE.put("AUT", "+01:00");
        COUNTRY_TIMEZONE.put("AUS", "+09:00");
        COUNTRY_TIMEZONE.put("BGD", "+06:00");
        COUNTRY_TIMEZONE.put("BHR", "+03:00");
        COUNTRY_TIMEZONE.put("BRA", "+00:00");
        COUNTRY_TIMEZONE.put("BLR", "+02:00");
        COUNTRY_TIMEZONE.put("CAN", "-03:00");
        COUNTRY_TIMEZONE.put("CHL", "-04:00");
        COUNTRY_TIMEZONE.put("COL", "+00:00");
        COUNTRY_TIMEZONE.put("CZE", "+01:00");
        COUNTRY_TIMEZONE.put("DEU", "+01:00");
        COUNTRY_TIMEZONE.put("EGY", "+02:00");
        COUNTRY_TIMEZONE.put("ESP", "+01:00");
        COUNTRY_TIMEZONE.put("FRA", "+01:00");
        COUNTRY_TIMEZONE.put("HKG", "+08:00");
        COUNTRY_TIMEZONE.put("IDN", "+08:00");
        COUNTRY_TIMEZONE.put("IND", "+05:00");
        COUNTRY_TIMEZONE.put("IRQ", "+03:00");
        COUNTRY_TIMEZONE.put("IRN", "+04:00");
        COUNTRY_TIMEZONE.put("ITA", "+01:00");
        COUNTRY_TIMEZONE.put("JPN", "+09:00");
        COUNTRY_TIMEZONE.put("KWT", "+03:00");
        COUNTRY_TIMEZONE.put("LBN", "+02:00");
        COUNTRY_TIMEZONE.put("MAR", "+00:00");
        COUNTRY_TIMEZONE.put("MEX", "-07:00");
        COUNTRY_TIMEZONE.put("MYS", "+08:00");
        COUNTRY_TIMEZONE.put("NGA", "+01:00");
        COUNTRY_TIMEZONE.put("NLD", "+01:00");
        COUNTRY_TIMEZONE.put("OMN", "+04:00");
        COUNTRY_TIMEZONE.put("PER", "-04:00");
        COUNTRY_TIMEZONE.put("PHL", "+08:00");
        COUNTRY_TIMEZONE.put("PAK", "+05:00");
        COUNTRY_TIMEZONE.put("POL", "+01:00");
        COUNTRY_TIMEZONE.put("QAT", "+03:00");
        COUNTRY_TIMEZONE.put("RUS", "+03:00");
        COUNTRY_TIMEZONE.put("SGP", "+08:00");
        COUNTRY_TIMEZONE.put("SVK", "+01:00");
        COUNTRY_TIMEZONE.put("THA", "+07:00");
        COUNTRY_TIMEZONE.put("TUR", "+03:00");
        COUNTRY_TIMEZONE.put("TZA", "+03:00");
        COUNTRY_TIMEZONE.put("USA", "-04:00");
        COUNTRY_TIMEZONE.put("VNM", "+07:00");
        COUNTRY_TIMEZONE.put("CHN", "+08:00");
        COUNTRY_TIMEZONE.put("ETH", "+03:00");
        COUNTRY_TIMEZONE.put("GBR", "+00:00");
        COUNTRY_TIMEZONE.put("TWN", "+08:00");
        COUNTRY_TIMEZONE.put("SAU", "+03:00");
        COUNTRY_TIMEZONE.put("KOR", "+09:00");
        COUNTRY_TIMEZONE.put("PRT", "+00:00");
        COUNTRY_TIMEZONE.put("KEN", "+03:00");
        COUNTRY_TIMEZONE.put("GBR", "+00:00");
    }

    public static ZoneId of(String country) {
        if (COUNTRY_TIMEZONE.containsKey(country.toUpperCase())) {
            return ZoneId.of(COUNTRY_TIMEZONE.get(country.toUpperCase()));
        }
        return ZoneId.of("+00:00");
    }

}
