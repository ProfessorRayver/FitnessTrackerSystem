/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

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
    private JButton btnWorkout, btnMeals, btnProgress, btnNotifications, btnProfile, btnWorkoutPlan;
//    private JPanel pnButton, panelNotifications;
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
        ImageIcon ImageIcon = new ImageIcon("C:\\Users\\colad\\OneDrive\\Documents\\NetBeansProjects\\PRACTIVEMOTO\\src\\main\\java\\com\\mycompany\\PUP HealthTrackerBuddy (1).png"); //KINDLY CHANGE FILE PATH DIRECTORY
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
        btnWorkout.setBounds(350, 400, 140, 40);
        add(btnWorkout);
       
        btnMeals = new JButton("My Meals");
        btnMeals.setBounds(350, 450, 140, 40);
        add(btnMeals);
        
        btnWorkoutPlan = new JButton("Workout Plan");
        btnWorkoutPlan.setBounds(350, 500, 140, 40);
        add(btnWorkoutPlan);
        
        btnNotifications = new JButton("Notifications");
        btnNotifications.setBounds(350, 550, 140, 40);
        add(btnNotifications);
        
        btnProgress = new JButton("View Progress");
        btnProgress.setBounds(350, 600, 140, 40);
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
                btnWorkoutPlan.addActionListener(this);
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

        } else if (e.getSource() == btnProfile) {
            dispose();
            new SignOut().setVisible(true);

        } else if (e.getSource() == btnWorkoutPlan) {
            dispose();
            new signup().setVisible(true);
        
        } else if (e.getSource() == btnNotifications) {
            JOptionPane.showMessageDialog(this, "You completed your Workout! Good job!", "Notifications", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        
        } else if (e.getSource() == btnProgress) {
            dispose();
            new viewProgress().setVisible(true);
         } 
        }

    public static void main(String[] args) {
        mainDashboard mainDashboard = new mainDashboard();
        mainDashboard.setVisible(true);
    }
}