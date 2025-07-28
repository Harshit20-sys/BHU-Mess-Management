package com.bhu.mess.servlet;

import com.bhu.mess.dao.UserDAO;
import com.bhu.mess.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        int age = Integer.parseInt(request.getParameter("age"));

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        user.setId(age);
        user.setRole("student"); // ✅ Set student role explicitly

        boolean success = UserDAO.registerUser(user);

        if (success) {
            response.sendRedirect(request.getContextPath() + "/pages/thankyou.jsp");
        } else {
            response.getWriter().println("Registration failed. Try again.");
        }
    }
}
