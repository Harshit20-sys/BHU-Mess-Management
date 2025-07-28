package com.bhu.mess.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bhu.mess.model.Menu;

public class MenuDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bhu_mess_management";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "89321";

    // Method to update existing menu
    public static boolean updateMenu(Menu menu) {
        boolean success = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String query = "UPDATE menu SET breakfast = ?, lunch = ?, dinner = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, menu.getBreakfast());
            ps.setString(2, menu.getLunch());
            ps.setString(3, menu.getDinner());
            ps.setInt(4, menu.getId());

            int row = ps.executeUpdate();
            success = row > 0;

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }


    // Method to add a new menu
    public static boolean addMenu(Menu menu) {
        boolean inserted = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String query = "INSERT INTO menu (day, breakfast, lunch, dinner) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, menu.getDay());
            ps.setString(2, menu.getBreakfast());
            ps.setString(3, menu.getLunch());
            ps.setString(4, menu.getDinner());

            int rowsInserted = ps.executeUpdate();
            inserted = rowsInserted > 0;

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inserted;
    }

    // (Optional) Fetch a menu for a specific day
    public static Menu getMenuByDay(String day) {
        Menu menu = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhu_mess_management", "root", "89321");

            String query = "SELECT * FROM menu WHERE day = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, day);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                menu = new Menu();
                menu.setId(rs.getInt("id"));
                menu.setDay(rs.getString("day"));
                menu.setBreakfast(rs.getString("breakfast"));
                menu.setLunch(rs.getString("lunch"));
                menu.setDinner(rs.getString("dinner"));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menu;
    }
    
    public static List<Menu> getAllMenus() {
        List<Menu> menuList = new ArrayList<>();

        String query = "SELECT * FROM menu ORDER BY id";

        try (
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setId(rs.getInt("id"));
                menu.setDay(rs.getString("day"));
                menu.setBreakfast(rs.getString("breakfast"));
                menu.setLunch(rs.getString("lunch"));
                menu.setDinner(rs.getString("dinner"));
                menuList.add(menu);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching menu list: " + e.getMessage());
            e.printStackTrace();
        }

        return menuList;
    }


    public static List<Menu> getMenuByMessId(int messId) {
        List<Menu> list = new ArrayList<>();
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM menu WHERE mess_id = ? ORDER BY id ASC")) {
            ps.setInt(1, messId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Menu m = new Menu();
                m.setDay(rs.getString("day"));
                m.setBreakfast(rs.getString("breakfast"));
                m.setLunch(rs.getString("lunch"));
                m.setDinner(rs.getString("dinner"));
                list.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
