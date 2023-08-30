
<%@ page import="com.hlb.controller.login.loginServlet" %>
<%@ page import="com.hlb.entity.Students_Inf" %>
<%--
  Created by IntelliJ IDEA.
  User: 麦田里的乌鸦
  Date: 2023/8/27
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生信息管理界面</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid black;
            padding: 2px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h2>hello!</h2>
    <table>
        <thead>
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>入学日期</th>
                <th>QQ邮箱</th>
            </tr>
        </thead>
        <tbody>
<%--            <c:forEach var="data" items="${requestScope.dataList}">--%>
            <c:forEach var="data" items="<%= request.getParameter("dataList") %>\">
               <tr>
                   <td>${data.id}</td>
                   <td>${data.name}</td>
                   <td>${data.sex}</td>
                   <td>${data.age}</td>
                   <td>${data.enter_time}</td>
                   <td>${data.email}</td>
               </tr>
           </c:forEach>

<%--            <td><%=request.getParameter("dataList")%></td>--%>
       </tbody>
    </table>
</body>
</html>
