package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {

    String host;
    int port;
    int clientNumber;

    public Client(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public Client(String host, int port, int clientNumber) {
        this.host = host;
        this.port = port;
        this.clientNumber = clientNumber;
    }

    public void run() {
        while (true) {
            try (Socket clientSocket = new Socket(host, port);
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            ) {
                Scanner scanner = new Scanner(System.in);
                String resp = in.readLine();
                if (resp.equals("???")) {
                    System.out.println(clientNumber + ". You are the first player. input any city name");
                } else {
                    System.out.println(clientNumber + ". Last city name is: " + resp +
                            "\n Input next city name");
                }
                String scannerInput = scanner.nextLine();

                out.println(scannerInput);
                String input = in.readLine();
                System.out.println(clientNumber + ". " + input);

                if (scannerInput.equals("end")) {
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Thread.yield();
    }
}

