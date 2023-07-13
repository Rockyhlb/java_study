<%--
  Created by IntelliJ IDEA.
  User: 麦田里的乌鸦
  Date: 2023/7/13
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
    <meta charset="UTF-8">
    <title>Login Result</title>
</head>

<body>
    <%
        // 获取前端表单提交的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

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
            out.println("<h1>Login Successful!</h1>");
        } else {
            out.println("<h1>Login Failed!</h1>");
        }
    %>
</body>
</html>
