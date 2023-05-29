package org.example;

public class SalesManager {
    protected int[] sales;

    public SalesManager(int[] sales) {
        this.sales = sales;
    }

    public int max() {
        int max = -1;
        for (int sale : sales) {
            if (sale > max) {
                max = sale;
            }
        }
        return max;
    }

    protected int min() {
        int min = Integer.MAX_VALUE;
        for (int sale: sales) {
            if (sale < min) {
                min = sale;
            }
        }
        return min;
    }
    public int croppedAverage() {
        int sum = 0;
        for (int sale: sales) {
            sum +=sale;
        }
        return (sum - min() - max()) / (sales.length - 2);
    }
}
