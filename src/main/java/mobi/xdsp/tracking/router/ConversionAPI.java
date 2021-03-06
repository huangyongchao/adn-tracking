package mobi.xdsp.tracking.router;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import mobi.xdsp.tracking.common.*;
import mobi.xdsp.tracking.core.rtcr.RtCrMonitor;
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
import org.apache.http.util.EntityUtils;
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
        //0 ?????? 1 ????????????????????? 2 ??????????????????
        int isPayoutEvent = 0;
        //log
        boolean isRej = false;
        boolean isConversion = false;
        boolean isMMP = false;
        boolean isPub = false;
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
             * 1 ??????Ctit <30?????????>2????????? ?????????
             * 1 ??????publisher offer
             * 2 ??????cap
             * 3 ?????????????????? publisher _offer conversion
             * 4 ??????cap
             * 3
             */
            ActivateWithBLOBs activate = new ActivateWithBLOBs();
            Click click = null;


            if ((clickid.indexOf("|") > 0 && clickid.split("\\|").length > 4)) {
                /*?????????MAF click*/
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
                        if (StringUtils.isNotBlank(click.getSoid())) {
                            OfferExample example = new OfferExample();
                            example.createCriteria().andAffiliateidEqualTo(new Short("2")).andSourceofferidEqualTo(click.getSoid());
                            List<Offer> offers = offerMapper.selectByExample(example);
                            if (!CollectionUtils.isEmpty(offers)) {
                                Offer offer = offers.get(0);
                                activate.setAffiliatename(offer.getAffiliatename());
                                activate.setOfferid(offer.getOfferid());
                                activate.setOfferuid(offer.getId().toString());
                                activate.setOffername(offer.getOffername());
                                activate.setAffiliateid(offer.getAffiliateid().toString());
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
                        activate.setDefaultpayout(0f);
                        activate.setPubpayout(0f);
                        activate.setAdvpayout(0f);

                        activate.setStatus(PBStateE.VALID.code);
                        activate.setAffsub2(click.getSoid());
                        activate.setNoticestatus(PBNoticeStateE.STOP.code);
                        ApiTools.packageCnt(activate);
                        if (isRej) {
                            /*????????????*/
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
            //??????click
            if (clickid.startsWith("PE")) {
                //Pubearn ????????????
                String unpackclickid = null;
                if (clickid.indexOf("FFF") > 0) {
                    unpackclickid = clickid.split("FFF")[0];
                } else {
                    unpackclickid = clickid;
                }
                Optional<Click> clickOptional = repository.findById(unpackclickid);

                if (clickOptional.isPresent()) {
                    click = clickOptional.get();
                } else {
                    click = AdTool.unpackClickId(clickid);
                }

            } else if (clickid.startsWith("DI0-") || clickid.startsWith("DI1-")) {
                //Pubearn S2S ??????,????????????offer?????? publisher like  DI1001-2311671-{click_id}
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
                if (offer != null && offer.getTrackurl().indexOf("appsflyer") > 0) {
                    isMMP = true;

                }
                if (offer != null && offer.getTrackurl().indexOf("adjust") > 0) {
                    isMMP = true;

                }
                if (offer != null) {
        /*            if (PostbackTypeE.EVENT.code == isevent) {

                        if (StringUtils.isNotBlank(offer.getCreatives()) && offer.getCreatives().equalsIgnoreCase(event)) {
                            isConversion = true;

                        }
                    } else {
                        isConversion = true;
                        if (StringUtils.isNotBlank(offer.getCreatives()) && !offer.getCreatives().equalsIgnoreCase(event)) {
                            isConversion = false;

                        }
                    }*/

                    if (StringUtils.isNotBlank(event) && StringUtils.isNotBlank(offer.getCreatives()) && offer.getCreatives().equalsIgnoreCase(event)) {
                        isConversion = true;

                    }

                    if (StringUtils.isBlank(offer.getCreatives()) && StringUtils.isBlank(event)) {
                        isConversion = true;
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


                //??????????????? ???????????????????????? ???????????????
                PublisherOffer puboffer = dataService.getPubOffer(click.getPid(), click.getOid());
                //????????????
                if (click != null && puboffer != null && puboffer.getPublisherid() > 3) {
                    if(puboffer.getPayout().floatValue()<=0.04f){
                        isConversion = true;
                    }
                    activate.setDefaultpayout(puboffer.getPayout().floatValue());
                    activate.setPubpayout(puboffer.getPayout().floatValue());
                    activate.setAdvpayout(offer.getDefaultpayout());
                    activate.setStatus(PBStateE.VALID.code);


                    if ("install".equalsIgnoreCase(event) && (puboffer.getActioncode() != null && puboffer.getActioncode() == -2)) {
                        isConversion = true;
                    }


                    if (!isConversion) {
                        activate.setDefaultpayout(0f);
                        activate.setAdvpayout(0f);
                        activate.setPubpayout(0f);
                        activate.setStatus(PBStateE.INVALID.code);
                        activate.setNoticestatus(PBNoticeStateE.STOP.code);
                    }


                    //??????Cap
                    int action = dataService.capAction(publisher.getId(), offer.getId(), puboffer);
                    if (action > 0) {
                        activate.setStatus(PBStateE.INVALID.code);
                        activate.setNoticestatus(PBNoticeStateE.CAPSTOP.code);
                    }
                    activate.setClicktime(DateTimeUtil.dateToStrLong(click.getCt()));
                    //??????
                    isPub = true;


                } else if (sdkclick) {

                    if (offer.getAffiliatename().indexOf("Lazada") >= 0) {
                        activate.setSubid1(activate.getPubsub());
                        activate.setPubsub(activate.getSspname());
                    }
                    if (offer.getDefaultpayout() == null) {
                        offer.setDefaultpayout(0f);
                    }

                    //?????????????????????
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
                    } else if (StringUtils.isNotBlank(idfa)) {
                        activate.setDeviceid(idfa);
                    }


                    //??????????????? ??????0
                    if (!isConversion) {
                        activate.setDefaultpayout(0f);
                        activate.setAdvpayout(0f);
                        activate.setPubpayout(0f);
                        activate.setStatus(PBStateE.INVALID.code);
                        activate.setNoticestatus(PBNoticeStateE.STOP.code);
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

                //?????? ??????
                ApiTools.packageCnt(activate);


                //??????????????????
                noticeAddClicks(isevent, isRej, publisher, offer, activate, subid);

                if (isRej) {
                    /*????????????*/
                    activate.setStatus(PBStateE.REJECT.code);
                    activate.setNoticestatus(PBNoticeStateE.STOP.code);
                    activate.setRejectcnt(1);
                    activate.setAffsub3(rejected_reason + "#" + rejected_sub_reason + "#" + rejected_reason_value);
                    //???PB
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

                        String poKey = publisher.getId() + "_" + offer.getId();
                        RtCrMonitor.increaseConvs(poKey, publisher.getId(), offer.getId());


                        if (isPub && isConversion) {
                            Integer deductrate = puboffer.getDeductrate();

                            if (deductrate == null) {
                                deductrate = publisher.getDeductrate();
                            }
                            if (deductrate == null) {
                                deductrate = 0;
                            }

                            if (deductrate > 0) {
                                int r = new Random().nextInt(100);
                                if (r <= deductrate) {
                                    activate.setStatus(PBStateE.DEDUCT.code);
                                    activate.setNoticestatus(PBNoticeStateE.STOP.code);
                                    activate.setDeductcnt(1);
                                    activate.setActivecnt(0);

                                }
                            }
                        }

                        // Postback ??????
                        if (PBStateE.VALID.code == activate.getStatus() && (activate.getNoticestatus() == null)) {
                            //???PB
                            boolean res = sendPb(isevent, event, isRej, isMMP, isConversion, publisher, offer, puboffer, click, null, null, null, subid);
                            if (res) {
                                activate.setNoticestatus(PBNoticeStateE.SENT.code);

                            } else {
                                activate.setNoticestatus(PBNoticeStateE.NO.code);

                            }
                        } else {
                            activate.setNoticestatus(PBNoticeStateE.STOP.code);
                        }
                        //??????
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


    public void noticeAddClicks(int isevent, boolean isRej, Publisher publisher, Offer offer, Activate activate, String subid) {
        final String pubsub = subid;
        if (isevent == 2) {
            return;
        }
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
            pblog.warn(tid + ":resp:" + resp + " actual pb:" + track);
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
                // ????????????

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
                        offer.setRemark("????????????");
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
