package com.zhangpeilin.concurrent.chapter03;

/**
 * @author ZhangPeiL1n
 * @date 2020/8/17 23:24
 * @Description
 **/
public class ThreadPriority {
    // public static void main(String[] args) {
    //     Thread t1 = new Thread(() -> {
    //         while(true){
    //             System.out.println("t1");
    //         }
    //     });
    //     t1.setPriority(3);
    //
    //     Thread t2 = new Thread(() -> {
    //         while(true){
    //             System.out.println("t2");
    //         }
    //     });
    //     t2.setPriority(10);
    //     t1.start();
    //     t2.start();
    // }

    public static void main(String[] args) {
        //定义一个线程组
        ThreadGroup group = new ThreadGroup("test");
        //将线程组的优先级指定为7
        group.setMaxPriority(7);
        //定义一个线程，将其加入到 group 中
        Thread thread = new Thread(group, "test-Thread");
        //试图将线程优先级设定为 10
        thread.setPriority(10);
        //设置失败
        System.out.println(thread.getPriority());
    }
}
