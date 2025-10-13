package com.Stockify.inventory.backend;

import javax.swing.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {

    JTextField user;
    JPasswordField pass;
    JButton login;

    public LoginPage() {
        // Initialize components
        user = new JTextField();
        pass = new JPasswordField();
        login = new JButton("Login");

        // Set position and size
        user.setBounds(50, 50, 150, 30);
        pass.setBounds(50, 100, 150, 30);
        login.setBounds(50, 150, 100, 30);

        // Add components to frame
        add(user);
        add(pass);
        add(login);

        // Add action listener to button
        login.addActionListener(this);

        // Frame settings
        setTitle("Login Form");
        setSize(300, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = user.getText();
        String password = new String(pass.getPassword());

        // Simple hardcoded check
        if (username.equals("admin") && password.equals("123")) {
            JOptionPane.showMessageDialog(this, "Login Successful");
            // Open the home page
            // new HomePage();
            // Close the login form
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Login Failed");
        }
    }
}