package com.hlb.controller.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.sql.*;

public class Login_Servlet extends HttpServlet {

    /*  设计一个 servlet 类，充当服务端组件，去处理客户端提交的数据，然后持久化到数据库;
    *   由于原始的 servlet 类，只能处理一件事，处理效率很低，我们进一步得优化sevrlet的设
    *   计，使之一个 servlet 能胜任多个操作任务，比如，对用户登陆信息的增、删、改、查都在单一的一
    *   个servlet内部完成.
    * */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取前端表单提交的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 验证用户名和密码是否正确，如从数据库中查询比对
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
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭数据库连接
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 根据登陆结果返回不同的提示信息
        if (loginSuccess) {
            // 如果验证成功，将用户信息保存在Session中
            HttpSession session = req.getSession();
            session.setAttribute("username", username);

            // 重定向到学生信息页面
            resp.sendRedirect("Menu.jsp");
        } else {
            // 生成包含登录失败提示信息的弹框
            String failureMessage = "登录失败，请检查用户名和密码。";

            // 设置响应的字符编码为UTF-8,避免输出乱码问题
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");

            String script = "<script>alert('" + failureMessage + "'); window.location.href='index.jsp';</script>";

            // 返回带有弹框提示的index.jsp页面
            resp.getWriter().println(script);
        }
    }
}
