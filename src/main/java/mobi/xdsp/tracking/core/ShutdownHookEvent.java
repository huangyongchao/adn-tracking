package mobi.xdsp.tracking.core;

import mobi.xdsp.tracking.core.job.CounterJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author huangyongchao
 * 注册优雅停机事件 暂时不能捕获kill -9 所以尽量避免Kill -9
 * <p>
 * 上报内存数据等操作
 */
@Component
public class ShutdownHookEvent {
    public static boolean SHUTDOWN = false;
    private static final Logger logger = LoggerFactory.getLogger(ShutdownHookEvent.class);
    @Autowired
    CounterJob counterJob;
    @PreDestroy
    public void exeWhenShutdown() throws Exception {
        SHUTDOWN = true;
        logger.info("++++++++++++++++++++++++++++++Write Clicks to Report++++++++++++++++++++++++++++++");

        counterJob.recordClicks();

        logger.info("++++++++++++++++++++++++++++++System  Shutdown++++++++++++++++++++++++++++++");
    }
}
