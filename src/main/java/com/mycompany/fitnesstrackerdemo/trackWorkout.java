package com.mycompany;

/**
 *
 * @author rromp
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class trackWorkout extends JFrame implements ActionListener {

    private JLabel titlelb, categlb, intenslb;
    private JTextArea resultTxt;
    private JButton enterbtn, clearbtn, choosebtn, calqbtn, home, submit;
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
        revalidate();
        repaint();

        // Labels.
        titlelb = new JLabel("Please select workout & intensity first:");
        titlelb.setBounds(150, 20, 250, 30);
        add(titlelb);

        categlb = new JLabel("Workout Categories:");
        categlb.setBounds(20, 80, 150, 30);
        add(categlb);

        intenslb = new JLabel("Intensities:");
        intenslb.setBounds(20, 130, 150, 30);
        add(intenslb);

        // List.
        listModel = new DefaultListModel<>();
        exerciseList = new JList<>(listModel);
        displayScrollPane = new JScrollPane(exerciseList);
        displayScrollPane.setBounds(20, 200, 200, 220);
        add(displayScrollPane);

        // Display.
        resultTxt = new JTextArea();
        resultTxt.setBounds(250, 200, 200, 220);
        resultTxt.setEditable(false);
        add(resultTxt);

        // Buttons.

        choosebtn = new JButton("Choose");
        choosebtn.setBounds(350, 90, 100, 30);
        add(choosebtn);

        clearbtn = new JButton("Clear");
        clearbtn.setBounds(50, 450, 100, 30);
        add(clearbtn);

        enterbtn = new JButton("Select");
        enterbtn.setBounds(250, 500, 100, 30);
        add(enterbtn);

        // Combo boxes.
        categcb = new JComboBox<>(category);
        categcb.setBounds(170, 80, 150, 30);
        add(categcb);

        intenscb = new JComboBox<>(intensity);
        intenscb.setBounds(170, 130, 150, 30);
        add(intenscb);

        // Buttons.
        calqbtn = new JButton("Calculate");
        calqbtn.setBounds(250, 450, 100, 30);
        add(calqbtn);

        home = new JButton("Home");
        home.setBounds(20, 40, 100, 30);
        add(home);

        submit = new JButton("Submit");
        submit.setBounds(50, 500, 100, 30);
        add(submit);

        submit.addActionListener(this);
        home.addActionListener(this);
        choosebtn.addActionListener(this);
        enterbtn.addActionListener(this);
        clearbtn.addActionListener(this);
        calqbtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == choosebtn) {
            loadExercises();
        } else if (e.getSource() == enterbtn) { // button to select an exercise.
            selectExercise();
        } else if (e.getSource() == clearbtn) { // button to clear info.
            clearSelections();
        } else if (e.getSource() == calqbtn) { // button to show the calories burned on each workout.
            calculateCalories();
        } else if (e.getSource() == home) {    // button to go back at the homepage
            new mainDashboard();
            dispose();
        } else if (e.getSource() == submit) { // button to submit info to database
            submitToDatabase();
        }
    }

    private void loadExercises() {
        listModel.clear();
        chosenEx = null;
        resultTxt.setText("");
        int categoryIndex = categcb.getSelectedIndex();

        String[] exercises;
        if (categoryIndex == 0) exercises = chestEx;
        else if (categoryIndex == 1) exercises = backEx;
        else if (categoryIndex == 2) exercises = legEx;
        else if (categoryIndex == 3) exercises = armEx;
        else exercises = cardioEx;

        for (String ex : exercises) listModel.addElement(ex);
    }

    private void selectExercise() {
        chosenEx = exerciseList.getSelectedValue();
        if (chosenEx != null) {     //to show the selected exercise.
            resultTxt.setText("Selected: " + chosenEx);
        } else {            // warning to choose first before entering.
            JOptionPane.showMessageDialog(null, "Please select an exercise first.");
        }
    }

    private void clearSelections() { // to clear the info
        listModel.clear();
        resultTxt.setText("");
        chosenEx = null;
        categcb.setSelectedIndex(0);
        intenscb.setSelectedIndex(0);
    }

    private void calculateCalories() { // warning msg
        if (chosenEx == null) {
            JOptionPane.showMessageDialog(null, "Please select an exercise first.");
            return;
        }
        //int declaration
        int categoryIndex = categcb.getSelectedIndex();
        int intensityIndex = intenscb.getSelectedIndex();

         caloriesBurned = 0;

            //switch method for selected exercise, and show the calories burned assigned on each intensity.
            
        switch (categoryIndex) {
            case 0: //chest 
                caloriesBurned = getCalories(chestEx, chestCalories, intensityIndex);
                break;
            case 1: //back
                caloriesBurned = getCalories(backEx, backCalories, intensityIndex);
                break;
            case 2: //legs
                caloriesBurned = getCalories(legEx, legCalories, intensityIndex);
                break;
            case 3: //arms
                caloriesBurned = getCalories(armEx, armCalories, intensityIndex);
                break;
            case 4: //cardio
                caloriesBurned = getCalories(cardioEx, cardioCalories, intensityIndex);
                break;
        }
                //displaying text
        resultTxt.setText("Selected: " + chosenEx + "\nCalories Burned: " + caloriesBurned + " kcal");
    }

    private int getCalories(String[] exercises, int[][] calorieArray, int intensityIndex) {
        for (int i = 0; i < exercises.length; i++) {
            if (exercises[i].equals(chosenEx)) {
                return calorieArray[i][intensityIndex];
            }
        }
        return 0;
    }

    private void submitToDatabase() {
        if (chosenEx == null || resultTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please calculate the calories before submitting.");
            return;
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitnesstrackerdb", "root", "admin123");
             PreparedStatement ps = conn.prepareStatement("INSERT INTO workout_log (selected, calories_burned) VALUES (?, ?)")) {

            int categoryIndex = categcb.getSelectedIndex();
            int intensityIndex = intenscb.getSelectedIndex();
            int cc = caloriesBurned;
            

            ps.setString(1, chosenEx);
            ps.setInt(2, caloriesBurned);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data submitted successfully!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        trackWorkout workOut = new trackWorkout();
        workOut.setVisible(true);
    }
}
//Reyes Rayver
