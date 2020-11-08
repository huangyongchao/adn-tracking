package com.adscanal.sdk.core.job;

import com.adscanal.sdk.common.HttpClientUtil;
import com.adscanal.sdk.core.SdkConf;
import com.adscanal.sdk.dto.Counter;
import com.adscanal.sdk.dto.OfferClick;
import com.adscanal.sdk.dto.OfferCounter;
import com.adscanal.sdk.dto.SimpleData;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CounterJob {
    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger logger = LoggerFactory.getLogger(CounterJob.class);


    @Value("${businessserver}")
    private String businessserver;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Scheduled(cron = "1 0,10,20,30,40,50 * * * ?")
    public void setCurrentHour() {
        Counter.CURRENT_HOUR = new Date().getHours();
    }


    @Scheduled(cron = "1 0,5,15,35,55 0 */1 * ?")
    public void exchangeCounter() {
        Counter.exchange();
    }


    @Scheduled(cron = "0 0,5,15,35,55 21,22,23 */1 * ?")
    public void resetExchangeLock() {
        Counter.EXCHANGE_LOCK.set(false);
    }


    @Scheduled(cron = "1 0 * * * ?")
    public void initdailayreport() {
        String current = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH");
        String state_date = current + ":00:00";

        String sql = "INSERT INTO daily_report (channel_id,sub_id,advertiser_id,advertiser_name,affiliate_id,affiliate_name,offer_id,offer_name,country,state_date,offer_uid,app_id,app_name,source_affiliate_id,source_campaign,click_count,click_invalid) " +
                "select '0','',s.aId,s.affiliateName,s.affiliateId,s.affiliateName,s.offerId,s.offerName,s.countries,'"+state_date+"',s.id,s.appId,s.offerName,  s.sourceAffiliateId,s.sourceOfferId," +
                " 0,0 from offer s where s.status = 'active' " +
                "and s.priority >=2 ON DUPLICATE KEY UPDATE click_count = click_count+0,click_invalid=click_invalid+0";

        jdbcTemplate.execute(sql);
    }

    @Scheduled(cron = "55 9,19,29,39,49,59 * * * ?")
    public void saveClicks() {

        String current = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH");
        String state_date = current + ":00:00";

        Map<Integer, OfferCounter>  map = Counter.counterMap();
        map.forEach((k, v) -> {
            long ss = v.success1.longValue();
            long dvs = ss - v.getSuccess1snp();

            long ss2 = v.success.longValue();
            long dvs2 = ss2 - v.getSuccesssnp();

            long er1 = v.getError1().longValue();
            long dv1 = er1 - v.getError1snp();

            long er = v.getError().longValue();
            long dv0 = er - v.getErrorssnp();

            long clicks = (dvs + dvs2);
            long vclicks = (dv1 + dv0);
            try {
            /*    String sql1 = "update daily_report s set s.click_count = click_count+" + (dvs+dvs2) + ",s.click_invalid=s.click_invalid+" + (dv1+dv0) + " where s.state_date = '" + state_date + "' and s.offer_uid =" + k;
                jdbcTemplate.execute(sql1);*/

                String s = HttpClientUtil.get("http://" + businessserver + "/api/open/saveclicks/" + k + "/" + clicks + "/" + vclicks);
                if (s != null && s.indexOf("error") < 0) {
                    v.setSuccess1snp(ss);
                    v.setSuccesssnp(ss2);
                    v.setError1snp(er1);
                    v.setErrorssnp(er);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }



        });
    }

    public static void main(String[] args) {
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH") + ":00:00");
        long dv =100;
        long dv1 = 1000;
        String d = "2020-10-17 12:00:00";
        int k = 111;
        String sql1 = "update daily_report s set s.click_count = click_count+" + dv + ",s.click_invalid=s.click_invalid+" + dv1 + " where s.state_date = '" + d + "' and s.offer_uid = " + k;
        System.out.println(sql1);

    }

    @PostConstruct
    public void autoStart() {
        setCurrentHour();
        initdailayreport();
    }


    @PostConstruct
    @Scheduled(cron = "0 */3 * * * ?")
    public void loadOfferClicks() {
        //http://admin.colour.mobi/api/open/dailyclicks/1
        //http://admin.colour.mobi/api/open/saveclicks/11588/2/1

        try {
            String json = HttpClientUtil.get("http://" + businessserver + "/api/open/dailyclicks/1");
            List<OfferClick> offerClicks = JSONArray.parseArray(json, OfferClick.class);
            if (!CollectionUtils.isEmpty(offerClicks)) {
                offerClicks.forEach(n -> {
                    Counter.DAILY_CLICKS.put(n.getUid(), new AtomicInteger(n.getClicks()));
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    /*    String today = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
        String start = today + " 00:00:00";
        String end = today + " 23:59:59";

        String sql = "select s.offer_uid uid ,sum(ifnull(s.click_count,0)) as clicks from  daily_report s  where  s.state_date between '" + start + "' and  '" + end + "' group by  s.offer_uid";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        if (list != null) {
            list.forEach(o -> {
                Integer id = Integer.parseInt(o.get("uid").toString());
                Integer clicks = Integer.parseInt(o.get("clicks").toString());
                Counter.DAILY_CLICKS.put(id, new AtomicInteger(clicks));
            });
        }
*/


    }

    @Scheduled(cron = "1 0/1 * * * ?")
    public void checkPauseOffersByClicks() {
        SimpleData.OFFER_CLICKS.forEach((id, v) -> {
            if (v < Counter.DAILY_CLICKS.get(id).get()) {
                SimpleData.PAUSE_OFFERS.add(id);
                if(SdkConf.OFFER_SCHED.containsKey(id)){
                    SdkConf.OFFER_SCHED.get(id).shutdownNow();
                    SdkConf.OFFER_SCHED.remove(id);
                }
                logger.warn("PAUSEOFFER:" + id);
            }
        });
    }


}
