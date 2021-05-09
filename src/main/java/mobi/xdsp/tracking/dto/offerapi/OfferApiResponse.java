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
public class OfferApiResponse {

    private boolean success;
    private String msg;
    private List<Offers> offers;
    private boolean next;

}