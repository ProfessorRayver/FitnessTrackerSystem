package com.mycompany;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class fitnessGoals extends JFrame implements ActionListener {
    private JLabel lblGetStarted, lblIntro, lblUsername;
    private JTextArea txtAreaWeight;
    private JButton btnNext, btnConfirm;
    public JTextField txtFldWeightUnits, txtFldHeightUnits, txtFldUsername;
    private JComboBox<String> cmbHeightUnits;
    private JComboBox<String> cmbWeightUnits;
    private String[] heightUnits = {"Meter (m)"};
    private String[] weightUnits = {"Kilogram (kg)"};

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/fitnesstrackerdb";
    private static final String USER = "root";
    private static final String PASS = "admin123";  // Change this to your MySQL password

    fitnessGoals() {
        
        setSize(800, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Adding Labels
        lblGetStarted = new JLabel("Let's Get Started!");
        lblGetStarted.setBounds(0, 60, 800, 30);
        lblGetStarted.setHorizontalAlignment(SwingConstants.CENTER);
        lblGetStarted.setFont(new Font("Courier", Font.PLAIN, 30));
        add(lblGetStarted);

        lblIntro = new JLabel("Enter your weight and height to calculate BMI");
        lblIntro.setBounds(0, 80, 800, 30);
        lblIntro.setHorizontalAlignment(SwingConstants.CENTER);
        lblIntro.setFont(new Font("Courier", Font.PLAIN, 20));
        add(lblIntro);
        
        lblUsername = new JLabel("Enter USERNAME");
        lblUsername.setBounds(390, 140, 800, 30);
        lblUsername.setFont(new Font("Courier", Font.PLAIN, 20));
        add(lblUsername);

        // Adding Input Fields
        txtFldWeightUnits = new JTextField();
        txtFldWeightUnits.setBounds(80, 200, 280, 50);
        txtFldWeightUnits.setFont(new Font("Courier", Font.PLAIN, 20));
        add(txtFldWeightUnits);
        
        txtFldUsername = new JTextField();
        txtFldUsername.setBounds(80, 140, 280, 50);
        txtFldUsername.setFont(new Font("Courier", Font.PLAIN, 20));
        add(txtFldUsername);
        
        txtFldHeightUnits = new JTextField();
        txtFldHeightUnits.setBounds(80, 280, 280, 50);
        txtFldHeightUnits.setFont(new Font("Courier", Font.PLAIN, 20));
        add(txtFldHeightUnits);
        
        txtAreaWeight = new JTextArea();
        txtAreaWeight.setBounds(80, 360, 510, 200);
        txtAreaWeight.setFont(new Font("Courier", Font.PLAIN, 20));
        txtAreaWeight.setEditable(false);
        add(txtAreaWeight);

        cmbWeightUnits = new JComboBox<>(weightUnits);
        cmbWeightUnits.setBounds(390, 200, 200, 50);
        add(cmbWeightUnits);

        cmbHeightUnits = new JComboBox<>(heightUnits);
        cmbHeightUnits.setBounds(390, 280, 200, 50);
        add(cmbHeightUnits);

        // Buttons
        btnConfirm = new JButton("Confirm Input");
        btnConfirm.setBounds(80, 600, 200, 40);
        add(btnConfirm);

        btnNext = new JButton("Next");
        btnNext.setBounds(480, 600, 200, 40);
        add(btnNext);

        btnConfirm.addActionListener(this);
        btnNext.addActionListener(this);

        setVisible(true);
    }
    //FUNCTION FOR GETTING THE INPUT
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConfirm) { //TO GET THE TEXT OF WEIGHT AND HEIGHT
            String weight = txtFldWeightUnits.getText();
            String height = txtFldHeightUnits.getText();
            String username = txtFldUsername.getText();

            try { //DECLARATION OF DOUBLE
                double doubleWeight = Double.parseDouble(weight);
                double doubleHeight = Double.parseDouble(height);

                if (doubleWeight > 0 && doubleHeight > 0) { //TO GET BMI
                    double doubleSqrdHeight = doubleHeight * doubleHeight;
                    double doubleBmi = doubleWeight / doubleSqrdHeight;

                    String category = bmiCategory(doubleBmi); //DISPLAY THE CALCULATED BMI
                    txtAreaWeight.setText(doubleWeight + " " + cmbWeightUnits.getSelectedItem() + "\n" +
                            doubleHeight + " " + cmbHeightUnits.getSelectedItem() + "\n" +
                            "Your BMI is: " + Math.round(doubleBmi) + "\n" +
                            "BMI Category: " + category);

                    saveToDatabase(username, doubleWeight, doubleHeight, doubleBmi, category);

                    txtFldWeightUnits.setText("");
                    txtFldHeightUnits.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "invalid information", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "invalid information", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
            if (e.getSource() == btnNext) {
            new mainDashboard();
            setVisible(true); 
            dispose();
            }
    }   

    // INPUT TO DATA BASE
    private void saveToDatabase(String username, double weight, double height, double bmi, String category) {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmtBMI = con.prepareStatement(
                     "INSERT INTO bmi_data (username, weight, height, bmi, bmi_category) VALUES (?, ?, ?, ?, ?)");) {
            stmtBMI.setString(1, username);
            stmtBMI.setDouble(2, weight); 
            stmtBMI.setDouble(3, height);
            stmtBMI.setDouble(4, bmi);
            stmtBMI.setString(5, category);
            stmtBMI.executeUpdate(); //UPDATES INFO
            JOptionPane.showMessageDialog(this, "Successful!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new fitnessGoals();
    }

    public static String bmiCategory(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal weight";
        else if (bmi < 29.9) return "Overweight";
        else return "Obesity";
    }
}
