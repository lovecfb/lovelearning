package com.love.thread.wang_wen_jun.chapter_4;

import java.util.concurrent.TimeUnit;

/**
 * Created by ls on 2018/11/7.
 */
public class ThisMonitor {

    public synchronized void method1() { // 这种情况下synchronized使用的锁是 对象
        System.out.println(Thread.currentThread().getName() + " enter to method1 ");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " enter to method2 ");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThisMonitor thisMonitor = new ThisMonitor();
        new Thread(thisMonitor::method1, "T1").start();
        new Thread(thisMonitor::method2, "T2").start();
    }


}
