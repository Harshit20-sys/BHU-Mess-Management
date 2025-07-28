package com.bhu.mess.dao;

import com.bhu.mess.model.MessRegistration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bhu_mess_management";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "89321";

    public static List<MessRegistration> getAllRegistrations() {
        List<MessRegistration> list = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String query = "SELECT * FROM mess_registration";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MessRegistration reg = new MessRegistration();
                reg.setId(rs.getInt("id"));
                reg.setEmail(rs.getString("email"));
                reg.setMessName(rs.getString("mess_name"));
                reg.setJoiningDate(rs.getDate("joining_date"));
                reg.setMealType(rs.getString("meal_type"));
                list.add(reg);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

	public static int getRegisteredMessIdByStudentEmail(String email) {
    int messId = -1;
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement ps = conn.prepareStatement(
             "SELECT mess_id FROM registrations WHERE student_email = ?")) {
        ps.setString(1, email);
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
