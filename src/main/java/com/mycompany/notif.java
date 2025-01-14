
package com.mycompany;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class notif extends JFrame {
    private JTextArea notificationLog;
    private JButton btnBack;
    private ArrayList<String> notifications = new ArrayList<>();

    notif() {
        initializeWindow();
        loadSampleNotifications();
        setVisible(true);
    }

    // GUI Setup
    private void initializeWindow() {
        setTitle("User Notifications");
        setSize(450, 275);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(173, 216, 230));
        

        //TEXT AREA FOR NOTIFICATION
        notificationLog = new JTextArea();
        notificationLog.setBounds(30, 40, 370, 100);
        notificationLog.setEditable(false);
        add(notificationLog);

        //BUTTONS FOR BACK
        btnBack = new JButton("Sign out");
        btnBack.setBounds(120, 175, 200, 40);
        add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new signInScreen().setVisible(true); // BACK TO MAINDASHBOARD
            }
        });
    }

  //FETHCING
    private void loadSampleNotifications() {
        notifications.add("\n▶ Time to start your workout! \n" + "▶ Drink water and stay hydrated. \n"  + "▶ Don’t forget to stretch after today’s session.");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");

        for (String note : notifications) {
            String currentTime = format.format(LocalDateTime.now());
            notificationLog.append(currentTime + " ➤ " + note + "\n");
        }
    }

  public static void main(String[] args) {
    new notif();
 }
}