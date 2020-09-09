package com.zhangpeilin.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhangPeiL1n
 * @date 2020/9/9 22:06
 * @Description
 **/
public class InterruptThreadExit {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("I will start work");
                while (!isInterrupted()) {
                    //    working
                }
                System.out.println("I will be exiting.");
            }
        };

        t.start();
        TimeUnit.MINUTES.sleep(1);
        System.out.println("System will be shutdown.");
        t.interrupt();

        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("I will start work");
                for (; ; ) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
                System.out.println("I will be exiting.");
            }
        };


    }
}
