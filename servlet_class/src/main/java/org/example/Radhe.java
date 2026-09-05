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


        // Write anything to show as output.
        printWriter.println(
            "<H1>Radhe</H1>"
        );
    }
}
