package edu.galileo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class MultiThreading {

    /**
     * When a customer enters to the Movie Theater, he or she is assigned to one of the queues,
     * depending on which movie he or she wants to watch.
     * When it is the customer’s turn to buy a ticket, an attendant asks the customer which movie
     * ticket he or she wants to buy.
     *
     * The attendant takes a certain time to complete the transaction because the attendant must verify
     * if tickets are available for the movie in order to sell them to the customer. If there are available
     * tickets for the movie that the customer wants, the customer buys one and exits the queue. This means
     * that the program must subtract one ticket from the available tickets of the corresponding movie because
     * it was sold.
     *
     * If there are no tickets available for the movie that the customer wants, he or she exits the movie
     * theater without buying. This means that the customer leaves the simulated queue and tickets are not
     * changed.  When all the tickets from all the movies are sold, the Movie Theater closes (End the program).
     *
     *
     * On this Movie Theater there are 15 movies and 5 Queues, there is one attendant on each queue and each
     * of them sell tickets for 3 movies. Every movie has 50 tickets available when the Movie Theater open
     * (The program start).
     *
     * ----------------------------------------------------------------------------------------------------------
     *
     * Your task is to bring to life this Movie Theater by implementing the simulation and using the classes
     * from the file MultiThreading.java. The list of movies (the names) are on the file movies.txt you should read
     * from the file and get the movies, assign 3 movies for each attendant.
     *
     * In the main method, write the code to read the movies names, assign them to the movie stock, instantiate
     * the threads and start them. In the Customer class, complete the information. Every Customer has an ID and
     * what movie he wants to watch as attributes.
     *
     * Complete MovieTicketsStock class, assign the movies and the available tickets for every movie. Complete
     * the sellTicket method. Hint: use arrays of two dimensions, or HashMaps.
     *
     * Complete MovieQueues class, in enterCustomer() method remember to enter a customer at the end of each
     * correct queue depending on what movie he or she wishes to watch. In the attendCustomer() method,
     * remember to the remove the first customer and if there are no customers, return null. Also, specify
     * from what queue a customer is attended.
     *
     * The Entry class is a Thread that generates randomly a new Customer with a random movie and invokes the
     * enterCustomer() method. There are 15 movies to choose. And generates a customer every 1 to 3 seconds.
     *
     * The Attender class is a Thread, assigns every attender to one queue, and this one just sold 3 different
     * movies. Each customer he attends will take certain random time (3 to 5 seconds) to complete a
     * transaction. Use attendCustomer() method to attend a customer, if there are no customers in queue,
     * wait 1 second before invoking it again.
     *
     * Every time a Customer enters a queue print the information, use the following format:
     *
     * Format:
     * Customer#(id) enters the queue (number) in (time) seconds
     *
     * Example:
     * Customer#20 enters the queue 4 in 3 seconds
     *
     * Every time a Customer is attended (after the waiting time) print the information depending if the
     * ticket for the movie is available or not. Use this
     *
     * Format:
     * Customer#(id) from queue (number) buys ticket after (time) seconds for the movie (name)
     * Customer#(id) from queue (number) leaves queue. No tickets available for the movie (name)
     *
     * Example:
     * Customer#15 from queue 1 buys ticket after 4 seconds for the movie Star Trek Beyond
     * Customer#31 from queue 3 leaves queue. No tickets available for the movie Justice League
     *
     * If you want, create an extra class that prints the actual state of all the queues and the tickets stock.
     * When all the tickets are sold you should end the program and print: Movie Theater Closes.
     *
     */

    public static void main(String[] args) throws Exception{

        Scanner inputReader = new Scanner(System.in);
        String userInput;

        // Read Movies from movies.txt
        Scanner inputFile = null;
        Random rng = new Random();
        MovieTicketsStock movieStockList = new MovieTicketsStock();
        try {
            inputFile = new Scanner( new BufferedReader(new FileReader("movies.txt")));

            while( inputFile.hasNext() ){
                String movieName = inputFile.nextLine();
                int movieStock = rng.nextInt(20-10) + 10;   // Between 10 and 20 of stock
                System.out.print(" > " + movieName + "\t" + movieStock + "\n");
                movieStockList.setMovieToList(movieName, movieStock);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputFile != null){
                inputFile.close();
            }
        }

        // Create classes
        Entry comingCustomers = new Entry();
        Attender attender1 = new Attender(0);
        Attender attender2 = new Attender(1);
        Attender attender3 = new Attender(2);
        Attender attender4 = new Attender(3);

        // Start Threads
        comingCustomers.start();
        attender1.start();
        attender2.start();
        attender3.start();
        attender4.start();

        // Stop with any key, except just Enter
        while(true) {
            userInput = inputReader.next();
            // End Threads
            System.exit(0);
        }
    }
}



