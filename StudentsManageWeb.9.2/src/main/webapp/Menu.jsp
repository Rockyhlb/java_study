<%--
  Created by IntelliJ IDEA.
  User: 麦田里的乌鸦
  Date: 2023/9/1
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
    <link  rel="stylesheet"   href="css/Menu.css">
    <script>function cutword(){
        let word=document.getElementById("welcome_word").innerHTML;

        let _first=word.substring(0,1); // 双零位置取出一个字符
        let _left=word.substring(1);  //  双第二个位置取到字符串末尾

        document.getElementById("welcome_word").innerHTML=_left+_first;
        }
        setInterval("cutword()",800);
    </script>
</head>
<body>
    <div id="wrapper">
        <div id="top">
            <img id="logo" alt="site logo"  title="site logo"  src="images/soro.png" >
            <span><span id="welcome_word">欢迎登录</span> <span class="font35">Admin:<%= session.getAttribute("username")%></span>
            <div id="top_nav_menu">
                <ul>
                    <li>首&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;页</li>
                    <li>部门管理</li>
                    <li>角色管理</li>
                    <li>用户管理</li>
                    <li class="clearfloat"></li>
                </ul>
            </div>
        </div>
        <div id="bottom">
            <div id="b_left">
                <ul>
                    <li><h3>部门管理</h3>
                        <ul>
                            <li>部门添加</li>
                            <li>部门删除</li>
                            <li>部门修改</li>
                        </ul>
                    </li>
                    <li>
                        <h3>角色管理</h3>
                        <ul>
                            <li>角色添加</li>
                            <li>角色删除</li>
                            <li>角色修改</li>
                        </ul>
                    </li>
                    <li>
                        <h3>用户管理</h3>
                        <ul>
                            <li>用户添加</li>
                            <li>用户删除</li>
                            <li>用户修改</li>
                        </ul>
                    </li>
                </ul>

            </div>
            <div id="b_right">
                <%--    获取servlet设置的Session--%>
                <form method="Post" name="SearchStudents_Inf" action="Search_Students_Inf_Servlet">
                    <div style="width: 50px;height: 50px">
                        <input type="submit" value="查看学生信息">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
