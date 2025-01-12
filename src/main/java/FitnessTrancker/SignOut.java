/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

/**
 *
 * @author CLIENT
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignOut extends JFrame implements ActionListener {

    private JScrollPane scPane;
    private JButton btnSignOut, btnBack, btnView;
    private JLabel UserProfile, lbName, lbBmi, lbIntensity;

    public SignOut() {
        setTitle("SignOut");
        setSize(600, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UserProfile = new JLabel("User Profile");
        UserProfile.setBounds(150, 40, 200, 30);
        add(UserProfile);

//        scrollpane = new JScrollPane();
//        scrollpane.setBounds(50, 100, 300, 220);
//        add(scrollpane);

        //button for sign outing account
        btnSignOut = new JButton("SignOut");
        btnSignOut.setBounds(400, 100, 120, 30);
        add(btnSignOut);

        //button for back maindashboard
        btnBack = new JButton("Back");
        btnBack.setBounds(400, 150, 120, 30);
        add(btnBack);
        
        
        btnView = new JButton("View");
        btnView.setBounds(400, 200, 120, 30);
        add(btnView);
        
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
        btnView.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignOut) {
            new signInScreen().setVisible(true);
            dispose();
        } else if (e.getSource() == btnBack) {
            new mainDashboard().setVisible(true);
            dispose();
            
            } else if (e.getSource() == btnView) {
            dispose();
            new viewWorkoutPlan().setVisible(true);
        

        }
    }

    public static void main(String[] args) {
        new SignOut();
    }
}