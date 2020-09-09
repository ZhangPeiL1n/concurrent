package com.zhangpeilin.concurrent.chapter01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ZhangPeiL1n
 * @date 2020/8/3 21:16
 * @Description
 **/
public class RecordQuery {
    private final Connection connection;

    public RecordQuery(Connection connection) {
        this.connection = connection;
    }

    public <T> T query(RowHandler<T> handler, String sql, Object... params) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            int index = 1;
            for (Object param : params) {
                statement.setObject(index++, param);
            }

            ResultSet resultSet = statement.executeQuery();
            //调用 RowHandler
            return handler.handle(resultSet);
        }
    }
}
