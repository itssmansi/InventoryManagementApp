package com.Stockify.inventory.main;

import com.Stockify.inventory.db.DBConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.Stockify.inventory.gui.DemoForm;


public class InventoryApp {
    public static void main(String[] args) {
        new DemoForm();
        Connection conn = DBConnection.getConnection();

        if (conn != null) {
            System.out.println("Connection object is not null. Test passed!");

            // Optional: run a simple query to check
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SHOW TABLES;"); // shows tables in DB
                System.out.println("Tables in the database:");
                while (rs.next()) {
                    System.out.println(rs.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.closeConnection(conn);
            }
        } else {
            System.out.println("Connection failed!");
        }
    }
}
