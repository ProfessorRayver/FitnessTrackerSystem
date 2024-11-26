/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackapp;

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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    //private JTextArea txaSummary;
    private JScrollPane scroll;
    private Queue<String> Qname;
    private DefaultListModel<String> listModel;
    private JList<String> list;
    PreparedStatement pst;
    Connection con;
    ResultSet rst;
    

    
    trackMeal(){
        Qname = new LinkedList<>();
        listModel = new DefaultListModel<>();
    //frame
        setTitle("Meal Tracker");
        setSize(610, 600);
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
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
    btnAddNew.setBounds(493, 395, 85, 30); 
    add(btnAddNew);
     
//    txaSummary = new JTextArea();
//    txaSummary.setEditable(false);
    list = new JList<>(listModel);
    scroll = new JScrollPane(list);
    scroll.setBounds(30, 220, 450, 300);
    add(scroll);
    
    btnSave = new JButton("Save");
    btnSave.setBounds(493, 245, 85, 30);
    add(btnSave);
    
    btnClear = new JButton("Clear");
    btnClear.setBounds(493, 320, 85, 30);
    add(btnClear);
    
    btnAdd = new JButton("Add");
    btnAdd.setBounds(350, 150, 80, 30);  
    add(btnAdd);
    
    btnBack = new JButton("Home");
    btnBack.setBounds(493, 470, 85, 30);
    add(btnBack);
  
    revalidate();
    repaint();
        
    //add ActionListener
    btnAddNew.addActionListener(this);
    btnAdd.addActionListener(this);
    btnClear.addActionListener(this);
    btnBack.addActionListener(this);
    btnSave.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //new button
        if(e.getSource() == btnAddNew){
            String newMeal = JOptionPane.showInputDialog(this, "Enter New Meal", "New Meal", JOptionPane.INFORMATION_MESSAGE);
            if(newMeal.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please Enter New Meal!", "Error!", JOptionPane.ERROR_MESSAGE);
                
            }
            String cal = JOptionPane.showInputDialog(this, "Enter the Calorie", "New Meal", JOptionPane.INFORMATION_MESSAGE);
            if(cal.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please Enter the Calorie!", "Error!", JOptionPane.ERROR_MESSAGE);
               //to be continue
            }

//          //clear button
        }else if(e.getSource() == btnClear){
            listModel.clear();
            //back button
        }else if(e.getSource() == btnBack){
            new mainDashboard();
            setVisible(true);
            this.dispose();
            
        //save to database
        }else if(e.getSource() == btnSave){
            listModel.clear();
            if(!Qname.isEmpty()){
                for(String food : Qname){
                    listModel.addElement("User ID: "); //to follow
                    listModel.addElement("Name: ");
                    listModel.addElement("Date: " ); 
                    listModel.addElement("Calories Consumed: ");
                    listModel.addElement("Calories Target: ");
                    listModel.addElement("Carbohydrates: ");
                    listModel.addElement("Fat: ");
                    listModel.addElement("Protein: ");
                    listModel.addElement("Meal Name: " + food);
                    listModel.addElement("Meal Time: " + cmbMeals.getSelectedItem());
                    listModel.addElement("");
            }
            }else{
                JOptionPane.showMessageDialog(this, "No Meal in the List", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(e.getSource() == btnAdd){
            String input = txtInput.getText().trim();
            //String mealname =txtInput.getText();
            
            
            if(!input.isEmpty()){
                Qname.add(input);            
                txtInput.setText("");
                JOptionPane.showMessageDialog(this, "Meal Added!: " + input);
            }else{
                JOptionPane.showMessageDialog(this, "Input Meals", "Error!", JOptionPane.ERROR_MESSAGE);
            }

}
//            try{
//                
//                pst = con.prepareStatement("insert into fitnesstrackerdb (id, mealname, calories) values (?,?,?,?)");
//                pst.setString(1, mealname);
//                
//                int k = pst.executeUpdate();
//                
//                
//            }catch(Exception ex){
//                ex.printStackTrace();
//            }
}
        
    
//    public void con(){
//        String url = "jdbc:mysql://locahost:3306/fitnesstrackerdb";
//        String user = "root";
//        String pass = "admin123";
//        
//        try{
//            con = (Connection) DriverManager.getConnection(url, user, pass);
//            
//        }catch(SQLException ex){
//            Logger.getLogger(fitnesstrackerdb.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
          //to be continue with database    
        //main
       public static void main(String[] args) {
        trackMeal tm = new trackMeal();
        tm.setVisible(true);
    }
    
}
    //Barnuevo
