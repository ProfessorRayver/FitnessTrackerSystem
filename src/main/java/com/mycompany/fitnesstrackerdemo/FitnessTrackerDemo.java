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
    
    String[] cardio = {"Running", "Jump Rope", "Cycling", "Swimming",  
        "Stair Climbing",  "Dancing"};

    String[] BackDay = {"Deadlifts", "Pull-Ups", "Lat Pulldowns", "Barbell Rows", 
        "T-Bar Rows", "Single-Arm Dumbbell Rows", "Seated Cable Rows", "Face Pulls", 
        "Back Extensions"};

    String[] LegDay = {"Squats", "Lunges", "Leg Press", "Romanian Deadlifts", 
        "Bulgarian Split Squats", "Leg Extensions", "Hamstring Curls", "Calf Raises"};

    String[] ChestDay = {"Bench Press", "Incline Bench Press", "Chest Flys", 
        "Push-Ups", "Cable Crossovers", "Dumbbell Press", "Incline Dumbbell Press", 
        "Pec Deck Machine", "Dips", "Decline Bench Press"};

    String[] ArmDay = {"Bicep Curls", "Tricep Pushdowns", "Hammer Curls", "Skull Crushers", 
        "Concentration Curls", "Overhead Tricep Extension", "Preacher Curls", "Tricep Dips", 
        "Reverse Curls", "Close-Grip Bench Press"};

    
    
    //JFrames and LinkedList declarations
    LinkedList <String> values;
    JButton  btnClear, btnChoose, btnNextPage1, btnSelect, btnSubmit, btnCalculate;
    JTextArea input1;
    JScrollPane output1;
    JList list1;        
    JLabel lb1;
    JComboBox<String> selection;
    
    
    //Number Values declarations
    int[] LegsCount = {0};
    int[] BackCount = {0};
    int[] ArmCount = {0};
    int[] ChestCount = {0};
    int[] CardioCount = {0};
    

    
    public FitnessTrackerDemo() {
        
        
        setSize(850, 850);
        setLayout(null);
        setDefaultCloseOperation(FitnessTrackerDemo.EXIT_ON_CLOSE);

        selection = new JComboBox<>(workout);
        selection.setBounds(650, 100, 150, 50);
        add(selection);

        lb1 = new JLabel("Choose a workout");
        lb1.setBounds(650, 50, 150, 50);
        add(lb1);

        //Buttons
        btnClear = new JButton("Clear");
        btnClear.setBounds(650, 700, 100, 50);
        add(btnClear);

        btnChoose = new JButton("Choose");
        btnChoose.setBounds(650, 200, 100, 50);
        add(btnChoose);

        btnNextPage1 = new JButton("Next");
        btnNextPage1.setBounds(650, 300, 100 ,30);
        add(btnNextPage1);
        
        btnSelect = new JButton("Select");
        btnSelect.setBounds(650, 400, 100, 50);
        add(btnSelect);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(650, 600, 100, 30);
        add(btnSubmit);

        btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(650, 500, 150, 50);
        add(btnCalculate);
       
        //TextArea and JPanels
        
        input1 = new JTextArea ();
        input1.setBounds(100, 100, 200, 50);
        input1.setEditable(true);
        add(input1);
        
        output1 = new JScrollPane ();
        output1.setBounds(100, 200, 500, 250);
        add(output1);
        
        //Declarations of the actions
        
        btnClear.addActionListener(this);
        btnChoose.addActionListener(this);
        btnNextPage1.addActionListener(this);
   
        setVisible(true);
    }

    public static void main(String[] args) {
        FitnessTrackerDemo frame = new FitnessTrackerDemo();
        frame.setVisible(true);
    }

    
    //Logics
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnChoose){
            String selectedWorkout = (String) selection.getSelectedItem();
            input1.setText("Selected Workout:" + selectedWorkout);
            
            
            
        }
        
    }

}