package edu.galileo;

/**
 * Created by emiliano on 30/01/17.
 *
 * The CHILD class "F1Car" inherits from
 * the PARENT class "Car".
 *
 */
public class F1Car extends Car {
    /*
     * We need to initialize the parent class
     * by calling the method "Super".
     *
     */
    public F1Car (int topSpeed) {
        super(topSpeed);
    }

    // We'll to OVERRIDE the method printDescription()
    public void printDescription() {
        System.out.println("F1 Car");
    }
}
