package com.love.thread.wang_wen_jun.chapter_3;

/**
 * Created by ls on 2018/11/6.
 */
public class CurrentThread {

    /**
     * 返回当前执行线程的引用
     */

    public static void main(String[] args) {


        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() == this);
            }
        };

        thread.start();
        String name = Thread.currentThread().getName();
        System.out.println("main".equals(name));
    }


    /**
     * 线程上下文类加载器
     *
     * public ClassLoader getContextClassLoader() 获取线程上下文的类加载器（简单来说就是这个线程是由那个类加载器加载的）
     *
     * public void setContextClassLoader(ClassLoader cl) 设置该线程的类加载器，这个方法可以打破JAVA类加载器的父委托机制（java类加载器的后门）
     *
     */
}
