package com.mycompany;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class signInScreen extends JFrame implements ActionListener {

    private JLabel lblWelcome, lblUser, lblPassword;
    private JTextField txtFldUsername;
    private JButton signIn, registerIn;
    private JPanel bgButton;
    private JPasswordField txtPasswordFld;

    signInScreen() {
        // Add a welcome message
        JOptionPane.showMessageDialog(this, "Welcome to StudFit Tracker!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);

        // Frame settings
        setTitle("Sign In");
        setSize(800, 650);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(173, 216, 230)); 

        // Welcome label
        lblWelcome = new JLabel("WELCOME", SwingConstants.CENTER);
        lblWelcome.setBounds(0, 50, 800, 50);
        lblWelcome.setFont(new Font("Impact", Font.BOLD, 50));
        lblWelcome.setForeground(Color.BLACK);
        add(lblWelcome);

        // Username label
        lblUser = new JLabel("User Account:");
        lblUser.setBounds(50, 200, 800, 50);
        lblUser.setFont(new Font("Arial", Font.BOLD, 20));
        lblUser.setForeground(Color.BLACK);
        add(lblUser);

        // Password label
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 300, 800, 50);
        lblPassword.setFont(new Font("Arial", Font.BOLD, 20));
        lblPassword.setForeground(Color.BLACK);
        add(lblPassword);

        // Username text field
        txtFldUsername = new JTextField();
        txtFldUsername.setBounds(300, 200, 300, 50);
        txtFldUsername.setFont(new Font("Arial", Font.PLAIN, 18));
        add(txtFldUsername);

        // Password field
        txtPasswordFld = new JPasswordField();
        txtPasswordFld.setBounds(300, 300, 300, 50);
        txtPasswordFld.setFont(new Font("Arial", Font.PLAIN, 18));
        add(txtPasswordFld);

        // Buttons
        signIn = new JButton("Sign In");
        signIn.setFont(new Font("Arial", Font.BOLD, 18));
        signIn.setBackground(new Color(34, 139, 34)); 
        signIn.setForeground(Color.WHITE);

        registerIn = new JButton("Register");
        registerIn.setFont(new Font("Arial", Font.BOLD, 18));
        registerIn.setBackground(new Color(70, 130, 180)); 
        registerIn.setForeground(Color.WHITE);

        // Button panel
        bgButton = new JPanel();
        bgButton.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bgButton.setBounds(270, 400, 250, 100);
        bgButton.setOpaque(false); 
        bgButton.add(signIn);
        bgButton.add(registerIn);

        add(bgButton);

        revalidate();
        repaint();

        // Add action listeners
        signIn.addActionListener(this);
        registerIn.addActionListener(this);
    }

    public static void main(String[] args) {
        signInScreen signInScreen = new signInScreen();
        signInScreen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signIn) {
            String userID = txtFldUsername.getText();
            String pass = new String(txtPasswordFld.getPassword());

            if (!userID.isEmpty() || !pass.isEmpty()) {
                if (validateLogin(userID, pass)) {
                    JOptionPane.showMessageDialog(this, "Login Successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                    mainDashboard dashboard = new mainDashboard();       
                    dashboard.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Username or Password!", "Failed!", JOptionPane.ERROR_MESSAGE);
                    txtFldUsername.setText(""); 
                    txtPasswordFld.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Input Username and Password!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == registerIn) {
            new registerForm();
            dispose();
        }
    }

    private boolean validateLogin(String username, String password) {
        boolean isValid = false;
        String url = "jdbc:mysql://localhost:3306/fitnesstrackerdb"; 
        String dbUsername = "root"; 
        String dbPassword = "admin123"; 

        try {
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE idusers = ? AND idpass = ?");
            pst.setString(1, username);
            pst.setString(2, password);
            
            
            //get the idusers then input the idusers to the next frame
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                isValid = true;
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return isValid;
    }
}