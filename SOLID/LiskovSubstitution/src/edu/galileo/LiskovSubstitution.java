package edu.galileo;

import java.util.ArrayList;

public class LiskovSubstitution {

    /*
     * Objects can be substituted by their subclasses
     */

    public static void main(String[] args) throws Exception {
        PetShopInfoCenter.addProduct(
                new Dog(
                        180,
                        100,
                        15,
                        "If you Adopt Supplies are Free"
                )
        );
        PetShopInfoCenter.addProduct(
                new Fish(15, 15)
        );

        System.out.println(PetShopInfoCenter.generateCatalogue());

    }
}


final class PetShopInfoCenter {
    private static ArrayList<Animal> productCatalogue = new ArrayList<Animal>();

    public PetShopInfoCenter() {
        ;
    }

    public static void addProduct(Animal pet) {
        productCatalogue.add(pet);
    }

    public static String generateCatalogue(){
        String catalogue = "";

        for (Animal pet: productCatalogue) {
            catalogue += pet.getName() + ":\n\t" +
                    pet.getCompletePrice() +
                    "\n\t" + pet.getExtraSupplies() +
                    "\n\t" + pet.getBuyOptions() + "\n\n";
        }

        return catalogue;
    }
}

// Father Class
abstract class Animal {
    private String name;
    private int basePrice, suppliesPrice;

    public Animal(String name, int basePrice, int suppliesPrice) {
        this.name = name;
        this.basePrice = basePrice;
        this.suppliesPrice = suppliesPrice;
    }

    public String getName() {
        return this.name;
    }
    public String getCompletePrice() {
        return "Animal Price: $" + this.basePrice + ".00 + Supplies Price: $" + this.suppliesPrice +
                ".00\n\tTotal Price: $" + (this.basePrice + this.suppliesPrice) + ".00";
    }

    public abstract String getExtraSupplies();
    public abstract String getBuyOptions();
}

// Child Class
class Dog extends Animal {
    private String otherRelatedData;
    private int obligatorySuppliesPrice, optionalSuppliesPrice;
    public Dog(int basePrice, int obligatory, int optional, String otherRelatedData) {
        super("Dog", basePrice, obligatory + optional);
        this.otherRelatedData = otherRelatedData;
        this.obligatorySuppliesPrice = obligatory;
        this.optionalSuppliesPrice = optional;
    }

    public String getExtraSupplies(){
        return "\tObligatory: Vaccines, Food 50kg\t($"+
                this.obligatorySuppliesPrice +
                ".00)\n\t\tOptional: dog collar & harness\t($"+
                this.optionalSuppliesPrice +".00)";
    };

    public String getBuyOptions(){
        return "Breeds: Golden Retriever, Schnauzer, Husky\n\t" + this.otherRelatedData;
    };
}

// Child Class
class Fish extends Animal {
    public Fish(int basePrice, int suppliesPrice) {
        super("Fish", basePrice, suppliesPrice);
    }

    public String getExtraSupplies(){
        return "\tFishbowl, Food, Fungicide Drops";
    };

    public String getBuyOptions(){
        return "Breeds: Beta, Koi, Angel\n\t";
    };
}