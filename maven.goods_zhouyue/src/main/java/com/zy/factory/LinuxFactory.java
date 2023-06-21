package com.zy.factory;

import com.zy.dao.IDao;
import com.zy.dao.OrderDao;

import java.sql.*;
import java.time.LocalDate;

public class LinuxFactory implements JdbcFactory{

    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rs = null;

    @Override
    public boolean connect(String host,String userName,String userPasswd,String database) throws SQLException {

        String driverName = "com.mysql.cj.jdbc.Driver";

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
                    // 接受整型格式
                    if (update_data instanceof Integer)
                    {
                        pstm.setInt(i++, (Integer) update_data);
                    }
                    if (update_data instanceof Float)
                    {
                        pstm.setFloat(i++, (float) update_data);
                    }
                    // 接受日期格式
                    else if(update_data instanceof LocalDate){
                        LocalDate localDate = (LocalDate) update_data;
                        java.sql.Date date_sql = java.sql.Date.valueOf(localDate.toString());
                        pstm.setDate(i++, date_sql);
                    }
                    // 字符串格式
                    else if (update_data instanceof String){
                        pstm.setString(i++, (String) update_data);
                    }
                }
                try {
                    row = pstm.executeUpdate();
                }
                catch (SQLException e){
                    System.out.println("语句操作失败...");
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
                    System.out.println("序号" + "\t"+ "类别" + "\t" + " 商品" + "\t\t" + "价格" + "   " +"数量"+ "\t" + "售出时间");
                    while (rs.next()) {
                        String goods_id = rs.getString("id");
                        String type = rs.getString("type");
                        String name = rs.getString("name");
                        float price = rs.getFloat("price");

                        int num = rs.getInt("num");
                        Date sell_time = rs.getDate("sell_time");

                        System.out.println(goods_id + "\t\t" + type + "\t" + name + "\t\t" + price + "\t" + num + " \t" + sell_time);
                    }
                }
                else {
                    System.out.println("无该条订单信息...");
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

    // 方法重载
    public int executeQuery(String query,String id) throws SQLException {

        int count = 0; // 统计通过ID搜索到的数据数量

        if (conn != null){
            try {
                pstm = conn.prepareStatement(query);
                pstm.setString(1,id);
                ResultSet rs = pstm.executeQuery();
                if (!rs.next()){
                    System.out.println("数据库中无该订单信息...");
                }
                else {
                    System.out.println("序号" + "\t"+ "类别" + "\t" + " 商品" + "\t\t" + "价格" + "   " +"数量"+ "\t" + "进货时间");

                    String goods_id = rs.getString("id");
                    String type = rs.getString("type");
                    String name = rs.getString("name");
                    float price = rs.getFloat("price");

                    int num = rs.getInt("num");
                    Date sell_time = rs.getDate("sell_time");

                    System.out.println(goods_id + "\t\t" + type + "\t" + name + "\t" + price + "\t" + num + "  \t" + sell_time);
                    count++;

                }
            }
            catch (SQLException e){
                System.out.println("查找数据失败~");
            }
            finally {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
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
        return new OrderDao();
    }
}
