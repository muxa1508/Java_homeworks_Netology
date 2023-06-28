package org.example.Task1;

import java.util.HashMap;
import java.util.Map;

public class CharChecker {

    public void charCheck(String text) {

        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            Character iChar = text.toLowerCase().charAt(i);
            if (Character.isLetter(iChar)) {
                if (charMap.containsKey(iChar)) {
                    charMap.put(iChar, charMap.get(iChar) + 1);
                } else {
                    charMap.put(iChar, 1);
                }
            }
        }
//        charMap.forEach((key, value) -> System.out.println(key + " " + value));

        int maxIntValue = -1;
        char maxCharValue = 0;
        int minIntValue = Integer.MAX_VALUE;
        char minCharValue = 0;

        for (Character key : charMap.keySet()) {
            if (charMap.get(key) > maxIntValue) {
                maxIntValue = charMap.get(key);
                maxCharValue = key;
            }
            if (charMap.get(key) < minIntValue) {
                minIntValue = charMap.get(key);
                minCharValue = key;
            }
        }

        System.out.println("Наиболее часто встречающаяся буква: " + maxCharValue +
                " встречается " + maxIntValue + " раз" + "\n" +
                "Наименее часто встречающаяся буква: " + minCharValue +
                " встречается " + minIntValue + " раз");
    }
}

