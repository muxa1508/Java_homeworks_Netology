package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задача 1:");
        System.out.println("Михаил Шурлепов");
        System.out.println();

        System.out.println("Задача 2:");
        String name = "Михаил";
        String surname = "Шурлепов";
        long income = 50000;
        long spending = 60000;

        long surplus = income - spending;

        System.out.println(surname + " " + name + ", месячный остаток: " + surplus);
    }
}