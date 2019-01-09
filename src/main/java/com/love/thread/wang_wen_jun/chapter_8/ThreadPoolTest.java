package com.love.thread.wang_wen_jun.chapter_8;

import java.util.concurrent.TimeUnit;

/**
 *
 * Created by ls on 2018/11/30.
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {

        final ThreadPool threadPool = new BasicThreadPool(2, 6, 4, 1000);

        for (int i = 0; i < 20; i++)
            threadPool.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "  is running and done ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        for (; ; ) {
            System.out.println(" getActiveCount " + threadPool.getActiveCount());
            System.out.println(" getQueueSize " + threadPool.getQueueSize());
            System.out.println(" getCoreSize " + threadPool.getCoreSize());
            System.out.println(" getMaxSize " + threadPool.getMaxSize());
            System.out.println(" ================================ ");
            TimeUnit.SECONDS.sleep(5);
        }


    }


}
