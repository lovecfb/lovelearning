package com.love.thread.wang_wen_jun.chapter_3;

import java.util.concurrent.TimeUnit;

/**
 * Created by ls on 2018/11/6.
 */
public class Test01 {

    public static void main(String[] args) {

        // 判断当前线程是否中断
        System.out.println("Main thread is interrupted ? " + Thread.interrupted());

        // 中断当前线程
        Thread.currentThread().interrupt();

        // 判断当前线程是否已经被打断
        System.out.println("Main thread is interrupted ? " + Thread.currentThread().isInterrupted());

        try {
            // 当前线程执行可中断方法
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            // 捕获中断信号
            System.out.println("I will be interrupted still ...");
        }

//        System.out.println("Main thread is interrupted ? " + Thread.currentThread().isInterrupted());
//        System.out.println("Main thread is interrupted ? " + Thread.interrupted());
    }


}
