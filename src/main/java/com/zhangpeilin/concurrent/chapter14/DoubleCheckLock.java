package com.zhangpeilin.concurrent.chapter14;

import java.net.Socket;
import java.sql.Connection;

/**
 * @author 张沛霖
 * @date 2020/12/29
 *
 * final 不允许被继承
 */
public final class DoubleCheckLock {
    // 实例变量
    private byte[] data = new byte[1024];
    private static DoubleCheckLock instance = null;
    Connection connection;
    Socket socket;
    private DoubleCheckLock(){
        //初始化操作
        // this.connection;
        // this.socket;
    }

    public static DoubleCheckLock getInstance(){
        //第一次 check，instance 为 null，进入同步代码块，且该判断避免每次都进入同步代码块，提升效率
        if (null == instance){
            //只有一个线程能够获得 DoubleCheckLock.class 的 monitor
            synchronized (DoubleCheckLock.class){
                //第二次 check，避免 instance 重复创建
                if (null == instance){
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }
}
