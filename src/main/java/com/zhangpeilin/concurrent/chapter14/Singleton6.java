package com.zhangpeilin.concurrent.chapter14;

/**
 * @author 张沛霖
 * @date 2021/1/4
 */
public class Singleton6 {
    private byte[] data = new byte[1024];

    private Singleton6(){}

    private static class Holder{
        private static Singleton6 instance = new Singleton6();
    }

    public static  Singleton6 getInstance(){
        return Holder.instance;
    }
}
