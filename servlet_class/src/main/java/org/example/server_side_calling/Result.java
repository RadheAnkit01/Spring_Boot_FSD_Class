package org.example.server_side_calling;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class Result extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello from Result class");
        resp.setContentType("text/html");

//        ---------------- Using re
//        Integer num1 = Integer.parseInt(req.getParameter("num1"));
//        Integer num2 = Integer.parseInt(req.getParameter("num2"));

//        ------------------ Using Session ------------
//        HttpSession session = req.getSession();
//        int num1 = (int)session.getAttribute("num1");
//        int num2 = (int)session.getAttribute("num2");


//       --------------------  Using Cookies -----------------
        Cookie[] cookies = req.getCookies();

        int num1 = 0;
        int num2 = 0;
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("cNum1") ){
                num1 = Integer.parseInt(cookie.getValue());
            }
            if(cookie.getName().equals("cNum2") ) {
                num2 = Integer.parseInt(cookie.getValue());
            }
        }


        PrintWriter printWriter = resp.getWriter();
        req.getRequestDispatcher("header.html").include(req,resp);
        printWriter.println("<h1> Sum of %s and %s is : %s</h1>".formatted(num1,num2,num1+num2));
        req.getRequestDispatcher("footer.html").include(req,resp);
    }
}
