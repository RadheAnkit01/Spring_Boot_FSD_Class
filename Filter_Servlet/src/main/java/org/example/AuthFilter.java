package org.example;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        int age = Integer.parseInt( httpServletRequest.getParameter("age"));

        //To mimic real word (like repository layer)
        String user = "root";
        String pass = "12345678";

        httpServletResponse.setContentType("text/html");
        System.out.println("Pre-Processing");


        //Filter 2
        if(user.equals(username) && pass.equals(password)){
            //filtering
            chain.doFilter(request,response);
        }else {
            response.getWriter().println("<h1> User Not Found</h1");
        }

        System.out.println("Post-Processing");

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
