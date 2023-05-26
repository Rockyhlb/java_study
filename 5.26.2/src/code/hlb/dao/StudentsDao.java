package code.hlb.dao;

import java.sql.*;

public class StudentsDao implements IDao {

    @Override
    public void add() {
        //不用动，默认就是这么写的  --  后面连接驱动要用
        String driverName = "com.mysql.cj.jdbc.Driver";

        // 本地连接  用来确定连接的数据库信息
        String dbURL="jdbc:mysql://localhost:3306/bigdata?&useSSL=false&serverTimezone=Asia/Shanghai";
        // 数据库账号
        String userName = "root";
        // 数据库密码
        String userPwd = "000000";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // 1、连接驱动类
            Class.forName(driverName);
            // 2、获取连接
            conn = DriverManager.getConnection(dbURL,userName,userPwd);
            System.out.println(conn);
            // 3、准备发送Sql的准备语句
            String sql = "insert into student values(id,name,age);";
            pstm = conn.prepareStatement(sql);
            // 4、发送执行sql语句
            int update = pstm.executeUpdate();
            System.out.println( update );
            // 5、如果是查询语句，需要结果处理集  resultSet
            // 6、关闭资源
            pstm.close();
            conn.close();
            System.out.println("已经完成使用Mysql的增加操作");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(pstm != null) pstm.close();
                if(conn != null) conn.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(){
        System.out.println("正在使用Mysql的删除操作");
    }

    @Override
    public void select(){

    }

    @Override
    public void update(){

    }
}
