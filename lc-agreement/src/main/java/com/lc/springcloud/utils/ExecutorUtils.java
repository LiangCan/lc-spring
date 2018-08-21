package com.lc.springcloud.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by Liang on 2017/1/3.
 */
public class ExecutorUtils {
    /**
     * 可缓存,无限大线程池
     */
    public static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    /**
     * 定长线程池
     */
    public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

    /**
     * 定时执行线程池
     */
    public static ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

//    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
//        scheduledExecutor.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("--------------");
//            }
//        },3000,TimeUnit.MILLISECONDS);
//
//        Thread.sleep(4000);
//        scheduledExecutor.shutdownNow();
//    }


}
