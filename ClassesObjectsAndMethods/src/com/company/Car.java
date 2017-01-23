package com.company;

/**
 * Created by emiliano on 23/01/17.
 */
public class Car {

    /*
     * ATTRIBUTES
     */

    String Color, CompanyCar, Model, Line, Engine, Chassis, Owner;

    /*
     * CONSTRUCTORS
     */

    public Car(String color, String companyCar, String model, String line, String chassis, String owner) {
        Color = color;
        CompanyCar = companyCar;
        Model = model;
        Line = line;
        Chassis = chassis;
        Owner = owner;
    }

    public Car(String color, String companyCar, String model, String line, String chassis) {
        Color = color;
        CompanyCar = companyCar;
        Model = model;
        Line = line;
        Chassis = chassis;
        Owner = " ";
    }

    /*
     * METHODS
     */

    public void buycar(String owner) {
        Owner = owner;
        System.out.println("Congratulations! " + owner + " you just bought a car with the following specs: ");
        printCar();
    }

    public void returncar() {
        Owner = "";
        System.out.println("Returning car to agency...");
    }

    public void paintCar(String color) {
        Color = color;
    }

    public void printCar() {
        if (Owner == " ") {
            System.out.println("Hello, the color's car is " + Color + " Company car " + CompanyCar +
                    " line " + Line + " model " + Model + " and it has no owner");
        } else {
            System.out.println("Hello, the color's car is " + Color + " Company car " + CompanyCar +
                    " line " + Line + " model " + Model + " and it belongs to " + Owner);
        }
    }

}
