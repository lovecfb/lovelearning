package com.love.thread.wang_wen_jun.chapter_2;


import java.util.stream.IntStream;

/**
 * Created by ls on 2018/11/5.
 */
public class ThreadConstructed {

    /**
     * 结论：
     * 1）一个线程的创建，肯定是由另一个线程完成的
     * 2）被创建线程的父线程是创建它的线程
     * 3）main线程是由jvm创建的
     * 4)main线程所在的ThreadGroup称为main
     * 5）构建一个线程的时候如果没有显示指定ThreadGroup，那么它将会和父线程同属于一个ThreadGroup，默认设置中它和父线程拥有同样的优先级，同样的daemon
     *
     *
     */

    private final static String PREFIX = "ALEX-";

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        IntStream.range(0, 5).boxed().map(i -> new Thread(
                () -> System.out.println(Thread.currentThread().getName()))
        ).forEach(Thread::start);


        IntStream.range(0, 5).forEach(i -> System.out.println(i));

        IntStream.range(0, 5).mapToObj(ThreadConstructed::createThread).forEach(Thread::start);


    }

    private static Thread createThread(final int intName) {
        return new Thread(() -> System.out.println(Thread.currentThread().getName()), PREFIX + intName);
    }


}
