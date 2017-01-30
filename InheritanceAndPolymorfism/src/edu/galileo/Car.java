package edu.galileo;

/**
 * Created by emiliano on 30/01/17.
 */
public class Car {
    public int topSpeed;

    public Car(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public int getTopSpeed() {
        return this.topSpeed;
    }

    public void printDescription() {
        System.out.println("Car");
    }
}
