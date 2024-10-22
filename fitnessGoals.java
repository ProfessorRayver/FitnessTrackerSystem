/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackerdsa;

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
    public JTextField txtFldWeightUnits;
    private JComboBox<String> cmbUnits;
    private String[] weightUnits = {"lbs/Pounds", "kg/Kilogram"};
  
    
    
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
        
        
        lblIntro = new JLabel("Let us know your weight first!");
        lblIntro.setBounds(0, 110, 800, 30);
        lblIntro.setHorizontalAlignment(SwingConstants.CENTER);
        lblIntro.setFont(new Font("Courier", Font.PLAIN, 20));
        add(lblIntro);
        
        
        //ADDING COMPONENTS
       txtFldWeightUnits = new JTextField();
       txtFldWeightUnits.setBounds(80, 200, 280, 50);
       txtFldWeightUnits.setFont(new Font("Courier", Font.PLAIN, 20));
       add(txtFldWeightUnits);
       
       cmbUnits = new JComboBox<String>(weightUnits);
       cmbUnits.setBounds(390, 200, 200, 50);
       cmbUnits.setFont(new Font("Courier", Font.PLAIN, 20));
       add(cmbUnits);
       
       txtAreaWeight = new JTextArea();
       txtAreaWeight.setBounds(80, 280, 510, 200);
       txtAreaWeight.setFont(new Font("Courier", Font.PLAIN, 20));
       txtAreaWeight.setEditable(false);
       add(txtAreaWeight);
       
       btnConfirm = new JButton("Confirm Weight");
       btnConfirm.setBounds(80, 520, 200, 40);
       btnConfirm.setFont(new Font("Courier", Font.PLAIN, 20));
       add(btnConfirm);
               
       btnNext = new JButton("Next");
       btnNext.setBounds(480, 600, 200, 40);
       btnNext.setFont(new Font("Courier", Font.PLAIN, 20));
       add(btnNext);
      
        
        btnConfirm.addActionListener(this);
        
        
        setVisible(true);
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnConfirm){
            String weight = txtFldWeightUnits.getText();
           try{
             int intWeight = Integer.parseInt(weight);
             if(intWeight > 0){
                txtAreaWeight.setText(intWeight + " "+ cmbUnits.getSelectedItem());
                txtFldWeightUnits.setText("");
            }else{
                 txtFldWeightUnits.setText("");
                JOptionPane.showMessageDialog(this, "Invalid input or statement is blank", "ERROR",JOptionPane.ERROR_MESSAGE);
            }
         } catch (NumberFormatException ex){
             txtFldWeightUnits.setText("");
                JOptionPane.showMessageDialog(this, "Invalid input or statement is blank", "ERROR",JOptionPane.ERROR_MESSAGE);
         }
        }
    }
    
            
    public static void main(String[] args){
        
         new fitnessGoals();
        
         }
    }


