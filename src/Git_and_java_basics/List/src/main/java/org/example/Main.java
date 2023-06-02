package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    protected static List shopList = new ArrayList();
    protected static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        basket();

    }

    protected static void basket() {
        while (true) {
            System.out.println("Введите номер операции или end для завершения работы: \n" +
                    "1. Добавить \n" +
                    "2. Показать \n" +
                    "3. Удалить \n" +
                    "4. Найти");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            } else {
                switch (Integer.parseInt(input)) {
                    case 1:
                        System.out.println("Какую покупку вы хотите добавить?");
                        String addInput = scanner.nextLine();
                        shopList.add(addInput);
                        System.out.println(addInput +
                                "\nИтого в списке покупок: " +
                                shopList.size());
                        System.out.println();
                        break;
                    case 2:
                        print();
                        break;
                    case 3:
                        print();
                        System.out.println("Какую хотите удалить? Введите номер или название");

                        String removeInput = scanner.nextLine();

                        try {
                            int i = Integer.parseInt(removeInput);
                            if ((i - 1) <= shopList.size()) {
                                System.out.println("Покупка " + shopList.get(i) + " удалена");
                                shopList.remove(i);
                                print();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Покупка " + removeInput + " удалена");
                            shopList.remove(removeInput);
                            print();
                        }
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("Введите текст для поиска:");
                        String queryLower = scanner.nextLine().toLowerCase();
                        System.out.println("Найдено: ");
                        for (int i = 0; i < shopList.size(); i++) {
                            String itemLower = shopList.get(i).toString().toLowerCase();
                            if (itemLower.contains(queryLower)) {
                                System.out.println(i + 1 + ". " + shopList.get(i));
                            }
                        }
                }
            }
        }
    }

    protected static void print() {
        System.out.println("Список покупок:");
        for (int i = 0; i < shopList.size(); i++) {
            System.out.println(i + 1 + ". " + shopList.get(i));
        }
        System.out.println();
    }
}