package com.bhu.mess.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/BHU_MESS_MANAGEMENT";
    private static final String USER = "root"; // Change if your MySQL user is different
    private static final String PASSWORD = "89321"; // Put your actual MySQL password here

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // For MySQL 8.x
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found.");
        }
    }
}
