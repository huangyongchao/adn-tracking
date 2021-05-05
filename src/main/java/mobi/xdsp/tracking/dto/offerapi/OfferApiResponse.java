/**
 * Copyright 2020 bejson.com
 */
package mobi.xdsp.tracking.dto.offerapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.aerospike.mapping.Document;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferApiResponse {

    private boolean success;
    private List<Offers> offers;
    private boolean next;

}