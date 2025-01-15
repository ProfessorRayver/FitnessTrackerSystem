package com.mycompany;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class userProfile extends JFrame implements ActionListener {

        private JButton btnSignOut, btnBack, btnView, btnWorkoutPlan;
        private JLabel UserProfile, lbName, lbBmi, lbWeight, lbHeight, lbBMIcat;
        private JTextField tfName, tfHeight, tfWeight, tfAge, tfBMIcat;
        // DATABASE CON
        private static final String DB_URL = "jdbc:mysql://localhost:3306/fitnesstrackerdb";
        private static final String USER = "root";
        private static final String PASS = "admin123"; 
        private JTextField tfUserId; 

        public userProfile() {
        setTitle("User Profile");
        setSize(600, 500);
        getContentPane().setBackground(new Color(173, 216,230));
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

        lbName = new JLabel("ID:");
        lbName.setBounds(50, 120, 200, 30);
        add(lbName);

        lbWeight = new JLabel("Height:");
        lbWeight.setBounds(50, 170, 200, 30);
        add(lbWeight);

        lbHeight = new JLabel("Weight (Kg):");
        lbHeight.setBounds(50, 220, 200, 30);
        add(lbHeight);

        lbBmi = new JLabel("BMI:");
        lbBmi.setBounds(50, 270, 200, 30);
        add(lbBmi);

        lbBMIcat = new JLabel("Category:");
        lbBMIcat.setBounds(50, 320, 200, 30);
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
        tfName.setBounds(170, 120, 100, 30);
        add(tfName);

        tfHeight = new JTextField();
        tfHeight.setEditable(false);
        tfHeight.setBounds(170, 170, 100, 30);
        add(tfHeight);

        tfWeight = new JTextField();
        tfWeight.setEditable(false);
        tfWeight.setBounds(170, 220, 100, 30);
        add(tfWeight);

        tfAge = new JTextField();
        tfAge.setEditable(false);
        tfAge.setBounds(170, 270, 100, 30);
        add(tfAge);

        tfBMIcat = new JTextField();
        tfBMIcat.setEditable(false);
        tfBMIcat.setBounds(170, 320, 100, 30);
        add(tfBMIcat);

        btnSignOut.addActionListener(this);
        btnBack.addActionListener(this);
        btnView.addActionListener(this);
        btnWorkoutPlan.addActionListener(this);
        setVisible(true);
    }

        private void loadUserData(int userId) {
            String query = "SELECT * FROM bmi_data WHERE user_id = ?";
            try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
                 PreparedStatement pstmt = con.prepareStatement(query)) {

                pstmt.setInt(1, userId); 
                try (ResultSet resultdata = pstmt.executeQuery()) {
                    if (resultdata.next()) {
                        tfName.setText(resultdata.getString("user_id"));
                        tfHeight.setText(String.valueOf(resultdata.getDouble("height")));
                        tfWeight.setText(String.valueOf(resultdata.getDouble("weight")));
                        tfAge.setText(String.valueOf(resultdata.getDouble("bmi"))); 
                        tfBMIcat.setText(resultdata.getString("bmi_category"));
                    } else {
                        JOptionPane.showMessageDialog(this, "No data found for User ID: " + userId, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
//functions
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
            }else if (e.getSource() == btnView) {
                try {
                    int userId = Integer.parseInt(tfUserId.getText());
                    loadUserData(userId);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid User ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
//main
        public static void main(String[] args) {
            new userProfile();
}
}