package com.zhangpeilin.concurrent.chapter05;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhangPeiL1n
 * @date 2020/9/16 21:38
 * @Description
 **/
public class SynchronizedDefect {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedDefect defect = new SynchronizedDefect();
        Thread t1 = new Thread(defect::syncMethod, "T1");
        t1.start();
        TimeUnit.MILLISECONDS.sleep(2);

        Thread t2 = new Thread(defect::syncMethod, "T2");
        t2.start();

        TimeUnit.MILLISECONDS.sleep(2);
        t2.interrupt();
        //true
        System.out.println(t2.isInterrupted());
        //BLOCKED
        System.out.println(t2.getState());
    }

    /**
     * synchronized 方法的缺点，无法超时，无法被中断
     */
    public synchronized void syncMethod() {
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
