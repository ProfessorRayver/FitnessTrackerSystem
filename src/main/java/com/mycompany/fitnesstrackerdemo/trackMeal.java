/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackerdemo;

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

/**
 *
 * @author User
 */
public class trackMeal extends JFrame implements ActionListener{
    //contructor
    
    private JLabel lblTitle, lblInput, lblMeals;
    private JTextField txtInput;
    private String[] meals = {"Breakfast", "Lunch", "Dinner", "Snacks(Optional)"};
    private JComboBox <String> cmbMeals;
    private JButton btnSave, btnClear, btnAdd, btnBack, btnAddNew;
    private JTextArea txaSummary;
//    private JScrollPane scroll;
//    private LinkedList <String> ll;
//    private DefaultListModel <String> listmodel;
//    private JList<String> list;
    
    
    trackMeal(){
    //frame
        setSize(610, 600);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
    //components
//    ll = new LinkedList<>();
//    listmodel = new DefaultListModel<>();
    
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
    btnAddNew.setBounds(493, 395, 85, 30); 
    add(btnAddNew);
     
    txaSummary = new JTextArea();
    txaSummary.setBounds(30, 220, 450, 300);
    txaSummary.setEditable(false);
    add(txaSummary);
    
    btnSave = new JButton("Save");
    btnSave.setBounds(493, 245, 85, 30);
    add(btnSave);
    
    btnClear = new JButton("Clear");
    btnClear.setBounds(493, 320, 85, 30);
    add(btnClear);
    
    btnAdd = new JButton("Add");
    btnAdd.setBounds(350, 150, 80, 30);  
    add(btnAdd);
    
    btnBack = new JButton("Back");
    btnBack.setBounds(493, 470, 85, 30);
    add(btnBack);
    
    
    
//    list = new JList<>(listmodel);
//    scroll = new JScrollPane(list);
//    scroll.setBounds(30, 220, 450, 300);
//    add(scroll);
    //to be continue...............
    
    
  
    //add ActionListener
    btnAddNew.addActionListener(this);
    
    btnClear.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAddNew){
            String newMeal = JOptionPane.showInputDialog(this, "Enter New Meal", "New Meal", JOptionPane.INFORMATION_MESSAGE);
            
            if(newMeal.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please Enter New Meal!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
//        }else if(e.getSource() == btnAdd){
//            String input = txtInput.getText();
//            if(!input.isEmpty()){
//                int nutrionalInfo = totalCarbs + totalFats + totalProtein;
//                String formattedText = String.format("Date: %s\n" + "Calories Consumed: %d\n\n" +
//                        "Carbohydrates: %.2f%%\n " + "Protein: %.2f%%", date, totalCalories, 
//                        (nutrionalInfo > 0 ? (totalCarbs * 100.0 / nutrionalInfo) : 0),
//                        (nutrionalInfo > 0 ? (totalFats * 100.0 / nutrionalInfo) : 0),
//                        (nutrionalInfo > 0 ? (totalProtein * 100.0 / nutrionalInfo) : 0));
//                
//                txaSummary.setText(formattedText);
//            }else{
//                JOptionPane.showMessageDialog(this, "Please Input Meal!", "Error!", JOptionPane.ERROR_MESSAGE);
//            }
//            
        }else if(e.getSource() == btnClear){
            txaSummary.setText("");
        }
        
    }
       public static void main(String[] args) {
        trackMeal tm = new trackMeal();
        tm.setVisible(true);
    }
    
}
    
