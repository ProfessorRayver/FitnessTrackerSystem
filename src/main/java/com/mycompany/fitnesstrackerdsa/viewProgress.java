/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author colad
 */
public class viewProgress extends JFrame implements ActionListener{
    JLabel lblTitle;
    JScrollPane scrpn;
    JTable tblWorkout;
    JButton btnBack;
    
    
    
    
    viewProgress(){
        
        setSize(800, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Adding JSwing Components
        lblTitle = new JLabel("View Progress");
        lblTitle.setBounds(30, 60, 800, 35);
        lblTitle.setFont(new Font("Courier", Font.PLAIN, 30));
        add(lblTitle);
        
        String[][] rows = {};
        String[] workoutColumn = {"Arms", "Back", "Legs", "Chest", "Cardio"};
        
        tblWorkout = new JTable(rows, workoutColumn);
        
        
        scrpn = new JScrollPane(tblWorkout);
        scrpn.setBounds(30, 140, 450, 350);
        add(scrpn);
               
        btnBack = new JButton("Back");
        btnBack.setBounds(500, 460, 120, 30);
        add(btnBack);
        
        btnBack.addActionListener(this);
        setVisible(true);
    }
    public static void main (String[] agrs){
        new viewProgress();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBack){
            this.dispose();
            new mainDashboard();
            
        }
    }
}
