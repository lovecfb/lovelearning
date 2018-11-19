package com.love.thread.wang_wen_jun.chapter_3;


import java.util.concurrent.TimeUnit;

/**
 * Created by ls on 2018/11/6.
 */
public class ThreadInterrupt {
    /**
     *
     * 线程Interrupt，是一个非常重要的API
     *  public void interrupt()
     *  public static boolean interrupted()
     *  public boolean isInterrupted()
     *
     */

    /**
     * 如下方法会使当前线程进入阻塞状态，而调用interrupt方法，就可以打断阻塞
     * Object的 public final void wait() throws InterruptedException
     * Object的 public final native void wait(long timeout) throws InterruptedException;
     * Object的 public final void wait(long timeout, int nanos) throws InterruptedException
     * <p>
     * Thread的 sleep方法
     * Thread的 join方法
     * <p>
     * InterruptibleChannel的IO操作
     * Selector的wakeup方法
     * <p>
     * 上面的方法也称为可中断方法，打断一个线程并不等于该线程的生命周期结束，仅仅是打断了当前线程的阻塞状态
     * <p>
     * 一旦线程在阻塞的情况下被打断，都会抛出一个称为InterruptedException的异常，这个异常就像一个signal（信号）一样通知当前线程被打断了
     */


    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("oh, I am be interrupted ...");
            }
        });

        thread.start();

        // short block and make sure thread is started
        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();  // 如果一个线程已经是死亡状态，尝试对其的interrupt会直接被忽略

    }

}
