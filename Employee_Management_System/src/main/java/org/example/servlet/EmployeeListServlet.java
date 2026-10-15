package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.config.ThymeleafConfig;
import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/employees")
public class EmployeeListServlet extends HttpServlet {
    private EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Employee> employees = employeeDao.findAll();

        try {
            ThymeleafConfig.render(req,resp, Map.of("employees", employees),"employee");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
