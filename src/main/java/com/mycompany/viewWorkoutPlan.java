package com.mycompany;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class viewWorkoutPlan extends JFrame implements ActionListener {
    private JLabel lblActiveWorkoutPlan, lblCurrentWorkOutPlan;
    private JList<String> list;
    private JButton btnBack;
    private JScrollPane scPane;
    private DefaultListModel<String> listModel;
    private Connection con;
    private String value;
    private JTextArea text;

    viewWorkoutPlan() {
        
        setSize(450, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(173, 216, 230)); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ADDING COMPONENTS
        lblCurrentWorkOutPlan = new JLabel("Current Workout Plan");
        lblCurrentWorkOutPlan.setBounds(30, 40, 800, 30);
        lblCurrentWorkOutPlan.setFont(new Font("Courier", Font.PLAIN, 30));
        add(lblCurrentWorkOutPlan);

        lblActiveWorkoutPlan = new JLabel("Active Workout Plan");
        lblActiveWorkoutPlan.setBounds(30, 120, 800, 30);
        lblActiveWorkoutPlan.setFont(new Font("Courier", Font.PLAIN, 20));
        add(lblActiveWorkoutPlan);
        
        text =  new JTextArea();
        text.setEditable(false);
      
        scPane = new JScrollPane(text);
        scPane.setBounds(30, 150,350 , 500);
        add(scPane);
       
        btnBack = new JButton("Back");
        btnBack.setBounds(200, 700, 120, 30);
        add(btnBack);

        btnBack.addActionListener(this);
        
        workoutplancon();
        getworkoutPlan();
        setVisible(true);

       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            this.dispose();
            new mainDashboard().setVisible(true);
        }
    
    }
    public static void main(String args[]){
            new viewWorkoutPlan();
    }
    public void workoutplancon(){
        String url = "jdbc:mysql://localhost:3306/fitnesstrackerdb";
        String username = "root";
        String password = "admin123";

        try {
          con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(workoutPlan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void getworkoutPlan(){
        String choose = "select * from workoutplan";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(choose);
            JOptionPane.showMessageDialog(null, "SUCCESS");
            
            while(rs.next()){
                 value = rs.getString("currentworkoutplan");
                
                System.out.print(value);
                
            }
            text.setText(value);
           
        } catch (SQLException ex) {
            Logger.getLogger(viewWorkoutPlan.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
 

