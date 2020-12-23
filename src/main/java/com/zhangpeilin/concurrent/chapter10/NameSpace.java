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

        // //不同类加载器加载同一个 class
        // MyClassLoader classLoader1 = new MyClassLoader();
        // BreakDelegateClassLoader classLoader2 = new BreakDelegateClassLoader();
        // Class<?> aClass = classLoader1.loadClass("com.zhangpeilin.concurrent.chapter10.Test");
        // Class<?> bClass = classLoader2.loadClass("com.zhangpeilin.concurrent.chapter10.Test");
        // System.out.println(aClass.hashCode());
        // System.out.println(bClass.hashCode());
        // //false
        // System.out.println(aClass == bClass);


        //相同类加载器加载同一个 class
        MyClassLoader classLoader1 = new MyClassLoader("G:\\classloader1", null);
        MyClassLoader classLoader2 = new MyClassLoader("G:\\classloader1", null);
        Class<?> aClass = classLoader1.loadClass("com.zhangpeilin.concurrent.chapter10.Test");
        Class<?> bClass = classLoader2.loadClass("com.zhangpeilin.concurrent.chapter10.Test");
        System.out.println(aClass.getClassLoader());
        System.out.println(bClass.getClassLoader());
        System.out.println(aClass.hashCode());
        System.out.println(bClass.hashCode());
        //false
        System.out.println(aClass == bClass);
    }
}
