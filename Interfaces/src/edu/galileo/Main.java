package edu.galileo;

/*
 * INTERFACES are used to ensure that the class who
 * implements it, contains all of the functionality
 * required by it.
 *
 * It means that it must have all of the methods
 * defined in the interface within the class' body.
 *
 */

public class Main {

    public static void main(String[] args) {
        Car taxi = new Car(4);

        System.out.println("Taxi has wheels? " + taxi.hasWheels()
                + ", Number of wheels: " + taxi.getNumberOfWheels());
    }
}
