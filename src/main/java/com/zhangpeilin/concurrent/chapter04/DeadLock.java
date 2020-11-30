package com.zhangpeilin.concurrent.chapter04;

/**
 * @author ZhangPeiL1n
 * @date 2020/9/13 22:01
 * @Description
 **/
public class DeadLock {
    private final Object MUTEX_READ = new Object();
    private final Object MUTEX_WRITE = new Object();

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(() -> {
            while (true) {
                deadLock.read();
            }
        }, "READ-THREAD").start();
        new Thread(() -> {
            while (true) {
                deadLock.write();
            }
        }, "WRITE-THREAD").start();
    }

    public void read() {
        synchronized (MUTEX_READ) {
            System.out.println(Thread.currentThread().getName() + " get READ lock");
            synchronized (MUTEX_WRITE) {
                System.out.println(Thread.currentThread().getName() + " get WRITE lock");
            }
            System.out.println(Thread.currentThread().getName() + " release WRITE lock");
        }
        System.out.println(Thread.currentThread().getName() + " release READ lock");
    }

    public void write() {
        synchronized (MUTEX_WRITE) {
            System.out.println(Thread.currentThread().getName() + " get WRITE lock");
            synchronized (MUTEX_READ) {
                System.out.println(Thread.currentThread().getName() + " get READ lock");
            }
            System.out.println(Thread.currentThread().getName() + " release READ lock");
        }
        System.out.println(Thread.currentThread().getName() + " release WRITE lock");
    }
}
