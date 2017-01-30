package edu.galileo;

/**
 * Created by emiliano on 30/01/17.
 *
 * The class "Car" implements the class INTERFACE "Vehicle"
 *
 */
public class Car implements Vehicle {
    public String transportType = "terrestrial";

    public int wheels;

    public Car(int wheels) {
        this.wheels = wheels;
    }

    public String getTransportType() {
        return this.transportType;
    }

    public boolean hasWheels() {
        return (this.wheels > 0);
    }

    public int getNumberOfWheels() {
        return this.wheels;
    }
}
