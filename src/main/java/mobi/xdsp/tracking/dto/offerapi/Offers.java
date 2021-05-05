/**
 * Copyright 2020 bejson.com
 */
package mobi.xdsp.tracking.dto.offerapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Offers {

    private int id;
    private String name;
    private boolean incent;
    private String description;
    private String payoutType;
    private String appId;
    private String previewUrl;
    private float payout;
    private String currency;
    private String os;
    private String minOsVersion;
    private String geo;
    private String tracking_url;
    private int monthlyCap;
    private int dailyCap;
    private int clickCap;
    private boolean attParams;
    private String kpis;
    private String blacklist;
    private String whitelist;
    private boolean s2sLink;
    private List<Creative> creatives;


}