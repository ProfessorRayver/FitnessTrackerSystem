/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class SignOut extends JFrame implements ActionListener {

    private JScrollPane scrollpane;
    private JButton btnSignOut, btnBack;
    private JLabel UserProfile, lbName, lbBmi, lbIntensity;
    private Connection con;

    public SignOut() {
        setTitle("SignOut");
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UserProfile = new JLabel("User Profile");
        UserProfile.setBounds(150, 40, 200, 30);
        add(UserProfile);

        btnSignOut = new JButton("SignOut");
        btnSignOut.setBounds(400, 100, 120, 30);
        add(btnSignOut);

        btnBack = new JButton("Back");
        btnBack.setBounds(400, 150, 120, 30);
        add(btnBack);

        lbName = new JLabel("Name:");
        lbName.setBounds(50, 100, 200, 30);
        add(lbName);

        lbBmi = new JLabel("BMI:");
        lbBmi.setBounds(50, 150, 200, 30);
        add(lbBmi);

        lbIntensity = new JLabel("Intensity:");
        lbIntensity.setBounds(50, 200, 200, 30);
        add(lbIntensity);

        btnSignOut.addActionListener(this);
        btnBack.addActionListener(this);

        initializeDatabaseConnection();
        fetchUserData();

        setVisible(true);
    }

    private void initializeDatabaseConnection() {
        String url = "jdbc:mysql://localhost:3306/fitnesstrackerdb";
        String username = "root";
        String password = "admin123";

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(SignOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetchUserData() {
        String query = "SELECT name, bmi, intensity FROM useprof";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query)) {
            if (rs.next()) {
                lbName.setText("Name: " + rs.getString("name"));
                lbBmi.setText("BMI: " + rs.getString("bmi"));
                lbIntensity.setText("Intensity: " + rs.getString("intensity"));
            } else {
                JOptionPane.showMessageDialog(this, "No data found!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignOut) {
            new signInScreen().setVisible(true);
            dispose();
        } else if (e.getSource() == btnBack) {
            new mainDashboard().setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        new SignOut();
    }
}
