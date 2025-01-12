package com.mycompany;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class fitnessGoals extends JFrame implements ActionListener {
    private JLabel lblGetStarted, lblIntro;
    private JTextArea txtAreaWeight;
    private JButton btnNext, btnConfirm;
    public JTextField txtFldWeightUnits, txtFldHeightUnits;
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
        lblIntro.setBounds(0, 110, 800, 30);
        lblIntro.setHorizontalAlignment(SwingConstants.CENTER);
        lblIntro.setFont(new Font("Courier", Font.PLAIN, 20));
        add(lblIntro);

        // Adding Input Fields
        txtFldWeightUnits = new JTextField();
        txtFldWeightUnits.setBounds(80, 200, 280, 50);
        txtFldWeightUnits.setFont(new Font("Courier", Font.PLAIN, 20));
        add(txtFldWeightUnits);

        cmbWeightUnits = new JComboBox<>(weightUnits);
        cmbWeightUnits.setBounds(390, 200, 200, 50);
        add(cmbWeightUnits);

        txtFldHeightUnits = new JTextField();
        txtFldHeightUnits.setBounds(80, 280, 280, 50);
        txtFldHeightUnits.setFont(new Font("Courier", Font.PLAIN, 20));
        add(txtFldHeightUnits);

        cmbHeightUnits = new JComboBox<>(heightUnits);
        cmbHeightUnits.setBounds(390, 280, 200, 50);
        add(cmbHeightUnits);

        txtAreaWeight = new JTextArea();
        txtAreaWeight.setBounds(80, 360, 510, 200);
        txtAreaWeight.setFont(new Font("Courier", Font.PLAIN, 20));
        txtAreaWeight.setEditable(false);
        add(txtAreaWeight);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnConfirm) {
            String weight = txtFldWeightUnits.getText();
            String height = txtFldHeightUnits.getText();

            try {
                double doubleWeight = Double.parseDouble(weight);
                double doubleHeight = Double.parseDouble(height);

                if (doubleWeight > 0 && doubleHeight > 0) {
                    double doubleSqrdHeight = doubleHeight * doubleHeight;
                    double doubleBmi = doubleWeight / doubleSqrdHeight;

                    String category = bmiCategory(doubleBmi);
                    txtAreaWeight.setText(doubleWeight + " " + cmbWeightUnits.getSelectedItem() + "\n" +
                            doubleHeight + " " + cmbHeightUnits.getSelectedItem() + "\n" +
                            "Your BMI is: " + Math.round(doubleBmi) + "\n" +
                            "BMI Category: " + category);

                    saveToDatabase(doubleWeight, doubleHeight, doubleBmi, category);

                    txtFldWeightUnits.setText("");
                    txtFldHeightUnits.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == btnNext) {
            new mainDashboard();
            setVisible(true);
            this.dispose();
        }
    }

    // Save BMI Data to Database
    private void saveToDatabase(double weight, double height, double bmi, String category) {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = con.prepareStatement(
                     "INSERT INTO bmi_data (weight, height, bmi, bmi_category) VALUES (?, ?, ?, ?)");) {
            stmt.setDouble(1, weight);
            stmt.setDouble(2, height);
            stmt.setDouble(3, bmi);
            stmt.setString(4, category);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Success! Info Stored", "Success!", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error!", "ERROR", JOptionPane.ERROR_MESSAGE);
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
