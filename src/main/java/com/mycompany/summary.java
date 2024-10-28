///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.fitnesstrackerdemo;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*;
//
//
///**
// *
// * @author centy
// */
//public class summary extends JFrame implements ActionListener {
//    
////    COMPONENT DECLARATIONS
//    
//    private JLabel head, idlbl, namelbl, workoutlbl, meallbl, breakfast, lunch, dinner;
//    private JButton review,homepage;
//    private JTextArea txt, txtname, txtcalculate;
//    private JComboBox <String> cbreakfast, clunch, cdinner, workoutopt;
//    private String[] workout ={"squat","pull-ups","weightlifting"};
//    private String[] lunchopt = {"Pork Sinigang", "Adobo"};
//    private String[] breakfastopt ={"Egg Whites", "Pandesal", "Oatmeal", "Tinapa", "Bacon", "Nuggets", "Chicken Breast", 
//    "Tuyo", "Avocados", "Bananas", "Hard-Boiled Eggs", "Kamote", "Pancakes", "Oatmeal", "Scrambled Eggs", "Cereal", "Toast with Jam","pandesal","oatmeal","sinigang","adobo","caldereta","canned tuna"};
//    private String[] dinneropt = {"Adobo", "Caldereta", "Chicken Breast", "CannedTuna"};
//    
//    
//    
//    summary(){
////        FRAME
//        setSize(850,850);
//        setLayout(null);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        
////        ADDING GUI/COMPONENTS FOR THE JFRAME
//         
//         head = new JLabel("welcome to fitness tracker", SwingConstants.CENTER);
//         head.setBounds(0, 50, 600, 20);
//         add(head);
//         
//         idlbl = new JLabel ("ID: ");
//         idlbl.setBounds(50, 100, 100, 30);
//         add(idlbl);
//         
//         txt = new JTextArea();
//         txt.setBounds(120, 100, 150, 30);
//         add(txt);
//         
//         namelbl = new JLabel("NAME: ");
//         namelbl.setBounds(50, 150, 100, 30);
//         add(namelbl);
//         
//         txtname = new JTextArea();
//         txtname.setBounds(120, 150, 150, 30);
//         add(txtname);
//         
//         workoutlbl = new JLabel("WORKOUT: ");
//         workoutlbl.setBounds(50, 200, 100, 30);
//         add(workoutlbl);
//         
//         
//         workoutopt = new JComboBox(workout);
//         workoutopt.setBounds(120, 200, 100, 30);
//         add(workoutopt);
//         
//         meallbl = new JLabel("MEALS: ");
//         meallbl.setBounds(50, 270, 100, 30);
//         add(meallbl);
//         
//         breakfast = new JLabel("BREAKFAST");
//         breakfast.setBounds(120, 240, 100, 30);
//         add(breakfast);
//         
//         cbreakfast = new JComboBox(breakfastopt);
//         cbreakfast.setBounds(120, 270, 120, 30);
//         add(cbreakfast);
//         
//         lunch = new JLabel("LUNCH");
//         lunch.setBounds(250, 240, 100, 30);
//         add(lunch);
//         
//         clunch = new JComboBox(lunchopt);
//         clunch.setBounds(250, 270, 100, 30);
//         add(clunch);
//         
//         dinner = new JLabel("DINNER");
//         dinner.setBounds(360, 240, 100, 30);
//         add(dinner);
//         
//         cdinner = new JComboBox(dinneropt);
//         cdinner.setBounds(360, 270, 100, 30);
//         add(cdinner);
//         
//         review = new JButton("REVIEW");
//         review.setBounds(120, 350, 120, 30);
//         add(review);
//         
//         homepage = new JButton("HOMEPAGE");
//         homepage.setBounds(20, 60, 100, 15);
//         add(homepage);
//         
//         txtcalculate = new JTextArea();
//         txtcalculate.setBounds(50, 400, 475, 225);
//         txtcalculate.setEditable(false);
//         add(txtcalculate);
//         
//         
//         
////        ADDING FUNCTIONS AND CALCULATIONS OUTPUTS
//         review.addActionListener(this); 
//         
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//       if(e.getSource() == review){
//           txtcalculate.setText("ID: "+ txt +"\n"+
//                                "NAME: " + txtname +"\n"+
//                                "WORKOUT: " + workoutopt.getSelectedItem()+"\n"+
//                                "BREAKFAST: " + cbreakfast.getSelectedItem() +"\n"+
//                                "LUNCH: " + clunch.getSelectedItem() + "\n" + 
//                                "DINNER: " + cdinner.getSelectedItem());
//            } 
//        
////        to be continued
//        
//    }
//    
//}