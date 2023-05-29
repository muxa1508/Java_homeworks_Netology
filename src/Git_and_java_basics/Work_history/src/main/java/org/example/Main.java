package org.example;

public class Main {
    public static void main(String[] args) {

        SalesManager salesManager = new SalesManager(new long[]{100, 10, 20, 300, 15});

        System.out.println(salesManager.max());
    }
}