package com.zhangpeilin.concurrent.chapter06;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhangPeiL1n
 * @date 2020/10/29 22:34
 * @Description
 **/
public class ThreadGroupPriority {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("group1");
        Thread thread = new Thread(group, () -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread");
        thread.setDaemon(true);

        thread.start();

        System.out.printf("group.getMaxPriority()=%s%n", group.getMaxPriority());
        System.out.printf("thread.getPriority()=%s%n", thread.getPriority());
        group.setMaxPriority(3);
        System.out.printf("group.getMaxPriority()=%s%n", group.getMaxPriority());
        System.out.printf("thread.getPriority()=%s%n", thread.getPriority());

    }
}
