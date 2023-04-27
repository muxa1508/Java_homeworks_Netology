package org.example;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задача 1");
        Book book1 = new Book("Война и мир", 2021, "Л.Н. Толстой",
                1360, "Произведение в котором Французского языка больше чем Русского");
        System.out.println("Книга большая: " + book1.isBig() + "\n" +
                "Наличие поискового слова: " + book1.matches("мИР") + "\n" +
                "Стоимость: " + book1.estimatePrice() + "\n");


        System.out.println("Задача 2");
        Book book2 = new Book("Война и мир", 2021, new Author("Лев", "Толстой", 10),
                1360, "Произведение в котором Французского языка больше чем Русского");
        System.out.println("Книга большая: " + book2.isBig() + "\n" +
                "Наличие поискового слова: " + book2.matches("лЕВ") + "\n" +
                "Стоимость: " + book2.estimatePriceSqrt() + "\n");
    }
}