/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author CLIENT
 */
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;




/**
 *
 * @author User
 */
public class mainDashboard extends JFrame {
    // constructor
    private JLabel titleDash, imgLabel;
    private JButton btnWorkout, btnMeals, btnProgress;

    mainDashboard() {

        // frame
        setSize(800, 800);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // components
        titleDash = new JLabel("Welcome! Fitness Tracker Dashboard", SwingConstants.CENTER);
        titleDash.setBounds(0, 50, 800, 30);
        titleDash.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(titleDash);

        btnWorkout = new JButton("My Workout");
        btnWorkout.setBounds(100, 150, 160, 30);
        add(btnWorkout);

        btnMeals = new JButton("My Meals");
        btnMeals.setBounds(300, 150, 160, 30);
        add(btnMeals);

        btnProgress = new JButton("View My Progress");
        btnProgress.setBounds(500, 150, 160, 30);
        add(btnProgress);
    }

    // main method to run the application
    public static void main(String[] args) {
        mainDashboard dashboard = new mainDashboard();
        dashboard.setVisible(true);
    }
}
