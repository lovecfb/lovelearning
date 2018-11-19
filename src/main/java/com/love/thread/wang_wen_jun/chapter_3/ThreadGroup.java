package com.love.thread.wang_wen_jun.chapter_3;

/**
 * Created by ls on 2018/11/6.
 */
public class ThreadGroup {

    public static void main(String[] args) {


        java.lang.ThreadGroup group = new java.lang.ThreadGroup("test");
        group.setMaxPriority(7);

        Thread thread = new Thread(group, "test-thread");
        thread.setPriority(10);
        System.out.println(thread.getPriority());


    }


}
