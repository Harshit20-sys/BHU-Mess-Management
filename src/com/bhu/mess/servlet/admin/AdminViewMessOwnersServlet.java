package com.bhu.mess.servlet.admin;

import com.bhu.mess.dao.MessOwnerDAO;
import com.bhu.mess.model.MessOwner;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("serial")
public class AdminViewMessOwnersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<MessOwner> owners = MessOwnerDAO.getAllMessOwners();

        request.setAttribute("messOwners", owners);
        request.getRequestDispatcher("/pages/viewAllMessOwners.jsp").forward(request, response);
    }
}
