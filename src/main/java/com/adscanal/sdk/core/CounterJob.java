package com.adscanal.sdk.core;

import com.adscanal.sdk.dto.Counter;
import com.adscanal.sdk.dto.OfferCounter;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Map;

@Component
public class CounterJob {
    private static final Logger errorlog = LoggerFactory.getLogger("error");

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Scheduled(cron = "1 0,10,20,30,40,50 * * * ?")
    public void setCurrentHour() {
        Counter.CURRENT_HOUR = new Date().getHours();
    }


    @Scheduled(cron = "0 0,5,15,35,55 0 */1 * ?")
    public void exchangeCounter() {
        Counter.exchange();
    }


    @Scheduled(cron = "0 0,5,15,35,55 21,22,23 */1 * ?")
    public void resetExchangeLock() {
        Counter.EXCHANGE_LOCK.set(false);
    }


    @Scheduled(cron = "1 0 * * * ?")
    public void initdailayreport() {
        String sql = "INSERT INTO daily_report (channel_id,sub_id,advertiser_id,advertiser_name,affiliate_id,affiliate_name,offer_id,offer_name,country,state_date,offer_uid,app_id,app_name,source_affiliate_id,source_campaign,click_count,click_invalid) " +
                "select '0','',s.aId,s.affiliateName,s.affiliateId,s.affiliateName,s.offerId,s.offerName,s.countries,CONCAT(date_format(now(),'%Y%m%d%H'),'0000'),s.id,s.appId,s.offerName,  s.sourceAffiliateId,s.sourceOfferId," +
                " 0,0 from offer s where s.status = 'active' " +
                "and s.priority >=2 ON DUPLICATE KEY UPDATE click_count = click_count+0,click_invalid=click_invalid+0";

        jdbcTemplate.execute(sql);
    }

    @Scheduled(cron = "59 9,19,29,39,49,59 * * * ?")
    public void saveClicks() {

        String d = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH") + ":00:00";
        Map<Integer, OfferCounter>  map = Counter.counterMap();
        map.forEach((k, v) -> {
            long ss = v.success1.longValue();
            long dv = ss - v.getSuccess1snp();
            long er1 = v.getError1().longValue();
            long dv1 = er1 - v.getError1snp();
            try {
                String sql1 = "update daily_report s set s.click_count = click_count+" + dv + ",s.click_invalid=s.click_invalid+" + dv1 + " where s.state_date = '" + d + "' and s.offer_uid = " + k;
                jdbcTemplate.execute(sql1);
                v.setSuccess1snp(ss);
                v.setError1snp(er1);
            } catch (DataAccessException e) {
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
}
