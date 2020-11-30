package com.zhangpeilin.concurrent.chapter06;

/**
 * @author ZhangPeiL1n
 * @date 2020/10/29 23:06
 * @Description
 **/
public class ThreadGroupDestroy {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("TestGroup");

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.printf("group.isDestroyed = %s%n", group.isDestroyed());
        mainGroup.list();

        group.destroy();

        System.out.printf("group.isDestroyed = %s%n", group.isDestroyed());
        mainGroup.list();
    }
}
