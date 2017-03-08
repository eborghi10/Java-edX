package edu.galileo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by emiliano on 03/03/17.
 */
public class StdinThread extends Thread {

    protected BufferedReader in, stdIn;
    protected PrintWriter out;

    public StdinThread(BufferedReader in, BufferedReader stdIn, PrintWriter out) {
        this.in = in;
        this.stdIn = stdIn;
        this.out = out;
    }

    @Override
    public void run() {

        /**
         * Receives messages from keyboard and sends them to the server
         */

        try {
            String userInput = null;
            while((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("2 > " + userInput);
            }
        } catch (IOException e) {

            System.err.println("I/O Exception");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
