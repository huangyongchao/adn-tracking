package com.adscanal.sdk.common;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author huangyongchao
 */
public class ExecutorPool {
    private static ThreadPoolExecutor executor;


    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("sdk-threadpool-%d").build();

    static {
        executor = new ThreadPoolExecutor(1000, 2000,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(2000), namedThreadFactory);

    }

    public static ThreadPoolExecutor getExecutor() {
        return executor;
    }

}
