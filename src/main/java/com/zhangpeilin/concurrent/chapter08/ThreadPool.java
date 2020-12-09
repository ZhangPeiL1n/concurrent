package com.zhangpeilin.concurrent.chapter08;

/**
 * @author ZhangPeiL1n
 * @date 2020/11/18 22:31
 * @description 线程池接口
 **/
public interface ThreadPool {

    /**
     * 提交任务到线程池
     *
     * @param runnable 任务
     */
    void execute(Runnable runnable);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 获取线程池的初始化大小
     *
     * @return 初始线程数
     */
    int getInitSize();

    /**
     * 获取线程池最大线程数
     *
     * @return 最大线程数
     */
    int getMaxSize();

    /**
     * 获取核心线程数
     *
     * @return 核心线程数
     */
    int getCoreSize();

    /**
     * 获取线程池缓存任务队列长度
     *
     * @return 队列长度
     */
    int getQueueSize();

    /**
     * 获取线程池活跃线程数
     *
     * @return 活跃线程数
     */
    int getActiveCount();

    /**
     * 查看线程池是否已被 shutdown
     *
     * @return 是否被关闭
     */
    boolean isShutdown();
}
