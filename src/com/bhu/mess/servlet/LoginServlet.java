package com.bhu.mess.servlet;

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bhu_mess_management", "root", "89321");

            PreparedStatement ps = con.prepareStatement(
                "SELECT role FROM users WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("role", role);

                // ✅ Redirect to correct dashboard with folder path
                if ("admin".equalsIgnoreCase(role)) {
                	response.sendRedirect(request.getContextPath() + "/pages/adminDashboard.jsp");
                } else if ("student".equalsIgnoreCase(role)) {
                	response.sendRedirect(request.getContextPath() + "/pages/studentDashboard.jsp");
                } else {
                    response.getWriter().println("Unknown role.");
                }
            } else {
                response.getWriter().println("Invalid email or password.");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Login failed due to an internal error.");
        }
    }
}
