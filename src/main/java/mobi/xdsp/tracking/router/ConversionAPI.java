package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.mapper.AffiliateMapper;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PublisherOfferMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
public class ConversionAPI {

    @Autowired
    WebApplicationContext applicationContext;
    @Autowired
    OfferMapper offerMapper;
    @Autowired
    AffiliateMapper affiliateMapper;

    @Autowired
    PublisherOfferMapper publisherOfferMapper;

    @GetMapping("/conversion")
    public Object conversion(@RequestParam(value = "token", required = true) String token) {

        return null;
    }

    public static void main(String[] args) {
    }
}
