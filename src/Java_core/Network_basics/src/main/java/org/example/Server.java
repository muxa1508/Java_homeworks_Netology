package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    int port;

    String lastCity = "???";

    public Server(int port) {
        this.port = port;
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);) {

                    System.out.println("New connection accepted");
                    out.println(lastCity);
                    String input = in.readLine();
                    if (lastCity.equals("???")) {
                        lastCity = input;
                        out.println("OK");
                    } else {
                        String firstChar = input.toLowerCase().split("")[0];
                        String[] lastCityCharMassive = lastCity.toLowerCase().split("");
                        String lastChar = lastCityCharMassive[lastCityCharMassive.length - 1];
                        if (firstChar.equals(lastChar)) {
                            lastCity = input;
                            out.println("OK");
                        } else {
                            out.println("NOT OK");
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
