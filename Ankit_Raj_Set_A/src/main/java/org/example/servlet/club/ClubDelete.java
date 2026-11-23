package org.example.servlet.club;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.ClubDao;
import org.example.dao.StudentDao;

import java.io.IOException;

@WebServlet("/club/delete")
public class ClubDelete extends HttpServlet {
    private ClubDao clubDao = new ClubDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        clubDao.delete(id);

        resp.sendRedirect(req.getContextPath()+"/club");
    }
}
