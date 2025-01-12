package com.mycompany;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class notif extends JFrame {
    private JTextArea notificationLog;
    private JButton btnBack;
    private final int activeUser = 1;  // Simulated user ID
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

        notificationLog = new JTextArea();
        notificationLog.setBounds(30, 40, 370, 100);
        notificationLog.setEditable(false);
        add(notificationLog);

        btnBack = new JButton("Back");
        btnBack.setBounds(120, 175, 200, 40);
        add(btnBack);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new mainDashboard().setVisible(true);  // Assuming mainDashboard class exists
            }
        });
    }

    // Simulate Fetching Notifications (Locally)
    private void loadSampleNotifications() {
        // Correcting how notifications are added
        notifications.add("\n▶ Time to start your workout! \n" + "▶ Drink water and stay hydrated. \n"  + "▶ Don’t forget to stretch after today’s session.");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd, yyyy - HH:mm");

        for (String note : notifications) {
            String currentTime = format.format(LocalDateTime.now());
            notificationLog.append(currentTime + " ➤ " + note + "\n");
        }
    }

    // Main Method
  public static void main(String[] args) {
    new notif();
 }
}
