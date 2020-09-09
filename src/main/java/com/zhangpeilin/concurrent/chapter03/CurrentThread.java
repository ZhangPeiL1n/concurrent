package com.zhangpeilin.concurrent.chapter03;

/**
 * @author ZhangPeiL1n
 * @date 2020/8/18 15:25
 * @Description
 **/
public class CurrentThread {
    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() == this);
            }
        };
        thread.start();

        String name = Thread.currentThread().getName();
        System.out.println("main".equals(name));

    }
}
