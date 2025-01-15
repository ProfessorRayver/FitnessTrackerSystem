/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class mainDashboard extends JFrame implements ActionListener {
    
   private JLabel lblDashBoard, imgLbl;
   private JButton btnWorkout, btnNewPlan, btnMeals, btnProgress,  btnProfile, btnWorkoutPlan;


    mainDashboard() {

       // INITIALIZATION OF JFRAME
        setSize(800, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        // ADDING JFRAME COMPONENTS
        lblDashBoard = new JLabel("WELCOME TO WORKOUT PLAN!", SwingConstants.CENTER);
        lblDashBoard.setBounds(0, 360, 800, 30);
        lblDashBoard.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblDashBoard);
        
        ImageIcon ImageIcon = new ImageIcon("C:\\Users\\rromp\\OneDrive\\Documents\\NetBeansProjects\\FitnessTrackerSystem\\FitnessTrackerSystem(finals)\\src\\main\\java\\com\\mycompany\\PUP HealthTrackerBuddy (1).png"); //KINDLY CHANGE FILE PATH DIRECTORY
        imgLbl = new JLabel(ImageIcon);
        imgLbl.setBounds(0, 0, 800, 330);
        add(imgLbl);
        
        btnProfile = new JButton("View Profile");
        btnProfile.setBounds(660, 10, 120, 40);
        add(btnProfile);
     
        btnWorkout = new JButton("Track Workout");
        btnWorkout.setBounds(350, 400, 140, 40);
        add(btnWorkout);
       
        btnMeals = new JButton("Track Meals");
        btnMeals.setBounds(350, 450, 140, 40);
        add(btnMeals);
        
        btnNewPlan = new JButton("Create New Plan");
        btnNewPlan.setBounds(350, 500, 140, 40);
        add(btnNewPlan);
        
        btnWorkoutPlan = new JButton("View Workout Plan");
        btnWorkoutPlan.setBounds(350, 550, 140, 40);
        add(btnWorkoutPlan);
        
        btnProgress = new JButton("Workout Progress");
        btnProgress.setBounds(350, 600, 140, 40);
        add(btnProgress);
        
       
        setVisible(true);
        
        revalidate();
        repaint();
        
        // ADDING ACTIONLISTENERS FOR INTERACTABLES
        
                btnWorkout.addActionListener(this);
                btnMeals.addActionListener(this);
                btnProgress.addActionListener(this);
                btnWorkoutPlan.addActionListener(this);
                btnProfile.addActionListener(this);
                btnNewPlan.addActionListener(this);
    }
    @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnMeals) { //TO ACCESS MEAL TRACKER
            dispose();
            new trackMeal().setVisible(true); 
        
        } else if (e.getSource() == btnWorkout) { //TO ACCESS WORKOUT TRACKER
            dispose();
            new trackWorkout().setVisible(true);
            
        } else if (e.getSource() == btnProfile) { //TO ACCESS USERS PROFILE
            dispose();
            new userProfile().setVisible(true);

        } else if (e.getSource() == btnWorkoutPlan) { //TO ACCESS USERS WORKOUT PLAN
            dispose();
            new viewWorkoutPlan().setVisible(true);
        
        } else if (e.getSource() == btnNewPlan) { //TO GET NOTIFICATION OF WHAT TO DO
            dispose();
            new workoutPlan().setVisible(true);   
            
        } else if (e.getSource() == btnProgress) { //TO ACCESS THE OVERALL PROGRESS OF THE USER
            dispose();
            new viewProgress().setVisible(true);
            
         } 
        }

    public static void main(String[] args) {
        mainDashboard mainDashboard = new mainDashboard();
        mainDashboard.setVisible(true);
    }
}
