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
import java.util.Map;

@WebServlet("/students/update")
public class StudentUpdate extends HttpServlet {
    private final StudentDao studentDao = new StudentDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        Student student = studentDao.findById(id);
        if(student==null){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"Student Not Found");
            return;
        }
        ThymeleafConfig.render(req,resp,Map.of("student",student),"student-update");
    }
}