package org.example;

import java.util.Scanner;

public class Main {

    protected static String[] products = {"Хлеб", "Молоко", "Греча", "Кура", "Растишка"};
    protected static int[] prices = {32, 98, 46, 260, 42};
    protected static int[] basket = new int[products.length];
    protected static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        basket();
        showBasket();
    }

    protected static String input() {
        return scanner.nextLine();
    }

    protected static void showProducts() {
        System.out.println("Список возможных покупок");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " - " + prices[i] + " руб./шт.");
        }
        System.out.println();
    }

    protected static void basket() {
        showProducts();


        while (true) {
            System.out.println("Выберите товар и количество или введите end");
            String product = input();
            if (product.equals("end")) {
                System.out.println("Программа завершена" + "\n");
                break;
            }
            int productNumber = (Integer.parseInt(product.split(" ")[0]) - 1);
            int productCount = Integer.parseInt(product.split(" ")[1]);
            basket[productNumber] += productCount;
        }
    }

    protected static void showBasket() {
        System.out.println("Ваша корзина");
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != 0) {
                System.out.println((i + 1) + ". " + products[i] + " - " +
                        basket[i] + " шт., " + prices[i] + " руб./шт., " +
                        basket[i] * prices[i] + " руб. в сумме");
            }
        }
    }
}