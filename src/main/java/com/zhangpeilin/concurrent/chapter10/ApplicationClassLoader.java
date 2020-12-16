package com.zhangpeilin.concurrent.chapter10;

/**
 * @author 张沛霖
 * @date 2020/12/16
 */
public class ApplicationClassLoader {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ApplicationClassLoader.class.getClassLoader());
    }
}
