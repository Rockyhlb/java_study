package code.hlb.dao;

import java.sql.*;

public class StudentsDao implements IDao {

    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    @Override
    public boolean connect() throws SQLException {
        //不用动，默认就是这么写的  --  后面连接驱动要用
        String driverName = "com.mysql.cj.jdbc.Driver";

        // 本地连接  用来确定连接的数据库信息
        String dbURL="jdbc:mysql://localhost:3306/bigdata?&useSSL=false&serverTimezone=Asia/Shanghai";
        // 数据库账号
        String userName = "root";
        // 数据库密码
        String userPwd = "000000";

        try {
            // 1、连接驱动类
            Class.forName(driverName);
            // 2、获取连接
            conn = DriverManager.getConnection(dbURL,userName,userPwd);
            return true;
        }
        catch (ClassNotFoundException | SQLException e) {
            System.out.print("连接失败--");
            e.printStackTrace();
            conn.close();
            return false;
        }
    }

    @Override
    public int executeUpdate(String update) throws SQLException {
        int flag = 0;
        try {
            if (conn != null){
                pstm = conn.prepareStatement(update);
                flag = pstm.executeUpdate();
            }
            return flag;
        }
        catch (SQLException e){
            System.out.print("操作失败 -- ");
            e.printStackTrace();
            conn.close();
        }
        return 0;
    }

    @Override
    public ResultSet executeQuery(String query) throws SQLException {
        try {
            if (conn != null){
                pstm = conn.prepareStatement(query);
                rs = pstm.executeQuery();
            }
            return rs;
        }
        catch (SQLException e){
            System.out.print("查询失败 -- ");
            e.printStackTrace();
            conn.close();
        }
        return rs;
    }

    @Override
    public boolean disconnect() {
        try {
            // 逆序关闭资源
            if(rs != null) rs.close();
            if(pstm != null) pstm.close();
            if(conn != null) conn.close();
            return true;
        }
        catch (SQLException e) {
            System.out.println("关闭资源失败~");
            e.printStackTrace();
            return false;
        }
    }
}
