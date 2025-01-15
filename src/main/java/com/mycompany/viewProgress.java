package com.mycompany;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class viewProgress extends JFrame implements ActionListener {
    // COMPONENTS
    JLabel lblTitle, lblDateTime;
    JScrollPane scPane;
    JTable tblWorkout;
    JButton btnBack, btnClear;
    DefaultTableModel model;
    Timer timer;

    viewProgress() {
        setSize(680, 700);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(173, 216, 230)); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // TITLE LABEL
        lblTitle = new JLabel("View Workout Progress");
        lblTitle.setBounds(150, 60, 800, 35);
        lblTitle.setFont(new Font("Courier", Font.PLAIN, 30));
        add(lblTitle);

        // DATE AND TIME LABEL
        lblDateTime = new JLabel();
        lblDateTime.setBounds(30, 10, 300, 20); // Position at the top-left corner
        lblDateTime.setFont(new Font("Arial", Font.PLAIN, 14));
        add(lblDateTime);

        // TIMER TO UPDATE THE DATE AND TIME EVERY SECOND
        timer = new Timer(1000, e -> updateDateTime());
        timer.start();

        // TABLE SETUP
        String[] workoutColumn = {"Workout", "Calories Burned", "Date Logged"};
        model = new DefaultTableModel(workoutColumn, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are not editable
            }
        };
        
        // CREATE JTABLE
        tblWorkout = new JTable(model);
        scPane = new JScrollPane(tblWorkout);
        scPane.setBounds(30, 140, 600, 350);
        add(scPane);

        // BACK BUTTON
        btnBack = new JButton("Back");
        btnBack.setBounds(500, 520, 120, 30);
        add(btnBack);

        // CLEAR BUTTON
        btnClear = new JButton("Clear All");
        btnClear.setBounds(350, 520, 120, 30); // Positioning it near the "Back" button
        add(btnClear);

        // ACTION LISTENER
        btnBack.addActionListener(this);
        btnClear.addActionListener(this);

        loadDataFromDatabase();

        setVisible(true);
    }
    private void updateDateTime() {
        // Get current date and time
        String currentDateTime = new SimpleDateFormat("EEEE, MMMM dd, yyyy HH:mm:ss").format(new Date());
        lblDateTime.setText("Current Date & Time: " + currentDateTime);
    }
    // USER AND PASS TO OPEN THE DATABASE   
    private void loadDataFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/fitnesstrackerdb";
        String dbUsername = "root";
        String dbPassword = "admin123";

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT selected, calories_burned, logdate FROM workout_log")) {

            // CLEAR TABLE FOR NEW ROWS
            model.setRowCount(0);

            // LOOP ADD ROWS TO THE TABLE
            while (rs.next()) {
                String workout = rs.getString("selected");
                int calories = rs.getInt("calories_burned");
                String logDate = rs.getString("logdate"); //DATE
                model.addRow(new Object[]{workout, calories, logDate});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    private void clearAllDataFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/fitnesstrackerdb";
        String dbUsername = "root";
        String dbPassword = "admin123";
        String deleteQuery = "DELETE FROM workout_log";

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {

            // Execute the delete query
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "History deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "No data to clear.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new viewProgress();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            this.dispose();
            new mainDashboard();
        } else if (e.getSource() == btnClear) {
            int confirm = JOptionPane.showConfirmDialog(this, "Do you want to clear the data?", "Confirm Clear", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                clearAllDataFromDatabase();
                model.setRowCount(0); // Clear the table
            }
        }
    }
}