package org.example.application_scope;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/myapp")
public class MyApp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();

        ServletContext context = getServletContext();
        context.setAttribute("appKey","ankitrajkey");
        String key = (String) context.getAttribute("appKey");

        printWriter.println("<h1>Application Level Key : %s</h1>".formatted(key));
    }
}


