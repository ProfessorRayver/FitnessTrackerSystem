package com.mycompany.fitnesstrackerdemo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class FitnessTrackerDemo extends JFrame implements ActionListener {

    // Strings declarations
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
    LinkedHashMap<String, Integer> selectedExercisesMap = new LinkedHashMap<>();
    DefaultListModel<String> listModel;

    public FitnessTrackerDemo() {
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
        btnNextPage1 = new JButton("Home page");
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

    // ActionEvent handling logic
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnChoose) {
            String selectedWorkout = (String) selection.getSelectedItem();
            String[] selectedExercises;

            // Determine which workout is selected
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

            // Add exercises to list
            listModel = new DefaultListModel<>();
            for (String exercise : selectedExercises) {
                listModel.addElement(exercise);
            }

            list1 = new JList<>(listModel);
            list1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            output1.setViewportView(list1);

        } else if (e.getSource() == btnClear) {
            listModel.clear();
            calorieResult.setText("");
            selectedExercisesMap.clear();

        } else if (e.getSource() == btnSelect) {
            int[] selectedIndices = list1.getSelectedIndices();
            String setsText = setsInput.getText();
            int sets;

            try {
                // Convert input to integer for sets
                sets = Integer.parseInt(setsText);
            } catch (NumberFormatException ex) {
                calorieResult.setText("Please enter a valid number of sets.");
                return;
            }

            String selectedWorkout = (String) selection.getSelectedItem();

            // Add calories for the selected exercises based on workout
            switch (selectedWorkout) {
                case "Cardio":
                    for (int index : selectedIndices) {
                        String exercise = cardio[index];
                        int caloriesBurned = cardioCalories[index] * sets;
                        selectedExercisesMap.put(exercise + " (selected)", caloriesBurned);
                        listModel.set(index, exercise + " (selected)"); // Mark as selected in the list
                    }
                    break;
                case "Leg Day":
                    for (int index : selectedIndices) {
                        String exercise = legDay[index];
                        int caloriesBurned = legDayCalories[index] * sets;
                        selectedExercisesMap.put(exercise + " (selected)", caloriesBurned);
                        listModel.set(index, exercise + " (selected)"); // Mark as selected in the list
                    }
                    break;
                case "Chest day":
                    for (int index : selectedIndices) {
                        String exercise = chestDay[index];
                        int caloriesBurned = chestDayCalories[index] * sets;
                        selectedExercisesMap.put(exercise + " (selected)", caloriesBurned);
                        listModel.set(index, exercise + " (selected)"); // Mark as selected in the list
                    }
                    break;
                case "Back day":
                    for (int index : selectedIndices) {
                        String exercise = backDay[index];
                        int caloriesBurned = backDayCalories[index] * sets;
                        selectedExercisesMap.put(exercise + " (selected)", caloriesBurned);
                        listModel.set(index, exercise + " (selected)"); // Mark as selected in the list
                    }
                    break;
                case "Arm day":
                    for (int index : selectedIndices) {
                        String exercise = armDay[index];
                        int caloriesBurned = armDayCalories[index] * sets;
                        selectedExercisesMap.put(exercise + " (selected)", caloriesBurned);
                        listModel.set(index, exercise + " (selected)"); // Mark as selected in the list
                    }
                    break;
            }

        } else if (e.getSource() == btnCalculate) {
            int totalCalories = 0;
            StringBuilder calorieBreakdown = new StringBuilder();

            for (String exercise : selectedExercisesMap.keySet()) {
                int calories = selectedExercisesMap.get(exercise);
                totalCalories += calories;
                calorieBreakdown.append(exercise).append(": ").append(calories).append(" calories\n");
            }

            calorieBreakdown.append("\nTotal Calories Burned: ").append(totalCalories);
            calorieResult.setText(calorieBreakdown.toString());
            
        }
        
            if(e.getSource() == btnNextPage1){
            new trackMeal();
            setVisible(true);
            this.dispose();
           
        }
        }
    }

