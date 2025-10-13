package com.Stockify.inventory.db;

import com.Stockify.inventory.db.DBConnection;
import com.Stockify.inventory.model.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LowStockAlert {

    private static final int THRESHOLD = 5; // You can change the low-stock limit


    public ArrayList<Products> getLowStockProducts() {
        ArrayList<Products> lowStockList = new ArrayList<>();
        String low_stock_alert_query = "SELECT * FROM items WHERE quantity <= ?";

        try (Connection conn = DBConnection.getConnection();
                PreparedStatement pst = conn.prepareStatement(low_stock_alert_query)) {

            pst.setInt(1, THRESHOLD);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Products p = new Products(
                        rs.getInt("item_id"),
                        rs.getString("item_name"),
                        rs.getDouble("price"),
                        rs.getString("category"),
                        rs.getInt("quantity"),
                        rs.getString("brand"),
                        rs.getInt("supplier_id"));
                lowStockList.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lowStockList;
    }
}
