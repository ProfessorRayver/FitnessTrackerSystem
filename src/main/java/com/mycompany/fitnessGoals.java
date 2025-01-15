package com.mycompany;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class userProfile extends JFrame implements ActionListener {

    private JButton btnSignOut, btnBack, btnView, btnWorkoutPlan;
    private JLabel UserProfile, lbName, lbBmi, lbWeight, lbHeight, lbBMIcat;
    private JTextField tfName, tfHeight, tfWeight, tfAge, tfBMIcat, tfUsername;
    // DATABASE CON
    private static final String DB_URL = "jdbc:mysql://localhost:3306/fitnesstrackerdb";
    private static final String USER = "root";
    private static final String PASS = "admin123"; 
    private JTextField tfUserId; 

    public userProfile() {
        setTitle("User Profile");
        setSize(600, 550);
        getContentPane().setBackground(new Color(173, 216, 230));
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UserProfile = new JLabel("User Profile");
        UserProfile.setBounds(150, 20, 200, 30);
        add(UserProfile);

        // User ID input
        JLabel lbUserId = new JLabel("Enter User ID:");
        lbUserId.setBounds(50, 70, 200, 30);
        add(lbUserId);

        tfUserId = new JTextField();
        tfUserId.setBounds(170, 70, 100, 30);
        add(tfUserId);

        // Username input
        JLabel lbUsername = new JLabel("Enter Username:");
        lbUsername.setBounds(50, 110, 200, 30);
        add(lbUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(170, 110, 100, 30);
        add(tfUsername);

        lbName = new JLabel("ID:");
        lbName.setBounds(50, 160, 200, 30);
        add(lbName);

        lbWeight = new JLabel("Height:");
        lbWeight.setBounds(50, 210, 200, 30);
        add(lbWeight);

        lbHeight = new JLabel("Weight (Kg):");
        lbHeight.setBounds(50, 260, 200, 30);
        add(lbHeight);

        lbBmi = new JLabel("BMI:");
        lbBmi.setBounds(50, 310, 200, 30);
        add(lbBmi);

        lbBMIcat = new JLabel("Category:");
        lbBMIcat.setBounds(50, 360, 200, 30);
        add(lbBMIcat);

        btnSignOut = new JButton("Sign Out");
        btnSignOut.setBounds(400, 100, 120, 30);
        add(btnSignOut);

        btnBack = new JButton("Back");
        btnBack.setBounds(400, 150, 120, 30);
        add(btnBack);

        btnView = new JButton("View");
        btnView.setBounds(400, 200, 120, 30);
        add(btnView);

        btnWorkoutPlan = new JButton("Active Plan");
        btnWorkoutPlan.setBounds(400, 250, 120, 30);
        add(btnWorkoutPlan);

        // JTextFields for displaying user data
        tfName = new JTextField();
        tfName.setEditable(false);
        tfName.setBounds(170, 160, 100, 30);
        add(tfName);

        tfHeight = new JTextField();
        tfHeight.setEditable(false);
        tfHeight.setBounds(170, 210, 100, 30);
        add(tfHeight);

        tfWeight = new JTextField();
        tfWeight.setEditable(false);
        tfWeight.setBounds(170, 260, 100, 30);
        add(tfWeight);

        tfAge = new JTextField();
        tfAge.setEditable(false);
        tfAge.setBounds(170, 310, 100, 30);
        add(tfAge);

        tfBMIcat = new JTextField();
        tfBMIcat.setEditable(false);
        tfBMIcat.setBounds(170, 360, 100, 30);
        add(tfBMIcat);

        btnSignOut.addActionListener(this);
        btnBack.addActionListener(this);
        btnView.addActionListener(this);
        btnWorkoutPlan.addActionListener(this);
        setVisible(true);
    }

    private void loadUserData(int userId, String username) {
        String query = "SELECT * FROM bmi_data WHERE user_id = ? OR username = ?";
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, userId);
            pstmt.setString(2, username);
            try (ResultSet resultdata = pstmt.executeQuery()) {
                if (resultdata.next()) {
                    tfName.setText(resultdata.getString("user_id"));
                    tfHeight.setText(String.valueOf(resultdata.getDouble("height")));
                    tfWeight.setText(String.valueOf(resultdata.getDouble("weight")));
                    tfAge.setText(String.valueOf(resultdata.getDouble("bmi")));
                    tfBMIcat.setText(resultdata.getString("bmi_category"));
                } else {
                    JOptionPane.showMessageDialog(this, "No data found for the provided User ID or Username.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignOut) {
            new notif().setVisible(true);
            dispose();
        } else if (e.getSource() == btnBack) {
            new mainDashboard().setVisible(true);
            dispose();
        } else if (e.getSource() == btnWorkoutPlan) {
            new viewWorkoutPlan().setVisible(true);
            dispose();
        } else if (e.getSource() == btnView) {
            try {
                int userId = tfUserId.getText().isEmpty() ? -1 : Integer.parseInt(tfUserId.getText());
                String username = tfUsername.getText();
                loadUserData(userId, username);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid User ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new userProfile();
    }
}
