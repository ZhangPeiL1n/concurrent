package com.zhangpeilin.concurrent.chapter13;

import java.util.concurrent.CountDownLatch;

/**
 * @author 张沛霖
 * @date 2020/12/28
 */
public class VolatileTest {
    private static volatile int i = 0;
    private static final CountDownLatch latch = new CountDownLatch(10);

    private static void inc(){
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0;i < 10; i++){
            new Thread(()->{
                for (int x = 0; x < 1000; x++){
                    inc();
                }
                latch.countDown();
            }).start();
        }
        latch.await();
        System.out.println(i);
    }
}
