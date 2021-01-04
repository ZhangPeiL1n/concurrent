package com.zhangpeilin.concurrent.chapter14;

/**
 * 饿汉式
 *
 * @author 张沛霖
 * @date 2020/12/28
 *
 * final 不允许类被继承
 */
public final class Singleton1 {
    /**
     * 实例变量
     */
    private byte[] data = new byte[1024];

    /**
     * 在定义实例对象的时候直接初始化
     */
    private static Singleton1 instance = new Singleton1();

    /**
     * 私有构造函数，不允许外部 new
     */
    private Singleton1(){}

    public static Singleton1 getInstance(){
        return instance;
    }
}
