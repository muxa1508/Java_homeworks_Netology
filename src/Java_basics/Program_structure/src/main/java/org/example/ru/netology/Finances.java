package org.example.ru.netology;

public class Finances {

    public Finances() {
    }

    public static int calcPayment(int amount, int start, int years) {
        return (amount - start) / (years * 12);
    }
}
