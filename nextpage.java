import java.awt.Font;
import javax.swing.*; 
import java.awt.*;
import static java.awt.SystemColor.text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class nextpage extends JFrame implements ActionListener{

//        declarations
       private JButton lowintensity, midintensity, highintensity, confirm;
       private JScrollPane otp1;
       private JLabel head;
       private JTextArea text;
       
//                string of workouts
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
    

  nextpage(){
//     FRAME

      setSize(600,600);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(null);
      
//     adding components

      head = new JLabel("Welcome to FITNESS TRACKER",SwingConstants.CENTER);
      head.setBounds(0,50 , 600, 20);
      add(head);
      
      text =  new JTextArea();
      text.setEditable(false);
      
      otp1 = new JScrollPane(text);
      otp1.setBounds(20, 100,300 , 250);
      add(otp1);
      
      lowintensity = new JButton("LOW INTENSITY" );
      lowintensity.setBounds(350, 100, 200, 40);
      add(lowintensity);
      
      midintensity =  new JButton("MID INTENSITY" );
      midintensity.setBounds(350, 150, 200, 40);
      add(midintensity);
      
      highintensity =  new JButton("HIGH INTESNITY" );
      highintensity.setBounds(350, 200, 200, 40);
      add(highintensity);
      

      
      confirm = new JButton("CONFIRM");
      confirm.setBounds(350, 310, 125, 40);
      add(confirm);
   
//      ACTION LISTENER
     lowintensity.addActionListener(this);
          midintensity.addActionListener((ActionListener) this);
               highintensity.addActionListener((ActionListener) this);
                confirm.addActionListener((ActionListener) this);
               


    }
  
//     MAIN METHOD
   public static void main(String[]args){
      nextpage next = new nextpage();
      next.setVisible(true);
       
   } 
//   FUNCTIONS
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()== lowintensity){
          
       text.setText("");
            
            for(String str : low ){
                text.append(str + "\n");
            
            }
      }else if (e.getSource()== midintensity){
          text.setText("");
            
            for(String str : mid ){
                text.append(str + "\n");
    
    }
  
        }else if(e.getSource()== highintensity){
        text.setText("");
            
            for(String str : high){
                text.append(str + "\n");
        
                  }
        } else if (e.getSource()== confirm){
        new mainDashboard();
        dispose();
        }
        
        
        
        
    }

    }

   

    
   

       
