package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.DepartmentDao;
import org.example.model.Department;

import java.io.IOException;

@WebServlet("/department/save")
public class DepartmentSaveServlet extends HttpServlet {
    private final DepartmentDao departmentDao = new DepartmentDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String departmentName =
                req.getParameter("departmentName");
        String departmentLocation =
                req.getParameter("departmentLocation");

        Department department = new Department();
        department.setDepartmentName(departmentName);
        department.setDepartmentLocation(departmentLocation);

        departmentDao.saveDepartment(department);

        resp.sendRedirect(req.getContextPath()+"/department");

    }
}
