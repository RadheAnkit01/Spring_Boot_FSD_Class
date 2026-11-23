package org.example.servlet.club;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.config.ThymeleafConfig;
import org.example.model.Club;

import java.io.IOException;
import java.util.Map;

@WebServlet("/club/add")
public class ClubAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ThymeleafConfig.render(req, resp, Map.of("club", new Club()), "club-add");
    }

}
