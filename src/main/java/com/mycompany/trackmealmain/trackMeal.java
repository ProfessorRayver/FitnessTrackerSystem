/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trackmealmain;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author User
 */
public class trackMeal extends JFrame{
    //contructor
    private JLabel lblTitle, lblInput, lblBreakfast, lblLunch, lblDinner, lblSnacks;
    private JTextField txtInput;
    private String[] breakFastFoods = {"Egg Whites", "Pandesal", "Oatmeal", "Tinapa", "Bacon", "Nuggets", "Chicken Breast", 
    "Tuyo", "Avocados", "Bananas", "Hard-Boiled Eggs", "Kamote", "Pancakes", "Oatmeal", "Scrambled Eggs", "Cereal", "Toast with Jam",}; 
    private String[] lunchFoods = {"Pork Sinigang", "Adobo"};
    
    private String[] dinnerFoods = {"Adobo", "Caldereta", "Chicken Breast", "CannedTuna"};
    private JComboBox <String> cmbBreakFastFoods, cmbLunchFoods, cmbDinnerFoods;
    
    trackMeal(){
    //frame
        setSize(610, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    
    //components
    lblTitle = new JLabel("Meal Tracker");
    lblTitle.setBounds(40, 25, 200, 30);
    lblTitle.setFont(new Font("AvantGarde", Font.BOLD, 22));
    add(lblTitle);
    
    lblInput = new JLabel("Log Your Meals for Today:", SwingConstants.CENTER);
    lblInput.setBounds(0, 80, 600, 30);
    lblInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
    add(lblInput);
    
    lblBreakfast = new JLabel("Breakfast:");
    lblBreakfast.setBounds(30, 120, 80, 30);
    lblBreakfast.setFont(new Font("Korinna BT", Font.BOLD, 12)); 
    add(lblBreakfast);
 
    cmbBreakFastFoods = new JComboBox<>(breakFastFoods);
    cmbBreakFastFoods.setBounds(95, 120, 120, 30);
    cmbBreakFastFoods.setEditable(true);
    add(cmbBreakFastFoods);
    
    lblLunch = new JLabel("Lunch:");
    lblLunch.setBounds(230, 120, 80, 30);
    lblLunch.setFont(new Font("Korinna BT", Font.BOLD, 12)); 
    add(lblLunch);
 
    cmbLunchFoods = new JComboBox<>(lunchFoods);
    cmbLunchFoods.setBounds(275, 120, 120, 30);
    cmbLunchFoods.setEditable(true);
    add(cmbLunchFoods);
    
    lblDinner = new JLabel("Dinner:");
    lblDinner.setBounds(410, 120, 80, 30);
    lblDinner.setFont(new Font("Korinna BT", Font.BOLD, 12)); 
    add(lblDinner);
    
    cmbDinnerFoods = new JComboBox<>(dinnerFoods);
    cmbDinnerFoods.setBounds(455, 120, 120, 30);
    cmbDinnerFoods.setEditable(true);
    add(cmbDinnerFoods);
    
    //to be continue...............
    
    
  
    //add ActionListener
        
        

    setVisible(true);
    }
}
