package org.example;

import java.util.Scanner;

public class Main {

    protected static Scanner scanner = new Scanner(System.in);
    protected static String maxName = null;


    public static void main(String[] args) {
        check();
    }

    static String input() {
        return scanner.nextLine();
    }

    static void check() {
        while (true) {
            System.out.println("Введите имя с большой буквы или end для завершения программы:");
            String name = input();
            if (name.equals("end")) {
                System.out.println("Программа завершена");
                break;
            }
            if (Character.isUpperCase(name.charAt(0))) {
                if (maxName == null) {
                    maxName = name;
                    System.out.println("Это первое введенное имя!");
                } else if (maxName.length() < name.length()) {
                    maxName = name;
                } else if (maxName.length() > name.length()) {
                    System.out.println("Не хватило " + (maxName.length() - name.length()) + " символов");
                }
            } else {
                System.out.println("Имена нужно вводить с большой буквы!");
            }
        }
        if (maxName != null) {
            System.out.println("Самое длинное имя: " + maxName);
        }
    }
}