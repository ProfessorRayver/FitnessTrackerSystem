package com.mycompany;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class viewFood extends JFrame implements ActionListener {
    JLabel lblTitle;
    JScrollPane scPane;
    JTable tblFoods;
    JButton btnBack, btnSortCarbs, btnSortFat, btnSortProtein;
    DefaultTableModel model;

    viewFood() {
        setSize(680, 750);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // TITLE LABEL
        lblTitle = new JLabel("View Food List", SwingConstants.CENTER );
        lblTitle.setBounds(0, 20, 680, 35);
        lblTitle.setFont(new Font("Courier", Font.PLAIN, 30));
        add(lblTitle);

        // TABLE SETUP
        String[] foodColumns = {"Food Name", "Carbohydrates (g)", "Fat (g)", "Protein (g)"};
        model = new DefaultTableModel(foodColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // All cells are not editable
            }
        };

        tblFoods = new JTable(model);
        scPane = new JScrollPane(tblFoods);
        scPane.setBounds(30, 80, 600, 400);
        add(scPane);

        // SORT BUTTONS
        btnSortCarbs = new JButton("Sort by Carbs");
        btnSortCarbs.setBounds(50, 500, 150, 30);
        btnSortCarbs.addActionListener(this);
        add(btnSortCarbs);

        btnSortFat = new JButton("Sort by Fat");
        btnSortFat.setBounds(250, 500, 150, 30);
        btnSortFat.addActionListener(this);
        add(btnSortFat);

        btnSortProtein = new JButton("Sort by Protein");
        btnSortProtein.setBounds(450, 500, 150, 30);
        btnSortProtein.addActionListener(this);
        add(btnSortProtein);

        // BACK BUTTON
        btnBack = new JButton("Back");
        btnBack.setBounds(500, 600, 120, 30);
        btnBack.addActionListener(this);
        add(btnBack);

        loadDataFromDatabase();

        setVisible(true);
    }

    private void loadDataFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/fitnesstrackerdb";
        String dbUsername = "root";
        String dbPassword = "admin123";

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT mealname, carbohydrates, fat, protein FROM mealtbl")) {

            // CLEAR TABLE FOR NEW ROWS
            model.setRowCount(0);

            // LOOP ADD ROWS TO THE TABLE
            while (rs.next()) {
                String foodName = rs.getString("mealname");
                double carbohydrates = rs.getDouble("carbohydrates");
                double fat = rs.getDouble("fat");
                double protein = rs.getDouble("protein");
                model.addRow(new Object[]{foodName, carbohydrates, fat, protein});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    private void sortTable(int columnIndex) {
        ArrayList<Object[]> rows = new ArrayList<>();

        // EXTRACT ROW DATA
        for (int i = 0; i < model.getRowCount(); i++) {
            Object[] row = new Object[model.getColumnCount()];
            for (int j = 0; j < model.getColumnCount(); j++) {
                row[j] = model.getValueAt(i, j);
            }
            rows.add(row);
        }

        // SORT ROWS BASED ON COLUMN INDEX
        Collections.sort(rows, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] row1, Object[] row2) {
                Double value1 = Double.parseDouble(row1[columnIndex].toString());
                Double value2 = Double.parseDouble(row2[columnIndex].toString());
                return value1.compareTo(value2);
            }
        });

        // CLEAR AND REPOPULATE THE TABLE
        model.setRowCount(0);
        for (Object[] row : rows) {
            model.addRow(row);
        }
    }

    public static void main(String[] args) {
        new viewFood();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            this.dispose();
            new mainDashboard();
        } else if (e.getSource() == btnSortCarbs) {
            sortTable(1); // Sort by Carbohydrates
        } else if (e.getSource() == btnSortFat) {
            sortTable(2); // Sort by Fat
        } else if (e.getSource() == btnSortProtein) {
            sortTable(3); // Sort by Protein
        }
    }
}
