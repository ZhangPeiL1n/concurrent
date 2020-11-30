package com.zhangpeilin.concurrent.chapter05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;


/**
 * @author ZhangPeiL1n
 * @date 2020/9/16 22:23
 * @Description
 **/
public class BooleanLock implements Lock {
    private final List<Thread> blockedList = new ArrayList<>();
    private Thread currentThread;
    private boolean locked = false;

    @Override
    public void lock() throws InterruptedException {
        //使用同步代码块进行tongue
        synchronized (this) {
            //如果当前锁被某个线程获得，则该线程将加入阻塞队列，并且使当前线程 wait 释放对 this monitor 的所有权
            while (locked) {
                final Thread tempThread = Thread.currentThread();
                try {
                    if (!blockedList.contains(tempThread)) {
                        blockedList.add(Thread.currentThread());
                    }
                    this.wait();
                    //    当前线程在等待时被中断，则等待列表中删除当前线程
                } catch (InterruptedException e) {
                    blockedList.remove(tempThread);
                    throw e;
                }
            }
            //如果当前锁没有被其他线程获得，则该线程将尝试从阻塞队列中删除自己
            //如果当前线程从未进入过阻塞队列，删除方法不会有任何影响
            //如果当前线程是从 wait set 中被唤醒的，则需要从阻塞队列中将自己删除
            blockedList.remove(Thread.currentThread());
            //locked 开关被指定为 true
            this.locked = true;
            //记录获取锁的线程
            this.currentThread = Thread.currentThread();
        }
    }

    /**
     * 带有超时功能的 lock
     *
     * @param mills 超时时长
     * @throws InterruptedException
     * @throws TimeoutException
     */
    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this) {
            //如果时间不合法，即小于等于0，则调用不会超时的锁
            //也可以抛出参数非法已采样
            if (mills <= 0) {
                this.lock();
            } else {
                //剩余时间
                long remainingMills = mills;
                //计算结束时间，原文这里写的是 + remainingMills，我（zpl）认为这里写 mills 更容易理解
                //要表明的意思就是，mills 这么长的时间内我获取不到锁，我就抛出异常
                long endMills = System.currentTimeMillis() + mills;
                while (locked) {
                    //剩余时间小于0，超时
                    if (remainingMills <= 0) {
                        //这有个问题，如果这里抛异常然后退出了，blockedList 里应该还有这个线程吧，就是下面这段加进去的
                        throw new TimeoutException("can not get the lock during " + mills);
                    }
                    if (!blockedList.contains(Thread.currentThread())) {
                        blockedList.add(Thread.currentThread());
                    }
                    //这里直接让 thread 等待 remaining 的时长
                    this.wait(remainingMills);
                    //计算剩余时间，即到期时间减去当前时间，要是为负数则说明当前时间已经过了到期时间，已经超时
                    remainingMills = endMills - System.currentTimeMillis();
                }
                //能走到这说明在 remainingMills 的时间里获得了锁，因为 locked 变成了false
                //从 block 列表中删除当前线程
                blockedList.remove(Thread.currentThread());
                this.locked = true;
                this.currentThread = Thread.currentThread();
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (this) {
            //谁加锁谁释放
            if (currentThread == Thread.currentThread()) {
                //修改加锁标识
                this.locked = false;
                Optional.of(Thread.currentThread().getName() + " release the lock.").ifPresent(System.out::println);
                //唤醒所有线程
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}
