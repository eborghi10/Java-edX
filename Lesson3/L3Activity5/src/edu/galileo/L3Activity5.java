package edu.galileo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class L3Activity5 {

    public static void main(String[] args) throws Exception {
        /*
         * Users can create combos with: 1 Main Dish, 1 Drink and 1 Dessert.
         * Create the class "Combo" and a method called "CalculateComboPrice" to get the price of the combo.
         *
         * Your task is to complete or implement the classes and methods,
         * and create 20 combinations of "Food" to show to the user.
         *
         * Each "combo" can have a random discount range (from $0.00 to $5.00),
         * and a price (the sum of the price of each "Food" Object minus the discount).
         */
        Scanner input = null;

        try {
            String fileMainDish = "information/main_dish.txt";
            String fileDrink = "information/drinks.txt";
            String fileDessert = "information/dessert.txt";

            ArrayList<MainDish> mainDishList = new ArrayList<>();
            ArrayList<Drink> drinkList = new ArrayList<>();
            ArrayList<Dessert> dessertList = new ArrayList<>();

            ////////////////////////////////////////////////////////////////////

            input = new Scanner(new BufferedReader(new FileReader(fileMainDish)));
            MainDish dishElement = new MainDish();

            int cnt = 1;
            while (input.hasNext()) {
                String newLine = input.nextLine();

                switch (cnt) {
                    case 1 :
                        dishElement.setName(newLine);
                        break;
                    case 2 :
                        dishElement.setMainMeal(newLine);
                        break;
                    case 3 :
                        dishElement.setAccompaniments(newLine);
                        break;
                    case 4 :
                        dishElement.setPrice(Double.parseDouble(newLine.replace("$","")));
                        break;
                    default :
                        cnt = 0;
                        mainDishList.add(dishElement);
                        dishElement = new MainDish();
                        break;
                }
                ++cnt;
            }

            ////////////////////////////////////////////////////////////////////

            input = new Scanner(new BufferedReader(new FileReader(fileDrink)));
            Drink drinkElement = new Drink();

            cnt = 1;
            while (input.hasNext()) {
                String newLine = input.nextLine();

                switch (cnt) {
                    case 1 :
                        drinkElement.setName(newLine);
                        break;
                    case 2 :
                        drinkElement.setPrice(Double.parseDouble(newLine.replace("$","")));
                        break;
                    default :
                        cnt = 0;
                        drinkList.add(drinkElement);
                        drinkElement = new Drink();
                        break;
                }
                ++cnt;
            }

            ////////////////////////////////////////////////////////////////////

            input = new Scanner(new BufferedReader(new FileReader(fileDessert)));
            Dessert dessertElement = new Dessert();

            cnt = 1;
            while (input.hasNext()) {
                String newLine = input.nextLine();

                switch (cnt) {
                    case 1 :
                        dessertElement.setName(newLine);
                        break;
                    case 2 :
                        dessertElement.setDescription(newLine);
                        break;
                    case 3 :
                        dessertElement.setPrice(Double.parseDouble(newLine.replace("$","")));
                        break;
                    default :
                        cnt = 0;
                        dessertList.add(dessertElement);
                        dessertElement = new Dessert();
                        break;
                }
                ++cnt;
            }

            ////////////////////////////////////////////////////////////////////

            ArrayList<Combo> comboList = new ArrayList<>(20);

            for (Combo c : comboList) {
                c.
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
}

abstract class Food {
    private String name;
    private double price;
    public Food() {
        ;
    }

    void setName(String name) {
        this.name = name;
    }

    void setPrice(double price) {
        this.price = price;
    }

    public abstract String toString();
}

class MainDish extends Food {
    private String mainMeal, accompaniments;

    public MainDish() {
        ;
    }

    public String toString(){
        return "";
    }

    public void setMainMeal(String mainMeal) {
        this.mainMeal = mainMeal;
    }

    public void setAccompaniments(String accompaniments) {
        this.accompaniments = accompaniments;
    }

    @Override
    void setName(String name) {
        super.setName(name);
    }

    @Override
    void setPrice(double price) {
        super.setPrice(price);
    }
}

class Drink extends Food {
    public Drink() {
        ;
    }

    public String toString(){
        return "";
    };

    @Override
    void setName(String name) {
        super.setName(name);
    }

    @Override
    void setPrice(double price) {
        super.setPrice(price);
    }
}

class Dessert extends Food {
    private String description;
    public Dessert() {
        ;
    }

    public String toString(){
        return "";
    };

    public void setDescription(String description) {
        this.description = description;
    }
}


class Combo {
    //Combine Main Dish, Drink, Dessert
    private int mainDish;
    private int drink;
    private int dessert;
    private double ComboPrice;

    public Combo(MainDish mainDish, Drink drink, Dessert dessert) {
        this.mainDish = mainDish;
        this.
    }

    private double calculateComboPrice(){
        // Get the price of the combo
        return 0.00;
    }

    private double calculateComboDiscount(){
        return 0.00;
    }

    public String toString(){
        return "";
    };
}
