package com.mycompany;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class viewProgress extends JFrame implements ActionListener {
    JLabel lblTitle;
    JScrollPane scPane;
    JTable tblWorkout;
    JButton btnBack;
    DefaultTableModel model;

    viewProgress() {
        setSize(680, 650);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // TITLE LABEL
        lblTitle = new JLabel("View Workout Progress");
        lblTitle.setBounds(150, 60, 800, 35);
        lblTitle.setFont(new Font("Courier", Font.PLAIN, 30));
        add(lblTitle);

        // TABLE SETUP
        String[] workoutColumn = {"Workout", "Calories Burned"};
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

    private void loadDataFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/fitnesstrackerdb";
        String dbUsername = "root";
        String dbPassword = "admin123";

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT selected, calories_burned FROM workout_log")) {

            // CLEAR TABLE FOR NEW ROWS
            model.setRowCount(0);

            // LOOP ADD ROWS TO THE TABLE
            while (rs.next()) {
                String workout = rs.getString("selected");
                int calories = rs.getInt("calories_burned");
                model.addRow(new Object[]{workout, calories});
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
