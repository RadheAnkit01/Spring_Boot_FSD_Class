package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import java.io.IOException;

@WebServlet("/employee/save")
public class EmployeeSave extends HttpServlet {

    private final EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String branch = req.getParameter("branch");
        double salary = Double.parseDouble(req.getParameter("salary"));
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        Employee employee = new Employee(name,email,branch,salary,phone);

        employeeDao.create(employee);

        resp.sendRedirect(req.getContextPath()+"/employees");

    }
}
