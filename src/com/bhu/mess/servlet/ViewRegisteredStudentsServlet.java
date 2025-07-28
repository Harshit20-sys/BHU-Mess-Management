package com.bhu.mess.servlet;

import com.bhu.mess.dao.RegistrationDAO;
import com.bhu.mess.model.MessRegistration;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
public class ViewRegisteredStudentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<MessRegistration> registrations = RegistrationDAO.getAllRegistrations();

        if (registrations != null) {
            request.setAttribute("studentList", registrations);
            RequestDispatcher dispatcher = request.getRequestDispatcher("pages/viewAllRegistrations.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("pages/viewAllRegistrations.jsp?error=nodata");
        }
    }
}
