package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.EmployeeDao;
import org.example.model.Employee;

import java.io.IOException;

@WebServlet("/employees/modify")
public class EmployeeUpdate extends HttpServlet {
    private final EmployeeDao employeeDao = new EmployeeDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String branch = req.getParameter("branch");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        double salary = Double.parseDouble(req.getParameter("salary"));

        Employee employee = employeeDao.findById(id);

        if(employee==null){

        }
        employee.setName(name);
        employee.setDepartment(branch);
        employee.setPhone_number(phone);
        employee.setEmail(email);
        employee.setSalary(salary);

        resp.sendRedirect(req.getContextPath()+"/employees");
    }
}
