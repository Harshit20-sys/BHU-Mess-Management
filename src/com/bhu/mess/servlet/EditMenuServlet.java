package com.bhu.mess.servlet;

import com.bhu.mess.dao.MenuDAO;
import com.bhu.mess.model.Menu;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class EditMenuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch form parameters
        int id = Integer.parseInt(request.getParameter("id"));
        String day = request.getParameter("day");
        String breakfast = request.getParameter("breakfast");
        String lunch = request.getParameter("lunch");
        String dinner = request.getParameter("dinner");

        // Populate Menu object
        Menu menu = new Menu();
        menu.setId(id);
        menu.setDay(day);
        menu.setBreakfast(breakfast);
        menu.setLunch(lunch);
        menu.setDinner(dinner);

        // Call DAO to update menu
        boolean success = MenuDAO.updateMenu(menu);

        if (success) {
            // Redirect to view menu with success message
            response.sendRedirect("pages/viewMenu.jsp?success=updated");
        } else {
            // Redirect back with error
            response.sendRedirect("pages/editMenu.jsp?error=update_failed");
        }
    }
}
