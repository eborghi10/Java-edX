package edu.galileo;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumbers {

    public static void main(String[] args) {

        Integer bound = 20;
        ArrayList<Integer> myList = new ArrayList<>(bound);
        Random r = new Random();
        Integer num;

        for (Integer i = 0 ; i < bound ; i++) {
            num = r.nextInt(bound);
            System.out.println("> " + num);
        }

    }
}
