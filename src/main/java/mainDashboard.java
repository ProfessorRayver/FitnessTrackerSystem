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
    private JButton btnWorkout, btnMeals, btnProgress, btnNotifications;
    private JPanel pnButton, panelNotifications;
    private JScrollPane scrollPaneNotifications;

    mainDashboard() {

        // frame
        setSize(800, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

       // for the picture
        ImageIcon ImageIcon = new ImageIcon("C:\\Users\\CLIENT\\Documents\\NetBeansProjects\\FitnessTrackerSystem\\FitnessTrackerSystem\\src\\main\\java\\com\\mycompany\\fitnesstrackerdemo\\Image\\PUP HealthTrackerBuddy.png"); //KINDLY CHANGE FILE PATH DIRECTORY
        imgLabel = new JLabel(ImageIcon);
        imgLabel.setBounds(0, 0, 800, 330);
        add(imgLabel);
        
        // components
        titleDash = new JLabel("Welcome! Fitness Tracker Dashboard", SwingConstants.CENTER);
        titleDash.setBounds(0, 360, 800, 30);
        titleDash.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(titleDash);
     
        // buttons
        btnWorkout = new JButton("My Workout");
       
        btnMeals = new JButton("My Meals");
        
        btnProgress = new JButton("View Progress");
        
        btnNotifications = new JButton("Notifications");
        
        pnButton = new JPanel();
        pnButton.setLayout(new GridLayout(1, 4, 30, 20));
        pnButton.setBounds(90, 430, 600, 60);
        pnButton.add(btnWorkout);
        pnButton.add(btnMeals);
        pnButton.add(btnProgress);
        pnButton.add(btnNotifications);
        
        add(pnButton);
            
        panelNotifications = new JPanel();
        panelNotifications.setLayout(new GridLayout(10, 1));
        
        scrollPaneNotifications = new JScrollPane(panelNotifications);
        scrollPaneNotifications.setBounds(80, 540, 600, 200);
        scrollPaneNotifications.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPaneNotifications);
        
        
        
        setVisible(true);
        
        revalidate();
        repaint();
        
                btnWorkout.addActionListener(this);
                btnMeals.addActionListener(this);
                btnProgress.addActionListener(this);
                btnNotifications.addActionListener(this);
    }
    
    
        
           public static void main(String[] args) {
        mainDashboard mainDashboard = new mainDashboard();
        mainDashboard.setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getSource() == btnWorkout) {
            new FitnessTrackerDemo(); 
            dispose();
        } else if (e.getSource() == btnMeals) {
            new trackMeal();
            dispose();
        } else if (e.getSource() == btnProgress) {
            new fitnessGoals(); 
            dispose();
        } else if (e.getSource() == btnNotifications) {
            JOptionPane.showMessageDialog(this, "You completed your Workout! Goodjob!", "Notifications", JOptionPane.INFORMATION_MESSAGE);
            new notification(); 
           
            dispose();
        }
    }
            
            
}
