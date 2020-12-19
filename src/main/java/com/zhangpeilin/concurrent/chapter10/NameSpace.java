package com.zhangpeilin.concurrent.chapter10;

/**
 * @author 张沛霖
 * @date 2020/12/17
 */
public class NameSpace {
    public static void main(String[] args) throws ClassNotFoundException {
        // ClassLoader classLoader = NameSpace.class.getClassLoader();
        // Class<?> aClass = classLoader.loadClass("com.zhangpeilin.concurrent.chapter10.Test");
        // Class<?> bClass = classLoader.loadClass("com.zhangpeilin.concurrent.chapter10.Test");
        //
        // System.out.println(aClass.hashCode());
        // System.out.println(bClass.hashCode());
        // System.out.println(aClass == bClass);

        MyClassLoader classLoader1 = new MyClassLoader();
        BreakDelegateClassLoader classLoader2 = new BreakDelegateClassLoader();
        Class<?> aClass = classLoader1.loadClass("com.zhangpeilin.concurrent.chapter10.Test");
        Class<?> bClass = classLoader2.loadClass("com.zhangpeilin.concurrent.chapter10.Test");
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
        System.out.println(aClass == bClass);
    }
}
