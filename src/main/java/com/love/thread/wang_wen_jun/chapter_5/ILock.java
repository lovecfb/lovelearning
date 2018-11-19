package com.love.thread.wang_wen_jun.chapter_5;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * Created by ls on 2018/11/15.
 */
public interface ILock {

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBlockedThreads();
}
