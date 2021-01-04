package com.zhangpeilin.concurrent.chapter12;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhangPeiL1n
 * @date 2020/12/21 22:27
 * @Description
 **/
public class VolatileFoo {
    /**
     * init_value 的最大值
     */
    final static int MAX = 5;
    /**
     * init_value 的初始值
     */
    // static int init_value = 0;
    static volatile int init_value = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                if (init_value != localValue) {
                    System.out.printf("The init_value is updated to [%d]\n", init_value);
                    localValue = init_value;
                }
            }
        }, "Reader").start();

        new Thread(() -> {
            int localValue = init_value;
            while (localValue < MAX) {
                System.out.printf("The init_value will be changed to [%d]\n", ++localValue);
                init_value = localValue;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Updater").start();
    }
}
