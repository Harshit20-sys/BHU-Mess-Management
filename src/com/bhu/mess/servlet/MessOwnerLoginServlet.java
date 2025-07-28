package com.bhu.mess.servlet;

import com.bhu.mess.dao.MessOwnerDAO;
import com.bhu.mess.model.MessOwner;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class MessOwnerLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("Login attempt: " + email + " / " + password);

        MessOwner owner = MessOwnerDAO.getOwnerByEmailAndPassword(email, password);

        if (owner != null) {
            // ✅ Successful Login
            HttpSession session = request.getSession();
            session.setAttribute("messOwner", owner);
            response.sendRedirect("pages/messOwnerDashboard.jsp");
        } else {
            // ❌ Login Failed
        	response.sendRedirect("pages/messOwnerLogin.jsp?error=invalid");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.sendRedirect("pages/messOwnerLogin.jsp");

    }
}
