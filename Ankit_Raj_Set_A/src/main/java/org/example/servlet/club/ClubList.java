package org.example.servlet.club;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.config.ThymeleafConfig;
import org.example.dao.ClubDao;
import org.example.dao.StudentDao;
import org.example.model.Club;
import org.example.model.Student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/club")
public class ClubList extends HttpServlet {
    private ClubDao clubDao = new ClubDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Club> clubList = clubDao.findAll();

        try {
            ThymeleafConfig.render(req,resp, Map.of("clubs", clubList),"club");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
