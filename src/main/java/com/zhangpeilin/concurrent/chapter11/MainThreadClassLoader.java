package com.zhangpeilin.concurrent.chapter11;

/**
 * @author 张沛霖
 * @date 2020/12/21
 */
public class MainThreadClassLoader {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
