package com.love.thread.wang_wen_jun.chapter_3;

/**
 * Created by ls on 2018/11/6.
 */
public class ThreadPriority {

    /**
     * 设置线程优先级 是一个hint（提示）操作
     * <p>
     * 源码分析：
     * 线程的优先级不能小于1也不能大于10
     * 如果指定的线程优先级大于线程所在group的优先级，那么指定的优先级将会失效
     * <p>
     * <p>
     * 线程默认的优先级和它的父类保持一致，一般情况下都是5，因为main线程的优先级就是5，所以它派生出来的线程都是5
     */

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("t1");
            }
        });

        t1.setPriority(3);


        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("t2");
            }
        });

        t2.setPriority(10);

//        t1.start();
//        t2.start();

        test();
    }

    /**
     * 线程默认的优先级和它的父类保持一致，一般情况下都是5，因为main线程的优先级就是5，所以它派生出来的线程都是5
     */
    private static void test() {

        Thread t1 = new Thread();
        System.out.println("  t1  priority  " + t1.getPriority());

        Thread t2 = new Thread(() -> {
            Thread t3 = new Thread();
            System.out.println("  t3  priority  " + t3.getPriority());
        });

        t2.setPriority(6);
        t2.start();
        System.out.println("  t2  priority  " + t2.getPriority());

    }

    /**
     *
     * public long getId()  获取线程的唯一ID，线程的ID在整个JVM中都是唯一的
     *
     */


}
