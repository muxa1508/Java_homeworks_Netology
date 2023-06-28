package org.example;

import org.example.Task1.CharChecker;
import org.example.Task2.WordsChecker;

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

        CharChecker charChecker = new CharChecker();
        charChecker.charCheck(text);

        System.out.println();

        WordsChecker wordsChecker = new WordsChecker(text);
        System.out.println(wordsChecker.hasWord("Lorem ipsum"));
    }
}