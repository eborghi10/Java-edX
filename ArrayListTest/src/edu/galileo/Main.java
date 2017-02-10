package edu.galileo;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.print("Test of an array list:");

        MyClass object;
        ArrayList<MyClass> classList = new ArrayList<>();

        object = new MyClass();
        object.setVar(3);
        object.setName("Pepe");
        object.setMoreNumbers(15);
        object.setMoreNumbers(46);
        classList.add(object);

        object = new MyClass();
        object.setVar(6);
        object.setName("Miguel");
        object.setMoreNumbers(45);
        object.setMoreNumbers(235);
        object.setMoreNumbers(-124);
        classList.add(object);

        for(MyClass it : classList) {
            System.out.print(it.toString());
        }
    }
}