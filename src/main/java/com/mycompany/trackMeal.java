/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;

/**
 *
 * @author User
 */
public class trackMeal extends JFrame implements ActionListener{
    // Database connection
    private static final String url = "jdbc:mysql://localhost:3306/fitnesstrackerdb";
    private static final String user = "root";
    private static final String pass = "admin123";
    //contructor
    
    private JLabel lblTitle, lblInput, lblMeals;
    private JTextField txtInput;
    private String[] meals = {"Breakfast", "Lunch", "Dinner", "Snacks(Optional)"};
    private JComboBox <String> cmbMeals;
    private JButton btnClear, btnAdd, btnBack, btnAddNew, btnSearch, btnViewFoods;
    //private JTextArea txaSummary;
    private JScrollPane scroll;
    private Queue<String> Qname;
    private DefaultListModel<String> listModel;
    private JList<String> list;
    private ArrayList<String> mealList;

    

    
    trackMeal(){
        Qname = new LinkedList<>();
        listModel = new DefaultListModel<>();
        mealList = new ArrayList<>();
        loadMealList();
        ConsumedMeals();

    //frame
        setTitle("Meal Tracker");
        setSize(610, 600);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(173, 216,230));
        
    //components

    
    lblTitle = new JLabel("Meal Tracker");
    lblTitle.setBounds(40, 25, 200, 30);
    lblTitle.setFont(new Font("AvantGarde", Font.BOLD, 22));
    add(lblTitle);
    
    lblInput = new JLabel("Log Your Meals for Today:", SwingConstants.CENTER);
    lblInput.setBounds(0, 80, 600, 30);
    lblInput.setFont(new Font("Tahoma", Font.BOLD, 15));
    add(lblInput);
    
    lblMeals = new JLabel("Meal Name:");
    lblMeals.setBounds(30, 150, 100, 30);
    add(lblMeals);
    
    txtInput = new JTextField();
    txtInput.setBounds(105, 150, 125, 30);
    add(txtInput);
            
    cmbMeals = new JComboBox<>(meals);
    cmbMeals.setBounds(235, 150, 110, 30);
    add(cmbMeals);
    
    btnAddNew = new JButton("Add New");
    btnAddNew.setBounds(493, 320, 85, 30); 
    add(btnAddNew);
     
    list = new JList<>(listModel);
    scroll = new JScrollPane(list);
    scroll.setBounds(30, 220, 450, 300);
    add(scroll);
    
    btnClear = new JButton("Clear");
    btnClear.setBounds(493, 250, 85, 30);
    add(btnClear);
    
    btnAdd = new JButton("Add");
    btnAdd.setBounds(350, 150, 80, 30);  
    add(btnAdd);
    
    btnBack = new JButton("Back");
    btnBack.setBounds(493, 450, 85, 30);
    add(btnBack);
    
    btnSearch = new JButton("Search");
    btnSearch.setBounds(435, 150, 85, 30);
    add(btnSearch);
    
