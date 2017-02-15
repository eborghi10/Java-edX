package edu.galileo;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/*
 * This program is a simulation of a restaurant.
 *
 * When a customer enters, goes to one of the two queues.
 * The Attendant asks him which food he deserves.
 * The customer takes a little bit of time to decide.
 * If there is food in stock, the customer receives its food
 * immediately. Else, it should wait.
 * Then, the customer exit.
 *
 * Three types of food: hamburger, salad and sandwich.
 * Two attendants.
 * Two customer queues.
 * One chef.
 *
 */

public class MultiThreading {

    public static void main(String[] args) throws Exception {

        Scanner inputReader = new Scanner(System.in);
        String userInput;

        Chef chef = new Chef();
        Entry comingCustomers = new Entry();
        Attender attender1 = new Attender(0);
        Attender attender2 = new Attender(1);

        chef.start();
        comingCustomers.start();
        attender1.start();
        attender2.start();

        //Stop with any key, except just Enter
        while(true){
            userInput = inputReader.next();
            chef.end();
            comingCustomers.end();
            attender1.end();
            attender2.end();
            System.exit(0);
        }
    }
}


final class FoodStock {
    /**
     * Implements methods which cook or sell a specific food.
     * They are SYNCHRONIZED because ONLY ONE thread can access
     * to them (like semaphores).
     *
     */
    private static int burger, sandwich, salad;

    private FoodStock() {}

    public static synchronized boolean cookSellBurger(String action) {
        if(action.equals("cook")) {
            burger++;
            return true;
        } else if (action.equals("sell")) {
            if(burger > 0){
                burger--;
                return true;
            }
        }
        return false;
    }

    public static synchronized boolean cookSellSandwich(String action) {
        if(action.equals("cook")) {
            sandwich++;
            return true;
        } else if (action.equals("sell")) {
            if(sandwich > 0){
                sandwich--;
                return true;
            }
        }
        return false;
    }

