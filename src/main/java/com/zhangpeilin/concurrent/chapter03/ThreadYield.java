package com.zhangpeilin.concurrent.chapter03;

import java.util.stream.IntStream;

/**
 * @author ZhangPeiL1n
 * @date 2020/8/17 23:01
 * @Description
 **/
public class ThreadYield {
    public static void main(String[] args) {
        IntStream.range(0, 2).mapToObj(ThreadYield::create).forEach(Thread::start);
    }


    private static Thread create(int index) {
        return new Thread(() -> {
            // if (index == 0){
            //     Thread.yield();
            // }
            System.out.println(index);
        });
    }
}
