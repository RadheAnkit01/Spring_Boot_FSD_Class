package org.example.form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        //getting parameter
        String name =  req.getParameter("name");
        System.out.println("New user registered : " + name);

        //If we do use println here then it will create double posting problems

//        PrintWriter printWriter =  resp.getWriter();
//
//        //
//        printWriter.println("""
//                  <h1> Registered : %s </h1>
//                  """.formatted(name)
//        );



        // We are avoiding double posting problem through redirect
        resp.sendRedirect("success");
    }
}
