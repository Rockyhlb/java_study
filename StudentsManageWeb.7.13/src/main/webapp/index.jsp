<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>登陆界面</title>
<%--    ${pageContext.request.contextPath} 用于获取当前应用程序的上下文路径--%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}../resources/css/LoginPage.css">
</head>

<body>
    <div class="box">
        <form method="post" name="login" action="LoginResult.jsp">
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
                <a href="#">Signup</a>
            </div>

            <input type="submit" value="login">
        </form>
    </div>
</body>
</html>