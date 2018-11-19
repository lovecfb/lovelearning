package com.love.thread.wang_wen_jun.chapter_5;

import java.util.concurrent.TimeUnit;

/**
 * Created by ls on 2018/11/15.
 */
public class SynchronizedDefect {

    public synchronized void synchronizedMethod() {
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        SynchronizedDefect defect = new SynchronizedDefect();
        Thread t1 = new Thread(defect::synchronizedMethod, "t1");
        // make sure the t1 start
        t1.start();

        TimeUnit.MILLISECONDS.sleep(2);
        Thread t2 = new Thread(defect::synchronizedMethod, "t2");
        t2.start();

        // make sure the t2 start
        TimeUnit.MILLISECONDS.sleep(2);

        t2.interrupt();
        System.out.println(t2.isInterrupted());
        System.out.println(t2.getState());
    }


}
