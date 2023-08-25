package com.hlb.controller.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet {

    /*  设计一个 servlet 类，充当服务端组件，去处理客户端提交的数据，然后持久化到数据库;
    *   由于原始的 servlet 类，只能处理一件事，处理效率很低，我们进一步得优化sevrlet的设
    *   计，使之一个 servlet 能胜任多个操作任务，比如，对用户登陆信息的增、删、改、查都在单一的一
    *   个servlet内部完成.
    * */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
