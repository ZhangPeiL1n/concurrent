package com.zhangpeilin.concurrent.chapter09;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author ZhangPeiL1n
 * @date 2020/12/13 17:46
 * @Description
 **/
public class ClassInit {

    // static {
    //     x = 100;
    // }
    //
    // private static int x = 10;
    //
    // static class Parent {
    //     static int value = 10;
    //
    //     static {
    //         value = 20;
    //     }
    //
    // }
    //
    // static class Child extends Parent{
    //     static int i = value;
    //
    // }
    //
    // public static void main(String[] args) {
    //     System.out.println(Child.i);
    // }


    static {
        try {
            System.out.println("The ClassInit static code block will be invoke.");
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, 5).forEach(i -> new Thread(ClassInit::new));
    }
}
