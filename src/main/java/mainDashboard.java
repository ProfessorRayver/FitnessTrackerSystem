/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;




/**
 *
 * @author User
 */
public class mainDashboard extends JFrame {
    // constructor
    private JLabel titleDash, imgLabel;
    private JButton btnWorkout, btnMeals, btnProgress, btnNotifications;
    private JPanel pnButton, panelNotifications;
    private JScrollPane scrollPaneNotifications;

    mainDashboard() {

        // frame
        setSize(800, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

       // for the picture
        ImageIcon ImageIcon = new ImageIcon("C:\\Users\\CLIENT\\Documents\\NetBeansProjects\\project\\src\\main\\java\\Image\\PUP HealthTrackerBuddy.png\\"); //KINDLY CHANGE FILE PATH DIRECTORY
        imgLabel = new JLabel(ImageIcon);
        imgLabel.setBounds(0, 0, 800, 330);
        add(imgLabel);
        
        // components
        titleDash = new JLabel("Welcome! Fitness Tracker Dashboard", SwingConstants.CENTER);
        titleDash.setBounds(0, 360, 800, 30);
        titleDash.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(titleDash);
     
        // buttons
        btnWorkout = new JButton("My Workout");
       
        btnMeals = new JButton("My Meals");
        
        btnProgress = new JButton("View Progress");
        
        btnNotifications = new JButton("Notifications");
        
        pnButton = new JPanel();
        pnButton.setLayout(new GridLayout(1, 4, 50, 20));
        pnButton.setBounds(90, 430, 600, 60);
        pnButton.add(btnWorkout);
        pnButton.add(btnMeals);
        pnButton.add(btnProgress);
        pnButton.add(btnNotifications);
        
        add(pnButton);
        
        panelNotifications = new JPanel();
        panelNotifications.setLayout(new GridLayout(10, 1));
        
        scrollPaneNotifications = new JScrollPane(panelNotifications);
        scrollPaneNotifications.setBounds(80, 540, 600, 200);
        scrollPaneNotifications.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPaneNotifications);
        
        setVisible(true);
        
        revalidate();
        repaint();
    }
        
           public static void main(String[] args) {
        mainDashboard mainDashboard = new mainDashboard();
        mainDashboard.setVisible(true);
    }
}