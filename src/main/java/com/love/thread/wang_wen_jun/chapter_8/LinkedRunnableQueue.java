package com.love.thread.wang_wen_jun.chapter_8;

import java.util.LinkedList;

/**
 * Created by ls on 2018/11/29.
 */
public class LinkedRunnableQueue implements RunnableQueue {

    private final int limit;

    private final DenyPolicy denyPolicy;

    private final LinkedList<Runnable> runnableList = new LinkedList<>();

    private final ThreadPool threadPool;

    public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }


    @Override
    public void offer(Runnable runnable) {

        synchronized (runnableList) {
            if (runnableList.size() >= limit) {
                // 无法容纳新的任务时执行拒绝策略
                denyPolicy.reject(runnable, threadPool);
            } else {
                // 将任务加入队列尾，并且唤醒阻塞中的线程
                runnableList.addLast(runnable);
                runnableList.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException {

        synchronized (runnableList) {

            while (runnableList.isEmpty()) {
                try {
                    runnableList.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            return runnableList.getFirst();
        }
    }

    @Override
    public int size() {

        synchronized (runnableList) {
            return runnableList.size();
        }
    }
}
