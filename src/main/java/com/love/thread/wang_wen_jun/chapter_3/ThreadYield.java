package com.love.thread.wang_wen_jun.chapter_3;

import java.util.stream.IntStream;

/**
 * Created by ls on 2018/11/6.
 */
public class ThreadYield {
    /**
     * yield方法属于一种启发式的方法，其会提醒调度器我愿意放弃当前的CPU资源，如果CPU的资源不紧张，则会忽略这种提醒
     * yield方法 使得当前线程从RUNNING -> RUNNABLE
     */
    public static void main(String[] args) {
        IntStream.range(0, 2).mapToObj(ThreadYield::create).forEach(Thread::start);
    }

    private static Thread create(int index) {
        return new Thread(() -> {
//            如果打开此注释，那么打印的顺序是固定的 0,1
//            但是yield只是一个提示（hint）CPU调度器并不会担保每次都能满足yield提示
//            if (index == 1)
//                Thread.yield();
            System.out.println(index);
        });
    }

    /**
     * yield和sleep的区别：
     *  sleep会导致当前线程暂停指定时间，没有CPU时间片的消耗
     *  yield只是对CPU调度器的一个提示，如果CPU调度器没有忽略这个提示，它会导致线程上下文的切换
     *  sleep会使线程短暂block，会在给定的时间内释放CPU资源
     *  yield会使RUNNING状态的Thread进入RUNNABLE状态（如果CPU调度器没有忽略这个提示的话）
     *  sleep几乎百分百的完成了给定时间的休眠，而yield的提示并不一定能保证
     *  一个线程sleep另一个线程调用interrupt会捕获到中断信号，而yield则不会
     */


}
