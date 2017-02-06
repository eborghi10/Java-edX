package edu.galileo;

public class Main {

    public static void main(String[] args) {

        String[][] pets = new String[2][3];

        // Dogs
        pets[0][0] = "French poodle";
        pets[0][1] = "Boxer";
        pets[0][2] = "Chihuahua";
        // Cats
        pets[1][0] = "British short hair";
        pets[1][1] = "Himalayan";
        pets[1][2] = "Siberian";

        System.out.println("Pets:");

        for(int type = 0; type < pets.length; type++) {
            for (int breed = 0; breed < pets[type].length; breed++) {
                System.out.println("- " + pets[type][breed]);
            }
        }
    }
}
