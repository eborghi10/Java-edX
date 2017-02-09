package edu.galileo;

public class L3Activity5 {

    public static void main(String[] args) throws Exception {
        //
    }
}

abstract class Food {
    private String name;
    private double price;
    public Food() {
        ;
    }

    public abstract String toString();
}

class MainDish extends Food {
    private String mainmeal, accompaniments;
    public MainDish() {
        ;
    }

    public String toString(){
        return "";
    };
}

class Drink extends Food {
    public Drink() {
        ;
    }

    public String toString(){
        return "";
    };
}

class Dessert extends Food {
    private String description;
    public Dessert() {
        ;
    }

    public String toString(){
        return "";
    };
}


class Combo {
    //Combine Main Dish, Drink, Dessert
    private double ComboPrice;
    public Combo() {
        ;
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
