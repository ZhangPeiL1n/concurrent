package com.zhangpeilin.concurrent.chapter02;

/**
 * @Author: ZhangPeiL1n
 * @Date: 2020/8/13 16:44
 * @Description:
 **/
public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        //main 线程开始
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // thread.setDaemon(true);
        thread.start();
        Thread.sleep(2_000L);
        System.out.println("Main thread finished lifecycle");
        //    main线程结束
    }
}
