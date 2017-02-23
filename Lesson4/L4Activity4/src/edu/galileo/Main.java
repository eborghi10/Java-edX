package edu.galileo;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.text.DecimalFormat;

public class Main {

    static List<Product> technologyStore = null;

    // Read from file products.txt the list of products
    // Format: Name Category Stock Price

    public static void readProductsFile() {
        String filePath = "products.txt";

        Scanner input = null;

        try {
            input = new Scanner(new BufferedReader(new FileReader(filePath)));

            int lines = 0;
            int cols = 0;
            String[][] attributes = new String[1][4];
            while(input.hasNext()) {

                String data = input.next();
                if (data != null) {
                        if (cols > 3) {
                            cols = 0;
                            attributes[][] = new String[4];
                            lines++;
                        }
                    attributes[lines][cols] = data;
                    lines++;
                }
            }
            for (int i = 0; i < attributes[0].length; i++) {

                List<Product> productList = Arrays.asList(
                        new Product(
                                Integer.valueOf(attributes[0][i]),
                                attributes[1][i],
                                attributes[2][i],
                                Float.parseFloat(attributes[3][i]),
                                Integer.valueOf(attributes[4][i])
                        )
                );

            }
            //technologyStore = new LinkedList<>(productList);
        } catch (FileNotFoundException e) {
            System.out.println("> File not found!");
        } finally {
            if (input != null){
                input.close();
            }
        }
    }

    //Print each of the products
    public static void printProducts() {

    }

    //Filter and print from the list all the products that are Accessories
    public static void filter2() {

    }

    //Filter and print from the list all the products that the stock is more or equal to 50
    public static void filter3() {


    }

    //Filter and print from the list all the products that: are cheaper than $150.00 and has more than 25 in stock
    public static void filter4() {


    }

    public static void filter5() {
        //Remove from the list (don't print) if product: the categorie is Office
        //Your Code here

        //Remove from the list (don't print) if product: has less than 30 in stock
        //Your Code here

        //Remove from the list (don't print) if product: are cheaper than $250.00
        //Your Code here

        //Print each of the products that left
        //Your Code here
    }

    public static void main(String[] args) {

        Main activity4 = new Main();
        activity4.readProductsFile();
        System.out.println("----------Filter 1---------");
        activity4.printProducts();
        System.out.println("----------Filter 2---------");
        activity4.filter2();
        System.out.println("----------Filter 3---------");
        activity4.filter3();
        System.out.println("----------Filter 4---------");
        activity4.filter4();
        System.out.println("----------Filter 5---------");
        activity4.filter5();


        /* ANSWER

        ----------Filter 1---------
        Laptop-12GB_RAM-HDD_1T Printer Headphones HDMI-VGA-Adapter Laptop-16GB_RAM-SSD_750GB Scanner Computer-Keyboard AUX_5ft Ink-Cartridge Mouse-Wireless Laptop-8GB_RAM-HDD_500GB USB-microUSB
        ----------Filter 2---------
        Headphones Computer-Keyboard Mouse-Wireless
        ----------Filter 3---------
        Printer Headphones AUX_5ft Ink-Cartridge Mouse-Wireless USB-microUSB
        ----------Filter 4---------
        Headphones Computer-Keyboard AUX_5ft Ink-Cartridge Mouse-Wireless USB-microUSB
        ----------Filter 5---------
        Laptop-12GB_RAM-HDD_1T Laptop-16GB_RAM-SSD_750GB Laptop-8GB_RAM-HDD_500GB
        */

    }
}
