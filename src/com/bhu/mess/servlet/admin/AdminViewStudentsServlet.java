package com.bhu.mess.servlet.admin;

import com.bhu.mess.dao.UserDAO;
import com.bhu.mess.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
public class AdminViewStudentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<User> students = UserDAO.getAllStudents();

        if (students != null && !students.isEmpty()) {
            request.setAttribute("students", students);
        } else {
            request.setAttribute("error", "No student records found.");
        }

        request.getRequestDispatcher("/pages/viewAllStudents.jsp").forward(request, response);
    }
}
