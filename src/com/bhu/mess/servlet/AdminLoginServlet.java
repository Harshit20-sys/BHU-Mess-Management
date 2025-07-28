package com.bhu.mess.servlet;

import com.bhu.mess.dao.AdminDAO;
import com.bhu.mess.model.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        @SuppressWarnings("unused")
		Admin admin = AdminDAO.getAdminByEmailAndPassword(email, password);

        if (email.equals("harshit20@bhu.ac.in") && password.equals("89321")) {
            HttpSession session = request.getSession();
            session.setAttribute("adminEmail", email);
            response.sendRedirect("pages/adminDashboard.jsp");
        } else {
            response.sendRedirect("pages/adminLogin.jsp?error=invalid");
        }

    }
}
