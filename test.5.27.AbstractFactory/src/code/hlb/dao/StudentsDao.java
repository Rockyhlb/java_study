package code.hlb.dao;

import java.sql.*;
import java.util.Scanner;

public class StudentsDao implements IDao {

    static Scanner sc;

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

        String id = null;
        String name = null;
        int age = -1;

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            sc = new Scanner(System.in);

            try {
                System.out.print("请输入添加用户的id：");
                id = sc.nextLine();
                System.out.print("请输入用户name：");
                name = sc.nextLine();
                System.out.print("请输入用户年龄：");
                age = sc.nextInt();
            }
            catch (Exception e){
                e.printStackTrace();
            }

            // 1、连接驱动类
            Class.forName(driverName);
            // 2、获取连接
            conn = DriverManager.getConnection(dbURL,userName,userPwd);
            System.out.println(conn);
            // 3、准备发送Sql的准备语句
            String sql = "insert into student values(?,?,?);";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,id);
            pstm.setString(2,name);
            pstm.setInt(3,age);
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
        String driverName = "com.mysql.cj.jdbc.Driver";
        String dbURL="jdbc:mysql://localhost:3306/bigdata?&useSSL=false&serverTimezone=Asia/Shanghai";
        String userName = "root";
        String userPwd = "000000";

        // 根据id删除数据
        String id = null;

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            sc = new Scanner(System.in);
            System.out.print("请输入删除用户的id：");
            try {
                id = sc.nextLine();
            }
            catch (Exception e){
                System.out.println("输入异常~");
            }

            // 1、连接驱动类
            Class.forName(driverName);
            // 2、获取连接
            conn = DriverManager.getConnection(dbURL,userName,userPwd);
            System.out.println(conn);
            // 3、准备发送Sql的准备语句
            String sql = "delete from student where id=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,id);
            // 4、发送执行sql语句
            int update = pstm.executeUpdate();
            if (1 == update){
                System.out.println("删除成功");
            }
            else {
                System.out.println("删除失败");
            }
            // 5、如果是查询语句，需要结果处理集  resultSet
            // 6、关闭资源
            pstm.close();
            conn.close();
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
    public void select(){
        String driverName = "com.mysql.cj.jdbc.Driver";
        String dbURL="jdbc:mysql://localhost:3306/bigdata?&useSSL=false&serverTimezone=Asia/Shanghai";
        String userName = "root";
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
            String sql = "select * from student";
            pstm = conn.prepareStatement(sql);
            // 4、执行sql，接收结果集
            ResultSet rs = pstm.executeQuery();
            // 5、如果是查询语句，需要处理处理集  resultSet
            while (rs.next()){
                String id = rs.getString("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id + "\t" + name+ "\t" + age);
            }
            // 6、关闭资源
            rs.close();
            pstm.close();
            conn.close();
            System.out.println("已经完成使用Mysql的查询操作");
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
    public void update(){
        String driverName = "com.mysql.cj.jdbc.Driver";
        String dbURL="jdbc:mysql://localhost:3306/bigdata?&useSSL=false&serverTimezone=Asia/Shanghai";
        String userName = "root";
        String userPwd = "000000";

        Connection conn = null;
        PreparedStatement pstm = null;

        // 根据id修改年纪
        String id = null;
        int age = 0;

        try {
            try {
                sc = new Scanner(System.in);
                System.out.print("请输入需要修改年纪的id:");
                id = sc.nextLine();
                System.out.print("请输入需要修改的年纪:");
                age = sc.nextInt();
            }
            catch (Exception e){
                e.printStackTrace();
            }

            // 1、连接驱动类
            Class.forName(driverName);
            // 2、获取连接
            conn = DriverManager.getConnection(dbURL,userName,userPwd);
            System.out.println(conn);
            // 3、准备发送Sql的准备语句
            String sql = "update student set age=? where id=?;";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,age);
            pstm.setString(2,id);
            // 4、发送执行sql语句
            int update = pstm.executeUpdate();
            System.out.println( update );
            // 5、如果是查询语句，需要结果处理集  resultSet
            // 6、关闭资源
            pstm.close();
            conn.close();
            System.out.println("已经完成使用Mysql的修改操作");
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
}
