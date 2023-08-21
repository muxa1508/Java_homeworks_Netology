package org.example;

public class Main {

    static int PORT = 8080;
    static String HOST = "localhost";

    public static void main(String[] args) {

        Server serverThread = new Server(PORT);
        serverThread.start();

        Client clientThread = new Client(HOST, PORT, 1);
        clientThread.start();

        Client clientThread2 = new Client(HOST, PORT, 2);
        clientThread2.start();
    }
}