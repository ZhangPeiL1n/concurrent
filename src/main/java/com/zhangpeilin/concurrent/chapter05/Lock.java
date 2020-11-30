package com.zhangpeilin.concurrent.chapter05;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @author ZhangPeiL1n
 * @date 2020/9/16 22:16
 * @description
 **/
public interface Lock {
    /**
     * 永远阻塞，除非获取到了锁
     * 可被中断
     *
     * @throws InterruptedException
     */
    void lock() throws InterruptedException;

    /**
     * 可被中断，可超时
     *
     * @param mills 超时时长
     * @throws InterruptedException
     * @throws TimeoutException
     */
    void lock(long mills) throws InterruptedException, TimeoutException;

    /**
     * 释放锁
     */
    void unlock();

    /**
     * 获取被阻塞的线程
     *
     * @return
     */
    List<Thread> getBlockedThreads();
}
