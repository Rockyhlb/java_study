<%--
  Created by IntelliJ IDEA.
  User: 麦田里的乌鸦
  Date: 2023/9/1
  Time: 16:00
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登陆界面</title>
    <link type="text/css" rel="stylesheet" href="./css/LoginPage.css">
</head>

<body>
<div class="box">
    <form method="post" name="login" action="UserServlet">

        <h2>sign in</h2>
        <div class="inputBox">
            <input type="text" name="username" required>
            <span>Username</span>
            <i></i>
        </div>

        <div class="inputBox">
            <input type="password" name="password" required>
            <span>Password</span>
            <i></i>
        </div>

        <div class="links">
            <a href="#">Forgot Password</a>
            <a href="Register.jsp">Signup</a>
        </div>

        <input type="submit" name="action" value="login">
    </form>
</div>
</body>
</html>