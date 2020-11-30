package com.zhangpeilin.concurrent.chapter06;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhangPeiL1n
 * @date 2020/10/28 22:34
 * @Description
 **/
public class ThreadGroupEnumerateThreadGroups {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup myGroup1 = new ThreadGroup("MyGroup1");
        ThreadGroup myGroup2 = new ThreadGroup(myGroup1, "MyGroup2");

        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup[] threadGroups = new ThreadGroup[mainGroup.activeGroupCount()];

        int recurseSize = mainGroup.enumerate(threadGroups);
        System.out.println(recurseSize);

        recurseSize = mainGroup.enumerate(threadGroups, false);
        System.out.println(recurseSize);
    }
}
