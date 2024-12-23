package com.mycompany;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registerForm extends JFrame implements ActionListener {
   
    private JLabel lblTypes, lblSignUp, lblUser, lblPass, lblConfirmPass;
    private JTextField txtUsername;
    private JPasswordField txtPass, txtConfirmPass;
    private JButton btnCreate, btnBack;
    private String user, pass, confirmPass;

    registerForm() {
        //frame setup
        setTitle("Sign up");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // components
        lblSignUp = new JLabel("Sign Up", SwingConstants.CENTER);
        lblSignUp.setBounds(0, 25, 600, 30);
        lblSignUp.setFont(new Font("AvantGarde", Font.BOLD, 22));
        add(lblSignUp);
         
        lblUser = new JLabel("Username:");
        lblUser.setBounds(160, 200, 100, 30);
        lblUser.setFont(new Font("Arial", Font.BOLD, 15));
        add(lblUser);
         
        txtUsername = new JTextField();
        txtUsername.setBounds(250, 200, 140, 30);
        add(txtUsername);
         
        lblPass = new JLabel("Create Password:");
        lblPass.setBounds(110, 250, 150, 30);
        lblPass.setFont(new Font("Arial", Font.BOLD, 15));
        add(lblPass);
         
        txtPass = new JPasswordField();
        txtPass.setBounds(250, 250, 140, 30);
        add(txtPass);
         
        lblConfirmPass = new JLabel("Confirm Password:");
        lblConfirmPass.setBounds(100, 300, 150, 30);
        lblConfirmPass.setFont(new Font("Arial", Font.BOLD, 15));
        add(lblConfirmPass);
         
        txtConfirmPass = new JPasswordField();
        txtConfirmPass.setBounds(250, 300, 140, 30);
        add(txtConfirmPass);
                     
        btnCreate = new JButton("Create");
        btnCreate.setBounds(320, 350, 80, 30);
        add(btnCreate);
         
        btnBack = new JButton("Back");
        btnBack.setBounds(230, 350, 80, 30);
        add(btnBack);
        
        // Add ActionListener
        btnBack.addActionListener(this);
        btnCreate.addActionListener(this);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            new signInScreen();
            dispose();
        
        } else if (e.getSource() == btnCreate) {
             user = txtUsername.getText();
             pass = txtPass.getText(); // Use getPassword() for password field
             confirmPass = txtConfirmPass.getText();
            
        String insert = "INSERT INTO users (idusers, idpass) VALUES ('"+user+"','"+pass+"')";
        String url = "jdbc:mysql://localhost:3306/fitnesstrackerdb"; // Update with your database URL
        String dbUsername = "root"; // Replace with your database username
        String dbPassword = "admin123"; // Replace with your database password
            Connection con;
            if(!user.isEmpty()&&!pass.isEmpty()&&!confirmPass.isEmpty()){
                if(pass.equals(confirmPass)){
            try {
                con = DriverManager.getConnection(url, dbUsername, dbPassword);
                   Statement st = con.createStatement();
                   JOptionPane.showMessageDialog(null, "SUCCESS");
                   txtUsername.setText("");
                   txtPass.setText("");
                   txtConfirmPass.setText("");
            
            st.executeUpdate(insert);
            dispose();
            signup sn = new signup();
            sn.setVisible(true);

            } catch (SQLException ex) {
                Logger.getLogger(registerForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{
                    JOptionPane.showMessageDialog(null, "Password Do not match!", "Error!", JOptionPane.ERROR_MESSAGE);
                txtPass.setText("");
                txtConfirmPass.setText("");
                }
                
                
         }
        }
    }

    // Method to insert user into the database
    private int insertUser(String username, String password) {
        int k = 0;
        String url = "jdbc:mysql://localhost:3306/fitnesstrackerdb"; // Update with your database URL
        String dbUsername = "root"; // Replace with your database username
        String dbPassword = "admin123"; // Replace with your database password

        try (Connection con = DriverManager.getConnection(url, dbUsername, dbPassword)) {
//             SQL query to insert user into the 'users' table
//            PreparedStatement pst = con.prepareStatement("INSERT INTO users (userid, userpass) VALUES (?, ?)");
//            pst.setString(1, username);
//            pst.setString(2, password);
          
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return k;
    }

    public static void main(String[] args) {
        new registerForm();
    }
}
