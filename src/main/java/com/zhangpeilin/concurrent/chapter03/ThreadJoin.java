package com.zhangpeilin.concurrent.chapter03;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @author ZhangPeiL1n
 * @date 2020/8/20 16:23
 * @Description
 **/
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        //定义两个线程放在 threads 中
        List<Thread> threads = IntStream.range(1, 3).mapToObj(ThreadJoin::create).collect(toList());
        //启动两个线程
        threads.forEach(Thread::start);
        //执行两个线程的 join
        for (Thread thread : threads) {
            thread.join();
        }
        //main 线程的循环输出
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "#" + i);
            shortSleep();
        }
    }

    public static Thread create(int seq) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "#" + i);
                shortSleep();
            }
        });
    }

    public static void shortSleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
