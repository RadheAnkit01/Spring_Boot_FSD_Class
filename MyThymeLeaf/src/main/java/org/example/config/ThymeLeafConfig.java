package org.example.config;

import jakarta.servlet.ServletContext;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

public class ThymeLeafConfig {
    public static TemplateEngine createTemplateEngine(ServletContext context){
        JakartaServletWebApplication application = JakartaServletWebApplication.buildApplication(context);

        WebApplicationTemplateResolver resolver = new WebApplicationTemplateResolver(application);

        resolver.setTemplateMode("HTML");
        resolver.setPrefix("/WEB-INF/templates/index.html");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        return templateEngine;

    }
}
