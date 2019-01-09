package com.love.thread.wang_wen_jun.chapter_8;

/**
 * 任务队列主要用于缓存提交到线程池中的任务
 * <p>
 * Created by ls on 2018/11/28.
 */
public interface RunnableQueue {

    /**
     * 当有新的任务进来时首先会offer到队列中
     *
     * @param runnable param
     */
    void offer(Runnable runnable);

    /**
     * @return get Runnable
     */
    Runnable take() throws InterruptedException;

    /**
     * @return get the number of task queue
     */
    int size();

}
