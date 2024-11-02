import java.awt.Font;
import javax.swing.*; 
import java.awt.*;

    public class nextpage extends JFrame {

        // contructor
    private JLabel lblTitle, lblLowIntensity, lblMediumIntensity, lblhighintensity;
    private String[] LowIntensity = {"Running", "Jump Rope", "Cycling", "Swimming", "Stair Climbing", "Dancing"};
    private String[] MediumIntensity = {"Deadlifts", "Pull-Ups", "Lat Pulldowns", "Barbell Rows", "T-Bar Rows", 
        "Single-Arm Dumbbell Rows", "Seated Cable Rows", "Face Pulls", "Back Extensions", "Bicep Curls", "Tricep Pushdowns", "Hammer Curls", "Skull Crushers", 
        "Concentration Curls", "Overhead Tricep Extension", "Preacher Curls", "Tricep Dips", 
        "Reverse Curls", "Close-Grip Bench Press"};
    private String[] highintensity = {"Squats", "Lunges", "Leg Press", "Romanian Deadlifts", 
        "Bulgarian Split Squats", "Leg Extensions", "Hamstring Curls", "Calf Raises","Bench Press", "Incline Bench Press", "Chest Flys", "Push-Ups", 
        "Cable Crossovers", "Dumbbell Press", "Incline Dumbbell Press", "Pec Deck Machine", 
        "Dips", "Decline Bench Press"};
    private JComboBox<String> cmblowintensity, cmbmedintensity, cmbhighintensity;

  nextpage(){
//     FRAME

      setSize(600,600);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(null);
      
      // backround image
       ImageIcon pic = new ImageIcon("C:\\Users\\user\\Pictures\\pic.jpg");
       JLabel pics = new JLabel();
       pics.setIcon(pic);
       add(pics);
  

//      adding components for the JFrame

       lblTitle = new JLabel("Workout Plan", SwingConstants.CENTER);
       lblTitle.setBounds(0, 50, 600, 20);
       lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
       add(lblTitle);

    lblLowIntensity = new JLabel("LOW INTENSITY ");
    lblLowIntensity.setBounds(20, 80, 100, 30);
    add(lblLowIntensity);

    cmblowintensity = new JComboBox<>(LowIntensity);
    cmblowintensity.setBounds(20, 120, 100, 30);
    cmblowintensity.setEditable(true);
    add(cmblowintensity);

    lblMediumIntensity = new JLabel("MID INTENSITY");
    lblMediumIntensity.setBounds(150, 80, 100, 30);
    add(lblMediumIntensity);

    cmbmedintensity= new JComboBox<>(MediumIntensity);
    cmbmedintensity.setBounds(150, 120, 100, 30);
    cmbmedintensity.setEditable(true);
    add(cmbmedintensity);
    
    lblhighintensity =  new JLabel("HIGH INTENSITY");
    lblhighintensity.setBounds(270, 80, 100, 30);
    add(lblhighintensity);
    
    cmbhighintensity = new JComboBox(highintensity);
    cmbhighintensity.setBounds(270, 120, 100, 30);
    add(cmbhighintensity);
    
    }
   public static void main(String[]args){
      nextpage next = new nextpage();
      next.setVisible(true);
       
   }

   

   

    
   

       
}