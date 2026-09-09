package org.example.servlet_config;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/myconfig", initParams = @WebInitParam(name = "batch",value = "B2"))
public class MyCfgConfig extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        jakarta.servlet.ServletConfig cfg = getServletConfig();

        String init = cfg.getInitParameter("batch");

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(""" 
                <p>We are in my cfg config and we are saving data to servlet for specific servlet calss only and data should not be shared among other servlet</p>
                <h1>init value using web Servlet annotation : %s</h1>
                
                
                """.formatted(init)
        );
    }
}
