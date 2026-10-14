package org.example.config;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.utility.HibernateUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.util.Map;


public class ThymeleafConfig implements ServletContextListener {
    private static TemplateEngine templateEngine;
    private static JakartaServletWebApplication application;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        application = JakartaServletWebApplication.buildApplication(sce.getServletContext());
        WebApplicationTemplateResolver resolver = new WebApplicationTemplateResolver(application);
        resolver.setSuffix(".html");
        resolver.setPrefix("/WEB_INF/templates");
        resolver.setCharacterEncoding("UTF-8");

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        HibernateUtil.getSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        HibernateUtil.closeSessionFactory();
    }

    public static void render(HttpServletRequest req,
                              HttpServletResponse resp,
                              Map<String,Object> variables,
                              String templateName)
    throws Exception{
        IWebExchange exchange = application.buildExchange(req,resp);
        WebContext context = new WebContext(exchange,resp.getLocale());
        context.setVariables(variables);
        templateEngine.process(templateName, context, resp.getWriter());
    }
}
