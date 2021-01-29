package com.adscanal.sdk.common;


import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huangyongchao
 */
public class ExecutorPool {
    private static ThreadPoolExecutor executor;


    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("sdk-threadpool-%d").build();

    static {
        executor = new ThreadPoolExecutor(1000, 50000,
                60L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), namedThreadFactory);

    }

    public static ThreadPoolExecutor getExecutor() {
        return executor;
    }

}
