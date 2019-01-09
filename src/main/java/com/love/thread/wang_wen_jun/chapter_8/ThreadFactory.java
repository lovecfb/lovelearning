package com.love.thread.wang_wen_jun.chapter_8;

/**
 * 创建线程的工厂
 * <p>
 * Created by ls on 2018/11/29.
 */
@FunctionalInterface
public interface ThreadFactory {

    /**
     * createThread
     *
     * @param runnable
     * @return
     */
    Thread createThread(Runnable runnable);


}
