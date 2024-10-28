/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackerdemo;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author colad
 */
public class userLogin extends JFrame implements ActionListener {
    
   private JLabel lblWelcome, lblUser, lblPassword;
   private JTextField txtFldUsername, txtFldPassword;
   private JButton signIn, registerIn;
   private JPanel bgButton;

        
    userLogin(){
        setSize(800, 800);
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
        
        txtFldPassword = new JTextField();
        txtFldPassword.setBounds(300, 300, 300, 50);
        add(txtFldPassword);
        
        //ADD BUTTONS
        
        signIn = new JButton("Sign In");
        signIn.addActionListener(this);
        
        
        registerIn = new JButton("Register");
        registerIn.addActionListener(this);
        
        
        bgButton = new JPanel();
        bgButton.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        bgButton.setBounds(270, 400, 250, 100);
        bgButton.add(signIn);
        bgButton.add(registerIn);
        
        add(bgButton);
        
        revalidate();
        repaint();
    }
    public void actionPerformed(ActionEvent e) {
            Object clickedButton = e.getSource();
            if(clickedButton == signIn) {
                System.out.println("Sign In Successful");
            }else if(clickedButton == registerIn){
                System.out.println("Register Successful");
            }
            
    }
    
     public static void main(String[] args) {
        userLogin userLogin = new userLogin();
        userLogin.setVisible(true);
    }
}
       
     


                
