package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static String[] products = {"Хлеб", "Молоко", "Масло", "Крупа"};
    static long[] prices = {25, 60, 100, 20};

    static File textFile = new File("src/Java_core/Input_output/src/main/java/org/example/basket.txt");


    public static void main(String[] args) throws IOException {
        Basket basket;
        if (textFile.exists()) {
            basket = Basket.loadFromTxtFile(textFile);
        } else {
            basket = new Basket(products, prices);
        }

        for (int i = 0; i < basket.getProducts().length; i++) {
            System.out.println(i + 1 + ". " + basket.getProducts()[i] + " " + basket.getPrices()[i] + " руб/шт");
        }
        while (true) {
            System.out.println("Введите порядковый номер продукта и требуемое количество или введите 'end'");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                basket.printCart();
                break;
            }
            int productNum = Integer.parseInt(input.split(" ")[0]);
            int amount = Integer.parseInt(input.split(" ")[1]);

            basket.addToCart(productNum, amount);
            basket.saveTxt(textFile);
        }
    }
}