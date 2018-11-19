package com.love.thread.wang_wen_jun.chapter_3;

/**
 * Created by ls on 2018/11/6.
 */
public class ThreadSleep {
    /**
     *
     *
     *
     */

    public static void main(String[] args) {

        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            sleep(3_000L);
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("Total spend %d ms", (endTime - startTime)));
        }).start();

        long startTime = System.currentTimeMillis();
        sleep(3_000L);
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Main thread total spend %d ms", (endTime - startTime)));
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
