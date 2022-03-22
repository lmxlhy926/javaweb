package com.byjs.imperial.court.servlet.module;
/**
 * @author shkstart
 * @create 2022-03-22 9:44
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "testServlet", value = "/testServlet")
public class ServletTest1 extends HttpServlet {

    @Override
    //第一次访问，创建Servlet程序时调用
    public void init(ServletConfig servletConfig) throws ServletException{
        super.init(servletConfig);  //必须先调用父类的初始化函数
        //获取servlet配置参数
        System.out.println("testServlet的别名是: " + servletConfig.getServletName());
        System.out.println("初始化参数username: " + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数password: " + servletConfig.getInitParameter("password"));
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
            ServletContext:
                1. 一个web工程，只有一个ServletContext对象实例
                2. 在web工程部署启动的时候创建，在web工程停止的时候销毁
                3. 在整个web工程范围内可进行存取

            ServletContext类的4个作用
                1. 获取web.xml中配置的上下文参数context-param
                2. 获取当前的工程路径，格式：/工程路径
                3. 获取工程部署后在服务器硬盘上的绝对路径
                4. 像Map一样存取数据
         */
        ServletContext context = getServletConfig().getServletContext();
        //获取 web.xml 中配置的上下文参数 context-param
        System.out.println("context-param参数username的值是: " + context.getInitParameter("username"));
        System.out.println("context-param参数password的值是: " + context.getInitParameter("password"));

        // 获取工程路径
        System.out.println("当前工程路径：" + context.getContextPath());
        System.out.println("工程部署的路径是: " + context.getRealPath("/"));    // 斜杠被服务器解析为：http://ip:port/工程名/
        System.out.println("工程下img目录下a.jpg的绝对路径是: " + context.getRealPath("/img/a.jpg"));

        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");

        System.out.println(context);
        System.out.println("保存之前key1对应的值: " + context.getAttribute("key1"));
        context.setAttribute("key1", list);
        System.out.println("获取到key1对应的值： " + context.getAttribute("key1"));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
