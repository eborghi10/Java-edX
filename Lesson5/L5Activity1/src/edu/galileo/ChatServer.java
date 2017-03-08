package edu.galileo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by emiliano on 02/03/17.
 */
public class ChatServer {
    public int port;
    private int IDs;
    private List<ClientThread> clients;
    private ServerSocket serverSocket = null;

    public ChatServer(int port) {
        this.port = port;
        IDs = 1;
        clients = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Socket socket = null;
        ClientThread newClient = null;
        System.out.println("Waiting for clients to connect...");
        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("I/O error: " + e);
            }
            // new thread for a client
            newClient = new ClientThread(socket, this, IDs++);
            newClient.start();  // Makes the thread eligible for running
            clients.add(newClient);
            newClient = null;
        }
    }

    public void removeClient(ClientThread clientClosed) {
        clients.remove(clientClosed);
        System.out.println("");
    }
}
