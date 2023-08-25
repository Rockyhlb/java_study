<%--
  Created by IntelliJ IDEA.
  User: 麦田里的乌鸦
  Date: 2023/8/25
  Time: 20:23
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<HEAD>
    <meta charset="UTF-8">
    <title>Login Result</title>
</HEAD>
<body>
    <%
        // 获取前端表单提交的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String res = "";

        // 连接数据库
        String url = "jdbc:mysql://localhost:3306/studentsmanageweb";
        String dbUsername = "root";
        String dbPassword = "000000";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        boolean loginSuccess = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);

            // 查询数据库中是否存在该用户
            String sql = "SELECT * FROM admin WHERE admin_name = ? AND admin_passwd = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();

            if (rs.next()) {
                // 用户存在，登陆成功
                loginSuccess = true;
            } else {
                // 用户不存在，登陆失败
                loginSuccess = false;
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // 关闭数据库连接
            try {
                if (rs!=null) rs.close();
                if (pstm!=null) pstm.close();
                if (conn!=null) conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        // 根据登陆结果返回不同的提示信息
        if (loginSuccess) {
            out.println("<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "    <title>学生信息表</title>\n" +
                    "    <style>\n" +
                    "        table {\n" +
                    "            border-collapse: collapse;\n" +
                    "            width: 100%;\n" +
                    "        }\n" +
                    "        th, td {\n" +
                    "            border: 1px solid black;\n" +
                    "            padding: 8px;\n" +
                    "            text-align: left;\n" +
                    "        }\n" +
                    "        th {\n" +
                    "            background-color: #f2f2f2;\n" +
                    "        }\n" +
                    "    </style>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <h2>学生信息表</h2>\n" +
                    "    <table>\n" +
                    "        <tr>\n" +
                    "            <th>学号</th>\n" +
                    "            <th>姓名</th>\n" +
                    "            <th>性别</th>\n" +
                    "            <th>年龄</th>\n" +
                    "            <th>入学日期</th>\n" +
                    "            <th>QQ邮箱</th>\n" +
                    "        </tr>\n" +
                    "        <tr>\n" +
                    "            <td>张三</td>\n" +
                    "            <td>18</td>\n" +
                    "            <td>男</td>\n" +
                    "            <td>2021001</td>\n" +
                    "            <td>计算机科学与技术</td>\n" +
                    "            <td>软件工程1班</td>\n" +
                    "            <td>1234567890</td>\n" +
                    "            <td>zhangsan@example.com</td>\n" +
                    "        </tr>\n" +
                    "    </table>\n" +
                    "</body>\n" +
                    "</html>");
            res="Login Successful!";
        } else {
            res="Login Failed!";
        }
    %>

    <script>
        const jsRes = '<%= res %>'; // 在JavaScript代码中使用res变量
        alert(jsRes);

        if (!<%= loginSuccess %>) {
            // 重定向到登录页面
            window.location.href = "./index.jsp";
        }
    </script>
</body>
</html>
