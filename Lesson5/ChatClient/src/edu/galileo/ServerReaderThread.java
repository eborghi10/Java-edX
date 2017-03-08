package edu.galileo;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by emiliano on 03/03/17.
 */
public class ServerReaderThread extends Thread {

    protected BufferedReader in;

    public ServerReaderThread(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {

        /**
         * Receives messages from the server and prints on screen
         *
         */

        try {
            // Read the welcome message from the server
            System.out.println("1 > " + in.readLine());

        } catch (IOException e) {

            System.err.println("I/O Exception");
            e.printStackTrace();
            System.exit(1);
        }

    }
}
