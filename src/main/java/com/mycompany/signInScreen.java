/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackapp;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
/**
 *
 * @author colad
 */
public class signInScreen extends JFrame implements ActionListener{
    
private JLabel lblWelcome, lblUser, lblPassword;
   private JTextField txtFldUsername;
   private JButton signIn, registerIn;
   private JPanel bgButton;
private JPasswordField txtPasswordFld;
        
    signInScreen(){

        //ADD JOPTIONPANE
        JOptionPane.showMessageDialog(this, "Welcome to StudFit Tracker!", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
        
        setSize(800, 650);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //ADD CONTENTS
        
        // USERNAME = group7
        // PASSWORD = admin123
        
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
        
        //ADD BUTTONS
        
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
        if(e.getSource() == signIn){
            String userID = txtFldUsername.getText();
            String pass = txtPasswordFld.getText();
            if(!userID.isEmpty() || !pass.isEmpty()){
            if(userID.equalsIgnoreCase("group7") && pass.equalsIgnoreCase("admin123")){
                JOptionPane.showMessageDialog(this, "Login Sucessfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
                new mainDashboard();
                setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Wrong User and Pass!", "Failed!", JOptionPane.ERROR_MESSAGE);
                txtFldUsername.setText("");
                txtPasswordFld.setText("");
            }
            }else{
                JOptionPane.showMessageDialog(this, "Please Input User and Pass!", "Error!!", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else if(e.getSource() == registerIn){
            new registerForm();
            dispose();
        }
                
    }
     
}
       //to be continue with Database
     