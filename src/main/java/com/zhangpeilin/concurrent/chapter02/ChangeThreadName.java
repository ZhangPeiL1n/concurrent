package com.zhangpeilin.concurrent.chapter02;

import java.util.concurrent.TimeUnit;

/**
 * @Author: ZhangPeiL1n
 * @Date: 2020/8/3 23:06
 * @Description:判断一下线程在运行时是否可以改变名称
 **/
public class ChangeThreadName {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        int i = 0;
        while (true) {
            TimeUnit.SECONDS.sleep(1);
            thread.setName("new Name" + i);
            i++;
        }

    }
}
