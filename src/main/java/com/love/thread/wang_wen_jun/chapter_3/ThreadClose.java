package com.love.thread.wang_wen_jun.chapter_3;

/**
 * Created by ls on 2018/11/7.
 */
public class ThreadClose {

    /**
     * 线程关闭
     *
     *  stop()方法  问题是：该方法在关闭线程时可能不会释放掉monitor锁
     *
     * 正常关闭
     *  1、线程结束生命周期正常结束
     *  2、捕获中断线程关闭线程
     *  3、使用volatile开关控制
     *
     * 异常退出
     *  checked异常封装成unchecked异常
     *
     * 进程假死
     *
     */

}
