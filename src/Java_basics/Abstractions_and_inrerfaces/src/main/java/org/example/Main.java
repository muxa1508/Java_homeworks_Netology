package org.example;

import org.example.account.CreditAccount;
import org.example.account.SimpleAccount;
import org.example.logger.SimpleLogger;
import org.example.logger.SmartLogger;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1");
        SimpleAccount account1 = new SimpleAccount();
        CreditAccount account2 = new CreditAccount(-1000);

        System.out.println(account2.add(200));
        System.out.println(account2.getBalance());
        System.out.println(account2.pay(400));
        System.out.println(account2.getBalance());
        System.out.println(account2.transfer(account1, 100));
        System.out.println(account2.getBalance() + " " + account1.getBalance());
        System.out.println();

        System.out.println("Задача 2");
        SimpleLogger simpleLogger = new SimpleLogger();
        simpleLogger.log("test");

        SmartLogger smartLogger = new SmartLogger();
        smartLogger.log("test");
        smartLogger.log("Error message");
        smartLogger.log("123");

    }
}