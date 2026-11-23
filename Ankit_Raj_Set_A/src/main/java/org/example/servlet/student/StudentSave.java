package org.example.servlet.student;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.StudentDao;
import org.example.model.Student;

import java.io.IOException;

@WebServlet("/students/save")
public class StudentSave extends HttpServlet {

    private final StudentDao studentDao = new StudentDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String course = req.getParameter("course");
        String year = req.getParameter("yearOfStudy");

        if (name == null || name.trim().isEmpty()
                || email == null || email.trim().isEmpty()
                || password == null || password.trim().isEmpty()
                || course == null || course.trim().isEmpty()
                || year == null || year.trim().isEmpty()) {

            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "All fields are required.");
            return;
        }
        if (!email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Invalid email format.");
            return;
        }
        if (password.length() < 6) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Password must be at least 6 characters.");
            return;
        }
        Student student = new Student(
                name.trim(),
                email.trim(),
                password,
                course.trim(),
                year.trim()
        );
        studentDao.create(student);
        resp.sendRedirect(req.getContextPath() + "/students");
    }
}