    btnViewFoods = new JButton("FoodList");
    btnViewFoods.setBounds(493, 380, 85, 30);
    add(btnViewFoods);
  
  
    //add ActionListener
    btnAddNew.addActionListener(this);
    btnAdd.addActionListener(this);
    btnClear.addActionListener(this);
    btnBack.addActionListener(this);
    btnSearch.addActionListener(this);
    btnViewFoods.addActionListener(this);
    
    }
    private Connection Database() throws SQLException{
        return DriverManager.getConnection(url, user, pass);
    }
    
    private void loadMealList() {
        try (Connection conn = Database()) {
            String query = "SELECT mealname FROM mealtbl";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            mealList.clear();
            while (rs.next()) {
                mealList.add(rs.getString("mealname"));
            }

            
            Collections.sort(mealList);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Loading Meals: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //binary search
    private int binarySearch(String target) {
        int low = 0;
        int high = mealList.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midMeal = mealList.get(mid);

            if (midMeal.equalsIgnoreCase(target)) {
                return mid; // meal found
            } else if (midMeal.compareToIgnoreCase(target) < 0) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }

        return -1; // meal not found
    }
    private void ConsumedMeals() {
        try (Connection conn = Database()) {
            String query = "SELECT * FROM consumedtbl ORDER BY date DESC";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            listModel.clear();
            while (rs.next()) {
                String mealInfo = "Meal: " + rs.getString("mealname") + "\n" +
                                  " | Meal Time: " + rs.getString("mealtime") + "\n" +
                                  " | Carbohydrates: " + rs.getDouble("carbohydrates") + "g\n" +
                                  " | Fat: " + rs.getDouble("fat") + "g\n" +
                                  " | Protein: " + rs.getDouble("protein") + "g";
                listModel.addElement(mealInfo);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error Loading Consumed Meals: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAdd){
            String input = txtInput.getText().trim();
            String mealTime = cmbMeals.getSelectedItem().toString();

        if (!input.isEmpty()) {
            int index = binarySearch(input);

        if (index != -1) {
            try (Connection conn = Database()) {
                String query = "SELECT * FROM mealtbl WHERE mealname = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, input);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    double carbs = rs.getDouble("carbohydrates");
                    double fat = rs.getDouble("fat");
                    double protein = rs.getDouble("protein");

                    // Save to database
                    String insertQuery = "INSERT INTO consumedtbl (mealname, mealtime, carbohydrates, fat, protein, date) VALUES (?, ?, ?, ?, ?, NOW())";
                    PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                    insertStmt.setString(1, input);
                    insertStmt.setString(2, mealTime);
                    insertStmt.setDouble(3, carbs);
                    insertStmt.setDouble(4, fat);
                    insertStmt.setDouble(5, protein);
                    insertStmt.executeUpdate();

                    // Update list
                    listModel.addElement("Meal: " + input + "  | Meal Time: " +mealTime +
                            " | Carbs: " + carbs + "g | Fat: " + fat + "g | Protein: " + protein + "g");

                    JOptionPane.showMessageDialog(this, "Meal added to the list!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Meal not found! Please add it using 'Add New'.", "Not Found", JOptionPane.WARNING_MESSAGE);
        }

        txtInput.setText("");
    } else {
        JOptionPane.showMessageDialog(this, "Please input a meal name.", "Error", JOptionPane.ERROR_MESSAGE);
    }


          //clear button
        }else if(e.getSource() == btnClear){
            listModel.clear();
            //back button
        }else if(e.getSource() == btnBack){
            new mainDashboard();
            setVisible(true);
            this.dispose();       

            //add new meal btn
        }else if(e.getSource() == btnAddNew){
            String newMeal = JOptionPane.showInputDialog(this, "Enter New Meal", "New Meal", JOptionPane.INFORMATION_MESSAGE);
            if (newMeal != null && !newMeal.trim().isEmpty()) {
                String carbs = JOptionPane.showInputDialog(this, "Enter Carbohydrates (g):", "Meal Nutrients", JOptionPane.INFORMATION_MESSAGE);
                String fat = JOptionPane.showInputDialog(this, "Enter Fat (g):", "Meal Nutrients", JOptionPane.INFORMATION_MESSAGE);
                String protein = JOptionPane.showInputDialog(this, "Enter Protein (g):", "Meal Nutrients", JOptionPane.INFORMATION_MESSAGE);

                if (carbs != null && fat != null && protein != null && !carbs.trim().isEmpty() && !fat.trim().isEmpty() && !protein.trim().isEmpty()) {
                    try (Connection conn = Database()) {
                        String insertQuery = "INSERT INTO mealtbl (mealname, carbohydrates, fat, protein) VALUES (?, ?, ?, ?)";
                        PreparedStatement stmt = conn.prepareStatement(insertQuery);
                        stmt.setString(1, newMeal);
                        stmt.setDouble(2, Double.parseDouble(carbs));
                        stmt.setDouble(3, Double.parseDouble(fat));
                        stmt.setDouble(4, Double.parseDouble(protein));
                        stmt.executeUpdate();
                        
                        loadMealList(); 
                        
                        JOptionPane.showMessageDialog(this, "New Meal Added: " + newMeal);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Please Enter Valid Numeric Values for Nutrients!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please Enter Valid Nutrient Values!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please Enter New Meal!", "Error!", JOptionPane.ERROR_MESSAGE);
            }


           //search btn
        }
        else if(e.getSource() == btnViewFoods){
            new viewFood();
            setVisible(true);
            this.dispose();
        }
         else if (e.getSource() == btnSearch) {
            String searchMeal = JOptionPane.showInputDialog(this, "Enter Meal to Search:", "Search Meal", JOptionPane.QUESTION_MESSAGE);
            if (searchMeal != null && !searchMeal.trim().isEmpty()) {
                int index = binarySearch(searchMeal);

                if (index != -1) {
                    JOptionPane.showMessageDialog(this, "Meal Found: " + mealList.get(index), "Search Result", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Meal Not Found!", "Search Result", JOptionPane.ERROR_MESSAGE);
                }
            }
    }
        
    }
    
        //main
       public static void main(String[] args) {
        trackMeal tm = new trackMeal();
        tm.setVisible(true);
    }
    
}
    //Arby Barnuevo

