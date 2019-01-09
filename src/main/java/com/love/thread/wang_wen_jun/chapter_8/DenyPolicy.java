package com.love.thread.wang_wen_jun.chapter_8;

/**
 * Created by ls on 2018/11/29.
 */
@FunctionalInterface
public interface DenyPolicy {

    void reject(Runnable runnable, ThreadPool threadPool);

    /**
     * 直接将任务丢弃
     */
    class DiscardDenyPolicy implements DenyPolicy {
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            // do nothing
        }
    }


    // 该拒绝策略会向提交者抛出异常
    class AbortDenyPolicy implements DenyPolicy {
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            throw new RunnableDenyException("The runnable " + runnable + "will be abort ...");
        }
    }

    /**
     * 使任务在提交者所在的线程中执行任务
     */
    class RunnerDenyPolicy implements DenyPolicy {
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if (!threadPool.isShutdown())
                runnable.run();
        }
    }


}
