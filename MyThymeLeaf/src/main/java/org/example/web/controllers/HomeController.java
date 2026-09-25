package org.example.web.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.config.ThymeLeafConfig;
import org.example.modal.User;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class HomeController extends HttpServlet {

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

        // New user
        List<User> userList = new ArrayList<>();

        userList.add(new User(1,"Ankit", "Delhi", 7903707134L));
        userList.add(new User(2,"Hasan", "Bihar", 9873478238L));
        userList.add(new User(3,"Pranav", "MP", 8137438798L));
        userList.add(new User(4,"Dristi", "Delhi", 9348734984L));

        webContext.setVariable("users", userList);

        webContext.setVariable("msg1","This is message 1, which is set in webContext.setVariable");
        templateEngine.process("index",webContext,resp.getWriter());
    }
}
