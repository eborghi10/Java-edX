package edu.galileo;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
	    System.out.println("----Dynamic Structures----\n");

	    // Create an empty Array List
        System.out.print("Empty Array List: ");
        // The 2nd data type it's implicit (<String>)
        ArrayList<String> dynamicList = new ArrayList<>();
        System.out.println(dynamicList);

        // Add elements to the List
        System.out.print("\nAdd an element to the ArrayList: ");
        dynamicList.add("I'm Dynamic");
        System.out.println(dynamicList);
        System.out.println("\t My size: " + dynamicList.size());

        System.out.print("\nAdd a second element to the ArrayList: ");
        dynamicList.add("I'm Growing");
        System.out.println(dynamicList);
        System.out.println("\t My size: " + dynamicList.size());
        // The size of the array is increasing (chage its size)
        // The new elements (String) are added to the end of the Array

        // String Pool
        // The list contains directions to the String objects (on the heap)
        System.out.println("\n\nCreating String I'm Growing and another one");
        String grow = "I'm Growing", other = "other";
        System.out.println("== compare the direction (pointer) of a Object");
        System.out.println( grow == dynamicList.get(1) );
        System.out.println( other == dynamicList.get(1) );
        System.out.println("The two strings has the same value so," +
                "\nthe String Pool of JVM assign the same direction to both strings\n\n");
        // The string "grow" has the same REFERENCE as the first element on "dynamicList"

        // HashMap <Key,Value> : Another dynamic data type
        System.out.print("Empty HashMap: ");
        HashMap<Integer,String> map = new HashMap<>();
        System.out.println(map);
        map.put(10,"I'm Dynamic");
        System.out.println(map);
        map.put(25,"I'm Growing");
        System.out.println(map);

        // String Pool
        System.out.println("\nDoesn't matter on what Structure the Strings are stored");
        // CAUTION: use parenthesis in the print() to avoid an error
        System.out.println("\t\tString I'm Growing: "
                + (dynamicList.get(0) == map.get(10)) );
        System.out.println("\t\tString I'm Dynamic: "
                + (dynamicList.get(1) == map.get(25)) );
        System.out.println("They are all just a reference to the String Pool");
    }
}
