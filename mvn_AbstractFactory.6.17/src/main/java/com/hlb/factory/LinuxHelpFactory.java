package com.hlb.factory;

import com.hlb.dao.IDao;
import com.hlb.dao.ScoresDao;
import com.hlb.entity.Students_score;

import java.sql.*;

public class LinuxHelpFactory implements JdbcFactory{

    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    @Override
    public boolean connect(String host,String userName,String userPasswd,String database) throws SQLException {
        //不用动，默认就是这么写的  --  后面连接驱动要用
        String driverName = "com.mysql.cj.jdbc.Driver";

        // 本地连接  用来确定连接的数据库信息
        String dbURL="jdbc:mysql://" + host + ":3306/" + database + "?&useSSL=false&serverTimezone=Asia/Shanghai";

        try {
            // 1、连接驱动类
            Class.forName(driverName);
            // 2、获取连接
            conn = DriverManager.getConnection(dbURL,userName,userPasswd);
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
    public int executeUpdate(String update, Object[] objects) throws SQLException {
        int row = 0;
        try {
            if (conn != null){
                pstm = conn.prepareStatement(update);

                int i = 1;
                for (Object update_data:objects)
                {
                    if (update_data instanceof Integer)
                    {
                        pstm.setInt(i, (Integer) update_data);
                    }
                    else {
                        pstm.setString(i, (String) update_data);
                    }
                    i++;
                }
                try {
                    row = pstm.executeUpdate();
                    System.out.println("sql语句操作成功...");
                }
                catch (SQLException e){
                    System.out.println("sql语句操作失败...");
                }
                finally {
                    pstm.close();
                    conn.close();
                }
            }
        }
        catch (SQLException e){
            System.out.print("操作失败..");
            e.printStackTrace();
        }
        finally {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
        return row;
    }

    @Override
    public void executeQuery(String query) throws SQLException {
        if (conn != null){
            try {
                pstm = conn.prepareStatement(query);
                ResultSet rs = pstm.executeQuery(query);
                System.out.println("学号" + "\t"+ "姓名" + "\t" + " Java" + "\t" + "C语言" + "\t" +"数据库"+ "\t" + "操作系统");
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    int Java = rs.getInt("CLanguage");
                    int CLanguage = rs.getInt("CLanguage");
                    int DataBase = rs.getInt("Database");
                    int OS = rs.getInt("OS");

                    System.out.println(id + "\t" + name + "\t" + Java + "\t " + CLanguage + "\t" + DataBase + "\t" + OS);
                }
            }
            catch (SQLException e){
                System.out.println("查找数据失败~");
            }
            finally {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            }
        }
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

    @Override
    public IDao createDateBase() {
        return new ScoresDao();
    }
}
