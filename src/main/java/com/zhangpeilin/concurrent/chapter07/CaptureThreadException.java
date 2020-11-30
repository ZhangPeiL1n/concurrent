package com.zhangpeilin.concurrent.chapter07;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhangPeiL1n
 * @date 2020/11/9 23:00
 * @Description
 **/
public class CaptureThreadException {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.out.println(thread.getName() + " occur exception.");
            throwable.printStackTrace();
        });

        //这为什么要用 final ？
        final Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //这里将抛出异常
            System.out.println(1 / 0);
        }, "Test-Thread");

        thread.start();
    }
}
