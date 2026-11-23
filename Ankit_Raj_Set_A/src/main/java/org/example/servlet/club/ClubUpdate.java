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
import java.util.Map;

@WebServlet("/club/update")
public class ClubUpdate extends HttpServlet {
    private final ClubDao clubDao = new ClubDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long id = Long.parseLong(req.getParameter("id"));
        Club club = clubDao.findById(id);
        if(club==null){
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"Club Not Found");
            return;
        }
        ThymeleafConfig.render(req,resp, Map.of("club",club),"club-update");
    }
}
