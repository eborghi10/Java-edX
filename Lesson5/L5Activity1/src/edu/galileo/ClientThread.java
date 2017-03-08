package edu.galileo;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by emiliano on 02/03/17.
 */
public class ClientThread extends Thread {

    // TODO: Why each modifier is used?
    private ChatServer server;
    protected Socket socket;
    public int id;

    public ClientThread(Socket clientSocket, ChatServer server, int id) {
        this.socket = clientSocket;
        this.server = server;
        this.id = id;
    }

    public void run() {
        // Code executed by the thread

        InputStream inp = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            inp = socket.getInputStream();
            in = new BufferedReader(new InputStreamReader(inp));
            out = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            return;
        }
        out.println("Welcome user#" + id);
        out.flush();

        String line;
        try {
            while ((line = in.readLine()) != null) {
                System.out.println("Message received from user#"+ id +": " + line);
                out.println("user#" + id + ": " + line);
                out.flush();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Removes the client if an exception exists or if closed normally
            server.removeClient(this);
            server = null;
        }
    }
}