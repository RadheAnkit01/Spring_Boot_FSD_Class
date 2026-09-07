package org.example.request_scope;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request1")
public class Request1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

//        req.setAttribute("name","Ankit");

        PrintWriter pr = resp.getWriter();

        String name = (String) req.getAttribute("name");

        pr.println("<p>What are you doing boyiii...</p>" +
                "<h1>Name : %s</h1>".formatted(name));

    }
}
