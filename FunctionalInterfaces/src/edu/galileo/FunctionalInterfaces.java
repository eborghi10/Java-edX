package edu.galileo;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalInterfaces {

    public static void main(String[] args) throws Exception {

        // Creates a grocery store list (: Tienda de comestibles)
        // Arrays.asList: returns a fixed-size list backed by the specified array.
        // To be dynamic use LinkedList.
        List<Product> groceryStore = new LinkedList<>(
                Arrays.asList(
                        new Product(0, "Tomato", "Fruit", 1.75f),
                        new Product(1, "Avocado", "Fruit", 5f),
                        new Product(2, "Lemon", "Fruit", 0.5f),
                        new Product(3, "Onion", "Vegetable", 1.50f),
                        new Product(4, "Carrot", "Vegetable", 1.25f),
                        new Product(5, "Broccoli", "Vegetable", 2f),
                        new Product(6, "Shrimp", "Seafood", 10.99f),
                        new Product(7, "Chicken", "Meat", 7.35f),
                        new Product(8, "Roast Beef", "Meat", 8.35f)
                )
        );

        // Print each of the products using a Lambda expression
        System.out.println("Original list: ");
        groceryStore.forEach(
                product -> System.out.println(product)
        );

        // Predicate filter or meat category
        Predicate<Product> meatRemover =
                (Product product) -> "Meat".equals(product.category);

        // Remove meat category
        groceryStore.removeIf(meatRemover);
        // Print each of the products
        System.out.println("\nWithout meat list: ");
        groceryStore.forEach(
                product -> System.out.println(product)
        );

        // Predicate filter of expensive products
        Predicate<Product> expensiveRemover =
                (Product product) -> product.price > 5f;

        // Remove expensive products
        groceryStore.removeIf(expensiveRemover);
        // Print each of the products
        System.out.println("\nWithout expensive & meat list: ");
        groceryStore.forEach(
                product -> System.out.println(product)
        );

        // Just filter first fruit-without eliminating the other products
        System.out.println("\n\nFilter first fruit:");
        System.out.println(
                groceryStore.stream().filter(
                        (Product product) -> product.category.equals("Fruit")
                ).findFirst()
        );

        // Filter fruit new list
        /*
         * stream() filters the list without modifying it.
         * collect() is used to take the resulting list
         *
         */
        System.out.println("\n\nFilter all fruit:");
        System.out.println(
                groceryStore.stream().filter(
                        (Product product) -> product.category.equals("Fruit")
                ).collect(Collectors.toList())
        );

        // Print each of the products
        System.out.println("\nDon't eliminate the other products, just filter: ");
        groceryStore.forEach(
                product -> System.out.println(product)
        );
    }
}

class Product {
    public int id;
    public String name, category;
    public float price;

    public Product(int id, String name, String category, float price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String toString() {
        return (this.name + (new DecimalFormat(" $0.00")).format(this.price));
    }
}