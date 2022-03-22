package com.byjs.imperial.court.filter; /**
 * @author shkstart
 * @create 2022-03-22 16:33
 */

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter")
public class AdminFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        System.out.println("URL: " + httpServletRequest.getRequestURI().toString());
        if(httpServletRequest.getRequestURL().toString().contains("/javaweb_war_exploded/login")){
            chain.doFilter(request, response);

        }else{
            HttpSession session = httpServletRequest.getSession();
            String user = (String)session.getAttribute("user");
            if(user == null || !user.equals("lhy")){
                System.out.println("---not login, need to login first");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }else{
                chain.doFilter(request, response);
            }
        }

    }
}
