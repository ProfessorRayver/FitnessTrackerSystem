/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackapp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author colad
 */
public class fitnessGoals extends JFrame implements ActionListener {
    private JLabel lblGetStarted, lblIntro;
    private JTextArea txtAreaWeight; 
    private JButton btnNext, btnConfirm;
    public JTextField txtFldWeightUnits, txtFldHeightUnits;
    private JComboBox<String> cmbHeightUnits;
    private JComboBox<String> cmbWeightUnits;
    private String[] heightUnits = {"Meter (m)"};
    private String[] weightUnits = {"Kilogram (kg)"};
  
    
    
    fitnessGoals(){
        
        setSize(800, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        //ADDING LABELS
        lblGetStarted = new JLabel("Let's Get Started!");
        lblGetStarted.setBounds(0, 60, 800, 30);
        lblGetStarted.setHorizontalAlignment(SwingConstants.CENTER);
        lblGetStarted.setFont(new Font("Courier", Font.PLAIN, 30));
        add(lblGetStarted);
        
        
        lblIntro = new JLabel("Please enter your weight and height to calculate your BMI");
        lblIntro.setBounds(0, 110, 800, 30);
        lblIntro.setHorizontalAlignment(SwingConstants.CENTER);
        lblIntro.setFont(new Font("Courier", Font.PLAIN, 20));
        add(lblIntro);
        
        
        //ADDING COMPONENTS
       txtFldWeightUnits = new JTextField();
       txtFldWeightUnits.setBounds(80, 200, 280, 50);
       txtFldWeightUnits.setFont(new Font("Courier", Font.PLAIN, 20));
       add(txtFldWeightUnits);
       
       cmbWeightUnits = new JComboBox<String>(weightUnits);
       cmbWeightUnits.setBounds(390, 200, 200, 50);
       cmbWeightUnits.setFont(new Font("Courier", Font.PLAIN, 20));
       add(cmbWeightUnits);
       
       txtFldHeightUnits = new JTextField();
       txtFldHeightUnits.setBounds(80, 280, 280, 50);
       txtFldHeightUnits.setFont(new Font("Courier", Font.PLAIN, 20));
       add(txtFldHeightUnits);
       
       cmbHeightUnits = new JComboBox<String>(heightUnits);
       cmbHeightUnits.setBounds(390, 280, 200, 50);
       cmbHeightUnits.setFont(new Font("Courier", Font.PLAIN, 20));
       add(cmbHeightUnits);
               
       txtAreaWeight = new JTextArea();
       txtAreaWeight.setBounds(80, 360, 510, 200);
       txtAreaWeight.setFont(new Font("Courier", Font.PLAIN, 20));
       txtAreaWeight.setEditable(false);
       add(txtAreaWeight);
       
       btnConfirm = new JButton("Confirm Input");
       btnConfirm.setBounds(80, 600, 200, 40);
       btnConfirm.setFont(new Font("Courier", Font.PLAIN, 20));
       add(btnConfirm);
               
       btnNext = new JButton("Next");
       btnNext.setBounds(480, 600, 200, 40);
       btnNext.setFont(new Font("Courier", Font.PLAIN, 20));
       add(btnNext);
      
        
        btnConfirm.addActionListener(this);
        btnNext.addActionListener(this);
        
        
        setVisible(true);
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnConfirm){
            String weight = txtFldWeightUnits.getText();
            String height = txtFldHeightUnits.getText();
          
           try{
            double doubleWeight = Double.parseDouble(weight);
            double doubleHeight = Double.parseDouble(height);
            
             if(doubleWeight > 0 && doubleHeight > 0){
                 
            //CALCULATIONS FOR BMI   
            double doubleSqrdHeight = doubleHeight*doubleHeight;
            double doubleBmi = doubleWeight/doubleSqrdHeight;
            
                txtAreaWeight.setText(doubleWeight + " "+ cmbWeightUnits.getSelectedItem() + "\n" +
                                      doubleHeight + " "+ cmbHeightUnits.getSelectedItem() + "\n" +
                                      "Your BMI is: " + Math.round(doubleBmi) + "\n" +
                                      "BMI Category is: " + bmiCategory(doubleBmi));
                
                    
                txtFldWeightUnits.setText("");
                txtFldHeightUnits.setText("");
            }else{
                 txtFldWeightUnits.setText("");
                JOptionPane.showMessageDialog(this, "Invalid input or statement is blank", "ERROR",JOptionPane.ERROR_MESSAGE);
            }
         } catch (NumberFormatException ex){
             txtFldWeightUnits.setText("");
                JOptionPane.showMessageDialog(this, "Invalid input or statement is blank", "ERROR",JOptionPane.ERROR_MESSAGE);
         }
        }if(e.getSource() == btnNext){
            new mainDashboard();
            setVisible(true);
            this.dispose();
           
        }
    }
   
    public static void main(String[] args){
        
         new fitnessGoals();
        
         }
    public static String bmiCategory(double doublebmi){
        if(doublebmi < 18.5) {
            return "Underweight";
        } else if (doublebmi >= 18.5 && doublebmi < 24.9) {
            return "Normal weight";
        } else if (doublebmi >= 25 && doublebmi < 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
            }
        }
    }