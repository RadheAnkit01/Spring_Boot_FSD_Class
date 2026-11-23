package org.example.servlet.student;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.StudentDao;
import org.example.model.Student;

import java.io.IOException;

@WebServlet("/students/modify")
public class StudentModify extends HttpServlet {
    private final StudentDao studentDao = new StudentDao();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        String name = req.getParameter("name");
        String course = req.getParameter("course");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String year = req.getParameter("yearOfStudy");

        Student student = studentDao.findById(id);

        if(student==null){
            return;
        }
        student.setName(name);
        student.setCourse(course);
        student.setPassword(password);
        student.setEmail(email);
        student.setYearOfStudy(year);

        studentDao.update(student);

        resp.sendRedirect(req.getContextPath()+"/students");
    }
}
