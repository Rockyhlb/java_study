package com.hlb.factory;

import com.hlb.dao.IDao;
import com.hlb.dao.ScoresDao;
import com.hlb.entity.Students_Inf;

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
                Students_Inf students_inf = new Students_Inf();

                /*
                Arrays.stream()将该数组转换为一个流。然后，我们使用map()操作将每个对象转换为其字符串表示形式，
                即调用Object.toString()方法。最后，我们使用toArray()将流转换为String数组。Arrays.stream()将该数组转换为一个流。
                然后，我们使用map()操作将每个对象转换为其字符串表示形式，即调用Object.toString()方法。
                最后，我们使用toArray()将流转换为String数组。
                * */
//                String[] stringArray = Arrays.stream(objects)
//                        .map(Object::toString)
//                        .toArray(String[]::new);

                int i = 1;
                for (Object update_data:objects)
                {
                    if (update_data instanceof Integer)
                    {
                        pstm.setInt(i, (Integer) update_data);
                    }
                    else if(update_data instanceof java.util.Date){
                        java.util.Date date = (java.util.Date) update_data;
                        Date date_sql = new Date(date.getTime());
                        pstm.setDate(5, date_sql);
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
