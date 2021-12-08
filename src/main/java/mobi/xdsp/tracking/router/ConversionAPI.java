package mobi.xdsp.tracking.router;

import com.google.common.collect.Maps;
import mobi.xdsp.tracking.common.AdTool;
import mobi.xdsp.tracking.common.DateTimeUtil;
import mobi.xdsp.tracking.common.HttpClientUtil;
import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.dto.enums.PBNoticeStateE;
import mobi.xdsp.tracking.dto.enums.PBStateE;
import mobi.xdsp.tracking.dto.enums.StateE;
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
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;

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
    private static final Logger logger = LoggerFactory.getLogger(ConversionAPI.class);

    Map<String, Offer> SOURCEID_OFFER_CACHE = Maps.newHashMap();

    private Offer getOfferBySourceId(String sourceOfferId) {
        if (StringUtils.isBlank(sourceOfferId)) {
            return null;
        }
        if (SOURCEID_OFFER_CACHE.containsKey(sourceOfferId)) {
            return SOURCEID_OFFER_CACHE.get(sourceOfferId);
        } else {
            OfferExample example = new OfferExample();
            example.createCriteria().andSourceofferidEqualTo(sourceOfferId);
            List<Offer> offers = offerMapper.selectByExample(example);
            if (CollectionUtils.isEmpty(offers)) {
                return null;
            } else {

                SOURCEID_OFFER_CACHE.put(sourceOfferId, offers.get(0));
                return offers.get(0);
            }

        }
    }


    @GetMapping("/conversion")
    public Object conversion(
            @RequestParam(value = "clickid", required = true) String clickid,
            @RequestParam(value = "click_id", defaultValue = "") String clickidbak,
            @RequestParam(value = "rej", defaultValue = "") String rej,
            @RequestParam(value = "advid", defaultValue = "-1") Integer advid,
            @RequestParam(value = "event", defaultValue = "") String event,
            @RequestParam(value = "isevent", defaultValue = "0") Integer isevent,
            @RequestParam(value = "rejr", defaultValue = "") String rejr,
            @RequestParam(value = "rejected_reason", defaultValue = "") String rejected_reason,
            @RequestParam(value = "rejected_sub_reason", defaultValue = "") String rejected_sub_reason,
            @RequestParam(value = "rejected_reason_value", defaultValue = "") String rejected_reason_value,
            @RequestParam(value = "isrejected", defaultValue = "") String isrejected,
            @RequestParam(value = "idfa", defaultValue = "") String idfa,
            @RequestParam(value = "gaid", defaultValue = "") String gaid,
            @RequestParam(value = "subid", defaultValue = "") String subid,
            @RequestParam(value = "rejrv", defaultValue = "") String rejrv) {
        /*isevent 1 global 2 event*/

        //log
        boolean isRej = false;
        if ("1".equals(rej) || "1".equals(isrejected)) {
            isRej = true;
            rejlog.warn("clickid={},isrejected={},event={},rejected_reason={},rejected_sub_reason={}", clickid, isrejected, event, rejected_reason, rejected_sub_reason);
            logger.warn("clickid={},isrejected={},event={},rejected_reason={},rejected_sub_reason={}", clickid, isrejected, event, rejected_reason, rejected_sub_reason);

        } else {

            convlog.warn("{},{},{},{},{},{}", clickid, clickidbak, advid, event, isevent);
        }
        try {
            if (StringUtils.isBlank(clickid) && StringUtils.isNotBlank(clickidbak)) {
                clickid = clickidbak;
            }
            clickid = URLDecoder.decode(clickid, "utf-8");

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
            boolean mafclick = false;
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
                if (StringUtils.isBlank(click.getGaid())) {
                    click.setGaid(gaid);
                }
                if (StringUtils.isBlank(click.getIdfa())) {
                    click.setIdfa(idfa);
                }
                click.setPubSub(subid);

                mmplink = true;
            } else {
                /*判断是MAF click*/
                if (clickid.indexOf("|") > 0 && clickid.split("\\|").length > 1) {
                    mafclick = true;
                    click = new Click();
                    click.setPid(2);
                    String[] ms = clickid.split("\\|");
                    if (ms.length > 2) {

                        click.setSoid(ms[2]);
                    }
                    click.setId(clickid);
                    click.setClickId(clickid);
                    click.setPubSub(subid);
                    if (StringUtils.isBlank(click.getGaid())) {
                        click.setGaid(gaid);
                    }
                    if (StringUtils.isBlank(click.getIdfa())) {
                        click.setIdfa(idfa);
                    }

                }
            }
            activate.setDeviceid(StringUtils.isBlank(click.getIdfa()) ? click.getGaid() : click.getIdfa());

            if (mafclick) {

                activate.setAid("" + advid);
                activate.setClickid(clickid);
                activate.setEvent(event);
                activate.setChannelid(2);
                activate.setPubsub(click.getPubSub());
                activate.setClickdate(DateTimeUtil.getStringDate());
                activate.setClicktime(DateTimeUtil.getStringDate());


                activate.setStatus(PBStateE.INVALID.code);
                activate.setAffsub2(click.getSoid());
                activate.setNoticestatus(PBNoticeStateE.STOP.code);
                ApiTools.packageCnt(activate);
                if (isRej) {
                    /*被拒入库*/
                    activate.setStatus(PBStateE.REJECT.code);
                    activate.setNoticestatus(PBNoticeStateE.STOP.code);
                    activate.setAffsub3(rejected_reason + "#" + rejected_sub_reason + "#" + rejected_reason_value);
                    activate.setStatus(PBStateE.REJECT.code);
                }
                int r = activateMapper.insertSelective(activate);
            } else if (click != null) {
                boolean sentpb = false;
                if (StringUtils.isNotBlank(click.getClickId())) {
                    sentpb = true;
                }
                Offer offer = dataService.getOfferCache(click.getOid());

                Publisher publisher = dataService.getPublisherCache(click.getPid());
                PublisherOffer puboffer = dataService.getPubOfferCache(click.getPid(), click.getOid());

                Integer deductrate = publisher.getDeductrate();

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


                activate.setAdvpayout(offer.getDefaultpayout());
                if (puboffer != null) {
                    if (deductrate == null || deductrate == 0) {
                        deductrate = puboffer.getDeductrate();
                    }
                    activate.setDefaultpayout(puboffer.getPayout().floatValue());
                    activate.setPubpayout(puboffer.getPayout().floatValue());
                }
                if (AdTool.is3pt(offer.getTrackurl())) {
                    if (!("" + offer.getCreatives()).equalsIgnoreCase(event)) {
                        activate.setDefaultpayout(0f);
                        activate.setPubpayout(0f);
                        activate.setAdvpayout(0f);

                    }
                    if (puboffer != null && puboffer.getPayout().floatValue() < 0.2) {
                        activate.setDefaultpayout(puboffer.getPayout().floatValue());
                        activate.setPubpayout(puboffer.getPayout().floatValue());
                        activate.setAdvpayout(puboffer.getPayout().floatValue());
                    }
                }
                if (StringUtils.isBlank(activate.getDeviceid())) {
                    activate.setDeviceid("NO CLICK");
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
                if (puboffer != null) {
                    int action = dataService.capAction(publisher.getId(), offer.getId(), puboffer);
                    if (action > 0) {
                        activate.setStatus(PBStateE.INVALID.code);
                        activate.setNoticestatus(PBNoticeStateE.CAPSTOP.code);
                    }
                } else {
                    activate.setStatus(PBStateE.INVALID.code);
                    activate.setNoticestatus(PBNoticeStateE.STOP.code);
                }
               /* if (offer.getStatus() != null && offer.getStatus().equalsIgnoreCase(StateE.VALID.name)) {
                    activate.setStatus(PBStateE.VALID.code);
                }
                if (offer.getStatus() != null && offer.getStatus().equalsIgnoreCase(StateE.PIDBLOCK.name)) {
                    activate.setStatus(PBStateE.DEDUCT.code);
                }
                if (offer.getStatus() != null && offer.getStatus().equalsIgnoreCase(StateE.INVALID.name)) {
                    activate.setStatus(PBStateE.INVALID.code);
                } else {
                    activate.setStatus(PBStateE.INVALID.code);
                }*/
                /*符合条件发PB*/
                if (!isRej && publisher.getId() != null && publisher.getId() > 10) {
                    // Postback 下发
                    if (PBStateE.VALID.code == activate.getStatus() && (activate.getNoticestatus() == null)) {
                        //发PB
                        boolean res = sendPb(isRej, publisher, offer, puboffer, click, null, null);
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
                    if (isRej) {
                        /*被拒入库*/
                        activate.setStatus(PBStateE.REJECT.code);
                        activate.setNoticestatus(PBNoticeStateE.STOP.code);
                        activate.setAffsub3(rejected_reason + "#" + rejected_sub_reason + "#" + rejected_reason_value);
                        //发PB
                        boolean res = sendPb(isRej, publisher, offer, puboffer, click, rejected_reason, rejected_sub_reason);
                        if (res) {
                            activate.setNoticestatus(PBNoticeStateE.SENT.code);

                        } else {
                            activate.setNoticestatus(PBNoticeStateE.NO.code);

                        }
                        int r = activateMapper.insertSelective(activate);

                    } else {
                        if (publisher.getId() != null && (publisher.getId() == 0 || publisher.getId() == 1)) {
                            /*被拒入库*/
                            activate.setStatus(PBStateE.VALID.code);
                            activate.setNoticestatus(PBNoticeStateE.STOP.code);
                            int r = activateMapper.insertSelective(activate);
                        } else {
                            /*非 SDK DSP 被拒 以及 需要的PB渠道的最终入库,依然遵照上诉状态判定*/
                            int r = activateMapper.insertSelective(activate);
                        }
                    }

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
                if (isRej) {
                    /*被拒入库*/
                    activate.setStatus(PBStateE.REJECT.code);
                    activate.setNoticestatus(PBNoticeStateE.STOP.code);
                    activate.setAffsub3(rejected_reason + "#" + rejected_sub_reason + "#" + rejected_reason_value);

                }
                int r = activateMapper.insertSelective(activate);

            }

        } catch (Exception e) {
            System.out.println(clickid);
            System.out.println(rej);
            System.out.println(rejrv);
            System.out.println(rejr);

            logger.error(clickid, e);
            Click click = AdTool.unpackClickId(clickid);
            logger.error(click.getOid() + ":" + click.getPid());

            e.printStackTrace();
        }

        return "ok";
    }

    public boolean sendPb(boolean isrej, Publisher publisher, Offer offer, PublisherOffer publisherOffer, Click click, String block_reason, String block_sub_reason) {
        String tid = RandomStringUtils.randomAlphabetic(4) + "-" + publisher.getId() + "-" + offer.getId();
        String track = publisher.getPostbackurl();
        pblog.warn(tid + ":" + track);
        boolean sentstatus = false;
        if (track.indexOf("{click_id}") > -1 && StringUtils.isNotBlank(click.getClickId())) {
            track = StringUtils.replaceAll(track, "\\{click_id}", click.getClickId());
        }
        if (!isrej) {
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

        } else {

            if (track.indexOf("{rejected_reason}") > -1) {
                track = StringUtils.replaceAll(track, "\\{rejected_reason}", block_reason);
            }
            if (track.indexOf("{rejected_sub_reason}") > -1) {
                track = StringUtils.replaceAll(track, "\\{rejected_sub_reason}", block_sub_reason);
            }

        }

        try {
            track = AdTool.urlEncode(track);
            pblog.warn(tid + ":" + isrej + ":" + track);
            String resp = HttpClientUtil.get(track);
            sentstatus = true;
            pblog.warn(tid + ":" + isrej + ":resp");
        } catch (Exception e) {
            e.printStackTrace();
            sentstatus = false;

            pblog.warn(tid + ":" + "senderror");
        }

        return sentstatus;
    }

    public static void main(String[] args) {
        String clickid = "8061|Y29tLmlsaWtlLmNhcnRvb24oMTkp|30309303|788197|D360244F-9B51-4003-9DC3-EF7B88972CCA||1636290757|1.760|VN|Android|2|Vietnam";


        System.out.println(clickid.indexOf("|"));
        System.out.println(clickid.split("\\|").length);
    }
}
