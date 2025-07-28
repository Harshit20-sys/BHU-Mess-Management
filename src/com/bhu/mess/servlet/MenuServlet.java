package com.bhu.mess.servlet;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.bhu.mess.model.Menu;

@SuppressWarnings("serial")
public class MenuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Menu> menuList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhu_mess_management", "root", "89321");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM menu");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Menu menu = new Menu();
                menu.setId(rs.getInt("id"));
                menu.setDay(rs.getString("day"));
                menu.setBreakfast(rs.getString("breakfast"));
                menu.setLunch(rs.getString("lunch"));
                menu.setDinner(rs.getString("dinner"));
                menuList.add(menu);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("menuList", menuList);
        RequestDispatcher rd = request.getRequestDispatcher("/pages/menu.jsp");
        rd.forward(request, response);
        
        
    }
}
