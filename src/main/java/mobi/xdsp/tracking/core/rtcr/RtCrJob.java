package mobi.xdsp.tracking.core.rtcr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RtCrJob {
    @Autowired


    @Scheduled(cron = "0 0/5 * * * ?")
    public void crMonitor() {

        RtCrMonitor.exchangeNumber();
        RtCrMonitor.crCallback();

    }


}
