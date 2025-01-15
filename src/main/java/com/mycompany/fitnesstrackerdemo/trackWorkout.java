package com.mycompany;

/**
 *
 * @author rromp
 */

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class trackWorkout extends JFrame implements ActionListener {

    private JLabel lbtitle, lbCategory, lbIntensity;
    private JTextArea txtResults;
    private JButton btnEnter, btnClear, btnChoose, btnCalculate, btnHome, btnSubmit;
    private JComboBox<String> categcb, intenscb;
    private JScrollPane displayScrollPane;
    private JList<String> exerciseList;
    private DefaultListModel<String> listModel;
    private int caloriesBurned;

    // listing of workout
    String[] category = {"chest", "back", "legs", "arms", "cardio"};
    String[] intensity = {"low", "medium", "high"};
    String[] chestEx = {"Bench Press", "Push-Ups", "Chest Fly"};
    String[] backEx = {"Lat Pulldown", "Pull-Ups", "Barbell Rows", "Deadlifts"};
    String[] legEx = {"Squats", "Lunges", "Leg Press", "Calf Raises"};
    String[] armEx = {"Bicep Curls", "Tricep Pushdowns", "Hammer Curls", "Skull Crushers"};
    String[] cardioEx = {"Running", "Cycling", "Jump Rope", "Stair Climbing"};

    // specific calories burned that depends on the user's intensity
    int[][] chestCalories = {
            {4, 6, 8}, // bench press
            {5, 7, 9}, // pushups
            {4, 6, 8}  // chest fly
    };
    int[][] backCalories = {
            {4, 6, 8}, // lat pulldown
            {5, 7, 9}, // pull ups
            {6, 8, 10}, // barbell row
            {5, 7, 9}  // deadlifts
    };
    int[][] legCalories = {
            {6, 8, 10}, // squats
            {5, 7, 9}, // lunges
            {6, 8, 10}, // leg press
            {4, 6, 8}  // calf raises
    };
    int[][] armCalories = {
            {5, 7, 9},  // bicep curl
            {4, 6, 8}, // tricep pushdown
            {5, 7, 9}, // hammer curls
            {6, 8, 10} // skull crushers
    };
    int[][] cardioCalories = {
            {8, 10, 12}, // running
            {10, 12, 14}, // cycling
            {12, 15, 18}, // jumping rope
            {10, 12, 14}  // stair climbing
    };

    String chosenEx = null;

    public trackWorkout() {
        setSize(500, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(173, 216,230));
        revalidate();
        repaint();

        // LABELS.
        lbtitle = new JLabel("Please select workout & intensity first:");
        lbtitle.setBounds(150, 20, 250, 30);
        add(lbtitle);

        lbCategory = new JLabel("Workout Categories:");
        lbCategory.setBounds(20, 80, 150, 30);
        add(lbCategory);

        lbIntensity = new JLabel("Intensities:");
        lbIntensity.setBounds(20, 130, 150, 30);
        add(lbIntensity);
        
        
        
        // BUTTONS.

        btnChoose = new JButton("Choose");
        btnChoose.setBounds(350, 90, 100, 30);
        add(btnChoose);

        btnClear = new JButton("Clear");
        btnClear.setBounds(250, 500, 100, 30);
        add(btnClear);

        btnEnter = new JButton("Select");
        btnEnter.setBounds(50, 450, 100, 30);
        add(btnEnter);
        
        btnCalculate = new JButton("Calculate");
        btnCalculate.setBounds(250, 450, 100, 30);
        add(btnCalculate);

        btnHome = new JButton("Home");
        btnHome.setBounds(20, 40, 100, 30);
        add(btnHome);

        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(50, 500, 100, 30);
        add(btnSubmit);
        

        // TEXTAREA / LIST.
        listModel = new DefaultListModel<>();
        exerciseList = new JList<>(listModel);
        displayScrollPane = new JScrollPane(exerciseList);
        displayScrollPane.setBounds(20, 200, 200, 220);
        add(displayScrollPane);

        txtResults = new JTextArea();
        txtResults.setBounds(250, 200, 200, 220);
        txtResults.setEditable(false);
        add(txtResults);


        // Combo boxes.
        categcb = new JComboBox<>(category);
        categcb.setBounds(170, 80, 150, 30);
        add(categcb);

        intenscb = new JComboBox<>(intensity);
        intenscb.setBounds(170, 130, 150, 30);
        add(intenscb);

        
        //      ACTION LISTENER
        btnSubmit.addActionListener(this);
        btnHome.addActionListener(this);
        btnChoose.addActionListener(this);
        btnEnter.addActionListener(this);
        btnClear.addActionListener(this);
        btnCalculate.addActionListener(this);
    }

    @Override
   public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnChoose) { 
            loadExercises(); // LOADS THE EXERCISES BASED ON SELECTED CATEGORY
        } else if (e.getSource() == btnEnter) { 
            selectExercise(); // SELECT AN EXERCISE FROM THE LIST
        } else if (e.getSource() == btnClear) { 
            clearSelections(); // CLEAR THE SELECTED ITEMS
        } else if (e.getSource() == btnCalculate) { 
            calculateCalories(); // CALCULATES THE CALORIES BURNED
        } else if (e.getSource() == btnHome) {    
            new mainDashboard(); // NAVIGATES BACK TO THE HOME PAGE
            dispose();
        } else if (e.getSource() == btnSubmit) { 
            submitToDatabase(); // SUBMITS THE SELECTED WORKOUT AND CALORIES TO THE DATABASE
        }
    }

    private void loadExercises() { 
        listModel.clear(); // CLEARS THE LIST OF EXERCISES
        chosenEx = null;
        txtResults.setText(""); // CLEARS THE RESULTS TEXT AREA
        int categoryIndex = categcb.getSelectedIndex(); // GETS THE SELECTED CATEGORY

        // LOADS EXERCISES BASED ON THE SELECTED CATEGORY
        String[] exercises;
        if (categoryIndex == 0) exercises = chestEx;
        else if (categoryIndex == 1) exercises = backEx;
        else if (categoryIndex == 2) exercises = legEx;
        else if (categoryIndex == 3) exercises = armEx;
        else exercises = cardioEx;

        for (String ex : exercises) listModel.addElement(ex);
    }

    private void selectExercise() {
        chosenEx = exerciseList.getSelectedValue(); // GETS THE SELECTED EXERCISE
        if (chosenEx != null) {     
            txtResults.setText("Selected: " + chosenEx); // DISPLAYS THE SELECTED EXERCISE
        } else {            
            JOptionPane.showMessageDialog(null, "Please select an exercise first."); // PROMPTS IF NOTHING IS SELECTED
        }
    }

    private void clearSelections() { 
        listModel.clear(); // CLEARS THE LIST
        txtResults.setText(""); // CLEARS THE RESULTS AREA
        chosenEx = null; // RESETS THE SELECTED EXERCISE
        categcb.setSelectedIndex(0); // RESETS THE CATEGORY COMBO BOX
        intenscb.setSelectedIndex(0); // RESETS THE INTENSITY COMBO BOX
    }

    private void calculateCalories() { 
        if (chosenEx == null) { // CHECKS IF AN EXERCISE IS SELECTED
            JOptionPane.showMessageDialog(null, "Please select an exercise first.");
            return;
        }

        int categoryIndex = categcb.getSelectedIndex(); // GETS THE CATEGORY INDEX
        int intensityIndex = intenscb.getSelectedIndex(); // GETS THE INTENSITY INDEX

        caloriesBurned = 0; // INITIALIZES THE CALORIES VARIABLE

        // DETERMINES THE CALORIES BASED ON THE SELECTED CATEGORY AND EXERCISE
        switch (categoryIndex) {
            case 0: 
                caloriesBurned = getCalories(chestEx, chestCalories, intensityIndex);
                break;
            case 1: 
                caloriesBurned = getCalories(backEx, backCalories, intensityIndex);
                break;
            case 2: 
                caloriesBurned = getCalories(legEx, legCalories, intensityIndex);
                break;
            case 3: 
                caloriesBurned = getCalories(armEx, armCalories, intensityIndex);
                break;
            case 4: 
                caloriesBurned = getCalories(cardioEx, cardioCalories, intensityIndex);
                break;
        }

        // DISPLAYS THE RESULT
        txtResults.setText("Selected: " + chosenEx + "\nCalories Burned: " + caloriesBurned + " kcal");
    }

    private int getCalories(String[] exercises, int[][] calorieArray, int intensityIndex) {
        for (int i = 0; i < exercises.length; i++) {
            if (exercises[i].equals(chosenEx)) { // FINDS THE MATCHING EXERCISE
                return calorieArray[i][intensityIndex]; // RETURNS THE CALORIES BASED ON INTENSITY
            }
        }
        return 0; // RETURNS 0 IF NO MATCH FOUND
    }

    private void submitToDatabase() {
        if (chosenEx == null || txtResults.getText().isEmpty()) { 
            JOptionPane.showMessageDialog(null, "Please calculate the calories before submitting."); // PROMPTS TO CALCULATE FIRST
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitnesstrackerdb", "root", "admin123");
             PreparedStatement ps = conn.prepareStatement("INSERT INTO workout_log (selected, calories_burned) VALUES (?, ?)")) {

            ps.setString(1, chosenEx); // INSERTS THE SELECTED EXERCISE
            ps.setInt(2, caloriesBurned); // INSERTS THE CALORIES BURNED
            ps.executeUpdate(); // EXECUTES THE QUERY
            JOptionPane.showMessageDialog(null, "Data submitted successfully!"); // CONFIRMATION MESSAGE

        } catch (SQLException ex) { 
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage()); // HANDLES DATABASE ERRORS
        }
    }

    public static void main(String[] args) {
        trackWorkout workOut = new trackWorkout(); // CREATES AND DISPLAYS THE GUI
        workOut.setVisible(true);
    }
}
// Reyes Rayver