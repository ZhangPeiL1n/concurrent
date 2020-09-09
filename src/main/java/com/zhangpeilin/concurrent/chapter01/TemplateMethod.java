package com.zhangpeilin.concurrent.chapter01;

/**
 * @author ZhangPeiL1n
 * @date 2020/8/2 21:06
 * @Description
 **/
public class TemplateMethod {
    public static void main(String[] args) {
        TemplateMethod template1 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("*" + message + "*");
            }
        };

        template1.print("Hello Thread");

        TemplateMethod template2 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("+" + message + "+");
            }
        };
        template2.print("Hello Thread");

    }

    public final void print(String message) {
        System.out.println("###########");
        wrapPrint(message);
        System.out.println("###########");
    }

    protected void wrapPrint(String message) {

    }
}
