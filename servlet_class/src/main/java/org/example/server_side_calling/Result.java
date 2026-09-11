package org.example.server_side_calling;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class Result extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello from Result class");
        resp.setContentType("text/html");
        Integer num1 = Integer.parseInt(req.getParameter("num1"));
        Integer num2 = Integer.parseInt(req.getParameter("num2"));

        PrintWriter printWriter = resp.getWriter();

        req.getRequestDispatcher("header.html").include(req,resp);

        printWriter.println("<h1> Sum of %s and %s is : %s</h1>".formatted(num1,num2,num1+num2));

        req.getRequestDispatcher("footer.html").include(req,resp);
    }
}
