/**
 * Copyright 2020 bejson.com
 */
package mobi.xdsp.tracking.dto.offerapi;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offers {

    private int id;
    private String name;
    private String mafid;
    private boolean incent;
    private String description;
    private String restrictions;
    private String payoutType;
    private String payEvent;
    private String appId;
    private String appName;
    private String category;
    private String previewUrl;
    private float payout;
    private String currency;
    private String os;
    private String minOsVersion;
    private String geo;
    private String trackingUrl;
    private int monthlyCap;
    private int dailyCap;
    private int clickCap;
    private boolean iosATT;
    private String kpis;
    private String blacklist;
    private String whitelist;
    private boolean s2sLink;
    private int subtype;
    private String suggestSubs;
    private String targetScheduleUTC;
    private List<String> targetCities = Lists.newLinkedList();
    private List<String> targetCarries = Lists.newLinkedList();
    private List<String> targetDeviceModels = Lists.newLinkedList();
    private List<String> targetStoreCategories = Lists.newLinkedList();
    private List<String> targetIabCategories = Lists.newLinkedList();
    private List<String> targetConnectTypes = Lists.newLinkedList();
    private List<String> targetDeviceTypes = Lists.newLinkedList();
    private List<Creative> creatives = Lists.newLinkedList();


}