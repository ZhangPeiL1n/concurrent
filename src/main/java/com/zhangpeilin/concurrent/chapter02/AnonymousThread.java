package com.zhangpeilin.concurrent.chapter02;

import java.util.stream.IntStream;

/**
 * @Author: ZhangPeiL1n
 * @Date: 2020/8/3 22:19
 * @Description: 未主动命名的线程，使用 “Thread-” + 自增数字 的命名方式
 **/
public class AnonymousThread {
    public static void main(String[] args) {
        IntStream.range(0, 5).boxed().map(i -> new Thread(
                () -> System.out.println(Thread.currentThread().getName())
        )).forEach(Thread::start);
    }
}
