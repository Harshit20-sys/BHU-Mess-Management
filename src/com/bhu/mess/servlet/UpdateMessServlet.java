package com.bhu.mess.servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;

import javax.servlet.http.*;


public class UpdateMessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("email");

        String messName = request.getParameter("messName");
        String joiningDate = request.getParameter("joiningDate");
        String mealType = request.getParameter("mealType");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhu_mess_management", "root", "89321");

            PreparedStatement ps = con.prepareStatement(
                "UPDATE mess_registration SET mess_name=?, joining_date=?, meal_type=? WHERE email=?");

            ps.setString(1, messName);
            ps.setString(2, joiningDate);
            ps.setString(3, mealType);
            ps.setString(4, email);

            int i = ps.executeUpdate();

            if (i > 0) {
            	response.sendRedirect(request.getContextPath() + "/pages/viewMessRegistration.jsp");

            } else {
                response.getWriter().println("Update failed. Try again.");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Internal error during update.");
        }
    }
}
