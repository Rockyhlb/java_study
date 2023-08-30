package com.hlb.controller.login;

import com.hlb.entity.Students_Inf;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/dataList")
public class loginServlet extends HttpServlet {

    /*  设计一个 servlet 类，充当服务端组件，去处理客户端提交的数据，然后持久化到数据库;
    *   由于原始的 servlet 类，只能处理一件事，处理效率很低，我们进一步得优化sevrlet的设
    *   计，使之一个 servlet 能胜任多个操作任务，比如，对用户登陆信息的增、删、改、查都在单一的一
    *   个servlet内部完成.
    * */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();

        List<Students_Inf> dataList = getDataFromDatabase(); // 从数据库获取数据
//        String message="hello world";
        req.setAttribute("dataList",dataList); // 将数据存储在请求属性中

        // 获取RequestDispatcher对象
        RequestDispatcher dispatcher = req.getRequestDispatcher("/webapp/Students_inf.jsp");
        // 将请求转发到JSP页面
        dispatcher.forward(req, resp);
    }

    private LinkedList<Students_Inf> getDataFromDatabase() {

        // 实体化Students_inf接受数据，再传给链表
        LinkedList<Students_Inf> linkedList = new LinkedList<>();

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
            String sql = "SELECT * FROM students_inf";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            if(rs!=null){
                while (rs.next()) {
                    Students_Inf studentsInf = new Students_Inf();

                    studentsInf.setId(rs.getString("id"));
                    studentsInf.setName(rs.getString("name"));
                    studentsInf.setSex(rs.getString("sex"));
                    studentsInf.setAge(rs.getInt("age"));
                    // 此处getDate 和 getTime 返回不同的日期格式
                    studentsInf.setEnter_time(rs.getDate("enter_time"));
                    studentsInf.setEmail(rs.getString("email"));

                    studentsInf.setId("324432");
                    studentsInf.setName("3dsad");
                    studentsInf.setSex("2");
                    studentsInf.setAge(23);
                    studentsInf.setEmail("dsadsadw23");

                    linkedList.add(studentsInf);
                }
            }
        }
        catch (SQLException | ClassNotFoundException e) {
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
        return linkedList;
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
            // 如果验证成功，将用户信息保存在Session中
            HttpSession session = req.getSession();
            session.setAttribute("username", username);

            // 重定向到学生信息页面
            resp.sendRedirect("Students_inf.jsp");
        } else {
//            alert("login failed!");
            resp.sendRedirect("index.jsp");
        }
    }
}
