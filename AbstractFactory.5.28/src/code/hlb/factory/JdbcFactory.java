package code.hlb.factory;

import code.hlb.dao.IDao;
import code.hlb.entity.Students_Inf;

import java.sql.Connection;
import java.sql.SQLException;

public interface JdbcFactory {

    // 连接驱动和数据库
    boolean connect() throws SQLException;

    Connection getConnection() throws SQLException;
    // 执行sql
    public int executeUpdate(String update, Object[] args) throws SQLException;
    void executeQuery(String query) throws SQLException;
    // 断开连接
    boolean disconnect();

    // 创建不同类型的数据库对象
    IDao createDateBase();
}
