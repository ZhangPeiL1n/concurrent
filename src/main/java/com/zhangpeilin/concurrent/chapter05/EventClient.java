package com.zhangpeilin.concurrent.chapter05;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhangPeiL1n
 * @date 2020/9/14 21:42
 * @Description
 **/
public class EventClient {
    public static void main(String[] args) {
        final EventQueue eventQueue = new EventQueue();

        new Thread(() -> {
            for (; ; ) {
                //提交任务
                eventQueue.offer(new EventQueue.Event());
            }
        }, "Producer").start();

        new Thread(() -> {
            for (; ; ) {
                //取出任务
                eventQueue.take();
                try {
                    //模拟任务处理耗时
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer").start();

    }
}
