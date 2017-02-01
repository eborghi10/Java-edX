package edu.galileo;

/*
 * INTERFACES are the capabilities of the class who
 * IMPLEMENTS it.
 *
 * The best manner of know when to use interfaces, is
 * renaming this interfaces (aka capabilities) to
 * something like:
 * - Drivable (or any adjective ended in "-able")
 * - CanDrive (verbs started with "Can")
 *
 */

public class Main {

    public static void main(String[] args) {
        Car taxi = new Car(4);

        System.out.println("Taxi has wheels? " + taxi.hasWheels()
                + ", Number of wheels: " + taxi.getNumberOfWheels());
        System.out.println("Transport type: " + taxi.getTransportType());
    }
}
