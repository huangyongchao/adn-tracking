package mobi.xdsp.tracking.core.job;

import mobi.xdsp.tracking.common.AdTool;
import mobi.xdsp.tracking.common.DateTimeUtil;
import mobi.xdsp.tracking.common.HttpClientUtil;
import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.dto.enums.PBNoticeStateE;
import mobi.xdsp.tracking.dto.enums.PBStateE;
import mobi.xdsp.tracking.entity.Activate;
import mobi.xdsp.tracking.entity.ActivateExample;
import mobi.xdsp.tracking.entity.ActivateWithBLOBs;
import mobi.xdsp.tracking.entity.Publisher;
import mobi.xdsp.tracking.mapper.ActivateMapper;
import mobi.xdsp.tracking.mapper.OfferMapper;
import mobi.xdsp.tracking.mapper.PublisherMapper;
import mobi.xdsp.tracking.mapper.PublisherOfferMapper;
import mobi.xdsp.tracking.router.ConversionAPI;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class PbResentJob {
    @Autowired
    private OfferMapper offerMapper;
    @Autowired
    private ActivateMapper activateMapper;
    @Autowired
    private PublisherOfferMapper publisherOfferMapper;

    @Autowired
    private PublisherMapper publisherMapper;

    @Autowired
    private ConversionAPI  conversionAPI;
    @Autowired
    Mailer mailer;
    private static final Logger pblog = LoggerFactory.getLogger("pb");

    private static final Logger clicklog = LoggerFactory.getLogger("click");

    public static void main(String[] args) {
        System.out.println(DateTimeUtil.getDateBefore(new Date(), 2));
    }
    @Scheduled(cron = "* */40 * * * ?")
    public void resentPb() {

        try {

            ActivateExample example = new ActivateExample();
            example.createCriteria().andInserttimeGreaterThan(DateTimeUtil.getDateBefore(new Date(), 1))
                    .andStatusEqualTo(PBStateE.VALID.code).andChannelidGreaterThan(1).andNoticestatusEqualTo(PBNoticeStateE.NO.code);

            List<ActivateWithBLOBs> list = activateMapper.selectByExampleWithBLOBs(example);
            if(list!=null){
                list.forEach(n->{
                    if(n.getChannelid()!=null && n.getOfferuid()!=null){
                        Publisher publisher = publisherMapper.selectByPrimaryKey(n.getChannelid());
                        if(publisher==null){
                            return;
                        }
                        String tid = "RESENT:"+RandomStringUtils.randomAlphabetic(4) + "-" + publisher.getId() + "-" + n.getOfferuid();

                        String track = publisher.getPostbackurl();

                        if (track.indexOf("{click_id}") > -1 && StringUtils.isNotBlank(n.getClickidext())) {
                            track = StringUtils.replaceAll(track, "\\{click_id}", n.getClickidext());
                        }
                        if (track.indexOf("{clickid}") > -1 && StringUtils.isNotBlank(n.getClickid())) {
                            track = StringUtils.replaceAll(track, "\\{clickid}", n.getClickid());
                        }

                        if (track.indexOf("{idfa}") > -1 && StringUtils.isNotBlank(n.getDeviceid())) {
                            track = StringUtils.replaceAll(track, "\\{idfa}", n.getDeviceid());
                        }

                        if (track.indexOf("{gaid}") > -1 && StringUtils.isNotBlank(n.getDeviceid())) {
                            track = StringUtils.replaceAll(track, "\\{gaid}", n.getDeviceid());
                        }

                        if (track.indexOf("{pub_sub}") > -1 && StringUtils.isNotBlank(n.getPubsub())) {
                            track = StringUtils.replaceAll(track, "\\{pub_sub}", n.getPubsub());
                        }

                        if (track.indexOf("{appid}") > -1 && StringUtils.isNotBlank(n.getAppid())) {
                            track = StringUtils.replaceAll(track, "\\{appid}", n.getAppid());
                        }
                        if (track.indexOf("{sub1}") > -1 && StringUtils.isNotBlank(n.getSubid1())) {
                            track = StringUtils.replaceAll(track, "\\{sub1}", n.getSubid1());
                        }
/*
                        if (track.indexOf("{payout}") > -1&& n.getDefaultpayout()!= null) {
                            track = StringUtils.replaceAll(track, "\\{payout}", n.getDefaultpayout().toString());
                        }*/
                        try {
                            track = AdTool.urlEncode(track);
                            pblog.warn(tid + ":" + track);
                            String resp = HttpClientUtil.get(track);
                            n.setNoticestatus(PBNoticeStateE.SENT.code);
                            pblog.warn(tid + ":" + "resp");
                        } catch (Exception e) {
                            n.setNoticestatus(PBNoticeStateE.SENT.code);
                            pblog.warn(tid + ":" + "senderror",e);
                        }finally {
                            ActivateWithBLOBs activate = new ActivateWithBLOBs();
                            activate.setId(n.getId());
                            activate.setNoticestatus(PBNoticeStateE.SENT.code);
                            activateMapper.updateByPrimaryKeySelective(activate);
                        }



                    }

                });
            }
        } catch (Exception e) {
            mailer.sendErrorMail("Tracking Error: updateOfferCacheJob", e.getMessage() + "\n" + e.getLocalizedMessage());

            e.printStackTrace();
        }


    }


}
