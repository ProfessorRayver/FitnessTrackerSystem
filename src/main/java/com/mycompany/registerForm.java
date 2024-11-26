package com.mycompany.fitnesstrackapp;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

public class registerForm extends JFrame implements ActionListener{
    
    private String[] types = {"Endomorph", "Mesomorph", "Ectomorph"};
    private JComboBox<String> bodytpes;
    private JLabel lblTypes, lblSignUp, lblUser, lblPass, lblConfirmPass;
    private JTextField txtUsername;
    private JPasswordField txtPass, txtConfirmPass;
    private JButton btnCreate, btnBack, btnNext;

     registerForm(){
         //frame
         setTitle("Sign up");
         setSize(600, 600);
         setLayout(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLocationRelativeTo(null);
         //components
         lblSignUp = new JLabel("Sign Up", SwingConstants.CENTER);
         lblSignUp.setBounds(0, 25, 600, 30);
         lblSignUp.setFont(new Font("AvantGarde", Font.BOLD, 22));
         add(lblSignUp);
         
//         lblTypes = new JLabel("Body Types:");
//         lblTypes.setBounds(150, 150, 100, 30);
//         lblTypes.setFont(new Font("Arial", Font.BOLD, 15));
//         add(lblTypes);
         
//         bodytpes = new JComboBox<>(types);
//         bodytpes.setBounds(250, 150, 140, 30);
//         bodytpes.setEditable(false);
//         add(bodytpes);
         
         lblUser = new JLabel("Username:");
         lblUser.setBounds(150, 200, 100, 30);
         lblUser.setFont(new Font("Arial", Font.BOLD, 15));
         add(lblUser);
         
         txtUsername = new JTextField();
         txtUsername.setBounds(250, 200, 140, 30);
         add(txtUsername);
         
         lblPass = new JLabel("Create Password:");
         lblPass.setBounds(120, 250, 150, 30);
         lblPass.setFont(new Font("Arial", Font.BOLD, 15));
         add(lblPass);
         
         txtPass = new JPasswordField();
         txtPass.setBounds(250, 250, 140, 30);
         add(txtPass);
         
         lblConfirmPass = new JLabel("Confirm Password:");
         lblConfirmPass.setBounds(110, 300, 150, 30);
         lblConfirmPass.setFont(new Font("Arial", Font.BOLD, 15));
         add(lblConfirmPass);
         
         txtConfirmPass = new JPasswordField();
         txtConfirmPass.setBounds(250, 300, 140, 30);
         add(txtConfirmPass);
         
         btnNext = new JButton("Next");
         btnNext.setBounds(430, 350, 80, 30);
         add(btnNext);
                 
                 
         btnCreate = new JButton("Create");
         btnCreate.setBounds(320, 350, 80, 30);
         add(btnCreate);
         
         btnBack = new JButton("Back");
         btnBack.setBounds(230, 350, 80, 30);
         add(btnBack);
        
         
         
         //Add ActionListerner
         
         btnBack.addActionListener(this);
         btnCreate.addActionListener(this);
         btnNext.addActionListener(this);
         
         
         setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBack){
            new signInScreen();
            dispose();
}
            else if(e.getSource() == btnNext){
            new fitnessGoals();
            dispose();
       
        }else if(e.getSource() == btnCreate){
            String user = txtUsername.getText();
            String pass = txtPass.getText();
            String confirmPass = txtConfirmPass.getText();
            
            if(!user.isEmpty() || !pass.isEmpty() || !confirmPass.isEmpty()){
                // to be continue with database
                
                
                if(pass.equals(confirmPass)){
                    JOptionPane.showMessageDialog(this, "Create Sucessfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    txtUsername.setText("");
                    txtPass.setText("");
                    txtConfirmPass.setText("");
                }else{
                    JOptionPane.showMessageDialog(this, "Error! Password Do not match!", "Error!", JOptionPane.ERROR_MESSAGE);
                    txtPass.setText("");
                    txtConfirmPass.setText("");
                }

            }else{
                JOptionPane.showMessageDialog(this, "Please fill the require field!", "Error!", JOptionPane.ERROR_MESSAGE);
                
            }
            
        }
    }
    
    public static void main(String [] args){
        new registerForm();
    }

}