package com.love.thread.wang_wen_jun.chapter_3;

import java.util.concurrent.TimeUnit;

/**
 * Created by ls on 2018/11/6.
 */
public class ThreadInterrupted {

    /***
     *
     * interrupted()调用该方法会直接擦除线程的interrupt标识，需要注意的是，如果当前线程被打断了，那么第一次调用interrupted方法会
     * 返回true，并且立即擦除interrupt标识，第二次包括以后的调用永远都会返回false，除非在此期间线程又一次被打断
     *

     */

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.interrupted());
                }
            }
        };

        thread.setDaemon(true);
        thread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();


    }


}
