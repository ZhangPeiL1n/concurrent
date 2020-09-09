package com.zhangpeilin.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * @author ZhangPeiL1n
 * @date 2020/9/9 22:15
 * @Description
 **/
public class FlagThreadExit {
    public static void main(String[] args) throws InterruptedException {
        MyTask t = new MyTask();
        t.start();
        TimeUnit.MINUTES.sleep(1);
        System.out.println("System will be shutdown");
        t.close();
    }

    static class MyTask extends Thread {
        private volatile boolean closed = false;

        @Override
        public void run() {
            System.out.println("I will start work");
            while (!closed && !isInterrupted()) {

            }
            System.out.println("I will be exiting.");
        }

        public void close() {
            this.closed = true;
            this.interrupt();
        }
    }
}
