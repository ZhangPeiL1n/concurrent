package com.zhangpeilin.concurrent.chapter01;

import java.sql.ResultSet;

/**
 * @Author: ZhangPeiL1n
 * @Date: 2020/8/3 21:15
 * @Description:
 **/
public interface RowHandler<T> {
    /**
     * @param resultSet
     * @return
     */
    T handle(ResultSet resultSet);
}
