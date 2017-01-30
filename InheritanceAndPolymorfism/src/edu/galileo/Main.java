package edu.galileo;

public class Main {

    public static void main(String[] args) {
        Car ferrari = new F1Car(320);
        Car coupe = new Car(220);

        ferrari.printDescription();
        coupe.printDescription();
    }
}
