package com.love.thread.wang_wen_jun.chapter_8;

/**
 * Created by ls on 2018/11/28.
 */
public interface ThreadPool {

    /**
     * submit to pool
     *
     * @param runnable param
     */
    void execute(Runnable runnable);

    /**
     *
     */
    void shutdown();

    /**
     * @return init size
     */
    int getInitSize();

    /**
     * @return max size
     */
    int getMaxSize();

    /**
     * @return core size
     */
    int getCoreSize();

    /**
     * @return waiting task's number
     */
    int getQueueSize();

    /**
     * @return alive thread number
     */
    int getActiveCount();

    boolean isShutdown();

}
