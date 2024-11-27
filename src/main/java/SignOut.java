/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackerdemo;

/**
 *
 * @author CLIENT
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignOut extends JFrame implements ActionListener {

    private JScrollPane scrollpane;
    private JButton btnSignOut, btnBack;
    private JLabel UserProfile;

    public SignOut() {
        setTitle("SignOut");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        UserProfile = new JLabel("User Profile:");
        UserProfile.setBounds(50, 20, 200, 30);
        add(UserProfile);

        scrollpane = new JScrollPane();
        scrollpane.setBounds(50, 100, 300, 220);
        add(scrollpane);

        btnSignOut = new JButton("SignOut");
        btnSignOut.setBounds(400, 100, 120, 30);
        add(btnSignOut);

        btnBack = new JButton("Back");
        btnBack.setBounds(400, 250, 120, 30);
        add(btnBack);

        btnSignOut.addActionListener(this);
        btnBack.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSignOut) {
            //new btnSignOut.setVisible(true);
            dispose();
        } else if (e.getSource() == btnBack) {
            //new btnBack.setVisible(true);
            dispose();

        }
    }

    public static void main(String[] args) {
        new SignOut();
    }
}