package org.example;

public class Main {

    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, \n" +
            "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \n" +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris \n" +
            "nisi ut aliquip ex ea commodo consequat. \n" +
            "Duis aute irure dolor in reprehenderit in voluptate velit \n" +
            "esse cillum dolore eu fugiat nulla pariatur. \n" +
            "Excepteur sint occaecat cupidatat non proident, \n" +
            "sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {

        Task1 task1 = new Task1();
        task1.charCheck(text);


    }
}