package org.example;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int spendings = 0;
    static int earnings = 0;


    public static void main(String[] args) {
        counter();
    }

    protected static String input() {
        return scanner.nextLine();
    }

    protected static void counter() {
        while (true) {
            System.out.println("Выберите операцию и введите ее номер" + "\n" +
                    "1. Добавить новый доход" + "\n" +
                    "2. Добавить новый расход" + "\n" +
                    "3. Выберите систему налогооблажения");
            String input = input();
            if (input.equals("end")) {
                System.out.println("Программа завершена");
                break;
            }
            switch (Integer.parseInt(input)) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    int earnMoney = Integer.parseInt(input());
                    earnings += earnMoney;
                    sum();
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    int spendMoney = Integer.parseInt(input());
                    spendings += spendMoney;
                    sum();
                    break;
                case 3:
                    int taxEarn = taxEarn();
                    int taxEarnMinSpend = taxEarnMinSpend();
                    if (taxEarnMinSpend > taxEarn) {
                        System.out.println("Мы советуем Вам УСН Доходы" + "\n" +
                                "Ваш налог: " + taxEarn + "\n" +
                                "Налог на другой системе: " + taxEarnMinSpend + "\n");
                    } else if (taxEarnMinSpend < taxEarn) {
                        System.out.println("Мы советуем Вам УСН Доходы минус расходы" + "\n" +
                                "Ваш налог: " + taxEarnMinSpend + "\n" +
                                "Налог на другой системе: " + taxEarn + "\n");
                    } else {
                        System.out.println("Можете выбрать любую систему налогооблажения" + "\n" +
                                "Ваш налог: " + taxEarn + "\n");
                    }

                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }

    protected static int taxEarn() {
        int tax = earnings / 100 * 6;
        if (tax >= 0) {
            return tax;
        }
        return 0;
    }

    protected static int taxEarnMinSpend() {
        int tax = (earnings - spendings) / 100 * 16;
        if (tax >= 0) {
            return tax;
        }
        return 0;
    }

    protected static void sum() {
        System.out.println("Доходы: " + earnings + "\n" +
                "Расходы: " + spendings +
                "\n");
    }
}