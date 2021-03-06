package mobi.xdsp.tracking.core.job;

import mobi.xdsp.tracking.common.Mailer;
import mobi.xdsp.tracking.entity.DailyReportAdn;
import mobi.xdsp.tracking.entity.DailyReportAdnExample;
import mobi.xdsp.tracking.entity.Offer;
import mobi.xdsp.tracking.entity.Publisher;
import mobi.xdsp.tracking.mapper.DailyReportAdnMapper;
import mobi.xdsp.tracking.mapper.DailyReportOVMapper;
import mobi.xdsp.tracking.service.DataService;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Component
public class CounterJob {

    @Autowired
    Mailer mailer;
    @Autowired
    private DataService dataService;

    @Autowired
    private DailyReportAdnMapper dailyReportAdnMapper;
    @Autowired
    private DailyReportOVMapper dailyReportOVMapper;
    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger clicklog = LoggerFactory.getLogger("click");
    private static final Logger logger = LoggerFactory.getLogger(CounterJob.class);

    @Scheduled(cron = "0 0,10,20,30,40,50 0,1 * * ?")
    public void exchange() {
        Counter.exchange();
    }


    @Scheduled(cron = "55 9,19,29,39,49,55,59 * * * ?")
    public void recordClicks() {
        String datestr = LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String monthstr = LocalDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM"));
        Counter.COUNTER_HOUR_TODAY.forEach((pid, vs) -> {
            vs.forEach((oid, vss) -> {
                vss.forEach((hour, vsss) -> {
                    vsss.forEach((pubsub, cnt) -> {

                        try {
                            Long c = cnt.getSuccess().longValue();
                            Long dev = c - cnt.getSuccesssnp();
                            cnt.setSuccesssnp(c);
                            if (dev == 0) {
                                return;
                            }

                            Offer offer = dataService.getOfferCache(oid);
                            if (offer == null) {
                                offer = dataService.cacheOfferFirst(oid);
                            }
                            Publisher publisher = null;
                            if (pid == 0) {
                                publisher = new Publisher(0, "SDK", "SDK");
                            } else if (pid == 1) {
                                publisher = new Publisher(1, "DSP", "DSP");

                            } else if (pid == 2) {
                                publisher = new Publisher(2, "MAF", "MAF");

                            } else {
                                publisher = dataService.getPublisherCache(pid);
                            }

                            String cdatestr = datestr + " " + hour + ":00:00";
                            Date cdate = DateUtils.parseDate(cdatestr, "yyyy-MM-dd HH:mm:ss");

                            DailyReportAdnExample example = new DailyReportAdnExample();
                            example.createCriteria().andChannelIdEqualTo(pid.shortValue()).andOfferUidEqualTo(oid)
                                    .andDaystrEqualTo(datestr).andSubIdEqualTo(pubsub).andHEqualTo(hour);


                            List<DailyReportAdn> list = dailyReportAdnMapper.selectByExample(example);
                            // ?????????????????? ??????????????????

                            if (CollectionUtils.isEmpty(list)) {
                                DailyReportAdn dailyReportAdn = new DailyReportAdn();
                                dailyReportAdn.setAdvertiserId(Short.parseShort(offer.getAid()));
                                dailyReportAdn.setAppId(offer.getAppid());
                                dailyReportAdn.setAdvertiserName(offer.getAffiliatename());
                                dailyReportAdn.setAffiliateName(offer.getAffiliatename());
                                dailyReportAdn.setAffiliateId(offer.getAffiliateid());
                                dailyReportAdn.setAppName(offer.getAppname());
                                dailyReportAdn.setClickCount(dev.intValue());
                                dailyReportAdn.setClickInvalid(0);
                                dailyReportAdn.setConverionCount(0);
                                dailyReportAdn.setChannelName(publisher.getCompanyname());
                                dailyReportAdn.setCurrency(offer.getCurrency());
                                dailyReportAdn.setCountry(offer.getCountries());
                                dailyReportAdn.setOfferId(offer.getOfferid());
                                dailyReportAdn.setOfferName(offer.getOffername());
                                dailyReportAdn.setSubId(pubsub);
                                dailyReportAdn.setOfferUid(oid);
                                dailyReportAdn.setChannelId(pid.shortValue());
                                dailyReportAdn.setSourceCampaign(offer.getSourceofferid());
                                dailyReportAdn.setSourceAffiliateId(offer.getSourceaffiliateid());
                                dailyReportAdn.setStateDate(cdate);
                                dailyReportAdn.setH(hour);
                                dailyReportAdn.setDaystr(datestr);

                                dailyReportAdnMapper.insertSelective(dailyReportAdn);

                                cnt.setNewrecord(false);
                            } else {
                                DailyReportAdn dailyReportAdn = list.get(0);
                                dailyReportAdn.setClickCount(dailyReportAdn.getClickCount() + dev.intValue());

                                dailyReportAdnMapper.updateByPrimaryKey(dailyReportAdn);

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.error(pid + "");
                        }


                        /*try {
                            Long c = cnt.getSuccess().longValue();
                            Long dev = c - cnt.getSuccesssnp();
                            cnt.setSuccesssnp(c);
                            if (dev == 0) {
                                return;
                            }

                            Offer offer = dataService.getOfferCache(oid);
                            Publisher publisher = null;
                            if (pid == 0) {
                                publisher = new Publisher(0, "SDK", "SDK");
                            } else if (pid == 1) {
                                publisher = new Publisher(1, "DSP", "DSP");

                            } else if (pid == 2) {
                                publisher = new Publisher(2, "MAF", "MAF");

                            } else {
                                publisher = dataService.getPublisherCache(pid);
                            }
                            String cdatestr = datestr + " " + hour + ":00:00";
                            Date cdate = DateUtils.parseDate(cdatestr, "yyyy-MM-dd HH:mm:ss");

                            DailyReportAdnExample example = new DailyReportAdnExample();
                            example.createCriteria().andChannelIdEqualTo(pid.shortValue()).andOfferUidEqualTo(oid)
                                    .andDaystrEqualTo(datestr).andHEqualTo(hour);


                            List<DailyReportAdn> list = dailyReportOVMapper.selectByExample(example);
                            // ?????????????????? ??????????????????

                            if (CollectionUtils.isEmpty(list)) {
                                DailyReportAdn dailyReportAdn = new DailyReportAdn();
                                dailyReportAdn.setAdvertiserId(Short.parseShort(offer.getAid()));
                                dailyReportAdn.setAppId(offer.getAppid());
                                dailyReportAdn.setAdvertiserName(offer.getAffiliatename());
                                dailyReportAdn.setAffiliateName(offer.getAffiliatename());
                                dailyReportAdn.setAffiliateId(offer.getAffiliateid());
                                dailyReportAdn.setAppName(offer.getAppname());
                                dailyReportAdn.setClickCount(dev.intValue());
                                dailyReportAdn.setClickInvalid(0);
                                dailyReportAdn.setConverionCount(0);
                                dailyReportAdn.setChannelName(publisher.getCompanyname());
                                dailyReportAdn.setCurrency(offer.getCurrency());
                                dailyReportAdn.setCountry(offer.getCountries());
                                dailyReportAdn.setOfferId(offer.getOfferid());
                                dailyReportAdn.setOfferName(offer.getOffername());
                                dailyReportAdn.setSubId("0");
                                dailyReportAdn.setOfferUid(oid);
                                dailyReportAdn.setChannelId(pid.shortValue());
                                dailyReportAdn.setSourceCampaign(offer.getSourceofferid());
                                dailyReportAdn.setSourceAffiliateId(offer.getSourceaffiliateid());
                                dailyReportAdn.setStateDate(cdate);
                                dailyReportAdn.setH(hour);
                                dailyReportAdn.setDaystr(datestr);

                                dailyReportOVMapper.insertSelective(dailyReportAdn);

                                cnt.setNewrecord(false);
                            } else {
                                DailyReportAdn dailyReportAdn = list.get(0);
                                dailyReportAdn.setClickCount(dailyReportAdn.getClickCount() + dev.intValue());

                                dailyReportOVMapper.updateByPrimaryKey(dailyReportAdn);

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            logger.error(pid + "");
                        }*/


                    });
                });
            });
        });
    }

    public static void main(String[] args) {
        
    }
}
