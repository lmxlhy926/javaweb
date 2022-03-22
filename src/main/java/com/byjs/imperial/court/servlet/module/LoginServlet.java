package com.byjs.imperial.court.servlet.module; /**
 * @author shkstart
 * @create 2022-03-22 16:06
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("===>in loginServlet======");
        response.setContentType("text/html; charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if("lhy".equals(username) && "12345".equals(password)){
            request.getSession().setAttribute("user", username);
            response.getWriter().write("登录 成功！！！");
        }else{
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
