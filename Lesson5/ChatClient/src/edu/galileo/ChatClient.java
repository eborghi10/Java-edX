package edu.galileo;

import java.io.*;
import java.net.*;

public class ChatClient {

    private String hostName;
    private int portNumber;
    private Socket clientSocket;

    public ChatClient(String hostName,int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
        try {
            clientSocket = new Socket(this.hostName,this.portNumber);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch(IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName + ":" + portNumber + ". Check that the server is running.");
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Client connected to server.");
    }

    public void start() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            StdinThread stdinThread = new StdinThread(in, stdIn, out);
            ServerReaderThread serverReaderThread = new ServerReaderThread(in);

            stdinThread.start();
            serverReaderThread.start();

        } catch(IOException e) {
            System.err.println("I/O Exception");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void main(String[] args) {

        if (args.length != 2) {
            System.err.println(
                    "Usage Java ChatClient <host_name> <port_number>"
            );
            System.exit(1);
        }

        String hostName = args[0];
        int port = Integer.parseInt(args[1]);
        ChatClient chatClient = new ChatClient(hostName,port);
        chatClient.start();
    }
}