package com.zhangpeilin.concurrent.chapter05;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author ZhangPeiL1n
 * @date 2020/10/22 22:51
 * @Description
 **/
public class BooleanLockTest {
    private final Lock lock = new BooleanLock();

    public static void main(String[] args) throws InterruptedException {
        BooleanLockTest booleanLockTest = new BooleanLockTest();

        // //多线程通过 lock()方法争抢锁
        // IntStream.range(0,10).mapToObj(i ->new Thread(booleanLockTest::syncMethod)).forEach(Thread::start);

        // //可中断示例
        // new Thread(booleanLockTest::syncMethod,"t1").start();
        // TimeUnit.MILLISECONDS.sleep(2);
        // Thread t2 = new Thread(booleanLockTest::syncMethod, "t2");
        // t2.start();
        // TimeUnit.MILLISECONDS.sleep(10);
        // t2.interrupt();
        // booleanLockTest.print();

        new Thread(booleanLockTest::syncMethodTimeoutable, "T1").start();
        TimeUnit.MILLISECONDS.sleep(2);
        Thread t2 = new Thread(booleanLockTest::syncMethodTimeoutable, "T2");
        t2.start();
        TimeUnit.MILLISECONDS.sleep(10);
    }

    public void syncMethod() {
        try {
            lock.lock();
            int randomInt = ThreadLocalRandom.current().nextInt(10);
            System.out.println(Thread.currentThread() + " get the lock.");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void print() {
        System.out.println(lock.getBlockedThreads());
    }

    public void syncMethodTimeoutable() {
        try {
            lock.lock(1000);
            System.out.println(Thread.currentThread() + " get the lock.");
            int randomInt = ThreadLocalRandom.current().nextInt(10);
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
