package org.example.servlet;

import org.example.config.ThymeleafConfig;
import org.example.dao.DepartmentDao;
import org.example.model.Department;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/department/add")
public class AddDepartmentServlet extends HttpServlet {

    private DepartmentDao departmentDao = new DepartmentDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ThymeleafConfig.render(req, resp, Map.of("department", new Department()), "add-department");
    }

}