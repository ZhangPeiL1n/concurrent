package com.zhangpeilin.concurrent.chapter10;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ZhangPeiL1n
 * @date 2020/12/16 22:50
 * @Description
 **/
public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //声明 classLoader
        MyClassLoader classLoader = new MyClassLoader();
        //使用 classLoader 加载类
        //zpl 重写的是 findClass 方法，loadClass 方法会调用 findClass
        Class<?> aClass = classLoader.loadClass("com.zhangpeilin.concurrent.chapter10.HelloWorld");

        System.out.println(aClass.getClassLoader());
        //1
        Object helloWorld = aClass.newInstance();
        System.out.println(helloWorld);
        Method welcomeMethod = aClass.getMethod("welcome");
        String result = (String) welcomeMethod.invoke(helloWorld);
        System.out.println("result:" + result);
    }
}
