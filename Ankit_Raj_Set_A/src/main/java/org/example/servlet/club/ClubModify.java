package org.example.servlet.club;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.ClubDao;
import org.example.model.Club;
import org.example.model.Student;

import java.io.IOException;
@WebServlet("/club/modify")
public class ClubModify extends HttpServlet {
    private final ClubDao clubDao = new ClubDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        long id;
        int maxMembers;

        try {
            id = Long.parseLong(req.getParameter("id"));
            maxMembers = Integer.parseInt(req.getParameter("maxMembers"));
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Invalid club ID or maximum members.");
            return;
        }

        String name = req.getParameter("name");
        String category = req.getParameter("category");
        String facultyCoordinator = req.getParameter("facultyCoordinator");
        String description = req.getParameter("description");

        if (name == null || name.trim().isEmpty()
                || category == null || category.trim().isEmpty()
                || facultyCoordinator == null || facultyCoordinator.trim().isEmpty()
                || description == null || description.trim().isEmpty()
                || maxMembers <= 0) {

            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "All fields are required and maximum members must be positive.");
            return;
        }

        Club club = clubDao.findById(id);

        if (club == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,
                    "Club not found.");
            return;
        }

        club.setName(name.trim());
        club.setCategory(category.trim());
        club.setFacultyCoordinator(facultyCoordinator.trim());
        club.setMaxMembers(maxMembers);
        club.setDescription(description.trim());

        clubDao.update(club);

        resp.sendRedirect(req.getContextPath() + "/club");
    }
}