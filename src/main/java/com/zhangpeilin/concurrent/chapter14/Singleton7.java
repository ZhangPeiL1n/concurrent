package com.zhangpeilin.concurrent.chapter14;

public enum Singleton7 {
    INSTANCE;

    private byte[] data = new byte[1024];

    Singleton7(){
        System.out.println("INSTANCE will be initialized immediately");
    }

    public static void method(){

    }

    public static Singleton7 getInstance(){
        return INSTANCE;
    }
}
