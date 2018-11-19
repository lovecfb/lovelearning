package com.love.thread.wang_wen_jun.chapter_3;

import java.util.concurrent.TimeUnit;

/**
 * Created by ls on 2018/11/6.
 */
public class ThreadIsInterrupted {

    /**
     *
     *
     */
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {

                    try {
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {

                        System.out.printf(" I am interrupted ? %s\n", isInterrupted()); // 中断方法获取到了中断信号之后，为了不影响
                        // 线程中其它方法的执行，将线程的interrupt标识复位是一种合理设计
                    }

                }
            }
        };

        thread.setDaemon(true);
        thread.start();
        // short block and make sure thread is started
        TimeUnit.MILLISECONDS.sleep(2);

        System.out.printf(" Thread is interrupted ? %s\n", thread.isInterrupted());
        thread.interrupt();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf(" Thread is interrupted ? %s\n", thread.isInterrupted());

    }

}
