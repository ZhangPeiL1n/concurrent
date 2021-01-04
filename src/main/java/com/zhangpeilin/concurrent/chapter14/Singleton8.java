package com.zhangpeilin.concurrent.chapter14;

/**
 * @author 张沛霖
 * @date 2021/1/4
 */
public class Singleton8 {
    private byte[] data = new byte[1024];

    private Singleton8(){

    }

    private enum EnumHolder{
        INSTANCE;
        private Singleton8 instance;

        EnumHolder(){
            this.instance = new Singleton8();
        }

        private Singleton8 getInstance(){
            return instance;
        }
    }

    public static Singleton8 getInstance(){
        return EnumHolder.INSTANCE.getInstance();
    }
}
