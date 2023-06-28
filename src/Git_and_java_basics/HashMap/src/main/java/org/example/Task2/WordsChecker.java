package org.example.Task2;

import java.util.HashSet;
import java.util.List;

public class WordsChecker {
    String text;

    public WordsChecker(String text) {
        this.text = text;
    }

    public boolean hasWord(String word) {
        HashSet<String> hashSet = new HashSet<>(List.of(text.toLowerCase().split("\\P{IsAlphabetic}+")));
//        hashSet.forEach(key -> System.out.println(key));

        String[] wordMassive = word.toLowerCase().split("\\P{IsAlphabetic}+");
        for (String word1 : wordMassive) {
            if (!hashSet.contains(word1)) {
                return false;
            }
        }
        return true;
    }
}
