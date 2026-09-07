package org.example.request_scope;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.session_scope.Session;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/request")
public class Request extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        req.setAttribute("name","Ankit");

        PrintWriter pr = resp.getWriter();

        String requestDataName = (String) req.getAttribute("name");

        HttpSession session = req.getSession();
        String sessionDataId = (String) session.getAttribute("Id");

        pr.println("<p>What are you doing boyiii...</p>" +
                "<h1>Name : %s and Id : %s</h1>".formatted(requestDataName,sessionDataId));

    }
}
