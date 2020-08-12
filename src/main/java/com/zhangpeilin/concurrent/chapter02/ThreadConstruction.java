package com.zhangpeilin.concurrent.chapter02;

import java.util.stream.IntStream;

/**
 * @Author: ZhangPeiL1n
 * @Date: 2020/8/3 22:22
 * @Description:
 **/
public class ThreadConstruction {
    private final static String PREFIX = "ALEX-";

    public static void main(String[] args) {
        IntStream.range(0, 5).mapToObj(ThreadConstruction::createThread).forEach(Thread::start);
    }

    private static Thread createThread(final int intName) {
        return new Thread(
                () -> System.out.println(Thread.currentThread().getName()), PREFIX + intName
        );
    }
}
