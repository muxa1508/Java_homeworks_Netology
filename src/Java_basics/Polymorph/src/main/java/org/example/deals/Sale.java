package org.example.deals;

public class Sale extends Deal {


public Sale(String title, int price) {
    this.comment = "Продажа " + title + " на " + price + " руб.";
    this.debitChange = price;
    this.creditChange = 0;
    }
}