    public static synchronized boolean cookSellSalad(String action) {
        if(action.equals("cook")) {
            salad++;
            return true;
        } else if (action.equals("sell")) {
            if(salad > 0){
                salad--;
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return  "\tFood Stock  burger: " + burger + " sandwich: " + sandwich + " salad: " + salad;
    }
}

final class CustomerQueues {
    /**
     * The customers are attended if they are in one of the queues.
     *
     */
    private static LinkedList<Customer> customerQueue1 = new LinkedList<>();
    private static LinkedList<Customer> customerQueue2 = new LinkedList<>();

    private CustomerQueues() {} // Constructor

    public static void enterCustomer(int queue, Customer customer) {
        if(queue == 0)
            customerQueue1.addLast(customer);
        else
            customerQueue2.addLast(customer);
    }

    public static Customer attendCustomer(int queue) {
        if(queue == 0){
            if(customerQueue1.size() > 0)
                return customerQueue1.removeFirst();
            return null;
        }
        if(customerQueue2.size() > 0)
            return customerQueue2.removeFirst();
        return null;
    }

    public String toString(){
        return  "\tQueue 1: " + customerQueue1 +
                "\n\tQueue 2: " + customerQueue2;
    }
}

class Customer {
    /**
     * timeToDecide: time spent deciding which food they want.
     * desiredFood: food chosen.
     *
     */
    public int id, timeToDecide;
    public String desiredFood;

    public Customer(int id, int timeToDecide, String desiredFood){
        this.id = id;
        this.timeToDecide = timeToDecide;
        this.desiredFood = desiredFood;
    }

    public String toString(){
        return "Customer #" + this.id;
    }
}

class Chef extends Thread {
    /**
     * Cooks at a random amount of time between
     * 2 and 5 seconds.
     * Also, chooses which food will cook.
     * Uses the FoodStock class.
     *
     */
    Random randomGenerator = new Random();
    private boolean threadAlive = true;

    public Chef() {}

    public void run() {
        int timeToCook = 0, whichFood = 0;
        while(this.threadAlive){
            timeToCook = 2000 + 1000* randomGenerator.nextInt(3);

            try {
                this.sleep(timeToCook);

                whichFood =  randomGenerator.nextInt(3);
                System.out.print("Chef on " + (timeToCook/1000) + " seconds Cook a ");
                switch(whichFood){
                    case 0:
                        FoodStock.cookSellBurger("cook");
                        System.out.println("burger");
                        break;
                    case 1:
                        FoodStock.cookSellSandwich("cook");
                        System.out.println("sandwich");
                        break;
                    case 2:
                        FoodStock.cookSellSalad("cook");
                        System.out.println("salad");
                        break;
                }
            } catch(InterruptedException e){
                System.out.println("Chef Interrupted");
            }
        }
    }

    public void end(){
        this.threadAlive = false;
    }
}

class Entry extends Thread {
    /**
     * Customers will be generated at a certain time.
     * between 1 and 4 seconds.
     */
    Random randomGenerator = new Random();
    private static int IDs;
    private boolean threadAlive = true;

    public Entry() {}

    public void run() {
        int timeCustomerEnter;

        while(this.threadAlive){
            timeCustomerEnter = 1000 + 1000* randomGenerator.nextInt(3);

            try {
                this.sleep(timeCustomerEnter);
                this.entry(timeCustomerEnter);  // Choose a queue
            } catch(InterruptedException e){
                System.out.println("Entry Interrupted");
            }
        }
    }

    public void entry(int timeCustomerEnter){
        /**
         * The customer enters in one queue and takes time to decide
         * which food he will eat.
         */
        int whichQueue = randomGenerator.nextInt(2);
        int whichFood = randomGenerator.nextInt(3);
        int timeToDecide = 1000 + 1000* randomGenerator.nextInt(3);
        String foodName = "";

        switch(whichFood){
            case 0:
                foodName = "burger";
                break;
            case 1:
                foodName = "sandwich";
                break;
            case 2:
                foodName = "salad";
                break;
        }


        CustomerQueues.enterCustomer(whichQueue,
                new Customer(IDs++, timeToDecide, foodName)
        );

        System.out.println("Customer #" + IDs + " enters " + (timeCustomerEnter/1000)
                + "seconds later to queue " + (whichQueue + 1));
    }

    public void end(){
        this.threadAlive = false;
    }
}

class Attender extends Thread {

    private int whichQueue;
    private boolean threadAlive = true;

    public Attender(int whichQueue) {
        this.whichQueue = whichQueue;
    }

    public void run() {
        /**
         * Checks if there is a customer to attend.
         * Uses the FoodStock class in PARALLEL with the Chef.
         */
//        int timeToDecide = 0;
        Customer customer;

        while(this.threadAlive){
            customer = CustomerQueues.attendCustomer(this.whichQueue);

            if(customer != null){
                try {
                    this.sleep(customer.timeToDecide);
                    this.attend(customer);
                } catch(InterruptedException e){
                    System.out.println("Attender Interrupted");
                }
            } else {
                try {
                    this.sleep(500);
                } catch(InterruptedException e){
                    System.out.println("Attender Interrupted");
                }
            }
        }
    }
    public void attend(Customer customer){
        /**
         * Asks which type of food the customer wishes.
         *
         */
        boolean sold = true;
        int wait = 0;
        while(sold){
            switch(customer.desiredFood){
                case "burger":
                    if(FoodStock.cookSellBurger("sell"))
                        sold = false;
                    break;
                case "sandwich":
                    if(FoodStock.cookSellSandwich("sell"))
                        sold = false;
                    break;
                case "salad":
                    if(FoodStock.cookSellSalad("sell"))
                        sold = false;
                    break;
            }
            if(sold){
                try {
                    this.sleep(1000);
                    wait++;
                } catch(InterruptedException e){
                    System.out.println("Attender Interrupted wait food");
                }
            }
        }
        System.out.println("Customer #" + (customer.id + 1) + " buy a "
                + customer.desiredFood + " and in " + (customer.timeToDecide / 1000)
                + "seconds and wait for food " + wait + "seconds");
    }

    public void end(){
        this.threadAlive = false;
    }
}