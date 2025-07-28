package com.bhu.mess.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bhu.mess.model.User;

public class UserDAO {

    private static final String DB_URL = null;
	private static final String DB_USER = null;
	private static final String DB_PASSWORD = null;

	public static boolean registerUser(User user) {
        boolean status = false;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to your database
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bhu_mess_management", "root", "89321");

            // Prepare SQL insert query
            String query = "INSERT INTO users(name, email, password, role, age) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.setInt(5, user.getId());

            // Execute and check if insert was successful
            int rows = ps.executeUpdate();
            if (rows > 0) {
                status = true;
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();  // Shows exact error in Console
        }

        return status;
    }

	public static List<User> getAllStudents() {
	    List<User> list = new ArrayList<>();
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	        String query = "SELECT * FROM users WHERE role = 'student'";
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            User user = new User();
	            user.setId(rs.getInt("id"));
	            user.setName(rs.getString("name"));
	            user.setEmail(rs.getString("email"));
	            user.setPhone(rs.getString("phone"));
	            user.setId(rs.getInt("age"));
	            user.setRole(rs.getString("role"));
	            list.add(user);
	        }
	        con.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}

    
}
