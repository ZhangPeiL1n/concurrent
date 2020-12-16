package com.zhangpeilin.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhangPeiL1n
 * @date 2020/8/19 16:23
 * @Description
 **/
public class ThreadIsInterrupted {
    public static void main(String[] args) throws InterruptedException {
        // Thread thread = new Thread() {
        //     @Override
        //     public void run() {
        //         while(true){
        //         //    do nothing,
        //         }
        //     }
        // };
        //
        // thread.start();
        // TimeUnit.MILLISECONDS.sleep(2);
        // System.out.printf("Thread is interrupted ? %s\n",thread.isInterrupted());
        // thread.interrupt();
        // System.out.printf("Thread is interrupted ? %s\n",thread.isInterrupted());

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.printf("I am be interrupted ? %s\n", isInterrupted());
                    }
                }
            }
        };

        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
        thread.interrupt();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
    }
}
