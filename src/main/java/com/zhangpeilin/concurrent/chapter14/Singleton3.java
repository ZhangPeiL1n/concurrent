package com.zhangpeilin.concurrent.chapter14;

/**
 * @author 张沛霖
 * @date 2020/12/29
 */
public final class Singleton3 {
    //实例变量
    private byte[] data = new byte[1024];

    private static Singleton3 instance = null;

    private Singleton3(){}

    public static synchronized Singleton3 getInstance(){
        if (null == instance){
            instance = new Singleton3();
        }
        return instance;
    }
}
