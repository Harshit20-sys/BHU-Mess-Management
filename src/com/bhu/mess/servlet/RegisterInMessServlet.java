package com.bhu.mess.servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;

import javax.servlet.http.*;


public class RegisterInMessServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String messName = request.getParameter("messName");
        String joiningDate = request.getParameter("joiningDate");
        String mealType = request.getParameter("mealType");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bhu_mess_management", "root", "89321");

            // ✅ Correct SQL Query
            String sql = "INSERT INTO mess_registration (email, mess_name, joining_date, meal_type) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, messName);
            ps.setDate(3, Date.valueOf(joiningDate)); // converting String to SQL Date
            ps.setString(4, mealType);

            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
            	response.sendRedirect(request.getContextPath() + "/pages/thankyou.jsp");
            } else {
                response.getWriter().println("Registration failed. Please try again.");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Internal error: " + e.getMessage());
        }
    }
}
