package com.mycompany.fitnesstrackapp;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registerForm extends JFrame implements ActionListener {

    private JLabel lblSignUp, lblUser, lblPass, lblConfirmPass, lblAge, lblName, lblSex;
    private JTextField txtUsername, txtName, txtAge, txtSex;
    private JPasswordField txtPass, txtConfirmPass;
    private JButton btnCreate, btnBack;

    registerForm() {
        // Frame setup
        setTitle("Sign up");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(173, 216, 230)); 

        // Components
        lblName = new JLabel("Name:", SwingConstants.CENTER);
        lblName.setBounds(150, 80, 100, 30);
        lblName.setFont(new Font("Verdana", Font.BOLD, 15));
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(250, 80, 140, 30);
        add(txtName);

        lblAge = new JLabel("Age:", SwingConstants.CENTER);
        lblAge.setBounds(150, 120, 100, 30);
        lblAge.setFont(new Font("Verdana", Font.BOLD, 15));
        add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(250, 120, 140, 30);
        add(txtAge);

        lblSex = new JLabel("Sex:", SwingConstants.CENTER);
        lblSex.setBounds(150, 160, 100, 30);
        lblSex.setFont(new Font("Verdana", Font.BOLD, 15));
        add(lblSex);

        txtSex = new JTextField();
        txtSex.setBounds(250, 160, 140, 30);
        add(txtSex);

        lblSignUp = new JLabel("Sign Up", SwingConstants.CENTER);
        lblSignUp.setBounds(0, 25, 600, 30);
        lblSignUp.setFont(new Font("Verdana", Font.BOLD, 22));
        lblSignUp.setForeground(Color.WHITE); 
        add(lblSignUp);

        lblUser = new JLabel("Username:");
        lblUser.setBounds(150, 200, 100, 30);
        lblUser.setFont(new Font("Verdana", Font.BOLD, 15));
        add(lblUser);

        txtUsername = new JTextField();
        txtUsername.setBounds(250, 200, 140, 30);
        add(txtUsername);

        lblPass = new JLabel("Create Password:");
        lblPass.setBounds(100, 250, 150, 30);
        lblPass.setFont(new Font("Verdana", Font.BOLD, 15));
        add(lblPass);

        txtPass = new JPasswordField();
        txtPass.setBounds(250, 250, 140, 30);
        add(txtPass);

        lblConfirmPass = new JLabel("Confirm Password:");
        lblConfirmPass.setBounds(90, 300, 170, 30);
        lblConfirmPass.setFont(new Font("Verdana", Font.BOLD, 15));
        add(lblConfirmPass);

        txtConfirmPass = new JPasswordField();
        txtConfirmPass.setBounds(250, 300, 140, 30);
        add(txtConfirmPass);

        btnCreate = new JButton("Create");
        btnCreate.setBounds(320, 350, 80, 30);
        btnCreate.setBackground(new Color(34, 139, 34)); 
        btnCreate.setForeground(Color.WHITE);
        add(btnCreate);

        btnBack = new JButton("Back");
        btnBack.setBounds(230, 350, 80, 30);
        btnBack.setBackground(new Color(255, 69, 0)); 
        btnBack.setForeground(Color.WHITE);
        add(btnBack);

        // Add ActionListener
        btnBack.addActionListener(this);
        btnCreate.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) { // Redirect to SignIn Page
            new signInScreen();
            dispose();
        } else if (e.getSource() == btnCreate) { // Get and store the input
            String user = txtUsername.getText();
            String pass = new String(txtPass.getPassword());
            String confirmPass = new String(txtConfirmPass.getPassword());
            String name = txtName.getText();
            String ageText = txtAge.getText();
            String sex = txtSex.getText();

            if (user.isEmpty() || pass.isEmpty() || confirmPass.isEmpty() || name.isEmpty() || ageText.isEmpty() || sex.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Warning if there is no/incomplete input
            }
            if (sex.matches(".*\\d.*")) {
                JOptionPane.showMessageDialog(this, "Invalid sex. Please enter letters only.", "Error", JOptionPane.ERROR_MESSAGE);
                txtSex.setText("");
                return;
            }

            int age;
            try {
                age = Integer.parseInt(ageText);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid age. Please enter a number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!pass.equals(confirmPass)) {
                JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
                txtPass.setText("");
                txtConfirmPass.setText("");
                return;
            }

            String url = "jdbc:mysql://localhost:3306/fitnesstrackerdb";
            String dbUsername = "root";
            String dbPassword = "admin123";

            try (Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
                 PreparedStatement pst = con.prepareStatement("INSERT INTO users (idusers, idpass, name, age, sex) VALUES (?, ?, ?, ?, ?)")) {

                pst.setString(1, user);
                pst.setString(2, pass);
                pst.setString(3, name);
                pst.setInt(4, age);
                pst.setString(5, sex);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "User registered successfully!");
                txtUsername.setText("");
                txtPass.setText("");
                txtConfirmPass.setText("");
                txtName.setText("");
                txtAge.setText("");
                txtSex.setText("");

                new fitnessGoals(); 
                dispose(); 

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new registerForm();
    }
}
