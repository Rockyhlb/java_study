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
    <script>
        function searchDatabase() {
            var searchInput = document.getElementById("searchInput");
            var keyword = searchInput.value; // 获取输入框的值

            var xhr = new XMLHttpRequest();
            xhr.open("GET", "your_servlet_url?keyword=" + keyword, true); // 将关键词作为参数发送到servlet

            xhr.onreadystatechange = function() {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    var response = JSON.parse(xhr.responseText); // 解析返回的JSON数据

                    // 在当前页面框架下展示数据
                    var bRight = document.getElementById("b_right");
                    bRight.innerHTML = ""; // 清空b_right区域

                    for (var i = 0; i < response.length; i++) {
                        var data = response[i];
                        var dataElement = document.createElement("div");
                        dataElement.textContent = data; // 根据返回数据的格式进行相应的处理
                        bRight.appendChild(dataElement); // 将数据添加到b_right区域
                    }
                }
            };

            xhr.send();
        }

        function cutword(){
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
            <span><span id="welcome_word">欢迎登录</span> <span class="font35">Admin: <%= session.getAttribute("username")%></span>
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
                    <li>
                        <h3>部门管理</h3>
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

                        <%-- servlet获取设置的action--%>
                        <form method="Post" name="Students_Inf_Menu" action="Students_Inf_Servlet">
                            <ul>
                                <li>
                                    <input type="submit" name="action" value="getStudentsInform">
                                </li>

                                <li>
                                    <input type="button" name="action"  value="addStudentsInform">
                                </li>

                                <li>
                                    <input type="button" name="action" value="deleteStudentsInform">
                                </li>

                                <li>
                                    <input type="button" name="action" value="updateStudentsInform">
                                </li>
                            </ul>
                        </form>
                    </li>
                </ul>
            </div>
            <div id="b_right">
                <iframe src="Students_inf.jsp" height="100%" width="100%"></iframe>
            </div>
        </div>
    </div>
</body>
</html>
