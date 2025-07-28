package com.bhu.mess.dao;

import java.sql.*;


public class MessDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bhu_mess_management";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "89321";

    public static int getMessIdByStudentEmail(String studentEmail) {
        int messId = -1;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT mess_id FROM registrations WHERE student_email = ?")) {
            ps.setString(1, studentEmail);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                messId = rs.getInt("mess_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messId;
    }
}