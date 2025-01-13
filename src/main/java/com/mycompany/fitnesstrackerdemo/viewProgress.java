package com.mycompany;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class viewProgress extends JFrame implements ActionListener {
    JLabel lblTitle, lblDateTime;
    JScrollPane scPane;
    JTable tblWorkout;
    JButton btnBack;
    DefaultTableModel model;
    Timer timer;

    viewProgress() {
        setSize(680, 700); // Increased height to accommodate the time and day label
        setLayout(null);
        setLocationRelativeTo(null);
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

        // Timer to update the date and time
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

        tblWorkout = new JTable(model);
        scPane = new JScrollPane(tblWorkout);
        scPane.setBounds(30, 140, 600, 350);
        add(scPane);

        // BACK BUTTON
        btnBack = new JButton("Back");
        btnBack.setBounds(500, 520, 120, 30);
        add(btnBack);

        btnBack.addActionListener(this);

        loadDataFromDatabase();

        setVisible(true);
    }

    private void updateDateTime() {
        // Get current date and time
        String currentDateTime = new SimpleDateFormat("EEEE, MMMM dd, yyyy HH:mm:ss").format(new Date());
        lblDateTime.setText("Current Date & Time: " + currentDateTime);
    }

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
                String logDate = rs.getString("logdate"); // Fetching the logdate column
                model.addRow(new Object[]{workout, calories, logDate});
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
        }
    }
}
