package edu.galileo;

import java.io.*;
import java.net.*;

public class Lesson5Activity1 {

    /**
     *  Multiple client chat application using sockets
     *
     */

     public static void main(String[] args) throws IOException {

         try {
             System.out.println("Server IP: " + InetAddress.getLocalHost().getHostAddress());
         } catch (UnknownHostException e) {
             System.out.println("UnknownHostException: " + e);
         }
         int port = 8080;
         ChatServer chatServer = new ChatServer(port);
         chatServer.start();
    }
}