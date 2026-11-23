package org.example.servlet.student;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.StudentDao;
import org.example.model.Student;

import java.io.IOException;

@WebServlet("/students/delete")
public class StudentDelete extends HttpServlet {
    private StudentDao studentDao = new StudentDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        studentDao.delete(id);

        resp.sendRedirect(req.getContextPath()+"/students");
    }
}
