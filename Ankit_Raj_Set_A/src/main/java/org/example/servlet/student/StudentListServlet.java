package org.example.servlet.student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.config.ThymeleafConfig;
import org.example.dao.StudentDao;
import org.example.model.Student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
    private StudentDao studentDao = new StudentDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Student> studentList = studentDao.findAll();

        try {
            ThymeleafConfig.render(req,resp, Map.of("students", studentList),"students");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
