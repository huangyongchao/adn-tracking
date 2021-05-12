package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.mapper.AffiliateMapper;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PublisherOfferMapper;
import mobi.xdsp.tracking.repositories.AerospikeClickRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

@RestController
public class ConversionAPI {

    @Autowired
    private AerospikeClickRepository repository;

    @Autowired
    WebApplicationContext applicationContext;
    @Autowired
    OfferMapper offerMapper;
    @Autowired
    AffiliateMapper affiliateMapper;

    @Autowired
    PublisherOfferMapper publisherOfferMapper;

    @GetMapping("/conversion")
    public Object conversion(
            @RequestParam(value = "clickid", required = true) String clickid,
            @RequestParam(value = "click_id", defaultValue = "") String clickidbak,
            @RequestParam(value = "advid") Integer advid,
            @RequestParam(value = "event",defaultValue = "") String event ,
            @RequestParam(value = "isevent") Integer isevent) {

        /*isevent 1 global 2 event*/


        if (StringUtils.isBlank(clickid) && StringUtils.isNotBlank(clickidbak)) {
            clickid = clickidbak;
        }

        if (clickid.startsWith("PE")) {
            //Pubearn 平台点击
            Optional<Click> clickOptional = repository.findById(clickid);
            if (clickOptional.isPresent()) {
                Click click = clickOptional.get();
            }


        } else if (clickid.startsWith("DI")) {
            //Pubearn S2S 点击,只能获取offer以及 publisher

        }

        return "ok";
    }

    public static void main(String[] args) {
    }
}
