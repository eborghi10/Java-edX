package com.company;

public class Main {

    public static void main(String[] args) {
        String weather = "sunny";
//        String weather = "rainy";
//        String weather = "windy";

        if (weather == "rainy") {
            System.out.println("Don't forget to bring your umbrella");
        } else if (weather == "sunny"){
            System.out.println("Don't forget your sunglasses");
        } else if (weather == "windy") {
            System.out.println("Don't forget to bring your coat");
        } else {
            System.out.println("Enjoy the snow!");
        }

        System.out.println("Basic for-loop example: ");
        for (int seq=0; seq <= 10; seq++) {
            System.out.println(seq);
        }

        // While-loop example
        int seqWhile = 0;
        while (seqWhile < 10) {
            System.out.println("While= " + seqWhile);
            seqWhile++;
        }

        // Do While-loop example
        int seqDoWhile = 0;
        do {
            System.out.println("do-while= " + seqDoWhile);
            seqDoWhile++;
        } while (seqDoWhile < 10);
    }
}
