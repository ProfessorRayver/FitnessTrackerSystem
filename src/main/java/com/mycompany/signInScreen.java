/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackerdemo;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author colad
 */
public class signInScreen extends JFrame {
    
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
    }
    
     public static void main(String[] args) {
        signInScreen signInScreen = new signInScreen();
        signInScreen.setVisible(true);
    }
}
       
     