package com.mycompany;

import java.awt.FlowLayout;
import java.awt.Font;
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
        // ADD JOPTIONPANE
        JOptionPane.showMessageDialog(this, "Welcome to StudFit Tracker!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);

        setSize(800, 650);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ADD CONTENTS
        lblWelcome = new JLabel("WELCOME");
        lblWelcome.setBounds(270, 50, 800, 50);
        lblWelcome.setFont(new Font("Courier", Font.PLAIN, 45));
        add(lblWelcome);

        lblUser = new JLabel("User/Account Name:");
        lblUser.setBounds(50, 200, 800, 50);
        lblUser.setFont(new Font("Courier", Font.PLAIN, 20));
        add(lblUser);

        txtFldUsername = new JTextField();
        txtFldUsername.setBounds(300, 200, 300, 50);
        add(txtFldUsername);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(50, 300, 800, 50);
        lblPassword.setFont(new Font("Courier", Font.PLAIN, 20));
        add(lblPassword);

        txtPasswordFld = new JPasswordField();
        txtPasswordFld.setBounds(300, 300, 300, 50);
        add(txtPasswordFld);

        // ADD BUTTONS
        signIn = new JButton("Sign In");
        registerIn = new JButton("Register");
        bgButton = new JPanel();
        bgButton.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bgButton.setBounds(270, 400, 250, 100);
        bgButton.add(signIn);
        bgButton.add(registerIn);

        add(bgButton);

        revalidate();
        repaint();

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
                    new mainDashboard(); // Redirect to mainDashboard
                    setVisible(false);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Username or Password!", "Failed!", JOptionPane.ERROR_MESSAGE);
                    txtFldUsername.setText(""); // to show warning about wrong info
                    txtPasswordFld.setText("");
                }
            } else {                                // warning msg if no info is given by the user
                JOptionPane.showMessageDialog(this, "Please Input Username and Password!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } else if(e.getSource() == registerIn){
            new registerForm();
            dispose();
        }
    }

    

    // Method to validate user login from the database
    private boolean validateLogin(String username, String password) {
        boolean isValid = false;
        String url = "jdbc:mysql://localhost:3306/fitnesstrackerdb"; // Update with your database name
        String dbUsername = "root"; // Replace with your database username
        String dbPassword = "admin123"; // Replace with your database password

        try {
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE idusers = ? AND idpass = ?");
            pst.setString(1, username);
            pst.setString(2, password);

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
