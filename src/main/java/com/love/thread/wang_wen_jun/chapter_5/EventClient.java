package com.love.thread.wang_wen_jun.chapter_5;

import java.util.concurrent.TimeUnit;

/**
 * Created by ls on 2018/11/9.
 */
public class EventClient {

    public static void main(String[] args) {

        final EventQueue eventQueue = new EventQueue();
        new Thread(() -> {
            for (; ; ) {
                eventQueue.offer(new EventQueue.Event());
            }
        }, "Producer").start();


        new Thread(() -> {
            for (; ; ) {
                eventQueue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }, "Consumer").start();

    }


}
