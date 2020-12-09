package com.zhangpeilin.concurrent.chapter08;

/**
 * @author ZhangPeiL1n
 * @date 2020/11/18 22:38
 * @description 拒绝策略
 **/
public interface DenyPolicy {

    /**
     * 任务的拒绝逻辑
     *
     * @param runnable   任务
     * @param threadPool
     */
    void reject(Runnable runnable, ThreadPool threadPool);

    /**
     * 该策略会直接将任务丢弃
     */
    class DiscardDenyPolicy implements DenyPolicy {
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {

        }
    }

    /**
     * 该拒绝策略会抛出异常
     */
    class AbortDenyPolicy implements DenyPolicy {
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) throws RunnableDenyException {
            throw new RunnableDenyException("The Runnable " + runnable + " will be abort.");
        }
    }

    /**
     * 该拒绝策略会使用提交者所在的线程去执行任务
     */
    class RunnerDenyPolicy implements DenyPolicy {
        @Override
        public void reject(Runnable runnable, ThreadPool threadPool) {
            if (!threadPool.isShutdown()) {
                runnable.run();
            }
        }
    }
}
