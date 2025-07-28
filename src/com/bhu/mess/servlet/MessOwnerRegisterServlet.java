package com.bhu.mess.servlet;

import com.bhu.mess.dao.MessOwnerDAO;
import com.bhu.mess.model.MessOwner;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class MessOwnerRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String messName = request.getParameter("messName");
        @SuppressWarnings("unused")
		String messAddress = request.getParameter("messAddress");

        MessOwner owner = new MessOwner();
        owner.setName(name);
        owner.setEmail(email);
        owner.setPassword(password);
        owner.setMessName(messName);
        

        boolean success = MessOwnerDAO.registerMessOwner(owner);

        if (success) {
        	response.sendRedirect("pages/messOwnerLogin.jsp?success=registered");

        } else {
        	response.sendRedirect("pages/mess_owner_register.jsp?error=failed");

        }
    }
}
