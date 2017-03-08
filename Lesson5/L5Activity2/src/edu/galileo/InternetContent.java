package edu.galileo;

/**
 * Created by emiliano on 02/03/17.
 */
import java.io.*;
import java.net.*;

public class InternetContent {
    public static String get(String url) throws Exception{

        URL urlAddress = new URL(url);
        BufferedReader in = null;
        String returnedContent = new String();
        String temp = new String();
        try {
            URLConnection connection = urlAddress.openConnection();

            in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            while ((temp = in.readLine()) != null)
                returnedContent += temp;

        } catch (IOException e) {

            e.printStackTrace();
        } finally {

            if (in != null) in.close();

            System.out.println(returnedContent);
            return returnedContent;
        }
    }
}
