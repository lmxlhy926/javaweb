package com.byjs.imperial.court.servlet.module; /**
 * @author shkstart
 * @create 2022-03-22 10:54
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "testServlet2", value = "/testServlet2")
public class ServletTest2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求的资源路径: /javaweb_war_exploded/hello2
        System.out.println("URI===>: " + request.getRequestURI());
        //获取请求的统一资源定位符（绝对路径）: http://localhost:8080/javaweb_war_exploded/hello2
        System.out.println("URL===>: " + request.getRequestURL());
        //客户端地址
        System.out.println("客户端Ip地址: " + request.getRemoteHost());
        //获取请求头
        System.out.println("请求头user-agent: " + request.getHeader("User-Agent"));
        //请求方式
        System.out.println("请求方式: " + request.getMethod());
        //获取请求参数
        System.out.println("请求参数-用户名: " + request.getParameter("username"));
        System.out.println("请求参数-密码: " + request.getParameter("password"));

        //转发到其它servlet, 通过request.setAttribute，request.getAttribute传递参数
        request.setAttribute("flag", "in testServlet2");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/hello3");
        requestDispatcher.forward(request, response);
        System.out.println("===>testServlet2 finished----");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
