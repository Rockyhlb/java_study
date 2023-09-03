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
<head>
    <meta charset="UTF-8">
    <title>User Register</title>
    <link type="text/css" rel="stylesheet" href="./css/Register.css">
</head>
<body>
    <form method="post" name="register" action="UserServlet">
        <h2>Please input new UserName and new Password--></h2>
        <div class="inputBox">
            <input type="text" name="NewUserName" required>
            <span>Username</span>
            <i></i>
        </div>

        <div class="inputBox">
            <input type="password" name="NewPassWord" required>
            <span>Password</span>
            <i></i>
        </div>

        <input type="submit" name="action" value="register">
    </form>
</body>
</html>
