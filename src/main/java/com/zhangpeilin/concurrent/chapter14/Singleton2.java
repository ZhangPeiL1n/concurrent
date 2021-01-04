package com.zhangpeilin.concurrent.chapter14;

/**
 * 懒汉式
 * @author 张沛霖
 * @date 2020/12/29
 *
 */
public final class Singleton2 {
    //实例变量
    private byte[] data = new byte[1024];

    private static Singleton2 instance = null;

    private Singleton2(){}

    public static Singleton2 getInstance(){
        if (null == instance){
            instance = new Singleton2();
        }
        return instance;
    }
}
