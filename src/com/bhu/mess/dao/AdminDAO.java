package com.bhu.mess.dao;

import java.sql.*;
import com.bhu.mess.model.Admin;

public class AdminDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/bhu_mess_management";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "89321";

    public static Admin getAdminByEmailAndPassword(String email, String password) {
        Admin admin = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String query = "SELECT * FROM admin WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return admin;
    }
}
