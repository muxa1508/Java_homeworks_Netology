package org.example;

import java.util.Scanner;

public class Main {

    protected static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        PasswordChecker passwordChecker = new PasswordChecker();

        System.out.println("Введите мин. длину пароля: ");
        passwordChecker.setMinLength(Integer.parseInt(scanner.nextLine()));

        System.out.println("Введите макс. допустимое количество символов подряд");
        passwordChecker.setMaxRepeats(Integer.parseInt(scanner.nextLine()));

        while (true) {
            System.out.println("Введите пароль или end");
            String pass = scanner.nextLine();
            if (endCheck(pass)) {
                break;
            }
            if (passwordChecker.verify(pass)) {
                System.out.println("Подходит !" + "\n");
            } else {
                System.out.println("Не подходит !" + "\n");
            }
        }
    }

    protected static boolean endCheck(String input) {
        if (input.equals("end")) {
            System.out.println("Программа завершена");
            return true;
        }
        return false;
    }
}