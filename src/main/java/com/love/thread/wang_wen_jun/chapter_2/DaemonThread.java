package com.love.thread.wang_wen_jun.chapter_2;

/**
 * Created by ls on 2018/11/5.
 */
public class DaemonThread {

    /**
     * JVM在什么情况下会正常退出：
     * 在正常情况下，若JVM中没有一个非守护线程，则JVM的进程会退出。
     */


    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(
                () -> {
                    while (true) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        thread.setDaemon(true);

        thread.start();
        Thread.sleep(2000L);
        System.out.println("Main thread finished lifecycle ...");


    }
}

