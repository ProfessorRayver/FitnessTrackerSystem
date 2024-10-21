/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectdsa;

import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author centy
 */
public class gui extends JFrame {
    
    
    private JLabel head, idlbl, namelbl, workoutlbl, meallbl;
    private JButton calculate;
    private JTextArea txt, txtname, txtcalculate;
    private JComboBox mealopt, workoutopt;
    private String[] workout ={"squat","pull-ups","weightlifting"};
    private String[] meals = {"vegetables","meat","herbs","fungus"};
    
    
    
    gui(){
    
        setSize(600,600);
        setLayout(null);
        
//       adding functions

         head = new JLabel("welcome to fitness tracker", SwingConstants.CENTER);
         head.setBounds(0, 50, 600, 20);
         add(head);
         
         idlbl = new JLabel ("id: ");
         idlbl.setBounds(50, 100, 100, 30);
         add(idlbl);
         
         txt = new JTextArea();
         txt.setBounds(80, 100, 80, 30);
         add(txt);
         
         namelbl = new JLabel("name: ");
         namelbl.setBounds(50, 150, 80, 30);
         add(namelbl);
         
         txtname = new JTextArea();
         txtname.setBounds(100, 150, 80, 30);
         add(txtname);
         
         workoutlbl = new JLabel("workout: ");
         workoutlbl.setBounds(50, 200, 100, 30);
         add(workoutlbl);
         
         workoutopt = new JComboBox(workout);
         workoutopt.setBounds(120, 200, 100, 30);
         add(workoutopt);
         
         meallbl = new JLabel("meals: ");
         meallbl.setBounds(50, 250, 100, 30);
         add(meallbl);
         
         mealopt = new JComboBox(meals);
         mealopt.setBounds(110, 250, 100, 30);
         add(mealopt);
         
         calculate = new JButton("calculate");
         calculate.setBounds(100, 300, 100, 30);
         add(calculate);
         
         txtcalculate = new JTextArea();
         txtcalculate.setBounds(100, 350, 450, 200);
         txtcalculate.setEditable(false);
         add(txtcalculate);
         
         
         
         
         
         
   


       
        
    
    }
    
}
