package org.example.server_side_calling;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/add")
public class Add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello from Add class");


//        Double POsting Problem
//        RequestDispatcher rd = req.getRequestDispatcher("result");
//        rd.forward(req,resp);

//      ----------------------  Solving Double Posting Problem ------------------
//      -------------  Using Http Session management -----
        Integer num1 = Integer.parseInt(req.getParameter("num1"));
        Integer num2 = Integer.parseInt(req.getParameter("num2"));

//      ----------------  Using Cookies --------------
        Cookie cNum1 = new Cookie("cNum1", req.getParameter("num1"));
        Cookie cNum2 = new Cookie("cNum2", req.getParameter("num2"));



        HttpSession session = req.getSession();
//        session.setAttribute("num1",num1);
//        session.setAttribute("num2",num2);

        resp.addCookie(cNum1);
        resp.addCookie(cNum2);


        resp.sendRedirect("result");
    }
}
