package com.hlb.controller.servlet;

import com.hlb.entity.Students_Inf;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import java.util.LinkedList;
import java.util.List;

@WebServlet("/dataList")
public class Students_Inf_Servlet extends HttpServlet {

    // 连接数据库
    private String url = "jdbc:mysql://localhost:3306/studentsmanageweb";
    private String dbUsername = "root";
    private String dbPassword = "000000";
    private String driver = "com.mysql.jdbc.Driver";

    private Connection conn = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            // 没有指定操作
            response.sendRedirect("Menu.jsp");
        } else {
            switch (action) {
                case "addStudentsInform":
                    addStudentsInf(request, response);
                    break;
                case "deleteStudentsInform":
                    deleteStudentsInf(request, response);
                    break;
                case "updateStudentsInform":
                    updateStudentsInf(request, response);
                    break;
                case "getStudentsInform":
                    getStudentsInf(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "Menu.jsp");
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    private void addStudentsInf(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteStudentsInf(HttpServletRequest request, HttpServletResponse response) {
    }

    private void updateStudentsInf(HttpServletRequest request, HttpServletResponse response) {
    }


    private void getStudentsInf(HttpServletRequest req,HttpServletResponse resp ) throws ServletException,IOException{
        List<Students_Inf> dataList = getDataFromDatabase(); // 从数据库获取数据
        req.setAttribute("List",dataList); // 将数据存储在请求属性中
        // 转发请求
        req.getRequestDispatcher("Students_inf.jsp").forward(req,resp);
    }

    private LinkedList<Students_Inf> getDataFromDatabase() {

        // 实体化Students_inf接受数据，再传给链表
        LinkedList<Students_Inf> linkedList = new LinkedList<>();

        try {
            Class.forName(driver);
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
}
