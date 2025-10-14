package com.Stockify.inventory.main;

import javax.swing.SwingUtilities;
import com.Stockify.inventory.backend.LoginPage;
import com.Stockify.inventory.gui.LowStockAlertGUI;
import com.Stockify.inventory.gui.ManageProductsGUI;
import com.Stockify.inventory.gui.EnhancedManageProductsGUI;


public class InventoryApp {
    public static void main(String[] args) {
        // Launch the enhanced product management GUI
        SwingUtilities.invokeLater(() -> {
            new EnhancedManageProductsGUI().setVisible(true);
        });
        
        // Alternative: Launch login page first
        // SwingUtilities.invokeLater(() -> {
        //     LoginPage frame = new LoginPage();
        //     frame.setVisible(true);
        // });
        
        // Alternative: Launch low stock alert
        // new LowStockAlertGUI();
        
        // Alternative: Launch original product manager
        // SwingUtilities.invokeLater(() -> {
        //     new ManageProductsGUI().setVisible(true);
        // });
    }
}
