package org.example.servlet;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.config.ThymeleafConfig;
import org.example.dao.DepartmentDao;
import org.example.model.Department;
import org.example.utility.HibernateUtil;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/department")
public class DepartmentServlet extends HttpServlet {

    private DepartmentDao departmentDao = new DepartmentDao();


    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Department> departments =
                departmentDao.getAllDepartments();

        try {
            ThymeleafConfig.render(request,response, Map.of("departments", departments),"department");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}