package com.bhu.mess.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import com.bhu.mess.model.Menu;
import com.bhu.mess.dao.MenuDAO;

public class AddMenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String day = request.getParameter("day");
        String breakfast = request.getParameter("breakfast");
        String lunch = request.getParameter("lunch");
        String dinner = request.getParameter("dinner");

        Menu menu = new Menu();
        menu.setDay(day);
        menu.setBreakfast(breakfast);
        menu.setLunch(lunch);
        menu.setDinner(dinner);

        boolean success = MenuDAO.addMenu(menu);

        if (success) {
            response.sendRedirect("pages/viewMenu.jsp");
        } else {
            response.sendRedirect("pages/addMenu.jsp?error=true");
        }
    }
}
