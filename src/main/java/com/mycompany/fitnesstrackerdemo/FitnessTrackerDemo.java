package com.mycompany.fitnesstrackerdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class FitnessTrackerDemo extends JFrame implements ActionListener {

//    PreparedStatement pst;
//    Connection con;
//    ResultSet rs;
//
//    public void con() {
//        String url = "jdbc:mysql://localhost:3306/fitnessdatabase";
//        String username = "root";
//        String password = "admin123";
//        
//     try {
//            con = DriverManager.getConnection(url, username, password);
//            System.out.println("Database connected successfully!");
//        } catch (SQLException ex) {
//            Logger.getLogger(workOutTracker.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(this, "Database connection failed.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    
    
    // Strings declarations (workouts)
    String[] workout = {"Cardio", "Leg Day", "Chest day", "Back day", "Arm day"};

    String[] cardio = {"Running", "Jump Rope", "Cycling", "Swimming", "Stair Climbing", "Dancing"};
    String[] backDay = {"Deadlifts", "Pull-Ups", "Lat Pulldowns", "Barbell Rows", "T-Bar Rows", 
        "Single-Arm Dumbbell Rows", "Seated Cable Rows", "Face Pulls", "Back Extensions"};
    String[] legDay = {"Squats", "Lunges", "Leg Press", "Romanian Deadlifts", 
        "Bulgarian Split Squats", "Leg Extensions", "Hamstring Curls", "Calf Raises"};
    String[] chestDay = {"Bench Press", "Incline Bench Press", "Chest Flys", "Push-Ups", 
        "Cable Crossovers", "Dumbbell Press", "Incline Dumbbell Press", "Pec Deck Machine", 
        "Dips", "Decline Bench Press"};
    String[] armDay = {"Bicep Curls", "Tricep Pushdowns", "Hammer Curls", "Skull Crushers", 
        "Concentration Curls", "Overhead Tricep Extension", "Preacher Curls", "Tricep Dips", 
        "Reverse Curls", "Close-Grip Bench Press"};

    // INT declarations (calories)
    int[] cardioCalories = {150, 100, 90, 150, 100, 50};
    int[] backDayCalories = {20, 15, 15, 18, 18, 15, 18, 12, 10};
    int[] legDayCalories = {25, 18, 15, 15, 15, 12, 12, 10};
    int[] chestDayCalories = {20, 20, 12, 15, 12, 15, 12, 20, 20};
    int[] armDayCalories = {10, 10, 10, 8, 10, 10, 8, 12, 8, 12};

    // JFrame components declarations
    JButton btnClear, btnChoose, btnNextPage1, btnSelect, btnSubmit, btnCalculate;
    JTextArea calorieResult;
    JScrollPane output1;
    JList<String> list1;
    JLabel lb1, lb2;
    JComboBox<String> selection;
    JTextField setsInput;
    DefaultListModel<String> listModel;
    LinkedHashMap<String, JTextField> exerciseSetsMap = new LinkedHashMap<>();

    public FitnessTrackerDemo() {
        
//         con();
        // Set up the JFrame
        setSize(600, 750);
        setLayout(null);
        setDefaultCloseOperation(FitnessTrackerDemo.EXIT_ON_CLOSE);

        selection = new JComboBox<>(workout);
        selection.setBounds(350, 150, 125, 30);
        add(selection);

        lb1 = new JLabel("Choose a workout");
        lb1.setBounds(350, 100, 150, 50);
        add(lb1);

        lb2 = new JLabel("Enter number of sets:");
        lb2.setBounds(150, 100, 150, 50);
        add(lb2);

        // Buttons
        btnNextPage1 = new JButton("Home");
        btnNextPage1.setBounds(400, 600, 100, 30);
        add(btnNextPage1);

        btnClear = new JButton("Clear");
        btnClear.setBounds(400, 550, 100, 30);
        add(btnClear);

        btnChoose = new JButton("Choose");
        btnChoose.setBounds(400, 200, 100, 30);
        add(btnChoose);

        btnSelect = new JButton("Select");
        btnSelect.setBounds(400, 250, 100, 30);
        add(btnSelect);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(400, 350, 100, 30);
        add(btnSubmit);

        btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(400, 300, 100, 30);
        add(btnCalculate);

        // TextArea and JScrollPane for input and output
        output1 = new JScrollPane();
        output1.setBounds(100, 200, 250, 175);
        add(output1);

        // Sets input and calorie result
        setsInput = new JTextField();
        setsInput.setBounds(150, 150, 125, 30);
        add(setsInput);

        calorieResult = new JTextArea();
        calorieResult.setBounds(100, 400, 250, 275);
        calorieResult.setEditable(false);
        add(calorieResult);

        // Add action listeners to the buttons
        btnClear.addActionListener(this);
        btnChoose.addActionListener(this);
        btnNextPage1.addActionListener(this);
        btnSelect.addActionListener(this);
        btnSubmit.addActionListener(this);
        btnCalculate.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        FitnessTrackerDemo frame = new FitnessTrackerDemo();
        frame.setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnChoose) {
        String selectedWorkout = (String) selection.getSelectedItem();
        String[] selectedExercises;

        // what workout is selected
        switch (selectedWorkout) {
            case "Cardio":
                selectedExercises = cardio;
                break;
            case "Leg Day":
                selectedExercises = legDay;
                break;
            case "Chest day":
                selectedExercises = chestDay;
                break;
            case "Back day":
                selectedExercises = backDay;
                break;
            case "Arm day":
                selectedExercises = armDay;
                break;
            default:
                selectedExercises = new String[]{};
                break;
        }
    }
    
}

}

//          testing of database
//          
//            if (e.getSource() == btnSubmit) {
//        String workoutcalories = calorieResult.getText();
//        
//
//        try {
//            pst = con.prepareStatement("INSERT INTO appointment (workoutcalories) VALUES (?)");
//            pst.setString(1, workoutcalories);
//           
//
//            int k = pst.executeUpdate();
//            if (k == 1) {
//                JOptionPane.showMessageDialog(null, "Added", null, JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(null, "ERROR", null, JOptionPane.ERROR_MESSAGE);
//            }
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "ERROR", null, JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();
//        }
//    }
    

    

