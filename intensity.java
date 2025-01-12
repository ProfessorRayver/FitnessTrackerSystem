

import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class intensity extends JFrame implements ActionListener {

    private JButton lowintensitybtn, midintensitybtn, highintensitybtn, confirmbtn;
    private JScrollPane scPane;
    private JLabel headlbl;
    private JTextArea txtAr;
    private Connection con;

    String[] low = {"Cardio: Cycling - 15 mins",
        "Back: Face Pulls - 2 sets, 12 reps", "Back Extensions - 2 sets, 12 reps",
        "Legs: Calf Raises - 2 sets, 10 reps", "Leg Press - 2 sets, 10 reps",
        "Chest: Dips - 2 sets, 10 reps", "Push-Ups - 2 sets, 12 reps",
        "Arms: Bicep Curls - 2 sets, 10 reps", "Reverse Curls - 2 sets, 10 reps"};

    String[] mid = {"Cardio: Running - 20 mins",
        "Back: Lat Pulldowns - 3 sets, 12 reps", "Pull-Ups - 3 sets, 10 reps", "Barbell Rows - 3 sets, 12 reps",
        "Legs: Squats - 3 sets, 12 reps", "Lunges - 3 sets, 10 reps", "Leg Extensions - 3 sets, 12 reps",
        "Chest: Bench Press - 3 sets, 10 reps", "Push-Ups - 3 sets, 12 reps", "Cable Crossovers - 3 sets, 12 reps",
        "Arms: Tricep Pushdowns - 3 sets, 12 reps", "Hammer Curls - 3 sets, 12 reps", "Close-Grip Bench Press - 3 sets, 10 reps"};

    String[] high = {"Cardio: Jump Rope - 15 mins", "Stair Climbing - 15 mins",
        "Back: Deadlifts - 4 sets, 12 reps", "Single-Arm Dumbbell Rows - 4 sets, 12 reps", "Lat Pulldowns - 4 sets, 12 reps", "Seated Cable Rows - 4 sets, 15 reps",
        "Legs: Romanian Deadlifts - 4 sets, 15 reps", "Bulgarian Split Squats - 4 sets, 12 reps", "Hamstring Curls - 4 sets, 12 reps", "Calf Raises - 4 sets, 15 reps",
        "Chest: Bench Press - 4 sets, 15 reps", "Incline Bench Press - 4 sets, 12 reps", "Chest Flys - 4 sets, 15 reps", "Decline Bench Press - 4 sets, 12 reps",
        "Arms: Skull Crushers - 4 sets, 15 reps", "Overhead Tricep Extension - 4 sets, 12 reps", "Preacher Curls - 4 sets, 12 reps", "Tricep Dips - 4 sets, 12 reps"};

    intensity() {
        connect();
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        headlbl= new JLabel("Welcome to FITNESS TRACKER", SwingConstants.CENTER);
        headlbl.setFont(new Font("Courier", Font.PLAIN, 20));
        headlbl.setBounds(0, 60, 800, 20);
        add(headlbl);

        txtAr = new JTextArea();
        txtAr.setEditable(false);

        scPane = new JScrollPane(txtAr);
        scPane.setBounds(20, 100, 400, 300);
        add(scPane);

        lowintensitybtn = new JButton("LOW INTENSITY");
        lowintensitybtn.setBounds(450, 100, 200, 40);
        add(lowintensitybtn);

        midintensitybtn = new JButton("MID INTENSITY");
        midintensitybtn.setBounds(450, 150, 200, 40);
        add(midintensitybtn);

        highintensitybtn = new JButton("HIGH INTENSITY");
        highintensitybtn.setBounds(450, 200, 200, 40);
        add(highintensitybtn);

        confirmbtn = new JButton("CONFIRM");
        confirmbtn.setBounds(450, 310, 125, 40);
        add(confirmbtn);

        lowintensitybtn.addActionListener(this);
        midintensitybtn.addActionListener(this);
        highintensitybtn.addActionListener(this);
        confirmbtn.addActionListener(this);
    }

    public static void main(String[] args) {
        intensity next = new intensity();
        next.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lowintensitybtn) {
            txtAr.setText("");
            for (String str : low) {
                txtAr.append(str + "\n");
            }
        } else if (e.getSource() == midintensitybtn) {
            txtAr.setText("");
            for (String str : mid) {
                txtAr.append(str + "\n");
            }
        } else if (e.getSource() == highintensitybtn) {
           txtAr.setText("");
            for (String str : high) {
                txtAr.append(str + "\n");
            }
        }
    }

    public void connect() {
        String url = "jdbc:mysql://localhost:3306/fitnesstrackerdb";
        String dbUsername = "root";
        String dbPassword = "admin123";
        try {
            con = DriverManager.getConnection(url, dbUsername, dbPassword);
        } catch (SQLException ex) {
            Logger.getLogger(intensity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}