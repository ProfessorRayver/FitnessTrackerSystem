package com.mycompany.fitnesstrackapp;

/**
 *
 * @author rromp
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class trackWorkout extends JFrame implements ActionListener {


    private JLabel titlelb, categlb, intenslb;
    private JTextArea resultTxt;
    private JButton enterbtn, clearbtn, choosebtn, calqbtn, home, submit;
    private JComboBox<String> categcb, intenscb;
    private JScrollPane displayScrollPane;
    private JList<String> exerciseList;
    private DefaultListModel<String> listModel;

    // listing of workout
    String[] category = {"chest", "back", "legs", "arms", "cardio"};
    String[] intensity = {"low", "medium", "high"};
    String[] chestEx = {"Bench Press", "Push-Ups", "Chest Fly"};
    String[] backEx = {"Lat Pulldown", "Pull-Ups", "Barbell Rows", "Deadlifts"};
    String[] legEx = {"Squats", "Lunges", "Leg Press", "Calf Raises"};
    String[] armEx = {"Bicep Curls", "Tricep Pushdowns", "Hammer Curls", "Skull Crushers"};
    String[] cardioEx = {"Running", "Cycling", "Jump Rope", "Stair Climbing"};

    //specific calories burned that depends on the users intensity
    double[][] chestCalories = 
    {{4, 6, 8}, //bench press
        {5, 7, 9}, //pushups
        {4, 6, 8}}; // chestfly
    double[][] backCalories = 
    {{4, 6, 8}, // lat pulldown
        {5, 7, 9}, // pull ups
        {6, 8, 10}, // barbell row
        {5, 7, 9}}; // deadlifts
    double[][] legCalories = 
    {{6, 8, 10}, //squats
        {5, 7, 9}, //lunges
        {6, 8, 10}, //leg press
        {4, 6, 8}}; // calf raises
    double[][] armCalories = 
    {{5, 7, 9},  //bicep curl
        {4, 6, 8}, // tricep pushdown
        {5, 7, 9}, // hammer curls
        {6, 8, 10}}; //skull crush
    double[][] cardioCalories = 
    {{8, 10, 12}, //running
        {10, 12, 14}, //cycling
        {12, 15, 18}, //jumping rope
        {10, 12, 14}}; // stair climb

    String chosenEx = null;

    public trackWorkout() {
        setSize(500, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        revalidate();
        repaint();

        titlelb = new JLabel("Please select workout & intensity first:");
        titlelb.setBounds(150, 20, 250, 30);
        add(titlelb);

        categlb = new JLabel("Workout Categories:");
        categlb.setBounds(20, 80, 150, 30);
        add(categlb);

        intenslb = new JLabel("Intensities:");
        intenslb.setBounds(20, 130, 150, 30);
        add(intenslb);

        listModel = new DefaultListModel<>();
        exerciseList = new JList<>(listModel);
        displayScrollPane = new JScrollPane(exerciseList);
        displayScrollPane.setBounds(20, 200, 200, 220);
        add(displayScrollPane);

        resultTxt = new JTextArea();
        resultTxt.setBounds(250, 200, 200, 220);
        resultTxt.setEditable(false);
        add(resultTxt);

        choosebtn = new JButton("Choose");
        choosebtn.setBounds(350, 90, 100, 30);
        add(choosebtn);

        clearbtn = new JButton("Clear");
        clearbtn.setBounds(50, 450, 100, 30);
        add(clearbtn);

        enterbtn = new JButton("Select");
        enterbtn.setBounds(250, 500, 100, 30);
        add(enterbtn);

        categcb = new JComboBox<>(category);
        categcb.setBounds(170, 80, 150, 30);
        add(categcb);

        intenscb = new JComboBox<>(intensity);
        intenscb.setBounds(170, 130, 150, 30);
        add(intenscb);

        calqbtn = new JButton("Calculate");
        calqbtn.setBounds(250, 450, 100, 30);
        add(calqbtn);

        home = new JButton("Home");
        home.setBounds(20, 40, 100, 30);
        add(home);
        
        submit = new JButton("Submit");
        submit.setBounds(50, 500, 100, 30);
        add(submit); 
        
       // revalidate();
        //repaint();
        
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
        } else if (e.getSource() == enterbtn) {
            selectExercise();
        } else if (e.getSource() == clearbtn) {
            clearSelections();
        } else if (e.getSource() == calqbtn) {
            calculateCalories();
        } else if (e.getSource() == home) {
            new mainDashboard();
            dispose();
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
        if (chosenEx != null) {
            resultTxt.setText("Selected: " + chosenEx);
        } else {
            JOptionPane.showMessageDialog(null, "Please select an exercise first.");
        }
    }

    private void clearSelections() {
        listModel.clear();
        resultTxt.setText("");
        chosenEx = null;
        categcb.setSelectedIndex(0);
        intenscb.setSelectedIndex(0);
    }

    private void calculateCalories() {
        if (chosenEx == null) {
            JOptionPane.showMessageDialog(null, "Please select an exercise first.");
            return;
        }

        int categoryIndex = categcb.getSelectedIndex();
        int intensityIndex = intenscb.getSelectedIndex();

        double caloriesBurned = 0;

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

        resultTxt.setText("Selected: " + chosenEx + "\nCalories Burned: " + caloriesBurned + " kcal");
    }

    private double getCalories(String[] exercises, double[][] calorieArray, int intensityIndex) {
        for (int i = 0; i < exercises.length; i++) {
            if (exercises[i].equals(chosenEx)) {
                return calorieArray[i][intensityIndex];
            }
        }
        return 0; // Default case if exercise not found
    }

    public static void main(String[] args) {
        trackWorkout workOut = new trackWorkout();
        workOut.setVisible(true);
    }
}
//Reyes Rayver