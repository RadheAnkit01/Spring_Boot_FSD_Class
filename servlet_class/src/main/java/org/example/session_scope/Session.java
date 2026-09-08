package org.example.session_scope;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class Session extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");


        HttpSession session = req.getSession();
        session.setAttribute("Id","161");


        String id = (String) session.getAttribute("Id");
        ServletContext context = getServletContext();
        String appKey = (String) context.getAttribute("appKey");

        PrintWriter pr = resp.getWriter();
        pr.println("<p>What are you doing boyiii... this is session path\n we are learning how to store data in session</p>" +
                "<h1>Some Data In Session : %s</h1>".formatted(id) +
                "<h1>Get Data From Application Scope/Level key name 'appKey' : %s</h1>".formatted(appKey)
        );

    }
}
