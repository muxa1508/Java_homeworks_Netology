package org.example;

import org.example.ru.netology.Finances;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1:");
        System.out.println(calcPayment(2600000, 200000, 2));
        System.out.println();

        System.out.println("Задача 2:");
        System.out.println(Finances.calcPayment(2600000, 200000, 2));
    }

    public static int calcPayment(int amount, int start, int years) {
        return (amount - start) / (years * 12);
    }
}