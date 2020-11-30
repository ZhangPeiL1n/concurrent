package com.zhangpeilin.concurrent.chapter06;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhangPeiL1n
 * @date 2020/10/28 23:03
 * @Description
 **/
public class ThreadGroupBasic {
    public static void main(String[] args) throws InterruptedException {
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

        TimeUnit.MILLISECONDS.sleep(1);

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.printf("activeCount = %s%n", mainGroup.activeCount());
        System.out.printf("activeGroupCount = %s%n", mainGroup.activeGroupCount());
        System.out.printf("getMaxPriority = %s%n", mainGroup.getMaxPriority());
        System.out.printf("getName = %s%n", mainGroup.getName());
        System.out.printf("getParent = %s%n", mainGroup.getParent());
        mainGroup.list();
        System.out.println("===========================================");
        System.out.printf("parentOf = %s%n", mainGroup.parentOf(group));
        System.out.printf("parentOf = %s%n", mainGroup.parentOf(mainGroup));
    }
}
