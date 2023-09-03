package com.hlb.controller.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

/*  设计一个 servlet 类，充当服务端组件，去处理客户端提交的数据，然后持久化到数据库;
 *   由于原始的 servlet 类，只能处理一件事，处理效率很低，我们进一步得优化sevrlet的设
 *   计，使之一个 servlet 能胜任多个操作任务，比如，对用户登陆信息的增、删、改、查都在单一的一
 *   个servlet内部完成.
 * */
public class UserServlet extends HttpServlet {

    private String url = "jdbc:mysql://localhost:3306/studentsmanageweb";
    private String dbUsername = "root";
    private String dbPassword = "000000";

    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            // 没有指定操作
            response.sendRedirect("index.jsp");
        } else {
            switch (action) {
                case "register":
                    addUser(request, response);
                    break;
                case "delete":
                    deleteUser(request, response);
                    break;
                case "update":
                    updateUser(request, response);
                    break;
                case "login":
                    getUser(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "index.jsp");
                    break;
            }
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取表单数据并处理逻辑
        // ...
        // 处理注册用户操作
        // 获取前端表单提交的用户名和密码
        String username = req.getParameter("NewUserName");
        String password = req.getParameter("NewPassWord");

        // 连接数据库
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
                pstm = conn.prepareStatement("insert into admin(admin_name,admin_passwd) values (?,?)");
                pstm.setString(1, username);
                pstm.setString(2, password);

                int sure = pstm.executeUpdate();
                if (0 != sure) {
                    String failureMessage = "注册成功~~~";
                    resp.setCharacterEncoding("UTF-8");
                    resp.setContentType("text/html; charset=UTF-8");
                    String script = "<script>alert('" + failureMessage + "'); window.location.href='index.jsp';</script>";
                    resp.getWriter().println(script);

                } else {
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
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数并处理逻辑
        // ...

        // 返回响应数据
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数并处理逻辑
        // ...

        // 返回响应数据
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    private void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取参数并处理逻辑
        // ...
        // 处理用户登陆
        // 获取前端表单提交的用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

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
                // 验证成功，将用户信息保存在Session中
                HttpSession session = req.getSession();
                session.setAttribute("username", username);

                // 重定向到学生信息页面
                resp.sendRedirect("Menu.jsp");
            } else {
                // 用户不存在，登陆失败
                // 生成包含登录失败提示信息的弹框
                String failureMessage = "登录失败，请检查用户名和密码。";

                // 设置响应的字符编码为UTF-8,避免输出乱码问题
                resp.setCharacterEncoding("UTF-8");
                resp.setContentType("text/html; charset=UTF-8");

                String script = "<script>alert('" + failureMessage + "'); window.location.href='index.jsp';</script>";

                // 返回带有弹框提示的index.jsp页面
                resp.getWriter().println(script);
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
    }
}
