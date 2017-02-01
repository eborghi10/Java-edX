package edu.galileo;

/**
 * Created by emiliano on 30/01/17.
 *
 * The class "Car" implements the class INTERFACE "Vehicle"
 *
 */
public class Car implements Vehicle {
    private String transportType = "terrestrial";

    private int wheels;

    public Car(int wheels) {
        // Constructor of the class
        this.wheels = wheels;
    }

    public String getTransportType() {
        // IMPLEMENTING the interface "vehicle"
        return this.transportType;
    }

    public boolean hasWheels() {
        // Another implementation
        return (this.wheels > 0);
    }

    public int getNumberOfWheels() {
        // This function is only inside this class
        // It's not implemented in the interface "Vehicle"
        return this.wheels;
    }
}
