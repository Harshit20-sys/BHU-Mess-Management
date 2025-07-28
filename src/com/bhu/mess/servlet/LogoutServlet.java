package com.bhu.mess.servlet;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.*;


public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L; // avoid warning

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Invalidate the current session
        HttpSession session = request.getSession(false); // false = don’t create if doesn’t exist
        if (session != null) {
            session.invalidate(); // logs out the user
        }

        // Redirect to login page
        response.sendRedirect("login.jsp");
    }
}
