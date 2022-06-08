package mobi.xdsp.tracking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.PublisherOffer;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MixTrack {

    private Offer offer;
    private String poKey;
    private PublisherOffer publisherOffer;

}
