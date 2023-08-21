package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends  Thread{

    int port;
    public Server(int port) {
        this.port = port;
    }

    public  void run() {
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            try (Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ) {

                System.out.println("New connection accepted");
                final String name = in.readLine();
                out.println(String.format("Hi %s, you port is %d", name, clientSocket.getPort()));

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
