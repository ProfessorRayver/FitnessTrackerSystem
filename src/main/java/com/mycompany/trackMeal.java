package com.mycompany;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class trackMeal extends JFrame implements ActionListener {

    private JLabel titlelb, mealnamelb, categorylb;
    private JTextArea resultTxt;
    private JButton clearbtn, homebtn, addNewMealbtn, submitbtn;
    private JComboBox<String> categorycb, mealSelector;

    String[] categories = {"Breakfast", "Lunch", "Dinner", "Snacks"};
    ArrayList<String> foodBreakfast = new ArrayList<>();
    ArrayList<String> foodLunch = new ArrayList<>();
    ArrayList<String> foodDinner = new ArrayList<>();
    ArrayList<String> foodSnacks = new ArrayList<>();

    ArrayList<Integer> breakfastProtein = new ArrayList<>();
    ArrayList<Integer> breakfastCarbs = new ArrayList<>();
    ArrayList<Integer> breakfastFats = new ArrayList<>();
    ArrayList<Integer> breakfastCalories = new ArrayList<>();

    ArrayList<Integer> lunchProtein = new ArrayList<>();
    ArrayList<Integer> lunchCarbs = new ArrayList<>();
    ArrayList<Integer> lunchFats = new ArrayList<>();
    ArrayList<Integer> lunchCalories = new ArrayList<>();

    ArrayList<Integer> dinnerProtein = new ArrayList<>();
    ArrayList<Integer> dinnerCarbs = new ArrayList<>();
    ArrayList<Integer> dinnerFats = new ArrayList<>();
    ArrayList<Integer> dinnerCalories = new ArrayList<>();

    ArrayList<Integer> snacksProtein = new ArrayList<>();
    ArrayList<Integer> snacksCarbs = new ArrayList<>();
    ArrayList<Integer> snacksFats = new ArrayList<>();
    ArrayList<Integer> snacksCalories = new ArrayList<>();

    public trackMeal() {
        // breakfast list
        
        
        foodBreakfast.add("Oatmeal with Berries");
        breakfastProtein.add(6);
        breakfastCarbs.add(27);
        breakfastFats.add(3);
        breakfastCalories.add(150);

        foodBreakfast.add("Greek Yogurt with Honey and Nuts");
        breakfastProtein.add(20);
        breakfastCarbs.add(20);
        breakfastFats.add(10);
        breakfastCalories.add(150);
        
        foodBreakfast.add("Scrambled Eggs with Avocado Toast");
        breakfastProtein.add(25);
        breakfastCarbs.add(40);
        breakfastFats.add(25);
        breakfastCalories.add(250);
        
        foodBreakfast.add("Smoothie Bowl with Fruits and Nuts");
        breakfastProtein.add(15);
        breakfastCarbs.add(60);
        breakfastFats.add(15);
        breakfastCalories.add(280);
        
        foodBreakfast.add("Pancakes with Syrup and Fruit");
        breakfastProtein.add(15);
        breakfastCarbs.add(60);
        breakfastFats.add(15);
        breakfastCalories.add(400);
        
        foodBreakfast.add("Waffles with Whipped Cream and Berries");
        breakfastProtein.add(15);
        breakfastCarbs.add(70);
        breakfastFats.add(20);
        breakfastCalories.add(500);
        
        foodBreakfast.add("Avocado Toast with a Fried Egg");
        breakfastProtein.add(20);
        breakfastCarbs.add(70);
        breakfastFats.add(25);
        breakfastCalories.add(350);
        
        foodBreakfast.add("Breakfast Burrito with Eggs, Cheese, and Veggies");
        breakfastProtein.add(20);
        breakfastCarbs.add(70);
        breakfastFats.add(25);
        breakfastCalories.add(450);
        
        foodBreakfast.add("Breakfast Sandwich with Egg, Cheese, and Bacon");
        breakfastProtein.add(20);
        breakfastCarbs.add(30);
        breakfastFats.add(25);
        breakfastCalories.add(550);
        
        foodBreakfast.add("French Toast with Maple Syrup and Powdered Sugar");
        breakfastProtein.add(15);
        breakfastCarbs.add(60);
        breakfastFats.add(25);
        breakfastCalories.add(600);
        
        foodBreakfast.add("Chia Seed Pudding with Fruit and Nuts");
        breakfastProtein.add(15);
        breakfastCarbs.add(60);
        breakfastFats.add(25);
        breakfastCalories.add(250);
        
        foodBreakfast.add("Breakfast Quesadilla with Cheese and Veggies");
        breakfastProtein.add(15);
        breakfastCarbs.add(45);
        breakfastFats.add(25);
        breakfastCalories.add(450);
        
        foodBreakfast.add("Breakfast Tacos with Eggs, Cheese, and Salsa");
        breakfastProtein.add(25);
        breakfastCarbs.add(45);
        breakfastFats.add(15);
        breakfastCalories.add(550);
        
        foodBreakfast.add("Breakfast Pizza with Eggs, Cheese, and Veggies");
        breakfastProtein.add(25);
        breakfastCarbs.add(50);
        breakfastFats.add(15);
        breakfastCalories.add(500);
        
        foodBreakfast.add("Bagel with Cream Cheese and Smoked Salmon");
        breakfastProtein.add(25);
        breakfastCarbs.add(60);
        breakfastFats.add(20);
        breakfastCalories.add(450);
        
        foodBreakfast.add("Cereal with Milk and Fruit");
        breakfastProtein.add(10);
        breakfastCarbs.add(40);
        breakfastFats.add(10);
        breakfastCalories.add(300);
        
        foodBreakfast.add("Yogurt Parfait with Layers of Fruit and Granola");
        breakfastProtein.add(15);
        breakfastCarbs.add(40);
        breakfastFats.add(20);
        breakfastCalories.add(350);
        
        foodBreakfast.add("Breakfast Frittata with Veggies and Cheese");
        breakfastProtein.add(25);
        breakfastCarbs.add(30);
        breakfastFats.add(20);
        breakfastCalories.add(400);
        
        foodBreakfast.add("Breakfast Hash with Potatoes, Veggies, and Eggs");
        breakfastProtein.add(25);
        breakfastCarbs.add(50);
        breakfastFats.add(25);
        breakfastCalories.add(500);
        
        foodBreakfast.add("Overnight Oats with Fruit and Nuts");
        breakfastProtein.add(15);
        breakfastCarbs.add(50);
        breakfastFats.add(25);
        breakfastCalories.add(350);
        
        // lunch list
        
        
        foodLunch.add("Grilled Chicken Breast with Quinoa");
        lunchProtein.add(40);
        lunchCarbs.add(35);
        lunchFats.add(8);
        lunchCalories.add(420);
        
        foodLunch.add("Salad with Grilled Chicken or Fish");
        lunchProtein.add(35);
        lunchCarbs.add(35);
        lunchFats.add(15);
        lunchCalories.add(400);
        
        foodLunch.add("Soup and Sandwich Combo");
        lunchProtein.add(30);
        lunchCarbs.add(50);
        lunchFats.add(15);
        lunchCalories.add(450);
        
        foodLunch.add("Pasta Salad with Veggies and Protein");
        lunchProtein.add(30);
        lunchCarbs.add(50);
        lunchFats.add(15);
        lunchCalories.add(350);
        
        foodLunch.add("Tuna or Chicken Salad Sandwich");
        lunchProtein.add(30);
        lunchCarbs.add(40);
        lunchFats.add(20);
        lunchCalories.add(400);
        
        foodLunch.add("Veggie Burger on a Whole-Grain Bun");
        lunchProtein.add(20);
        lunchCarbs.add(50);
        lunchFats.add(15);
        lunchCalories.add(450);
        
        foodLunch.add("Rice Bowl with Protein, Veggies, and Sauce");
        lunchProtein.add(30);
        lunchCarbs.add(60);
        lunchFats.add(20);
        lunchCalories.add(500);
        
        foodLunch.add("Burrito Bowl with Rice, Beans, and Veggies");
        lunchProtein.add(25);
        lunchCarbs.add(65);
        lunchFats.add(25);
        lunchCalories.add(550);
        
        foodLunch.add("Grilled Cheese Sandwich with Tomato Soup");
        lunchProtein.add(20);
        lunchCarbs.add(70);
        lunchFats.add(30);
        lunchCalories.add(450);
        
        foodLunch.add("Hummus and Vegetable Wrap");
        lunchProtein.add(20);
        lunchCarbs.add(40);
        lunchFats.add(20);
        lunchCalories.add(350);
        
        foodLunch.add("Lentil Soup and Whole-Grain Bread");
        lunchProtein.add(25);
        lunchCarbs.add(45);
        lunchFats.add(20);
        lunchCalories.add(300);
        
        foodLunch.add("Quinoa Salad with Veggies and Protein");
        lunchProtein.add(20);
        lunchCarbs.add(55);
        lunchFats.add(25);
        lunchCalories.add(400);
        
        foodLunch.add("Stir-Fry with Rice or Noodles");
        lunchProtein.add(30);
        lunchCarbs.add(65);
        lunchFats.add(30);
        lunchCalories.add(500);
        
        foodLunch.add("Curry with Rice or Naan");
        lunchProtein.add(35);
        lunchCarbs.add(60);
        lunchFats.add(20);
        lunchCalories.add(550);
        
        foodLunch.add("Pizza (per slice)");
        lunchProtein.add(15);
        lunchCarbs.add(50);
        lunchFats.add(20);
        lunchCalories.add(500);
        
        foodLunch.add("Sushi (per roll)");
        lunchProtein.add(15);
        lunchCarbs.add(30);
        lunchFats.add(10);
        lunchCalories.add(300);
        
        foodLunch.add("Tacos or Burritos");
        lunchProtein.add(30);
        lunchCarbs.add(40);
        lunchFats.add(20);
        lunchCalories.add(500);
        
        foodLunch.add("Ramen Noodles with Veggies and Protein");
        lunchProtein.add(20);
        lunchCarbs.add(50);
        lunchFats.add(15);
        lunchCalories.add(400);
        
        foodLunch.add("Mac and Cheese");
        lunchProtein.add(20);
        lunchCarbs.add(50);
        lunchFats.add(20);
        lunchCalories.add(450);
        
        foodLunch.add("Sandwich with Meat, Cheese, and Veggies");
        lunchProtein.add(30);
        lunchCarbs.add(40);
        lunchFats.add(15);
        lunchCalories.add(350);
        //dinnerlist
        
        
        foodDinner.add("Grilled Turkey Burger");
        dinnerProtein.add(35);
        dinnerCarbs.add(40);
        dinnerFats.add(10);
        dinnerCalories.add(420);
        
        foodDinner.add("Grilled Steak with Roasted Vegetables");
        dinnerProtein.add(45);
        dinnerCarbs.add(50);
        dinnerFats.add(30);
        dinnerCalories.add(500);
        
        foodDinner.add("Baked Chicken with Mashed Potatoes and Green Beans");
        dinnerProtein.add(55);
        dinnerCarbs.add(60);
        dinnerFats.add(20);
        dinnerCalories.add(400);
        
        foodDinner.add("Salmon with Roasted Broccoli and Rice");
        dinnerProtein.add(40);
        dinnerCarbs.add(50);
        dinnerFats.add(25);
        dinnerCalories.add(450);
        
        foodDinner.add("Spaghetti and Meatballs");
        dinnerProtein.add(40);
        dinnerCarbs.add(70);
        dinnerFats.add(25);
        dinnerCalories.add(500);
        
        foodDinner.add("Chicken Stir-Fry with Rice");
        dinnerProtein.add(40);
        dinnerCarbs.add(60);
        dinnerFats.add(35);
        dinnerCalories.add(400);
        
        foodDinner.add("Shrimp Scampi with Pasta");
        dinnerProtein.add(35);
        dinnerCarbs.add(50);
        dinnerFats.add(25);
        dinnerCalories.add(500);
        
        foodDinner.add("Beef Stew with Bread");
        dinnerProtein.add(35);
        dinnerCarbs.add(50);
        dinnerFats.add(25);
        dinnerCalories.add(550);
        
        foodDinner.add("Chili with Cornbread");
        dinnerProtein.add(45);
        dinnerCarbs.add(55);
        dinnerFats.add(35);
        dinnerCalories.add(600);
        
        foodDinner.add("Pork Chops with Roasted Potatoes and Carrots");
        dinnerProtein.add(55);
        dinnerCarbs.add(65);
        dinnerFats.add(45);
        dinnerCalories.add(650);
        
        foodDinner.add("Roasted Chicken with Potatoes and Carrots");
        dinnerProtein.add(65);
        dinnerCarbs.add(75);
        dinnerFats.add(55);
        dinnerCalories.add(750);
        
        foodDinner.add("Vegetarian Chili with Cornbread");
        dinnerProtein.add(65);
        dinnerCarbs.add(75);
        dinnerFats.add(55);
        dinnerCalories.add(750);
        
        foodDinner.add("Vegetable Curry with Rice");
        dinnerProtein.add(55);
        dinnerCarbs.add(65);
        dinnerFats.add(45);
        dinnerCalories.add(500);
        
        foodDinner.add("Tofu Stir-Fry with Noodles");
        dinnerProtein.add(45);
        dinnerCarbs.add(55);
        dinnerFats.add(25);
        dinnerCalories.add(400);
        
        foodDinner.add("Tacos or Burritos");
        dinnerProtein.add(45);
        dinnerCarbs.add(55);
        dinnerFats.add(25);
        dinnerCalories.add(400);
        
        foodDinner.add("Enchiladas");
        dinnerProtein.add(45);
        dinnerCarbs.add(55);
        dinnerFats.add(20);
        dinnerCalories.add(450);
        
        foodDinner.add("Lasagna");
        dinnerProtein.add(45);
        dinnerCarbs.add(65);
        dinnerFats.add(25);
        dinnerCalories.add(500);
        
        foodDinner.add("Shepherd's Pie");
        dinnerProtein.add(45);
        dinnerCarbs.add(65);
        dinnerFats.add(25);
        dinnerCalories.add(400);
        
        foodDinner.add("Roast Beef with Yorkshire Pudding");
        dinnerProtein.add(55);
        dinnerCarbs.add(65);
        dinnerFats.add(35);
        dinnerCalories.add(600);
        
        foodDinner.add("Grilled Pork Chops with Mashed Potatoes and Green Beans");
        dinnerProtein.add(55);
        dinnerCarbs.add(65);
        dinnerFats.add(35);
        dinnerCalories.add(500);
        
        
        //snack list
        foodSnacks.add("Protein Smoothie");
        snacksProtein.add(25);
        snacksCarbs.add(20);
        snacksFats.add(5);
        snacksCalories.add(220);

        setSize(500, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        revalidate();
        repaint();

        // Labels.
        titlelb = new JLabel("Meal Tracker");
        titlelb.setBounds(180, 20, 150, 30);
        add(titlelb);

        mealnamelb = new JLabel("Category:");
        mealnamelb.setBounds(20, 80, 150, 30);
        add(mealnamelb);

        categorylb = new JLabel("Select Meal:");
        categorylb.setBounds(20, 130, 150, 30);
        add(categorylb);

        // ComboBoxes.
        categorycb = new JComboBox<>(categories);
        categorycb.setBounds(120, 80, 150, 30);
        add(categorycb);
        categorycb.addActionListener(this);

        mealSelector = new JComboBox<>();
        mealSelector.setBounds(120, 130, 300, 30);
        add(mealSelector);
        mealSelector.addActionListener(this);

        // Display.
        resultTxt = new JTextArea();
        resultTxt.setBounds(20, 200, 400, 220);
        resultTxt.setEditable(false);
        add(resultTxt);

        // Buttons.
        clearbtn = new JButton("Clear");
        clearbtn.setBounds(50, 450, 100, 30);
        add(clearbtn);

        homebtn = new JButton("Home");
        homebtn.setBounds(180, 450, 100, 30);
        add(homebtn);

        addNewMealbtn = new JButton("Add New Meal");
        addNewMealbtn.setBounds(300, 450, 150, 30);
        add(addNewMealbtn);

        submitbtn = new JButton("Submit");
        submitbtn.setBounds(180, 500, 100, 30);
        add(submitbtn);

        clearbtn.addActionListener(this);
        homebtn.addActionListener(this);
        addNewMealbtn.addActionListener(this);
        submitbtn.addActionListener(this);

        // Initialize meal options.
        updateMealSelector();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == categorycb) {
            updateMealSelector();
        } else if (e.getSource() == mealSelector) {
            displayMealDetails();
        } else if (e.getSource() == clearbtn) {
            resultTxt.setText("");
        } else if (e.getSource() == homebtn) {
            new mainDashboard();
            dispose();
        } else if (e.getSource() == addNewMealbtn) {
            new AddMealDialog(this);
        }
    }

    private void updateMealSelector() {
        mealSelector.removeAllItems();
        String selectedCategory = (String) categorycb.getSelectedItem();

        ArrayList<String> selectedList = switch (selectedCategory) {
            case "Breakfast" -> foodBreakfast;
            case "Lunch" -> foodLunch;
            case "Dinner" -> foodDinner;
            case "Snacks" -> foodSnacks;
            default -> new ArrayList<>();
        };

        for (String meal : selectedList) {
            mealSelector.addItem(meal);
        }
    }

    private void displayMealDetails() {
        String selectedCategory = (String) categorycb.getSelectedItem();
        int selectedIndex = mealSelector.getSelectedIndex();

        if (selectedIndex == -1) return;

        int protein = 0, carbs = 0, fats = 0, calories = 0;

        ArrayList<Integer> proteinList, carbsList, fatsList, caloriesList;

        switch (selectedCategory) {
            case "Breakfast" -> {
                proteinList = breakfastProtein;
                carbsList = breakfastCarbs;
                fatsList = breakfastFats;
                caloriesList = breakfastCalories;
            }
            case "Lunch" -> {
                proteinList = lunchProtein;
                carbsList = lunchCarbs;
                fatsList = lunchFats;
                caloriesList = lunchCalories;
            }
            case "Dinner" -> {
                proteinList = dinnerProtein;
                carbsList = dinnerCarbs;
                fatsList = dinnerFats;
                caloriesList = dinnerCalories;
            }
            case "Snacks" -> {
                proteinList = snacksProtein;
                carbsList = snacksCarbs;
                fatsList = snacksFats;
                caloriesList = snacksCalories;
            }
            default -> throw new IllegalStateException("Unexpected value: " + selectedCategory);
        }

        protein = proteinList.get(selectedIndex);
        carbs = carbsList.get(selectedIndex);
        fats = fatsList.get(selectedIndex);
        calories = caloriesList.get(selectedIndex);

        String selectedMeal = (String) mealSelector.getSelectedItem();
        resultTxt.setText("Meal: " + selectedMeal + "\n" +
                "Protein: " + protein + "g\n" +
                "Carbs: " + carbs + "g\n" +
                "Fats: " + fats + "g\n" +
                "Calories: " + calories + " kcal");
    }

    public void addMeal(String category, String mealName, int protein, int carbs, int fats, int calories) {
        switch (category) {
            case "Breakfast" -> {
                foodBreakfast.add(mealName);
                breakfastProtein.add(protein);
                breakfastCarbs.add(carbs);
                breakfastFats.add(fats);
                breakfastCalories.add(calories);
            }
            case "Lunch" -> {
                foodLunch.add(mealName);
                lunchProtein.add(protein);
                lunchCarbs.add(carbs);
                lunchFats.add(fats);
                lunchCalories.add(calories);
            }
            case "Dinner" -> {
                foodDinner.add(mealName);
                dinnerProtein.add(protein);
                dinnerCarbs.add(carbs);
                dinnerFats.add(fats);
                dinnerCalories.add(calories);
            }
            case "Snacks" -> {
                foodSnacks.add(mealName);
                snacksProtein.add(protein);
                snacksCarbs.add(carbs);
                snacksFats.add(fats);
                snacksCalories.add(calories);
            }
        }
        updateMealSelector();
    }

    public static void main(String[] args) {
        new trackMeal().setVisible(true);
    }
}

