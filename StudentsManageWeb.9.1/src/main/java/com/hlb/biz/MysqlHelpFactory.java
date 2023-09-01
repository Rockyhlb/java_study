package com.hlb.biz;

import com.hlb.dao.IDao;
import com.hlb.dao.StudentsDao;

import java.sql.*;

public class MysqlHelpFactory implements JdbcFactory{

    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    @Override
    public boolean connect(String host,String userName,String userPasswd,String database) throws SQLException {
        // 默认这么写 -- 驱动名称
        String driverName = "com.mysql.cj.jdbc.Driver";

        // 本地连接  用来确定连接的数据库信息
        String dbURL="jdbc:mysql://" + host + ":3306/" + database + "?&useSSL=false&serverTimezone=Asia/Shanghai";

        try {
            // 1、连接驱动类 -- 通过反射技术，将JDBC驱动程序引入项目进程内存
            Class.forName(driverName);
            // 2、获取连接  --  通过JDBC驱动程序引入连接对象
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
                    // 接受整型格式
                    if (update_data instanceof Integer)
                    {
                        pstm.setInt(i++, (Integer) update_data);
                    }
                    // 接受日期格式
                    else if(update_data instanceof java.util.Date){
                        Date date_sql = new Date(((java.util.Date) update_data).getTime());
                        pstm.setDate(i++, date_sql);
                    }
                    // 字符串格式
                    else {
                        pstm.setString(i++, (String) update_data);
                    }
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
        finally {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (conn != null) conn.close();
        }
        return row;
    }

    public void executeQuery(String query) throws SQLException {
        if (conn != null){
            try {
                pstm = conn.prepareStatement(query);
                ResultSet rs = pstm.executeQuery(query);
                if(rs!=null){
                    System.out.println("学号" + "\t"+ " 姓名" + "\t" + "  性别" + "\t" + "年龄" + "\t" +"入校时间"+ "\t\t" + "   邮箱" + "\t");
                    while (rs.next()) {
                        String id = rs.getString("id");
                        String name = rs.getString("name");
                        String sex = rs.getString("sex");
                        int age = rs.getInt("age");
                        // 此处getDate 和 getTime 返回不同的日期格式
                        Date enter_time = rs.getDate("enter_time");
                        String email = rs.getString("email");

                        System.out.println(id + "\t\t" + name + "\t   " + sex + " \t " + age + "\t\t" + enter_time + "\t  " + email);
                    }
                }
                else {
                    System.out.println("数据库中无该学生信息...");
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

    // 方法重载，用于修改模块通过ID验证数据库当中是否有该条数据
    public int executeQuery(String query,String id) throws SQLException {

        int count = 0; // 统计通过ID搜索到的数据数量

        if (conn != null){
            try {
                pstm = conn.prepareStatement(query);
                pstm.setString(1,id);
                ResultSet rs = pstm.executeQuery();
                if (!rs.next()){
                    System.out.println("数据库中无该学生信息...");
                }
                else {

                    System.out.println("学号" + "\t"+ " 姓名" + "\t" + "  性别" + "\t" + "年龄" + "\t" +"入校时间"+ "\t\t" + "   邮箱" + "\t");

                    // 表当中id为主键，所以通过id检索到的结果集只能是一个，此处不需要rs.next()
//                    while (rs.next()) {
                        String select_id = rs.getString("id");
                        String name = rs.getString("name");
                        String sex = rs.getString("sex");
                        int age = rs.getInt("age");
                        // 此处getDate 和 getTime 返回不同的日期格式
                        Date enter_time = rs.getDate("enter_time");
                        String email = rs.getString("email");

                        System.out.println(select_id
                                + "\t\t" + name + "\t   " + sex + " \t " + age + "\t\t" + enter_time + "\t  " + email);
                        count++;
//                    }
                }
            }
            catch (SQLException e){
                System.out.println("查找数据失败~");
            }
            finally {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                // bug -- 如果此处断开连接，则StudentsDao更改方法模块中调用这个方法以后就不能调用excuteUpdate方法了
//                if (conn != null) conn.close();
            }
        }
        return count;
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
        return new StudentsDao();
    }
}
