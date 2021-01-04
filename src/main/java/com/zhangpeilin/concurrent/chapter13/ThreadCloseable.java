package com.zhangpeilin.concurrent.chapter13;

/**
 * @author 张沛霖
 * @date 2020/12/28
 */
public class ThreadCloseable extends Thread {
    private volatile boolean started = true;


    @Override
    public void run() {
        while (started){
        //    do work
        }
    }

    public void shutdown(){
        this.started = false;
    }
}
