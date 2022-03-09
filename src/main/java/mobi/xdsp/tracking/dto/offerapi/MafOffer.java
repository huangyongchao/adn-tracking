/**
 * Copyright 2020 bejson.com
 */
package mobi.xdsp.tracking.dto.offerapi;

import com.google.common.collect.Lists;
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
public class MafOffer {

    private String mafid;
    //private String clickUrl;
    private int clickcap = 1;
    private String geo;
    private String os;
    private String suggestSubs;
    private String targetScheduleUTC;

}