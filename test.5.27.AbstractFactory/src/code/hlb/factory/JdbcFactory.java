package code.hlb.factory;//配置成自己的包路径

import java.sql.Connection;
import java.sql.DriverManager;

class JdbcFacctory {
    public static void main(String[] args) {
        //不用动，默认就是这么写的
        String driverName = "com.mysql.cj.jdbc.Driver";
        //本地连接
        String dbURL="jdbc:mysql://localhost:3306/bigdata?&useSSL=false&serverTimezone=Asia/Shanghai"; //mysql为数据库名

        //自己数据库的账号
        String userName = "root";
        //自己数据库的密码
        String userPwd = "000000";

        try {
            Class.forName(driverName);

            Connection con= DriverManager.getConnection(dbURL, userName, userPwd);

            System.out.println("连接数据库成功");

        } catch (Exception e) {

            e.printStackTrace();

            System.out.print("连接失败");

        }
    }

}
