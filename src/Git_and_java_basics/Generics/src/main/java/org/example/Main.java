package org.example;

public class Main {
    public static void main(String[] args) {

        MagicBox magicBox = new MagicBox<>(3);

        magicBox.add("Первый элемент");

//        System.out.println(magicBox.pick());

        magicBox.add(2);
        magicBox.add(3);

        System.out.println(magicBox.pick());
    }
}
