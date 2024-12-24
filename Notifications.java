import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Notifications extends JFrame implements ActionListener {

//    declarations
    private JTextField fitnessGoal;
    private JComboBox reminderCombo;
    private JCheckBox workoutNotificationCheck;
    private JCheckBox mealLoggingNotificationCheck;
    private JButton startButton;
    private JButton btnHomePage;

    public Notifications() {
        
        // Frame
        setTitle("Fitness Tracker Notifications");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // label for input
        JLabel goalLabel = new JLabel("Fitness Goal:");
        goalLabel.setBounds(20, 20, 100, 50);
        add(goalLabel);

        fitnessGoal = new JTextField();
        fitnessGoal.setBounds(150, 20, 200, 50);
        add(fitnessGoal);

        // Reminderer
        JLabel reminderLabel = new JLabel("Reminder:");
        reminderLabel.setBounds(20, 70, 100, 50);
        add(reminderLabel);

        reminderCombo = new JComboBox();
        reminderCombo.setBounds(150, 80, 200, 50);
        reminderCombo.addItem("Daily");
        reminderCombo.addItem("Weekly");
        reminderCombo.addItem("Monthly");
        add(reminderCombo);

        // Notification of meals and workout
        workoutNotificationCheck = new JCheckBox("Missed Workouts");
        workoutNotificationCheck.setBounds(20, 150, 150, 50);
        add(workoutNotificationCheck);

        mealLoggingNotificationCheck = new JCheckBox("Missed Meal Logging");
        mealLoggingNotificationCheck.setBounds(20, 190, 150, 50);
        add(mealLoggingNotificationCheck);

        // Button
        startButton = new JButton("Start");
        startButton.setBounds(200, 250, 100, 60);
        add(startButton);

        btnHomePage = new JButton("Home");
        btnHomePage.setBounds(330, 250, 100, 60);
        add(btnHomePage);

        // actionlistners
        startButton.addActionListener(this);
        btnHomePage.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            
            String goal = fitnessGoal.getText();
            String reminder = (String) reminderCombo.getSelectedItem();
            String workoutNotifications = workoutNotificationCheck.isSelected() ? "Yes" : "No";
            String mealNotifications = mealLoggingNotificationCheck.isSelected() ? "Yes" : "No";
 
            String message = "Fitness Goal: " + goal + "\n" +
                             "Reminder Frequency: " + reminder + "\n" +
                             "Workout Notifications: " + workoutNotifications + "\n" +
                             "Meal Notifications: " + mealNotifications;
            if (mealLoggingNotificationCheck.isSelected()) {
                JOptionPane.showMessageDialog(this, "make sure your meals is completed.");
            }
         if (workoutNotificationCheck.isSelected()) {
                JOptionPane.showMessageDialog(this, "track your workouts if you miss something.");
            }
            JOptionPane.showMessageDialog(this, message);
            //         if the checkbox is selected the message will appear but will not if it is unchecked

        } else if (e.getSource() == btnHomePage) {
            JOptionPane.showMessageDialog(this, "Returning to Home Page.");
            
//            returning the homepage to the main dashboard
             new mainDashboard(); 
            setVisible(true);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        Notifications app = new Notifications();
        app.setVisible(true);
    }
}
