package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задача 1:");
        System.out.println("Количество дней " + check(inputYear()));
        System.out.println();

        System.out.println("Задача 2:");
        loop();


    }

    protected static int inputYear() {
        System.out.println("Введите год в формате YYYY");
        return new Scanner(System.in).nextInt();
    }

    protected static int check(int year) {
        int days;
        if (year % 400 == 0) {
            days = 366;
        } else if (year % 4 == 0 && year % 100 != 0) {
            days = 366;
        } else {
            days = 365;
        }
        return days;
    }

    protected static int inputDays() {
        System.out.println("Введите количество дней:");
        return new Scanner(System.in).nextInt();
    }

    protected static void loop() {
        int successes = 0;
        System.out.println("Введите год и количество дней");
        while (true) {
            int checkedDays = check(inputYear());
            int inputDays = inputDays();
            if (inputDays == checkedDays) {
                successes++;
            } else {
                System.out.println("Неправильно! В этом году " + checkedDays + " дней");
                System.out.println("Набрано очков: " + successes);
                break;
            }
        }
    }
}