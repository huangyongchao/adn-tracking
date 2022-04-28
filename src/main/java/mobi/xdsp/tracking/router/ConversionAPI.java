package mobi.xdsp.tracking.router;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import mobi.xdsp.tracking.common.*;
import mobi.xdsp.tracking.dto.Click;
import mobi.xdsp.tracking.dto.PBchecker;
import mobi.xdsp.tracking.dto.enums.*;
import mobi.xdsp.tracking.entity.*;
import mobi.xdsp.tracking.mapper.ActivateMapper;
import mobi.xdsp.tracking.mapper.AffiliateMapper;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PublisherOfferMapper;
import mobi.xdsp.tracking.repositories.AerospikeClickRepository;
import mobi.xdsp.tracking.service.DataService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
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
            @RequestParam(value = "affid", defaultValue = "0") Integer affid,
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
            @RequestParam(value = "payout", defaultValue = "") String payout,
            @RequestParam(value = "device", defaultValue = "") String device,
            @RequestParam(value = "currency", defaultValue = "") String currency,
            @RequestParam(value = "ip", defaultValue = "") String ip,
            @RequestParam(value = "appid", defaultValue = "") String appid,
            @RequestParam(value = "rejrv", defaultValue = "") String rejrv) {
        /*isevent 1 global 2 event*/

        convlog.warn("affid={},clickid={},clickidbak={},advid={},event={},isevent={},subid={},idfa={},gaid={},payout={},device={},ip={},appid={},rejrv={}", affid, clickid, clickidbak, advid, event, isevent, subid, idfa, gaid, payout, device, ip, appid, rejrv);
        if ("null".equalsIgnoreCase(event)) {
            event = null;
        }
        if ("null".equalsIgnoreCase(payout)) {
            payout = null;
        }
        //0 默认 1 直连非结算事件 2 直连结算事件
        int isPayoutEvent = 0;
        //log
        boolean isRej = false;
        boolean isConversion = false;
        boolean isMMP = false;
        boolean mafclick = false;
        boolean sdkclick = false;


        if ("1".equals(rej) || "1".equals(isrejected) || StringUtils.isNotBlank(rejected_sub_reason)) {
            isRej = true;
            rejlog.warn("Appsflyer={},clickid={},isrejected={},event={},rejected_reason={},rejected_sub_reason={},subid={}", affid, clickid, isrejected, event, rejected_reason, rejected_sub_reason, subid);
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


            if ((clickid.indexOf("|") > 0 && clickid.split("\\|").length > 4)) {
                /*判断是MAF click*/
                try {
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

                    if (mafclick) {
                        if(StringUtils.isNotBlank(click.getSoid())){
                            OfferExample example = new OfferExample();
                            example.createCriteria().andAffiliateidEqualTo(new Short("2")).andSourceofferidEqualTo(click.getSoid());
                            List<Offer> offers = offerMapper.selectByExample(example);
                            if(!CollectionUtils.isEmpty(offers)){
                                Offer offer = offers.get(0);
                                activate.setAffiliatename(offer.getAffiliatename());
                                activate.setOfferid(offer.getOfferid());
                                activate.setOfferuid(offer.getId().toString());
                                activate.setOffername(offer.getOffername());
                                activate.setAid(offer.getAid());
                                activate.setAppid(offer.getAppid());
                                activate.setCountry(offer.getCountries());
                            }
                        }
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
                            activate.setRejectcnt(1);

                        }
                        postSave(activate, subid, isRej, isevent);
                        save(activate, subid, isRej, isevent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "maf_pb_ok";

            }
            //包装click
            if (clickid.startsWith("PE")) {
                //Pubearn 平台点击
                Optional<Click> clickOptional = repository.findById(clickid);

                if (clickOptional.isPresent()) {
                    click = clickOptional.get();
                } else {
                    click = AdTool.unpackClickId(clickid);
                }

            } else if (clickid.startsWith("DI0-") || clickid.startsWith("DI1-")) {
                //Pubearn S2S 点击,只能获取offer以及 publisher like  DI1001-2311671-{click_id}
                sdkclick = true;
                click = AdTool.unpackClickId(clickid);
                if (StringUtils.isBlank(click.getGaid())) {
                    click.setGaid(gaid);
                }
                if (StringUtils.isBlank(click.getIdfa())) {
                    click.setIdfa(idfa);
                }
                click.setPubSub(subid);
                try {
                    activate.setSsp(click.getDeviceInfo().getSsp());
                    activate.setSspname(ExchangesE.getKey(activate.getSsp()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    activate.setSsppub(click.getDeviceInfo().getPub());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    activate.setSspapp(click.getDeviceInfo().getAppid());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    String code = click.getDeviceInfo().getOs();
                    activate.setOs(OsE.getKeyByV(code));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            if (click != null) {

                Offer offer = dataService.getOfferCache(click.getOid());


                if ((offer.getTrackurl().indexOf("appsflyer") > 0 || offer.getTrackurl().indexOf("adjust") > 0)) {
                    isMMP = true;
                    if (PostbackTypeE.EVENT.code == isevent) {

                        if (StringUtils.isNotBlank(offer.getCreatives()) && offer.getCreatives().equalsIgnoreCase(event)) {
                            isConversion = true;

                        }
                    } else {
                        isConversion = true;
                        if (StringUtils.isNotBlank(offer.getCreatives()) && !offer.getCreatives().equalsIgnoreCase(event)) {
                            isConversion = false;

                        }
                    }


                }


                Publisher publisher = dataService.getPublisherCache(click.getPid());
                if (publisher == null) {
                    publisher = new Publisher();
                    publisher.setId(0);
                    publisher.setCompanyname("SDK");
                    publisher.setEmail("SDK");
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
                if (StringUtils.isBlank(activate.getDeviceid())) {
                    activate.setDeviceid(StringUtils.isBlank(click.getIdfa()) ? click.getGaid() : click.getIdfa());

                }

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


                //如果有点击 且有渠道开单信息 走开单价格
                PublisherOffer puboffer = dataService.getPubOffer(click.getPid(), click.getOid());
                //渠道转化
                if (click != null && puboffer != null && puboffer.getPublisherid() > 3) {

                    activate.setDefaultpayout(puboffer.getPayout().floatValue());
                    activate.setPubpayout(puboffer.getPayout().floatValue());
                    activate.setAdvpayout(offer.getDefaultpayout());
                    activate.setStatus(PBStateE.VALID.code);

                    if (isMMP) {
                        if (!isConversion) {
                            activate.setDefaultpayout(0f);
                            activate.setAdvpayout(0f);
                            activate.setPubpayout(0f);
                            activate.setStatus(PBStateE.INVALID.code);
                            activate.setNoticestatus(PBNoticeStateE.STOP.code);
                        }
                    }


                    //检查Cap
                    int action = dataService.capAction(publisher.getId(), offer.getId(), puboffer);
                    if (action > 0) {
                        activate.setStatus(PBStateE.INVALID.code);
                        activate.setNoticestatus(PBNoticeStateE.CAPSTOP.code);
                    }
                    activate.setClicktime(DateTimeUtil.dateToStrLong(click.getCt()));
                    //扣量

                    Integer deductrate = puboffer.getDeductrate();

                    if (deductrate == null) {
                        deductrate = publisher.getDeductrate();
                    }
                    if (deductrate == null) {
                        deductrate = 0;
                    }

                    if (deductrate > 0) {
                        int seed = deductrate / 5;
                        int r = new Random().nextInt(20);
                        if (r <= seed) {
                            activate.setStatus(PBStateE.DEDUCT.code);
                            activate.setNoticestatus(PBNoticeStateE.STOP.code);
                            activate.setDeductcnt(1);
                            activate.setActivecnt(0);

                        }
                    }


                } else if (sdkclick) {
                    if (offer.getDefaultpayout() == null) {
                        offer.setDefaultpayout(0f);
                    }

                    //有默认回传价格
                    if (StringUtils.isNotBlank(payout)) {
                        try {
                            Float p = Float.parseFloat(payout);
                            activate.setDefaultpayout(p);
                            activate.setAdvpayout(p);
                            activate.setPubpayout(p);
                        } catch (Exception e) {
                            e.printStackTrace();
                            activate.setDefaultpayout(0f);
                            activate.setAdvpayout(0f);
                            activate.setPubpayout(0f);
                        }

                    } else {
                        activate.setDefaultpayout(offer.getDefaultpayout());
                        activate.setAdvpayout(offer.getDefaultpayout());
                        activate.setPubpayout(offer.getDefaultpayout());
                    }
                    activate.setStatus(PBStateE.VALID.code);
                    activate.setNoticestatus(PBNoticeStateE.STOP.code);

                    if (StringUtils.isBlank(activate.getDeviceid())) {
                        activate.setDeviceid(StringUtils.isBlank(click.getIdfa()) ? click.getGaid() : click.getIdfa());

                    }
                    if (StringUtils.isNotBlank(gaid)) {
                        activate.setDeviceid(gaid);
                    }
                    else if (StringUtils.isNotBlank(idfa)) {
                        activate.setDeviceid(idfa);
                    }


                    //非计费事件 都是0
                    if (isMMP) {
                        if (!isConversion) {
                            activate.setDefaultpayout(0f);
                            activate.setAdvpayout(0f);
                            activate.setPubpayout(0f);
                            activate.setStatus(PBStateE.INVALID.code);
                            activate.setNoticestatus(PBNoticeStateE.STOP.code);
                        }

                    }
                }


                activate.setIp(click.getCip());
                activate.setInserttime(new Date());
                activate.setOfferuid("" + click.getOid());
                activate.setPubsub(click.getPubSub());
                activate.setAffsub3(click.getS1());
                activate.setAffsub2(click.getS2());
                activate.setSubid1(click.getMixSub());
                activate.setClickid(clickid);
                activate.setClickidext(click.getClickId());
                if (StringUtils.isBlank(activate.getOs())) {
                    activate.setOs(offer.getOs().toLowerCase());
                }

                //处理 状态
                ApiTools.packageCnt(activate);


                //处理点击通知
                noticeAddClicks(isRej, publisher, offer, activate, subid);

                if (isRej) {
                    /*被拒入库*/
                    activate.setStatus(PBStateE.REJECT.code);
                    activate.setNoticestatus(PBNoticeStateE.STOP.code);
                    activate.setRejectcnt(1);
                    activate.setAffsub3(rejected_reason + "#" + rejected_sub_reason + "#" + rejected_reason_value);
                    //发PB
                    postSave(activate, subid, isRej, isevent);
                    if (publisher != null && publisher.getId() > 3) {
                        boolean res = sendPb(isevent, event, isRej, isMMP, isConversion, publisher, offer, puboffer, click, rejected_reason, rejected_sub_reason, rejected_reason_value, subid);
                        if (res) {
                            activate.setNoticestatus(PBNoticeStateE.SENT.code);

                        } else {
                            activate.setNoticestatus(PBNoticeStateE.NO.code);

                        }
                    }
                    save(activate, subid, isRej, isevent);

                } else {
                    if (publisher.getId() != null && publisher.getId() > 3) {
                        // Postback 下发
                        if (PBStateE.VALID.code == activate.getStatus() && (activate.getNoticestatus() == null)) {
                            //发PB
                            boolean res = sendPb(isevent, event, isRej, isMMP, isConversion, publisher, offer, puboffer, click, null, null, null, subid);
                            if (res) {
                                activate.setNoticestatus(PBNoticeStateE.SENT.code);

                            } else {
                                activate.setNoticestatus(PBNoticeStateE.NO.code);

                            }
                        } else {
                            activate.setNoticestatus(PBNoticeStateE.STOP.code);
                        }
                        //入库
                        postSave(activate, subid, isRej, isevent);
                        save(activate, subid, isRej, isevent);
                    } else {
                        activate.setStatus(PBStateE.VALID.code);
                        activate.setNoticestatus(PBNoticeStateE.STOP.code);
                        postSave(activate, subid, isRej, isevent);
                        save(activate, subid, isRej, isevent);
                    }

                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

    public String getRejPb(String url) {
        if (StringUtils.isNotBlank(url) && url.indexOf("##") > 0) {
            return url.split("##")[0];
        }
        if (StringUtils.isNotBlank(url)) {
            return url;
        } else {
            return null;
        }
    }

    public String getEventPb(String url) {
        if (StringUtils.isNotBlank(url) && url.indexOf("##") > 1) {
            return url.split("##")[1];
        }
        if (StringUtils.isNotBlank(url)) {
            return url;
        } else {
            return null;
        }
    }

    public void replaceSubid(String offerid, String subid) {
        final String pubsub = subid;

        ExecutorPool.getExecutor().execute(() -> {
            if (StringUtils.isNotBlank(offerid) && StringUtils.isNotBlank(subid)) {

                try {
                    String url = "http://p.pubearn.com/api/open/replacesubid?id=" + offerid + "&oldsub=" + subid;
                    HttpClientUtil.get(url);
                    logger.warn("REPLACE SUBID :" + url);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }


    public void noticeAddClicks(boolean isRej, Publisher publisher, Offer offer, Activate activate, String subid) {
        final String pubsub = subid;

        ExecutorPool.getExecutor().execute(() -> {
            if (publisher != null
                    && offer != null
                    && publisher.getId() > 10
                    && StringUtils.isNotBlank(offer.getImprurl())
                    && StateE.VALID.name.equalsIgnoreCase(offer.getStatus())
                    && offer.getTrackurl() != null
                    && offer.getTrackurl().indexOf("appsflyer") > 0) {
                try {
                    if (!isRej) {
                        String url = null;

                        if (activate.getPubsub() == null) {
                            activate.setPubsub("");
                        }
                        String[] ss = offer.getImprurl().split("##");
                        url = ss[0];
                        url = StringUtils.replaceAll(url, "\\{sub_id}", (StringUtils.isNotBlank(pubsub) ? pubsub : activate.getPubsub()));
                        url = StringUtils.replaceAll(url, "\\{id}", "" + offer.getId());
                        if (ss.length > 1) {
                            int cnt = Integer.parseInt(ss[1]);
                            url = StringUtils.replaceAll(url, "\\{cnt}", "" + cnt);
                        }

                        HttpClientUtil.get(url);
                        logger.warn("NOTICE ADD CLICKS :" + url);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public boolean sendPb(int isEvent, String event, boolean isrej, boolean isMMP, boolean isConversion, Publisher publisher, Offer offer, PublisherOffer publisherOffer, Click click, String block_reason, String block_sub_reason, String rejected_reason_value, String realsubid) {
        String tid = RandomStringUtils.randomAlphabetic(4) + "-" + publisher.getId() + "-" + offer.getId();
        String track = publisher.getPostbackurl();
        if (isrej) {
            track = getRejPb(publisher.getPostbackeventurl());

        } else if (isEvent == PostbackTypeE.EVENT.code) {
            track = getEventPb(publisher.getPostbackeventurl());
        }
        if (StringUtils.isBlank(track)) {
            pblog.warn(tid + " rej:" + isrej + " event:" + isEvent + " " + event + ":track null");
            return false;
        }
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
            if (track.indexOf("{event}") > -1 && StringUtils.isNotBlank(event)) {
                track = StringUtils.replaceAll(track, "\\{event}", event);
            }
            if (track.indexOf("{pub_sub}") > -1 && StringUtils.isNotBlank(click.getMixSub())) {
                track = StringUtils.replaceAll(track, "\\{pub_sub}", click.getMixSub());
            }
            if (track.indexOf("{pub_sub}") > -1 && StringUtils.isBlank(click.getMixSub())) {
                track = StringUtils.replaceAll(track, "\\{pub_sub}", click.getPubSub());
            }

            if (track.indexOf("{real_subid}") > -1 && StringUtils.isNotBlank(realsubid)) {
                track = StringUtils.replaceAll(track, "\\{real_subid}", realsubid);
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
            if (track.indexOf("{rejected_reason_value}") > -1) {
                track = StringUtils.replaceAll(track, "\\{rejected_reason_value}", rejected_reason_value);
            }
            if (track.indexOf("{event}") > -1 && StringUtils.isNotBlank(event)) {
                track = StringUtils.replaceAll(track, "\\{event}", event);
            }
        }

        try {
            track = AdTool.urlEncode(track);
            pblog.warn(tid + " rej:" + isrej + " event:" + event + " " + isEvent + " actual pb:" + track);
            String resp = HttpClientUtil.get(track);
            sentstatus = true;
            pblog.warn(tid + ":" + isrej + " :resp " + isEvent);
        } catch (Exception e) {
            e.printStackTrace();
            sentstatus = false;

            pblog.warn(tid + ":" + "senderror");
        }

        return sentstatus;
    }


    public static Map<String, PBchecker> OFFER_CONV_RT = Maps.newHashMap();

    public void save(ActivateWithBLOBs activate, String subid, boolean isRej, int isEvent) {

        if (isEvent == PostbackTypeE.EVENT.code) {
            activate.setStatus(PBStateE.INVALID.code);
        }
        activate.setInserttime(new Date());
/*
        String sysdate = LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
*/
        int r = activateMapper.insertSelective(activate);
    }

    public void postSave(Activate activate, String subid, boolean isRej, int isEvent) {
        logger.warn("POSTSAVE:" + isRej + ":" + JSONObject.toJSONString(activate));
        try {
            if (StringUtils.isBlank(subid)) {
                subid = activate.getPubsub();
            }
            String key = activate.getOfferuid() + "#" + subid;
            if (!OFFER_CONV_RT.containsKey(key)) {
                OFFER_CONV_RT.put(key, new PBchecker());
            }
            if (isRej) {
                int i = OFFER_CONV_RT.get(key).getDayinstallreject().incrementAndGet();
                replaceSubid(activate.getOfferuid(), subid);
                // 停单逻辑

            } else {
                int rej = OFFER_CONV_RT.get(key).getDayinstallreject().get();
                int ins = OFFER_CONV_RT.get(key).getDayinstall().incrementAndGet();
                if ((ins == 0 && rej > 6) || (ins > 0 && rej > 9 && rej * 1f / (ins + rej) > 0.4f)) {
                    try {
                        int id = Integer.parseInt(activate.getOfferuid());
                        OfferExample example = new OfferExample();
                        example.createCriteria().andIdEqualTo(id);

                        Offer offer = new Offer();
                        offer.setStatus(StateE.INVALID.name);
                        offer.setRemark("被拒率高");
                        offerMapper.updateByExampleSelective(offer, example);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        String clickid = "8061|Y29tLmlsaWtlLmNhcnRvb24oMTkp|30309303|788197|D360244F-9B51-4003-9DC3-EF7B88972CCA||1636290757|1.760|VN|Android|2|Vietnam";


        System.out.println(clickid.indexOf("|"));
        System.out.println(clickid.split("\\|").length);
    }
}
