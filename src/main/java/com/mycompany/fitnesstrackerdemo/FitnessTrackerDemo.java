package com.mycompany.fitnesstrackerdemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class FitnessTrackerDemo 
        extends JFrame
        implements ActionListener{
    
    //Strings declarations
    String[] workout = {"Cardio", "Leg Day", "Chest day", "Back day", "Arm day"};
    
    String[] cardio = {"Running", "Jump Rope", "Cycling", "Swimming", "Rowing", "Elliptical Trainer", "Stair Climbing", "Aerobics", "HIIT", "Dancing"};

    String[] BackDay = {"Deadlifts", "Pull-Ups", "Lat Pulldowns", "Barbell Rows", "T-Bar Rows", "Single-Arm Dumbbell Rows", "Seated Cable Rows", "Face Pulls", "Back Extensions", "Good Mornings"};

    String[] LegDay = {"Squats", "Lunges", "Leg Press", "Romanian Deadlifts", "Step-Ups", "Bulgarian Split Squats", "Leg Extensions", "Hamstring Curls", "Calf Raises", "Glute Bridges"};

    String[] ChestDay = {"Bench Press", "Incline Bench Press", "Chest Flys", "Push-Ups", "Cable Crossovers", "Dumbbell Press", "Incline Dumbbell Press", "Pec Deck Machine", "Dips", "Decline Bench Press"};

    String[] ArmDay = {"Bicep Curls", "Tricep Pushdowns", "Hammer Curls", "Skull Crushers", "Concentration Curls", "Overhead Tricep Extension", "Preacher Curls", "Tricep Dips", "Reverse Curls", "Close-Grip Bench Press"};

    
    //JFrames and LinkedList declarations
    LinkedList <String> values;
    JButton  btnClear, btnChoose;
    JTextArea input1;
    JScrollPane output1;
    JList list1;        
    JLabel lb1;
    JComboBox<String> selection;
    
    
    //Number Values declarations
    int day = 0;
    int calories = 0;
    int burneCalories = 0;
    int totalWorkOutHour = 0;

    public FitnessTrackerDemo() {
        setSize(800, 600);
        setLayout(null);
        setDefaultCloseOperation(FitnessTrackerDemo.EXIT_ON_CLOSE);

        
        
        //JComboBox and Labels
        selection = new JComboBox<>(workout);
        selection.setBounds(300, 50, 200, 50);
        add(selection);

        lb1 = new JLabel("Choose a workout");
        lb1.setBounds(150, 50, 130, 50);
        add(lb1);


        
        //Buttons
        btnClear = new JButton("Reset");
        btnClear.setBounds(250, 450, 100, 50);
        add(btnClear);

        btnChoose = new JButton("Choose");
        btnChoose.setBounds(400, 450, 100, 50);
        add(btnChoose);

       
        //TextArea and JPanels
        
        input1 = new JTextArea ();
        input1.setBounds(100, 150, 100, 50);
        input1.setEditable(true);
        add(input1);
        
        output1 = new JScrollPane ();
        output1.setBounds(400, 450, 100, 50);
        add(output1);
        
             
        
        //Declarations of the actions
        
        btnClear.addActionListener(this);
        btnChoose.addActionListener(this);
        
        
        setVisible(true);
    }

    public static void main(String[] args) {
        FitnessTrackerDemo frame = new FitnessTrackerDemo();
        frame.setVisible(true);
    }

    
    //Logics
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
