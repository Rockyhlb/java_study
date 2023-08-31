<%--
  Created by IntelliJ IDEA.
  User: 麦田里的乌鸦
  Date: 2023/8/31
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>menu</title>
</head>
<body>
<%--    获取servlet设置的Session--%>
    <h2>welcome to menu! Admin:<%= session.getAttribute("username")%></h2>
    <form method="Post" name="SearchStudents_Inf" action="Search_Students_Inf_Servlet">
        <div style="width: 50px;height: 50px">
            <input type="submit" value="查看学生信息">
        </div>
    </form>
</body>
</html>

