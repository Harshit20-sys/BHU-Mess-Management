package com.bhu.mess.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bhu.mess.model.MessOwner;

public class MessOwnerDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/bhu_mess_management";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "89321";

    public static boolean registerMessOwner(MessOwner owner) {
        boolean success = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String query = "INSERT INTO mess_owners (name, email, password, mess_name) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, owner.getName());
            ps.setString(2, owner.getEmail());
            ps.setString(3, owner.getPassword());
            ps.setString(4, owner.getMessName());

            int row = ps.executeUpdate();
            success = row > 0;

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return success;
    }

    public static MessOwner getOwnerByEmailAndPassword(String email, String password) {
        MessOwner owner = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String query = "SELECT * FROM mess_owners WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                owner = new MessOwner();
                owner.setId(rs.getInt("id"));
                owner.setName(rs.getString("name"));
                owner.setEmail(rs.getString("email"));
                owner.setPassword(rs.getString("password"));
                owner.setMessName(rs.getString("mess_name"));
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return owner;
    }
    public static List<MessOwner> getAllMessOwners() {
        List<MessOwner> owners = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("DB_URL: " + DB_URL);

            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String query = "SELECT * FROM mess_owners";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MessOwner owner = new MessOwner();
                owner.setId(rs.getInt("id"));
                owner.setName(rs.getString("name"));
                owner.setEmail(rs.getString("email"));
                owner.setPassword(rs.getString("password"));
                owner.setMessName(rs.getString("mess_name"));
                owners.add(owner);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return owners;
    }

}
