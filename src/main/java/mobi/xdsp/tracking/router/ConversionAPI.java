package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.entity.Activate;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.Publisher;
import mobi.xdsp.tracking.entity.PublisherOffer;
import mobi.xdsp.tracking.mapper.AffiliateMapper;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PublisherOfferMapper;
import mobi.xdsp.tracking.repositories.AerospikeClickRepository;
import mobi.xdsp.tracking.service.DataService;
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

    @Autowired
    DataService dataService;

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

        /**
         * 1 计算Ctit <30秒或者>2天的都 不回发
         * 1 获取publisher offer
         * 2 获取cap
         * 3 定时统计每天 publisher _offer conversion
         * 4 计算cap
         * 3
         */
        Activate activate = new Activate();
        if (clickid.startsWith("PE")) {
            //Pubearn 平台点击
            Optional<Click> clickOptional = repository.findById(clickid);
            if (clickOptional.isPresent()) {
                Click click = clickOptional.get();
                Offer offer = dataService.getOfferCache(click.getOid());
                Publisher publisher = dataService.getPublisherCache(click.getPid());
                PublisherOffer  puboffer = dataService.getPubOfferCache(click.getPid(),click.getOid());

            }


        } else if (clickid.startsWith("DI")) {
            //Pubearn S2S 点击,只能获取offer以及 publisher like  DI1001-2311671-{click_id}

        }

        return "ok";
    }

    public static void main(String[] args) {
    }
}
