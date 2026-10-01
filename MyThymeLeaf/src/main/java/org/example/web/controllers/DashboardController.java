package org.example.web.controllers;

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

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {
    private TemplateEngine templateEngine;

    @Override
    public void init() throws ServletException {
        templateEngine = ThymeLeafConfig.createTemplateEngine(getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JakartaServletWebApplication application = JakartaServletWebApplication.buildApplication(getServletContext());
        IWebExchange exchange = application.buildExchange(req,resp);
        WebContext webContext = new WebContext(exchange,resp.getLocale());
        templateEngine.process("dashboard",webContext,resp.getWriter());
    }
}
