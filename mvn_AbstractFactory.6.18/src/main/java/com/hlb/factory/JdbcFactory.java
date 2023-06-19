package com.hlb.factory;

import com.hlb.dao.IDao;

import java.sql.SQLException;

public interface JdbcFactory {

    // 连接驱动和数据库
    boolean connect(String host, String userName, String userPasswd, String database) throws SQLException;

    // 执行sql
    public int executeUpdate(String update, Object[] args) throws SQLException;
    void executeQuery(String query) throws SQLException;
    // 断开连接
    boolean disconnect();

    // 创建不同类型的数据库对象
    IDao createDateBase();
}
