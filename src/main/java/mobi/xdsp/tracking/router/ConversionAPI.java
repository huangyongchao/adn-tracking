package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.common.AdTool;
import mobi.xdsp.tracking.common.DateTimeUtil;
import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.dto.enums.PBStateE;
import mobi.xdsp.tracking.entity.*;
import mobi.xdsp.tracking.mapper.ActivateMapper;
import mobi.xdsp.tracking.mapper.AffiliateMapper;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PublisherOfferMapper;
import mobi.xdsp.tracking.repositories.AerospikeClickRepository;
import mobi.xdsp.tracking.service.DataService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;
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
    ActivateMapper activateMapper;
    @Autowired
    PublisherOfferMapper publisherOfferMapper;
    @Autowired
    Mailer mailer;
    @Autowired
    DataService dataService;

    @GetMapping("/conversion")
    public Object conversion(
            @RequestParam(value = "clickid", required = true) String clickid,
            @RequestParam(value = "click_id", defaultValue = "") String clickidbak,
            @RequestParam(value = "advid") Integer advid,
            @RequestParam(value = "event", defaultValue = "") String event,
            @RequestParam(value = "isevent") Integer isevent) {

        /*isevent 1 global 2 event*/


        try {
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
            ActivateWithBLOBs activate = new ActivateWithBLOBs();
            Click click = null;
            if (clickid.startsWith("PE")) {
                //Pubearn 平台点击
                Optional<Click> clickOptional = repository.findById(clickid);

                if (clickOptional.isPresent()) {
                    click = clickOptional.get();
                } else {
                    click = AdTool.unpackClickId(clickid);
                }


            } else if (clickid.startsWith("DI")) {
                //Pubearn S2S 点击,只能获取offer以及 publisher like  DI1001-2311671-{click_id}
                click = AdTool.unpackClickId(clickid);
            }
            if (click != null) {
                Offer offer = dataService.getOfferCache(click.getOid());
                Publisher publisher = dataService.getPublisherCache(click.getPid());
                PublisherOffer puboffer = dataService.getPubOfferCache(click.getPid(), click.getOid());
                activate.setAid(offer.getAid());
                activate.setAffiliateid("" + offer.getAffiliateid());
                activate.setActivatetime(new Date());
                activate.setActivatedate(DateTimeUtil.getStringDate());
                activate.setAppid(offer.getAppid());
                activate.setAppname(offer.getAppname());
                activate.setChannelid(click.getPid());
                if (click.getCt() != null) {
                    activate.setClickdate(DateTimeUtil.dateToStrLong(click.getCt()));
                    activate.setClicktime(DateTimeUtil.dateToStrLong(click.getCt()));
                } else {
                    activate.setClickdate(DateTimeUtil.getStringDate());
                    activate.setClicktime(DateTimeUtil.getStringDate());
                    activate.setStatus(PBStateE.INVALID.code);
                }
                activate.setEvent(event);
                activate.setCosttype(offer.getPayouttype());
                activate.setCountry(offer.getCountries());
                activate.setDefaultpayout(puboffer.getPayout().floatValue());
                activate.setDeviceid(click.getIdfa() == null ? click.getGaid() : click.getIdfa());
                if (StringUtils.isBlank(activate.getDeviceid())) {
                    activate.setDeviceid("Error CLick");
                    activate.setStatus(PBStateE.INVALID.code);

                }
                activate.setInserttime(new Date());
                activate.setOfferuid("" + click.getOid());
                activate.setClickid(click.getClickId());
                activate.setPubsub(click.getPubSub());
                activate.setAffsub1(click.getS1());
                activate.setAffsub2(click.getS2());
                activate.setSubid1(click.getMixSub());
                if (activate.getStatus() == null){
                    //计算CTIT
                    //计算CAP

                }


            } else {
                activate.setAid("" + advid);
                activate.setClickid(clickid);
                activate.setEvent(event);
                activate.setClickdate(DateTimeUtil.getStringDate());
                activate.setClicktime(DateTimeUtil.getStringDate());
                activate.setStatus(PBStateE.INVALID.code);
            }
            if (activate.getStatus() != null) {
                activate.setStatus(PBStateE.VALID.code);
                //发PB
            }
            activateMapper.insertSelective(activate);
        } catch (Exception e) {
            mailer.sendErrorMail("Conversion Error: SaveConversion", e.getMessage() + "\n" + e.getLocalizedMessage());
            e.printStackTrace();
        }

        return "ok";
    }

    public static void main(String[] args) {

    }
}
