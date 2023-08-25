<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

<%-- Tomcat默认情况下会将index.html、index.jsp等文件作为默认的首页文件。如果项目中没有这些文件，Tomcat就会显示目录列表!!! --%>
<head>
    <meta charset="UTF-8">
    <title>登陆界面</title>
    <link type="text/css" rel="stylesheet" href="./css/LoginPage.css">
</head>

<body>
    <div class="box">
        <form method="post" name="login" action="loginResult.jsp">
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