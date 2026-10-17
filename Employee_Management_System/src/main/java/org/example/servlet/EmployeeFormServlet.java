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
import java.util.Map;

@WebServlet(urlPatterns = {"/employee/add","/employee/update"})
public class EmployeeFormServlet extends HttpServlet {
    private final EmployeeDao employeeDao = new EmployeeDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getServletConnection().equals("/employee/add")){
            ThymeleafConfig.render(req, resp, Map.of("employee", new Employee()), "add-new-employee");
            return;
        }
        Long id = Long.parseLong(req.getParameter("id"));

        Employee employee = employeeDao.findById(id);
        if(employee==null){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"Employee Not Found");
            return;
        }
        ThymeleafConfig.render(req,resp,Map.of("employee",employee),"update-employee");


    }
}
