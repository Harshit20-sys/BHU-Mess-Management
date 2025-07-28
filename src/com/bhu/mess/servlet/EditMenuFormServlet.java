package com.bhu.mess.servlet;

import com.bhu.mess.dao.MenuDAO;
import com.bhu.mess.model.Menu;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class EditMenuFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String day = request.getParameter("day");
        System.out.println("Requested Day: " + day);

        if (day == null || day.trim().isEmpty()) {
            request.setAttribute("error", "No day provided to edit menu.");
            request.getRequestDispatcher("/pages/editMenu.jsp").forward(request, response);
            return;
        }

        Menu menu = MenuDAO.getMenuByDay(day);

        if (menu != null) {
            request.setAttribute("menu", menu);
        } else {
            request.setAttribute("error", "No menu data found to edit. Please go back and try again.");
        }

        request.getRequestDispatcher("/pages/editMenu.jsp").forward(request, response);
    }
}
