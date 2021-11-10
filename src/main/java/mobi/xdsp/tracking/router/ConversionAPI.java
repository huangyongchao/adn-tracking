package mobi.xdsp.tracking.router;

import mobi.xdsp.tracking.common.AdTool;
import mobi.xdsp.tracking.common.DateTimeUtil;
import mobi.xdsp.tracking.common.HttpClientUtil;
import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.dto.enums.PBNoticeStateE;
import mobi.xdsp.tracking.dto.enums.PBStateE;
import mobi.xdsp.tracking.entity.*;
import mobi.xdsp.tracking.mapper.ActivateMapper;
import mobi.xdsp.tracking.mapper.AffiliateMapper;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PublisherOfferMapper;
import mobi.xdsp.tracking.repositories.AerospikeClickRepository;
import mobi.xdsp.tracking.service.DataService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

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
    private static final Logger convlog = LoggerFactory.getLogger("conv");
    private static final Logger rejlog = LoggerFactory.getLogger("rej");
    private static final Logger pblog = LoggerFactory.getLogger("pb");

    @GetMapping("/conversion")
    public Object conversion(
            @RequestParam(value = "clickid", required = true) String clickid,
            @RequestParam(value = "click_id", defaultValue = "") String clickidbak,
            @RequestParam(value = "rej",defaultValue = "") String rej,
            @RequestParam(value = "advid") Integer advid,
            @RequestParam(value = "event", defaultValue = "") String event,
            @RequestParam(value = "isevent") Integer isevent) {

        /*isevent 1 global 2 event*/

        //log
        boolean isRej = false;
        if ("1".equals(rej)) {

            isRej = true;
        } else {

            convlog.warn("{},{},{},{},{},{}", clickid, clickidbak, advid, event, isevent);
        }
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
            boolean mmplink = false;
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
                mmplink = true;
            }

            if (click != null) {
                boolean sentpb = false;
                if (StringUtils.isNotBlank(click.getClickId())) {
                    sentpb = true;
                }
                Offer offer = dataService.getOfferCache(click.getOid());
                Publisher publisher = dataService.getPublisherCache(click.getPid());
                PublisherOffer puboffer = dataService.getPubOfferCache(click.getPid(), click.getOid());

                Integer deductrate = publisher.getDeductrate();
                if (deductrate == null || deductrate == 0) {
                    deductrate = puboffer.getDeductrate();
                }
                if (deductrate == null) {
                    deductrate = 0;
                }

                activate.setAid(offer.getAid());
                activate.setAffiliateid("" + offer.getAffiliateid());
                activate.setActivatetime(new Date());
                activate.setActivatedate(DateTimeUtil.getStringDate());
                activate.setAppid(offer.getAppid());
                activate.setOfferid(offer.getOfferid());
                activate.setOffername(offer.getOffername());
                activate.setAppname(offer.getAppname());
                activate.setChannelid(click.getPid());
                if (click.getCt() != null) {
                    activate.setClickdate(DateTimeUtil.dateToStrLong(click.getCt()));
                    activate.setClicktime(DateTimeUtil.dateToStrLong(click.getCt()));
                    activate.setCtit(DateTimeUtil.getDatePoor(activate.getActivatetime(), click.getCt()));

                } else {
                    activate.setClickdate(DateTimeUtil.getStringDate());
                    activate.setClicktime(DateTimeUtil.getStringDate());
                    activate.setCtit("unknow");
                }
                activate.setEvent(event);
                activate.setCosttype(offer.getPayouttype());
                activate.setCountry(offer.getCountries());
                activate.setDefaultpayout(puboffer.getPayout().floatValue());
                activate.setPubpayout(puboffer.getPayout().floatValue());
                activate.setAdvpayout(offer.getDefaultpayout());

                if (AdTool.is3pt(offer.getTrackurl())) {
                    if (!("" + offer.getCreatives()).equalsIgnoreCase(event)) {
                        activate.setDefaultpayout(0f);
                        activate.setPubpayout(0f);
                        activate.setAdvpayout(0f);

                    }
                    if (puboffer.getPayout().floatValue() < 0.3) {
                        activate.setDefaultpayout(puboffer.getPayout().floatValue());
                        activate.setPubpayout(puboffer.getPayout().floatValue());
                        activate.setAdvpayout(puboffer.getPayout().floatValue());
                    }
                }
                activate.setDeviceid(click.getIdfa() == null ? click.getGaid() : click.getIdfa());
                if (StringUtils.isBlank(activate.getDeviceid())) {
                    activate.setDeviceid("Error CLick");
                }
                activate.setIp(click.getCip());
                activate.setInserttime(new Date());
                activate.setOfferuid("" + click.getOid());
                activate.setClickid(click.getClickId());
                activate.setPubsub(click.getPubSub());
                activate.setAffsub1(click.getS1());
                activate.setAffsub2(click.getS2());
                activate.setSubid1(click.getMixSub());
                if (StringUtils.isBlank(activate.getClickid())) {
                    activate.setClickid(clickid);
                    activate.setStatus(PBStateE.INVALID.code);
                    activate.setInactivecnt(1);

                }

                if (activate.getStatus() == null) {
                    activate.setStatus(PBStateE.VALID.code);
                    activate.setActivecnt(1);
                    activate.setDeductcnt(0);


                }
                //扣量比例
                if (deductrate > 0) {
                    int seed = deductrate / 5;
                    int r = new Random().nextInt(20);
                    if (r <= seed) {
                        activate.setStatus(PBStateE.DEDUCT.code);
                        activate.setDeductcnt(1);
                        activate.setActivecnt(0);

                    }
                }
                //处理 状态
                ApiTools.packageCnt(activate);
                //检查Cap
                int action = dataService.capAction(publisher.getId(), offer.getId(), puboffer);
                if (action > 0) {
                    activate.setStatus(PBStateE.INVALID.code);
                    activate.setNoticestatus(PBNoticeStateE.CAPSTOP.code);
                }
                if (!isRej) {
                    // Postback 下发
                    if (PBStateE.VALID.code == activate.getStatus() && (activate.getNoticestatus() == null || activate.getNoticestatus() == PBNoticeStateE.NO.code)) {
                        //发PB
                        boolean res = sendPb(publisher, offer, puboffer, click);
                        if (res) {
                            activate.setNoticestatus(PBNoticeStateE.SENT.code);

                        } else {
                            activate.setNoticestatus(PBNoticeStateE.NO.code);

                        }
                    } else {
                        activate.setNoticestatus(PBNoticeStateE.STOP.code);
                    }
                    //入库

                    int r = activateMapper.insertSelective(activate);
                } else {
                    rejlog.warn("{},{},{},{},{},{}", clickid, puboffer.getId(), click.getPubSub(), click.getPubSub(), event);

                }


            } else {
                activate.setAid("" + advid);
                activate.setClickid(clickid);
                activate.setEvent(event);
                activate.setClickdate(DateTimeUtil.getStringDate());
                activate.setClicktime(DateTimeUtil.getStringDate());
                activate.setStatus(PBStateE.INVALID.code);
                activate.setNoticestatus(PBNoticeStateE.STOP.code);
                ApiTools.packageCnt(activate);
                int r = activateMapper.insertSelective(activate);

            }

        } catch (Exception e) {
            mailer.sendErrorMail("Conversion Error: SaveConversion", Mailer.e2s(e));
            e.printStackTrace();
        }

        return "ok";
    }

    public boolean sendPb(Publisher publisher, Offer offer, PublisherOffer publisherOffer, Click click) {
        String tid = RandomStringUtils.randomAlphabetic(4) + "-" + publisher.getId() + "-" + offer.getId();
        String track = publisher.getPostbackurl();
        pblog.warn(tid + ":" + track);
        boolean sentstatus = false;
        if (track.indexOf("{click_id}") > -1 && StringUtils.isNotBlank(click.getClickId())) {
            track = StringUtils.replaceAll(track, "\\{click_id}", click.getClickId());
        }
        if (track.indexOf("{idfa}") > -1 && StringUtils.isNotBlank(click.getIdfa())) {
            track = StringUtils.replaceAll(track, "\\{idfa}", click.getIdfa());
        }

        if (track.indexOf("{gaid}") > -1 && StringUtils.isNotBlank(click.getGaid())) {
            track = StringUtils.replaceAll(track, "\\{gaid}", click.getGaid());
        }

        if (track.indexOf("{pub_sub}") > -1 && StringUtils.isNotBlank(click.getPubSub())) {
            track = StringUtils.replaceAll(track, "\\{pub_sub}", click.getPubSub());
        }

        if (track.indexOf("{appid}") > -1 && StringUtils.isNotBlank(offer.getAppid())) {
            track = StringUtils.replaceAll(track, "\\{appid}", offer.getAppid());
        }
        if (track.indexOf("{sub1}") > -1 && StringUtils.isNotBlank(click.getS1())) {
            track = StringUtils.replaceAll(track, "\\{sub1}", click.getS1());
        }
        if (track.indexOf("{sub2}") > -1 && StringUtils.isNotBlank(click.getS2())) {
            track = StringUtils.replaceAll(track, "\\{sub2}", click.getS2());
        }
        if (track.indexOf("{ip}") > -1 && StringUtils.isNotBlank(click.getIp())) {
            track = StringUtils.replaceAll(track, "\\{ip}", click.getIp());
        }
        if (track.indexOf("{payout}") > -1 && publisherOffer.getPayout() != null) {
            track = StringUtils.replaceAll(track, "\\{payout}", publisherOffer.getPayout().toString());
        }
        if (track.indexOf("{currency}") > -1 && offer.getCurrency() != null) {
            track = StringUtils.replaceAll(track, "\\{currency}", offer.getCurrency());
        }

        try {
            track = AdTool.urlEncode(track);
            pblog.warn(tid + ":" + track);
            String resp = HttpClientUtil.get(track);
            sentstatus = true;
            pblog.warn(tid + ":" + "resp");
        } catch (Exception e) {
            e.printStackTrace();
            sentstatus = false;

            pblog.warn(tid + ":" + "senderror");
        }

        return sentstatus;
    }

    public static void main(String[] args) {

    }
}
