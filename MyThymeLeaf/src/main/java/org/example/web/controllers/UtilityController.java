package org.example.web.controllers;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.config.ThymeLeafConfig;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@WebServlet("/utility")
public class UtilityController extends HttpServlet {
    private TemplateEngine templateEngine;

    @Override
    public void init() throws ServletException {
        templateEngine = ThymeLeafConfig.createTemplateEngine(getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JakartaServletWebApplication application = JakartaServletWebApplication.buildApplication(getServletContext());

        IWebExchange exchange = application.buildExchange(req,resp);

        WebContext context = new WebContext(exchange, resp.getLocale());

        context.setVariable("message", "Hello From Utility");
        //String
        String name = "Radhe";
        String[] names = {"Ankit", "Hasan", "Dristi", "Snigdha", "Amit", "Ritik", "Himanshu", "Aryan", "Arshad", "Jasgun", "Sunny", "Mahak", "Anuj", "Udit"};
        context.setVariable("name", name);
        context.setVariable("names", Arrays.toString(names));
        //List
        List<String> nameList = Arrays.asList(names);
        context.setVariable("nameList", nameList);
        //Number
        double salary = 19879.1020;
        context.setVariable("salary",salary);

        templateEngine.process("utility", context, resp.getWriter());


    }

    @Override
    public void destroy() {
        templateEngine.clearTemplateCache();
    }
}
