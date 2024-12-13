/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author colad
 */
public class viewWorkoutPlan extends JFrame implements ActionListener{
    private JLabel lblActiveWorkoutPlan, lblCurrentWorkOutPlan;
    private JList <String> list;
    private JButton btnBack;
    private JScrollPane scrllpn;
    private DefaultListModel <String> listModel;
           

    viewWorkoutPlan() {
        setSize(800, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        //ADDING COMPONENTS
        lblCurrentWorkOutPlan = new JLabel("Current Workout Plan");
        lblCurrentWorkOutPlan.setBounds(30, 40, 800, 30);
        lblCurrentWorkOutPlan.setFont(new Font ("Courier", Font.PLAIN, 30));
        add(lblCurrentWorkOutPlan);
        
        lblActiveWorkoutPlan = new JLabel("Active Workout Plan");
        lblActiveWorkoutPlan.setBounds(30, 120, 800, 30);
        lblActiveWorkoutPlan.setFont(new Font ("Courier", Font.PLAIN, 20));
        add(lblActiveWorkoutPlan);
        
        listModel = new DefaultListModel<String>();
        list = new JList<String>(listModel);
        scrllpn = new JScrollPane(list);
        scrllpn.setBounds(30, 150, 350, 500);
        add(scrllpn);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(410, 620, 120, 30);
        add(btnBack);
        
        btnBack.addActionListener(this);
        
        setVisible(true);
        
        
             
    }
    
    public static void main (String[] args){
        new viewWorkoutPlan();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnBack){
            this.dispose();
            new SignOut();
        
        }
    }
}
