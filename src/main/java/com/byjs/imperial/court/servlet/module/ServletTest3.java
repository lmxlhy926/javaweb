package com.byjs.imperial.court.servlet.module; /**
 * @author shkstart
 * @create 2022-03-22 13:52
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletTest3", value = "/ServletTest3")
public class ServletTest3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("========>in servletTest3----start");
        System.out.println("username: " + request.getParameter("username"));
        System.out.println("flag: " + request.getAttribute("flag"));
        System.out.println("========>in servletTest3----finished");

        //向客户端返回消息
        PrintWriter writer = response.getWriter();
        writer.write("response's content");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
