package edu.galileo;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        // First example
        HashMap<Integer, String> months = new HashMap<>();
        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");

        System.out.println("First month: " + months.get(1));
        System.out.println("Last month: " + months.get(12));
        System.out.println("Month #13: " + months.get(13) + "\n\n");

        // Second example
        HashMap<String, String> countries = new HashMap<>();
        countries.put("GTM", "Guatemala");
        countries.put("USA", "United States of America");
        countries.put("CHN", "China");
        countries.put("ESP", "Spain");

        countries.forEach(
                (code,name) -> System.out.println("*code: " + code
                        + ", name: " + name));

    }
}
