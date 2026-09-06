package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//you can configure Service by annotation or by xml file

public class Radhe extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Setting Response Content Type
        response.setContentType("text/html");

        PrintWriter printWriter = response.getWriter();

        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String pathInfo = request.getPathInfo();
        String getServletPath = request.getServletPath();

        // Write anything to show as output.
        printWriter.println("""
                    <html><head>
                    <title>Radhe</title>
                    </head><body>
                    <h1>Radhe</h1>
                    <img src='https://picsum.photos/800/500'alt='Random Image'>
                    <H1>URL BreakDown</H1>
                    <H1> requestURI : %s </H1>
                    <H1> contextPath : %s </H1>
                    <H1> pathInfo : %s </H1>
                    <H1> getServletPath : %s </H1>
                    </body> </html>
                """.formatted(requestURI,contextPath,pathInfo,getServletPath));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String pathInfo = request.getPathInfo();
        String getServletPath = request.getServletPath();

        printWriter.println("""
                <H1>URL BreakDown</H1>
                <H1> requestURI : %s</H1>
                <H1> contextPath : %s</H1>
                <H1> pathInfo : %s</H1>
                <H1> getServletPath : %s</H1>
                """);
    }
}
