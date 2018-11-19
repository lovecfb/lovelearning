package com.love.thread.wang_wen_jun.chapter_4;

/**
 * Created by ls on 2018/11/7.
 */
public class DeadLock {




    /***
     * 产生死锁的原因：
     *  1） 交叉验证可导致程序产生死锁
     *  2） 内存不足
     *  3） 一问一答式的数据交换
     *  4） 数据库锁
     *  5） 文件锁
     *  6） 死循环引起的死锁
     *
     *
     *  java性能监控工具： jprofile
     *
     */

    private final Object MUTEX_READ = new Object();
    private final Object MUTEX_WRITE = new Object();


    public void read() {
        synchronized (MUTEX_READ) {
            System.out.println(Thread.currentThread().getName() + " get read Lock");
            synchronized (MUTEX_WRITE) {
                System.out.println(Thread.currentThread().getName() + " get write Lock");
            }
            System.out.println(Thread.currentThread().getName() + " release write Lock");
        }

        System.out.println(Thread.currentThread().getName() + " release read Lock");
    }


    public void write() {
        synchronized (MUTEX_WRITE) {
            System.out.println(Thread.currentThread().getName() + " get write Lock");
            synchronized (MUTEX_READ) {
                System.out.println(Thread.currentThread().getName() + " get read Lock");
            }
            System.out.println(Thread.currentThread().getName() + " release read Lock");
        }

        System.out.println(Thread.currentThread().getName() + " release write Lock");
    }

    public static void main(String[] args) {

        final DeadLock deadLock = new DeadLock();
        new Thread(() -> {
            while (true) {
                deadLock.read();
            }
        }, "READ_WRITE").start();

        new Thread(() -> {
            while (true) {
                deadLock.write();
            }
        }, "WRITE_READ").start();


    }


}
