package com.bhu.mess.servlet;

import com.bhu.mess.dao.MenuDAO;
import com.bhu.mess.dao.RegistrationDAO;
import com.bhu.mess.model.Menu;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
public class ViewMyMessMenuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        String studentEmail = (String) session.getAttribute("studentEmail");

        if (studentEmail == null) {
            response.sendRedirect("pages/menu.jsp");
            return;
        }

        int messId = RegistrationDAO.getRegisteredMessIdByStudentEmail(studentEmail);

        if (messId == -1) {
            request.setAttribute("menuList", null);
        } else {
            List<Menu> menuList = MenuDAO.getMenuByMessId(messId);
            request.setAttribute("menuList", menuList);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/menu.jsp");
        dispatcher.forward(request, response);
    }
}