class AddMealDialog extends JDialog implements ActionListener {

    private JTextField mealNameTxt, proteinTxt, carbsTxt, fatsTxt, caloriesTxt;
    private JComboBox<String> categoryCombo;
    private JButton addBtn, cancelBtn;
    private trackMeal parent;

    public AddMealDialog(trackMeal parent) {
        this.parent = parent;
        setTitle("Add New Meal");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel categoryLbl = new JLabel("Category:");
        categoryLbl.setBounds(20, 20, 100, 30);
        add(categoryLbl);

        categoryCombo = new JComboBox<>(parent.categories);
        categoryCombo.setBounds(120, 20, 150, 30);
        add(categoryCombo);

        JLabel mealNameLbl = new JLabel("Meal Name:");
        mealNameLbl.setBounds(20, 70, 100, 30);
        add(mealNameLbl);

        mealNameTxt = new JTextField();
        mealNameTxt.setBounds(120, 70, 150, 30);
        add(mealNameTxt);

        JLabel proteinLbl = new JLabel("Protein (g):");
        proteinLbl.setBounds(20, 120, 100, 30);
        add(proteinLbl);

        proteinTxt = new JTextField();
        proteinTxt.setBounds(120, 120, 150, 30);
        add(proteinTxt);

        JLabel carbsLbl = new JLabel("Carbs (g):");
        carbsLbl.setBounds(20, 170, 100, 30);
        add(carbsLbl);

        carbsTxt = new JTextField();
        carbsTxt.setBounds(120, 170, 150, 30);
        add(carbsTxt);

        JLabel fatsLbl = new JLabel("Fats (g):");
        fatsLbl.setBounds(20, 220, 100, 30);
        add(fatsLbl);

        fatsTxt = new JTextField();
        fatsTxt.setBounds(120, 220, 150, 30);
        add(fatsTxt);

        JLabel caloriesLbl = new JLabel("Calories:");
        caloriesLbl.setBounds(20, 270, 100, 30);
        add(caloriesLbl);

        caloriesTxt = new JTextField();
        caloriesTxt.setBounds(120, 270, 150, 30);
        add(caloriesTxt);

        addBtn = new JButton("Add");
        addBtn.setBounds(50, 320, 80, 30);
        add(addBtn);
        addBtn.addActionListener(this);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(150, 320, 80, 30);
        add(cancelBtn);
        cancelBtn.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            String category = (String) categoryCombo.getSelectedItem();
            String mealName = mealNameTxt.getText();
            int protein = Integer.parseInt(proteinTxt.getText());
            int carbs = Integer.parseInt(carbsTxt.getText());
            int fats = Integer.parseInt(fatsTxt.getText());
            int calories = Integer.parseInt(caloriesTxt.getText());

            parent.addMeal(category, mealName, protein, carbs, fats, calories);
            JOptionPane.showMessageDialog(this, "Meal added successfully!");
            dispose();
        } else if (e.getSource() == cancelBtn) {
            dispose();
        }
    }
}
