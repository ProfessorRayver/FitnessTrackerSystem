/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackerdemo;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;




/**
 *
 * @author User
 */
public class mainDashboard extends JFrame implements ActionListener {
    // constructor
    private JLabel titleDash, imgLabel;
    private JButton btnWorkout, btnMeals, btnProgress, btnNotifications, btnProfile, btnworkoutPlan;
    private JPanel pnButton, panelNotifications;
    //private JScrollPane scrollPaneNotifications;

    mainDashboard() {

        // frame
        setSize(800, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //btn
        
        btnProfile = new JButton("View Profile");
        btnProfile.setBounds(660, 10, 120, 40);
        add(btnProfile);
        
       // for the picture
        ImageIcon ImageIcon = new ImageIcon("C:\\Users\\CLIENT\\Documents\\NetBeansProjects\\FitnessTrackerSystem\\FitnessTrackerSystem\\src\\main\\java\\com\\mycompany\\fitnesstrackerdemo\\Image\\image2\\PUP HealthTrackerBuddy (1).png"); //KINDLY CHANGE FILE PATH DIRECTORY
        imgLabel = new JLabel(ImageIcon);
        imgLabel.setBounds(0, 0, 800, 330);
        add(imgLabel);
        
        // components
        titleDash = new JLabel("WELCOME TO WORKOUT PLAN!", SwingConstants.CENTER);
        titleDash.setBounds(0, 360, 800, 30);
        titleDash.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(titleDash);
     
       
        
        // buttons
        btnWorkout = new JButton("My Workout");
        btnWorkout.setBounds(200, 450, 140, 40);
        add(btnWorkout);
       
        btnMeals = new JButton("My Meals");
        btnMeals.setBounds(350, 450, 140, 40);
        add(btnMeals);
        
        btnworkoutPlan = new JButton("Workout Plan");
        btnworkoutPlan.setBounds(500, 450, 140, 40);
        add(btnworkoutPlan);
        
        btnNotifications = new JButton("Notifications");
        btnNotifications.setBounds(230, 550, 140, 40);
        add(btnNotifications);
        
        btnProgress = new JButton("View Progress");
        btnProgress.setBounds(450, 550, 140, 40);
        add(btnProgress);
        
      

            
        //panelNotifications = new JPanel();
       // panelNotifications.setLayout(new GridLayout(21, 1));
        
        //scrollPaneNotifications = new JScrollPane(panelNotifications);
        //scrollPaneNotifications.setBounds(80, 540, 600, 200);
        //scrollPaneNotifications.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //add(scrollPaneNotifications);
        
        
        
        setVisible(true);
        
        revalidate();
        repaint();
        
                btnWorkout.addActionListener(this);
                btnMeals.addActionListener(this);
                btnProgress.addActionListener(this);
                btnNotifications.addActionListener(this);
                btnworkoutPlan.addActionListener(this);
                btnProfile.addActionListener(this);
    }
    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnMeals) {
        dispose();
        new trackMeal().setVisible(true); 

    } else if (e.getSource() == btnWorkout) {
        dispose();
        new trackWorkout().setVisible(true);

    } else if (e.getSource() == btnNotifications) {
        JOptionPane.showMessageDialog(this, "You completed your Workout! Good job!", "Notifications", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    } 
}

    public static void main(String[] args) {
        mainDashboard mainDashboard = new mainDashboard();
        mainDashboard.setVisible(true);
    }
}