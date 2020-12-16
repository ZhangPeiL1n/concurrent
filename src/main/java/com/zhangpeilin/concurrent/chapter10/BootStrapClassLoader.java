package com.zhangpeilin.concurrent.chapter10;

/**
 * @author 张沛霖
 * @date 2020/12/16
 */
public class BootStrapClassLoader {
    public static void main(String[] args) {
        System.out.println("Bootstrap:" + String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
