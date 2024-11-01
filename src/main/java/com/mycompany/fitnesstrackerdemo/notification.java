/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackerdemo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class notification extends JFrame implements ActionListener {

    private JTextField fitnessGoal;
    private JComboBox<String> reminderCombo;
    private JCheckBox workoutNotificationCheck;
    private  JCheckBox mealLoggingNotificationCheck;
    private JButton btnHomePage, startButton; // kulang sa start function
    
    public notification() {
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel goalLabel = new JLabel("Fitness Goal:");
        fitnessGoal = new JTextField();
        JLabel reminderLabel = new JLabel("Reminders!:");
        reminderCombo = new JComboBox();
        reminderCombo.addItem("Daily");
        reminderCombo.addItem("Weekly");
        reminderCombo.addItem("Monthly");
        JLabel notificationLabel = new JLabel("Notification Preferences:");
        workoutNotificationCheck = new JCheckBox("Send notifications for missed workouts");
        mealLoggingNotificationCheck = new JCheckBox("Send notifications for missed meal logging");
        JButton startButton = new JButton("Start Tracking");

        
        btnHomePage = new JButton("Home");
        btnHomePage.setBounds(500, 20, 80, 30);
        add(btnHomePage);
    
       
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(goalLabel);
        panel.add(fitnessGoal);
        panel.add(reminderLabel);
        panel.add(reminderCombo);
        panel.add(notificationLabel);
        panel.add(workoutNotificationCheck);
        panel.add(mealLoggingNotificationCheck);
        panel.add(startButton);
        panel.setBounds(50, 50, 500, 250);
        add(panel);
        
        startButton.addActionListener(this);
        btnHomePage.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == btnHomePage){
            new mainDashboard();
            setVisible(true);
            this.dispose();
            
        String goal = fitnessGoal.getText();
        String reminderFrequency = reminderCombo.getSelectedItem().toString();
        boolean sendWorkoutNotifications = workoutNotificationCheck.isSelected();
        boolean sendMealLoggingNotifications = mealLoggingNotificationCheck.isSelected();
        

        System.out.println("Fitness Goal: " + goal);
        System.out.println("Reminder Frequency: " + reminderFrequency);
        System.out.println("Send workout notifications: " + sendWorkoutNotifications);
        System.out.println("Send meal logging notifications: " + sendMealLoggingNotifications);
    }
    }
    public static void main(String[] args) {
        notification frame = new notification();
        frame.setVisible(true);
    }
}
