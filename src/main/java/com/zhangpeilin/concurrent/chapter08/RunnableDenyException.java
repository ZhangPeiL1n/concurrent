package com.zhangpeilin.concurrent.chapter08;

/**
 * @author ZhangPeiL1n
 * @date 2020/11/18 22:43
 * @Description
 **/
public class RunnableDenyException extends RuntimeException {
    public RunnableDenyException(String message) {
        super(message);
    }
}
