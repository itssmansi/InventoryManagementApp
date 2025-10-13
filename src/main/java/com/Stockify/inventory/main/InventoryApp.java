package com.Stockify.inventory.main;

import com.Stockify.inventory.db.DBConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.Stockify.inventory.gui.DemoForm;


public class InventoryApp {
    public static void main(String[] args) {
        // try {
        //     // Try to load the MySQL driver
        //     Class.forName("com.mysql.cj.jdbc.Driver");
        //     System.out.println("MySQL JDBC Driver is found! Test passed.");
        // } catch (ClassNotFoundException e) {
        //     System.out.println("MySQL JDBC Driver not found!");
        //     e.printStackTrace();
        // }

        new DemoForm();
        Connection conn = DBConnection.getConnection();

        if (conn != null) {
            System.out.println("Connection object is not null. Test passed!");

            // Here we run a simple query to check if connection is working
            try {
                Statement stmt = conn.createStatement();
                int count = stmt.executeUpdate("INSERT INTO items (item_name, price, category, quantity, brand, supplier_id) \r\n" + //
                                        "VALUES ('TV', 95000.00, 'Electronics', 8, 'Sony', '1')");
                // ResultSet rs = stmt.executeQuery("SHOW TABLES;"); // shows tables in DB inventory
                System.out.println(count + "row/s affected");
                // while (rs.next()) {
                //     System.out.println(rs.getString(1));
                // }
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
