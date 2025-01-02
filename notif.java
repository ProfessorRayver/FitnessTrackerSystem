package com.mycompany;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class notif {

    private List<Workout> workouts;
    private List<Meal> meals;
    private int currentProgress; 
    private int fitnessGoal; 

    public void checkAndNotify() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);

        // Check for missed workouts
        for (Workout workout : workouts) {
            if (isMissed(workout.getScheduledTime(), calendar)) {
                JOptionPane.showMessageDialog(null, "You missed a workout!", "Workout Reminder", JOptionPane.WARNING_MESSAGE); 
            }
        }

        // Check for missed meals
        for (Meal meal : meals) {
            if (isMissed(meal.getScheduledTime(), calendar)) {
                JOptionPane.showMessageDialog(null, "You missed a meal!", "Meal Reminder", JOptionPane.WARNING_MESSAGE);
            }
        }
        int goal = 0;

        // Check for progress towards goals
        if (isCloseToGoal(currentProgress, goal)) {
            JOptionPane.showMessageDialog(null, "You're close to your fitness goal!", "Progress Update", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean isMissed(Date scheduledTime, Calendar currentDate) {
        return currentDate.after(scheduledTime); 
    }

    private boolean isCloseToGoal(int currentProgress, int goal) {
        if (currentProgress >= goal * 0.9) { 
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    }
}

class Workout {
    private Date scheduledTime;
  
    public Workout(Date scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }
}

class Meal {
    private Date scheduledTime;
   
    public Meal(Date scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }
}