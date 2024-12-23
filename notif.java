import javax.swing.*;

public class notifications {


        public static void main(String[] args) {
                    checkFitnessProgress(
                            true,
                            "Running", 5, 2,
                            true,
                            "Meals", 5, 4
                    );
                }

                public static void checkFitnessProgress(
                        boolean workoutGoalMet, String workoutActivity, int workoutTarget, int workoutActual,
                        boolean mealGoalMet, String mealType, int mealTarget, int mealActual) {

                    String message = "";

                    if (workoutGoalMet) {
                        if (Math.abs(workoutTarget - workoutActual) <= 1) {
                            message += "Great job! You're very close to your " + workoutActivity + " goal of " + workoutTarget + "!\n";
                        } else {
                            message += "Congratulations! You've reached your " + workoutActivity + " goal of " + workoutTarget + "!\n";
                        }
                    } else {
                        message += "Oops! You missed your " + workoutActivity + " goal of " + workoutTarget + ". You can try again tomorrow!\n";
                    }

                    if (mealGoalMet) {
                        if (Math.abs(mealTarget - mealActual) <= 1) {
                            message += "Great job! You're very close to your " + mealType + " goal of " + mealTarget + "!\n";
                        } else {
                            message += "Congratulations! You've reached your " + mealType + " goal of " + mealTarget + "!\n";
                        }
                    } else {
                        message += "Oops! You missed your " + mealType + " goal of " + mealTarget + ". Make sure to include more " + mealType + " in your diet tomorrow!\n";
                    }

                    JOptionPane.showMessageDialog(null, message, "Fitness Progress", JOptionPane.INFORMATION_MESSAGE);
                }
            }

