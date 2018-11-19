package com.love.thread.wang_wen_jun.chapter_6;

import java.util.concurrent.TimeUnit;

/**
 * Created by ls on 2018/11/16.
 */
public class ThreadGroupDaemon {

    public static void main(String[] args) throws InterruptedException {

        ThreadGroup group1 = new ThreadGroup("group1");
        new Thread(group1, () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "group1-thread1").start();


        ThreadGroup group2 = new ThreadGroup("group2");
        new Thread(group2, () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "group2-thread2").start();

        // set daemon is true
        group2.setDaemon(true);

        TimeUnit.SECONDS.sleep(3);
        System.out.println(group1.isDestroyed());
        System.out.println(group2.isDestroyed());


    }


}
