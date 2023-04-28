package org.example.deals;

public class Expenditure extends Deal{

    public Expenditure(String title, int price) {
        this.comment = "Продажа " + title + " на " + price + " руб.";
        this.debitChange = 0;
        this.creditChange = price;
    }
}
