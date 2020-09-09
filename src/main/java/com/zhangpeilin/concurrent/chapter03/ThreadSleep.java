package com.zhangpeilin.concurrent.chapter03;

/**
 * @author ZhangPeiL1n
 * @date 2020/8/17 22:06
 * @Description
 **/
public class ThreadSleep {
    public static void main(String[] args) {
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            sleep(2_000L);
            long endTime = System.currentTimeMillis();
            System.out.println(String.format("Total spend %d ms", (endTime - startTime)));
        }).start();
        long startTime = System.currentTimeMillis();
        sleep(3_000L);
        long endTime = System.currentTimeMillis();
        System.out.printf("Main Thread total spend %d ms%n", (endTime - startTime));

    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {

        }
    }
}