class Customer {
    private int id;
    private String movieToWatch;

    public Customer(int id, String movieToWatch){
        this.id = id;
        this.movieToWatch = movieToWatch;
    }

    public String toString(){
        return "Customer #" + this.id;
    }
}

final class MovieTicketsStock {

    HashMap<String, Integer> movieList = new HashMap<>();

    public MovieTicketsStock() {}

    public void setMovieToList(String name, int stock) {
        this.movieList.put(name, stock);
    }

    public static boolean sellTicket() {
        return false;
    }

    public String toString(){
        return  "";
    }
}

final class MovieQueues {
    private static LinkedList<Customer> movieQueue1 = new LinkedList<>();
    private static LinkedList<Customer> movieQueue2 = new LinkedList<>();
    private static LinkedList<Customer> movieQueue3 = new LinkedList<>();
    private static LinkedList<Customer> movieQueue4 = new LinkedList<>();
    private static LinkedList<Customer> movieQueue5 = new LinkedList<>();

    private MovieQueues() {}

    public static void enterCustomer(int queue, Customer customer) {
        switch (queue) {
            case 0:
                movieQueue1.addLast(customer);
                break;
            case 1:
                movieQueue2.addLast(customer);
                break;
            case 2:
                movieQueue3.addLast(customer);
                break;
            case 3:
                movieQueue4.addLast(customer);
                break;
            case 4:
                movieQueue5.addLast(customer);
                break;
        }
    }

    public static Customer attendCustomer(int queue) {
        switch (queue) {
            case 0:
                if (movieQueue1.size() > 0)
                    return movieQueue1.removeFirst();
                break;
            case 1:
                if (movieQueue2.size() > 0)
                    movieQueue2.removeFirst();
                break;
            case 2:
                if (movieQueue3.size() > 0)
                    movieQueue3.removeFirst();
                break;
            case 3:
                if (movieQueue4.size() > 0)
                    movieQueue4.removeFirst();
                break;
            case 4:
                if (movieQueue5.size() > 0)
                    movieQueue5.removeFirst();
                break;
        }
        return null;
    }

    public String toString(){
        return  "\tQueue 1: " + movieQueue1 +
                "\n\tQueue 2: " + movieQueue2 +
                "\n\tQueue 3: " + movieQueue3 +
                "\n\tQueue 4: " + movieQueue4 +
                "\n\tQueue 5: " + movieQueue5;
    }
}

class Entry extends Thread {
    Random randomGenerator = new Random();
    private static int IDs;
    private boolean threadAlive = true;

    public Entry() {}

    public void run() {
        int timeCustomerEnter;

        while(this.threadAlive){
            timeCustomerEnter = 1000 + 1000 * randomGenerator.nextInt(3);   // 1 to 4 secs

            try {
                this.sleep(timeCustomerEnter);
                this.entry(timeCustomerEnter);
            } catch(InterruptedException e) {
                System.out.println("Entry interrupted");
            }
        }
    }

    public void entry(int timeCustomerEnter){
        int whichQueue = randomGenerator.nextInt(5);
        MovieQueues.enterCustomer(
                whichQueue,
                new Customer(IDs++, //TODO: movieToWatch)
        );
    }

    public void end(){
        this.threadAlive = false;
    }
}

class Attender extends Thread {
    private boolean threadAlive = true;
    private int whichQueue;

    public Attender(int whichQueue) {
        this.whichQueue = whichQueue;
    }

    public void run() {
        // TODO: complete
        while(this.threadAlive){}
    }
    public void attend(Customer customer){
        // TODO: Complete
    }

    public void end(){
        this.threadAlive = false;
    }
}
