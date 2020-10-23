package com.adscanal.sdk.core.job;

import com.adscanal.sdk.core.SdkConf;
import com.adscanal.sdk.dto.SimpleData;
import com.google.common.collect.Sets;
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

@Component
public class PauseOfferJob {

    private static final Logger logger = LoggerFactory.getLogger(PauseOfferJob.class);
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Scheduled(cron = "1 0 0 * * ?")
    public void cleanPauseSet() {
        SimpleData.PAUSE_OFFERS = Sets.newHashSet();
    }

    @Scheduled(cron = "1 0/10 * * * ?")
    @PostConstruct
    public void pauseOfferByClickLimited() {
        String today = DateFormatUtils.format(new Date(), "yyyy-MM-dd");
        String start = today + " 00:00:00";
        String end = today + " 23:59:59";

        String sql = "select s.offer_uid uid ,sum(ifnull(s.click_count,0)) as clicks from  daily_report s  where  s.state_date between '" + start + "' and  '" + end + "' group by  s.offer_uid";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        if (list != null) {
            list.forEach(o -> {

                Integer id = Integer.parseInt(o.get("uid").toString());
                Integer clicks = Integer.parseInt(o.get("clicks").toString());
                if (SimpleData.OFFER_CLICKS.containsKey(id)) {
                    Integer oldclicks = SimpleData.OFFER_CLICKS.get(id);
                    if (clicks > (oldclicks - 10000)) {
                        SimpleData.PAUSE_OFFERS.add(id);
                        SdkConf.OFFER_SCHED.get(id).shutdownNow();
                        SimpleData.OFFER_CLICKS.remove(id);
                        logger.warn("PAUSEOFFER:" + id);
                    }
                }
            });
        }

    }


}
