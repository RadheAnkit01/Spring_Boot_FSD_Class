package org.example;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AgeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        int age = Integer.parseInt( httpServletRequest.getParameter("age"));

        //To mimic real word (like repository layer)
        int minAge = 18;

        httpServletResponse.setContentType("text/html");

        //filter 1 - user pass
        //filter 2 - age should be greater than 18

        System.out.println("Pre-Processing");

        //filter 1
        if(age>=minAge){
            chain.doFilter(request,response);
        }else {
            response.getWriter().println("<h1> Age must be greater then equals to 18 </h1>");
        }

        System.out.println("Post-Processing");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
