package edu.galileo;

import java.util.Arrays;    // to use toString()

public class Main {

    public static void main(String[] args) throws Exception{
        int intArray[] = new int[3];
        System.out.println("Array of primitive int: "
                + Arrays.toString(intArray));
        // They are all created with zero values

        Integer integerArray[] = new Integer[3];
        System.out.print("\n\nArray of integer object: "
                + Arrays.toString(integerArray));
        // All the elements are initialized with "null"
        // It doesn't have any reference to the heap

        // We assign a value to the first element
        integerArray[0] = new Integer(5);
        System.out.println("\t" + Arrays.toString(integerArray));

        // Array of Foo objects
        Foo fooArray[] = {
                new Foo(1),
                new Foo(2),
                new Foo(3)
        };
        System.out.println("\n\nArray of Foo object: "
                + Arrays.toString(fooArray));
        // Prints the reference of the Foo object on the heap
        // EXCEPTS that, it's created the method toString().

        // The Garbage Collector (GC) will erase the element
        fooArray[1] = null;
        System.out.println(Arrays.toString(fooArray));
    }
}

class Foo {
    private int id;

    public Foo(int id) {
        this.id = id;
    }

    public String toString() {
        return "I'm the Foo object #" + this.id;
    }

}