package com.zhangpeilin.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhangPeiL1n
 * @date 2020/8/20 15:48
 * @Description
 **/
public class ThreadToBeInterrupted {
    public static void main(String[] args) {
        System.out.printf("Main thread is interrupted ? %s\n", Thread.interrupted());

        Thread.currentThread().interrupt();

        System.out.printf("Main thread is interrupted ? %s\n", Thread.currentThread().isInterrupted());

        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            System.out.printf("I will be interrupted still.");
        }
    }
}
