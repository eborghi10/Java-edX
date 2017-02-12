package edu.galileo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
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
                        dishElement.setPrice(newLine);
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
                        drinkElement.setPrice(newLine);
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
                        dessertElement.setPrice(newLine);
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

            System.out.println("Menu");
            System.out.println("\n\tMain Dishes");
            for (MainDish mainDishItem : mainDishList) {
                System.out.print(mainDishItem.toString());
            }
            System.out.println("\n\n\tDrinks");
            for (Drink drinkItem : drinkList) {
                System.out.print(drinkItem.toString());
            }
            System.out.println("\n\n\tDessert");
            for (Dessert dessertItem : dessertList) {
                System.out.print(dessertItem.toString());
            }

            ////////////////////////////////////////////////////////////////////

            ArrayList<Combo> comboList = new ArrayList<>(20);
            Random r = new Random();

            for (int i = 0; i < 20; i++) {
                Combo temp = new Combo(
                        mainDishList.get( r.nextInt(mainDishList.size()) ),
                        drinkList.get( r.nextInt(drinkList.size()) ),
                        dessertList.get( r.nextInt(dessertList.size()) ),
                        5.00 * r.nextDouble()
                );
                comboList.add(temp);
            }

            System.out.print("\n\nCombos with special discount:");
            for (Combo c : comboList) {
                System.out.print(c.toString());
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

    void setName(String name) {
        this.name = name;
    }

    final void setPrice(String price) {
        this.price = Double.parseDouble(price.replace("$",""));
    }

    final public String nameToString() {
        return ("\n\t\t" + this.getName());
    }

    final public String priceToString() {
        return ("\n\t\t\t$" + String.format("%.2f", this.getPrice()));
    }

    public String getName() { return this.name; }

    public double getPrice() { return this.price; }
}

class MainDish extends Food {

    private String mainMeal, accompaniments;

    public MainDish() {
        this.mainMeal = "";
        this.accompaniments = "";
    }

    public String toString(){
        return (super.nameToString() + "\n\t\t\t" + this.mainMeal
                + "\n\t\t\t" + this.accompaniments + super.priceToString());
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
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}

class Drink extends Food {
    public Drink() {
        ;
    }

    public String toString(){
        return (super.nameToString() + super.priceToString());
    }

    @Override
    void setName(String name) {
        super.setName(name);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}

class Dessert extends Food {

    private String description;

    public Dessert() {
        this.description = "";
    }

    public String toString(){
        return (super.nameToString() + "\n\t\t\t" + this.description + super.priceToString());
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}

class Combo {
    //Combine Main Dish, Drink, Dessert
    private MainDish mainDish;
    private Drink drink;
    private Dessert dessert;
    private double comboPrice;
    private double discount;

    public Combo(MainDish mainDish, Drink drink, Dessert dessert, double discount) {
        this.mainDish = mainDish;
        this.drink = drink;
        this.dessert = dessert;
        this.discount = discount;
        this.comboPrice = this.calculateComboPrice();
    }

    private double calculateComboPrice(){
        // Get the price of the combo
        return this.mainDish.getPrice() + this.drink.getPrice()
                + this.dessert.getPrice() - this.calculateComboDiscount();
    }

    private double calculateComboDiscount(){
        return this.discount;
    }

    public String toString(){

        return ("\n\n\t" + this.mainDish.getName() + " + "
                + this.drink.getName() + " + " + this.dessert.getName()
                + "\n\t\t$" + String.format("%.2f", this.comboPrice));
    }
}


