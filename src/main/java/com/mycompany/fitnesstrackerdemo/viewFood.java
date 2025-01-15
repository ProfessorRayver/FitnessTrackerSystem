package com.mycompany;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class viewFood extends JFrame implements ActionListener {
    JLabel lblTitle;
    JScrollPane scPane;
    JTable tblFoods;
    JButton btnBack, btnSortCarbs, btnSortFat, btnSortProtein, btnClear;
    DefaultTableModel model;

    viewFood() {
        setSize(680, 750);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Set background color
        getContentPane().setBackground(new Color(173, 216, 230)); // Light blue

        // TITLE LABEL
        lblTitle = new JLabel("View Food List", SwingConstants.CENTER);
        lblTitle.setBounds(0, 20, 680, 35);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
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
        btnSortCarbs = createButton("Sort by Carbs", 50, 500);
        btnSortFat = createButton("Sort by Fat", 250, 500);
        btnSortProtein = createButton("Sort by Protein", 450, 500);

        // CLEAR BUTTON
        btnClear = createButton("Clear", 50, 600);

        // BACK BUTTON
        btnBack = createButton("Back", 500, 600);

        loadDataFromDatabase();

        setVisible(true);
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 30);
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Button font
        button.setBackground(new Color(200, 200, 200)); // Light gray
        button.setForeground(Color.DARK_GRAY); // Dark gray text
        button.setFocusPainted(false); // Remove focus outline
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Subtle border
        button.addActionListener(this);

        // Optional hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(180, 180, 180)); // Slightly darker gray on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(200, 200, 200)); // Revert to original gray
            }
        });

        add(button);
        return button;
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

    private void clearTableData() {
        String url = "jdbc:mysql://localhost:3306/fitnesstrackerdb";
        String dbUsername = "root";
        String dbPassword = "admin123";

        try (Connection conn = DriverManager.getConnection(url, dbUsername, dbPassword);
             Statement stmt = conn.createStatement()) {

            // DELETE ALL RECORDS FROM TABLE
            int rowsAffected = stmt.executeUpdate("DELETE FROM mealtbl");

            // CLEAR DATA FROM GUI TABLE
            model.setRowCount(0);

            JOptionPane.showMessageDialog(this, rowsAffected + " records deleted successfully.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error clearing data: " + ex.getMessage());
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
        rows.sort((row1, row2) -> {
            Double value1 = Double.parseDouble(row1[columnIndex].toString());
            Double value2 = Double.parseDouble(row2[columnIndex].toString());
            return value1.compareTo(value2);
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
        } else if (e.getSource() == btnClear) {
            clearTableData();
        }
    }
}
