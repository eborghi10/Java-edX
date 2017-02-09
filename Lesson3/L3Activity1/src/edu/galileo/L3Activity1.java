package edu.galileo;

import java.util.ArrayList;

public class L3Activity1 {

    public static void main(String[] args) {
/*
        String [] toys = new String [9];
        toys[0] = "Buzz Lightyear";
        toys[1] = "Sheriff Woody";
        toys[2] = "Mr. Potato Head";
        toys[3] = "Barbie";
        toys[4] = "Troll doll";
        toys[5] = "Tonka Truck";
        toys[6] = "Elmo";
        toys[7] = "Big bird";
        toys[8] = "Cookie Monster";
*/
        //Make a list of lists or hashmap to classify the toys.
        //Then sort the list of lists or hashmap ascendingly
        //Print each value

        ArrayList<String> toys = new ArrayList<>();
        toys.add("Buzz Lightyear");
        toys.add("Sheriff Woody");
        toys.add("Mr. Potato Head");
        toys.add("Barbie");
        toys.add("Troll doll");
        toys.add("Tonka Truck");
        toys.add("Elmo");
        toys.add("Big bird");
        toys.add("Cookie Monster");

        for (String tmp : toys) {
            System.out.println(tmp);
        }
    }
}
