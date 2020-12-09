package com.zhangpeilin.concurrent.chapter08;

/**
 * @author ZhangPeiL1n
 * @date 2020/11/18 22:35
 * @description 任务队列接口
 **/
public interface RunnableQueue {
    /**
     * 新任务提交时首先进入队列
     *
     * @param runnable 被提交的任务
     */
    void offer(Runnable runnable);

    /**
     * 从队列中取出任务
     *
     * @return 任务
     */
    Runnable take() throws InterruptedException;

    /**
     * 队列中任务的数量
     *
     * @return 任务数量
     */
    int size();
}
