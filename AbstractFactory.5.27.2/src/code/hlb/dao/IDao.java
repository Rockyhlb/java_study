package code.hlb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDao {
    // 连接驱动和数据库
    boolean connect() throws SQLException;
    // 执行sql
    ResultSet executeQuery(String query) throws SQLException;
    int executeUpdate(String update) throws SQLException;
    // 断开连接
    boolean disconnect();
}
