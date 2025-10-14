package com.Stockify.inventory.main;

import javax.swing.SwingUtilities;
import com.Stockify.inventory.backend.LoginPage;
import com.Stockify.inventory.gui.LowStockAlertGUI;
import com.Stockify.inventory.gui.ManageProductsGUI;


public class InventoryApp {
    public static void main(String[] args) {
        //     javax.swing.SwingUtilities.invokeLater(new Runnable() {
        //     public void run() {
        //         new ManageProductsGUI().setVisible(true);
        //     }
        //     });
        // javax.swing.SwingUtilities.invokeLater(() -> new LoginPage());

        // new LowStockAlertGUI();

        SwingUtilities.invokeLater(() -> {
            LoginPage frame = new LoginPage();
            frame.setVisible(true);
        });
    }
}
