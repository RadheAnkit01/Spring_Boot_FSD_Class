package org.example.servlet.club;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.ClubDao;
import org.example.model.Club;

import java.io.IOException;

@WebServlet("/club/save")
public class ClubSave extends HttpServlet {

    private final ClubDao clubDao = new ClubDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String category = req.getParameter("category");
        String facultyCoordinator = req.getParameter("facultyCoordinator");
        String maxMembersStr = req.getParameter("maxMembers");
        String description = req.getParameter("description");

        if (name == null || name.trim().isEmpty()
                || category == null || category.trim().isEmpty()
                || facultyCoordinator == null || facultyCoordinator.trim().isEmpty()
                || maxMembersStr == null || maxMembersStr.trim().isEmpty()
                || description == null || description.trim().isEmpty()) {

            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "All fields are required.");
            return;
        }

        int maxMembers;

        try {
            maxMembers = Integer.parseInt(maxMembersStr.trim());

            if (maxMembers <= 0) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                        "Maximum members must be greater than zero.");
                return;
            }
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Maximum members must be a valid integer.");
            return;
        }

        Club club = new Club(
                name.trim(),
                category.trim(),
                facultyCoordinator.trim(),
                maxMembers,
                description.trim()
        );

        clubDao.create(club);

        resp.sendRedirect(req.getContextPath() + "/club");
    }
}