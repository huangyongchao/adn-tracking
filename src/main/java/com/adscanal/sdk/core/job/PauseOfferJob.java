package com.adscanal.sdk.core.job;

import com.adscanal.sdk.core.SdkConf;
import com.adscanal.sdk.dto.Counter;
import com.adscanal.sdk.dto.SimpleData;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class PauseOfferJob {

    private static final Logger logger = LoggerFactory.getLogger(PauseOfferJob.class);
    @Autowired
    JdbcTemplate jdbcTemplate;


    @PostConstruct
    public void loadOfferClicks() {
        String today = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
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

    }

    @Scheduled(cron = "1 0/2 * * * ?")
    public void checkPauseOffersByClicks() {
        SimpleData.OFFER_CLICKS.forEach((id, v) -> {
            if (v < Counter.DAILY_CLICKS.get(id).get()) {
                SimpleData.PAUSE_OFFERS.add(id);
                SdkConf.OFFER_SCHED.get(id).shutdownNow();
                SdkConf.OFFER_SCHED.remove(id);
                logger.warn("PAUSEOFFER:" + id);
            }
        });
    }

}
