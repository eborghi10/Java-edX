package edu.galileo;

/**
 * Created by emiliano on 30/01/17.
 */
public class Human {
    protected String name;

    public Human(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println(this.name);
    }
}
