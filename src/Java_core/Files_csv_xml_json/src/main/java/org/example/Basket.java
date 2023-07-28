package org.example;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class Basket {

    String[] products;
    long[] prices;
    int[] amounts;

    public Basket(String[] products, long[] prices) {
        this.products = products;
        this.prices = prices;
        this.amounts = new int[products.length];
    }

    public Basket(String[] inProducts, long[] inPricesLong, int[] inAmountInt) {
        this.products = inProducts;
        this.prices = inPricesLong;
        this.amounts = inAmountInt;
    }

    public void addToCart(int productNum, int amount) {
        amounts[productNum - 1] += amount;
    }

    protected void printCart() {
        int j = 1;
        for (int i = 0; i < amounts.length; i++) {
            if (amounts[i] != 0) {
                System.out.println(j + ". " + products[i] + " - " + amounts[i]
                        + " шт., " + prices[i] + " руб/шт., "
                        + (amounts[i] * prices[i]) + " руб в сумме");
                j++;
            }
        }
    }

    protected void saveTxt(File textFile) throws IOException {
        try (PrintWriter out = new PrintWriter(textFile)) {

            for (String product : products) {
                out.print(product + " ");
            }
            out.println();
            for (long price : prices) {
                out.print(price + " ");
            }
            out.println();
            for (int amount : amounts) {
                out.print(amount + " ");
            }
        }
    }


    public static Basket loadFromTxtFile(File textFile) throws IOException {
        try (Scanner in = new Scanner(textFile)) {
            String[] inProducts = in.nextLine().split(" ");

            String[] inPrices = in.nextLine().split(" ");
            long[] inPricesLong = Arrays.stream(inPrices).mapToLong(Integer::parseInt).toArray();

            String[] inAmounts = in.nextLine().split(" ");
            int[] inAmountInt = Arrays.stream(inAmounts).mapToInt(Integer::parseInt).toArray();

            return new Basket(inProducts, inPricesLong, inAmountInt);
        }
    }

    public String[] getProducts() {
        return products;
    }

    public long[] getPrices() {
        return prices;
    }
}
