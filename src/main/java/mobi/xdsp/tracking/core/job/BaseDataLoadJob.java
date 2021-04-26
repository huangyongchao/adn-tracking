package mobi.xdsp.tracking.core.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BaseDataLoadJob {
    private static final Logger errorlog = LoggerFactory.getLogger("error");
    private static final Logger logger = LoggerFactory.getLogger(BaseDataLoadJob.class);


}
