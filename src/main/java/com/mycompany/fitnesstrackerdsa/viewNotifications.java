/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fitnesstrackerdsa;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author colad
 */
public class viewNotifications extends JFrame implements ActionListener{

    private JScrollPane scrpn;
    private JButton btnRemove, btnClear, btnBack;
    private JList <String> list;
    private DefaultListModel <String> dflListModel;
    private JLabel lblViewNotif;
    
    
    public viewNotifications() {
        setSize(600, 700);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        //ADDING COMPONENTS
        
        lblViewNotif = new JLabel("Notifications");
        lblViewNotif.setBounds(30, 20, 800, 30);
        lblViewNotif.setFont(new Font("Courier", Font.PLAIN, 30));
        add(lblViewNotif);
        
        dflListModel = new DefaultListModel<String>();
        list = new JList<String>(dflListModel);
        scrpn = new JScrollPane(list);
        scrpn.setBounds(30, 70, 350, 450);
        add(scrpn);
        
        btnRemove = new JButton("Remove");
        btnRemove.setBounds(400, 250, 120, 40);
        add(btnRemove);
        
        btnClear = new JButton("Clear");
        btnClear.setBounds(400, 350, 120, 40);
        add(btnClear);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(30, 550, 120, 40);
        add(btnBack);
        
        btnRemove.addActionListener(this);
        btnClear.addActionListener(this);
        btnBack.addActionListener(this);
        
        
        setVisible(true);
    }
    public static void main (String[] args){
        new viewNotifications();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnRemove){
            int indexSelected = list.getSelectedIndex();
        if(indexSelected!=-1){
            list.remove(indexSelected);
            dflListModel.removeElementAt(indexSelected);
            }else{
            JOptionPane.showMessageDialog(this, "Select a notification to remove!", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(e.getSource() == btnClear){
            list.removeAll();
            dflListModel.removeAllElements();
            JOptionPane.showMessageDialog(this, "Notification is already cleared!", "NOTIFICATION", JOptionPane.INFORMATION_MESSAGE);
            }
    
        else if (e.getSource() == btnBack){
            new mainDashboard().setVisible(true);
            this.dispose();
                
        }
    }
}
