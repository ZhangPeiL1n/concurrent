package com.zhangpeilin.concurrent.chapter08;

/**
 * @author ZhangPeiL1n
 * @date 2020/11/18 22:37
 * @description 线程工厂接口
 **/
public interface ThreadFactory {
    /**
     * 创建线程
     *
     * @param runnable
     * @return 创建的线程
     */
    Thread createThread(Runnable runnable);
}
