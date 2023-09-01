package com.hlb.controller.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class Register_User_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前端表单提交的用户名和密码
        String username = req.getParameter("NewUserName");
        String password = req.getParameter("NewPassWord");

        // 连接数据库
        String url = "jdbc:mysql://localhost:3306/studentsmanageweb";
        String dbUsername = "root";
        String dbPassword = "000000";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);

            // 查询数据库中是否存在该用户
            String sql = "SELECT * FROM admin WHERE admin_name = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            rs = pstm.executeQuery();

            if (rs.next()) {
                // 用户存在，注册失败
                // 生成包含登录失败提示信息的弹框
                String failureMessage = "注册失败，已含有当前用户。";

                // 设置响应的字符编码为UTF-8,避免输出乱码问题
                resp.setCharacterEncoding("UTF-8");
                resp.setContentType("text/html; charset=UTF-8");

                String script = "<script>alert('" + failureMessage + "'); window.location.href='Register.jsp';</script>";

                // 返回带有弹框提示的Register.jsp页面
                resp.getWriter().println(script);
            } else {
                // 用户不存在，注册用户
                sql = "insert into admin(admin_name,admin_passwd) values (?,?)";
                pstm=conn.prepareStatement(sql);
                pstm.setString(1,username);
                pstm.setString(2,password);

                int sure = pstm.executeUpdate();
                if (0 != sure){
                    String failureMessage = "注册成功~~~";
                    resp.setCharacterEncoding("UTF-8");
                    resp.setContentType("text/html; charset=UTF-8");
                    String script = "<script>alert('" + failureMessage + "'); window.location.href='index.jsp';</script>";
                    resp.getWriter().println(script);

                }
                else {
                    // 生成包含登录失败提示信息的弹框
                    String failureMessage = "注册失败，已含有当前用户。";

                    // 设置响应的字符编码为UTF-8,避免输出乱码问题
                    resp.setCharacterEncoding("UTF-8");
                    resp.setContentType("text/html; charset=UTF-8");

                    String script = "<script>alert('" + failureMessage + "'); window.location.href='./Register.jsp';</script>";

                    // 返回带有弹框提示的Register.jsp页面
                    resp.getWriter().println(script);
                }
            }
        }
        catch (ClassNotFoundException | SQLException e) {
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
    }
}
