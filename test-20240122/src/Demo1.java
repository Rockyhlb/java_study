import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @BelongsProject: test-20240122
 * @BelongsPackage: PACKAGE_NAME
 * @CreateTime : 2024/1/22 19:11
 * @Description: TODO
 * @Author: code_hlb
 */
public class Demo1 {
    public static void main(String[] args) throws SQLException {
        // 一、声明数据源
        // 通过向上转型的方式创建数据源对象,然后再向下转型的方式解耦合
        // 高内聚：可以简单理解为一个模块只实现一个功能，
        // 低耦合：两个模块之间的联系越紧密，则这两个模块的耦合度越高，也就会导致当一个模块发生改变时，另一个模块也会随之发生改变
        // 因此我们平时代码中应该讲究“高内聚，低耦合”,这样有利于我们后期的代码优化和维护
        DataSource dataSource = new MysqlDataSource();
        // url 表示网络上的资源位置，mysql是一个客户端-服务器结构的程序，是通过网络进行交互的
        // 127.0.0.1 是一个特殊的IP地址，叫做“环回IP”，因为我们的jdbc程序和Mysql服务器在同一个主机上，因此我们用环回IP即可
        // 注：jdbc程序不支持设置字符集为”utf8mb4“
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java?characterEncoding=utf8&useSSL=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("000000");
        // 也可通过以下方式创建，但是这样会导致模块间的耦合性过高
        // MysqlDataSource mysqlDataSource = new MysqlDataSource();
        // mysqlDataSource.setURL();
        
        // 二、建立和数据库服务器之间的连接，以便后面进行的 请求-响应 交互
        Connection connection = dataSource.getConnection();
        Scanner scanner = new Scanner(System.in);

        // 三、构造sql语句
        // String sql = "insert into student values(1,'小红')";
        System.out.print("请输入待录入的id:");
        int id = scanner.nextInt();
        System.out.println("请输入待录入的姓名:");
        String name = scanner.next();
        // 不能使用字符串拼接的方式当作执行语句，容易被sql注入攻击!!
        // String sql = "insert into student values (" + id + ",'"+ name +"')";
        String sql = "insert into student values (?,?)";
        // PreparedStatement:译为”预处理语句“，可以先对sql语句解析检查，减少数据库服务器无效开销
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 通过使用占位符和设置占位符的值的方式提高安全性
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,name);

        // 四、把sql发给服务器，同时服务器返回一个整数，表示受影响的行数
        int res = preparedStatement.executeUpdate();
        System.out.println(res + " rows is affected");
        // 五、最后关闭资源
        preparedStatement.close();
        connection.close();
    }
}
