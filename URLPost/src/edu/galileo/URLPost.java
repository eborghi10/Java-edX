package edu.galileo;

import java.io.*;
import java.net.*;

public class URLPost {

    /**
     *
     * @param args : http://sentinel-test.appspot.com/mm/main Emiliano
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {

        // Check the input arguments, has to be:
        // 1) URL
        // 2) Value to post
        if (args.length != 2) {
            System.err.println("Usage: java Reverse "
                + "http://<location_of_your_servlet/script>"
                + " name_to_post");
            System.exit(1);
        }

        // Encode the value to post string to avoid problem with special characters
        String stringToPost = URLEncoder.encode(args[1], "UTF-8");

        // Creates the URL object and open a connection
        URL url = new URL(args[0]);
        URLConnection connection = url.openConnection();
        // Enables write capability to the URL
        connection.setDoOutput(true);

        // Gets the connection output-stream, write to it and close it
        OutputStreamWriter out = new OutputStreamWriter(
                connection.getOutputStream());
        // Writes to the connection (HTTP post to the URL)
        out.write("name=" + stringToPost);
        out.close();

        // Get the connection input-stream
        BufferedReader in = new BufferedReader( new InputStreamReader(
                connection.getInputStream()));

        String welcomeMessage;
        // Read the returned lines and print in the standard output
        while ((welcomeMessage = in.readLine()) != null) {
            System.out.println(welcomeMessage);
        }
        in.close();

    }
}
