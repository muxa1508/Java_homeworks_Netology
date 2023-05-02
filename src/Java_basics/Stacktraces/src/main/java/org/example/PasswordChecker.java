package org.example;

public class PasswordChecker {
    private int minLength;
    private int maxRepeats;

    public PasswordChecker() {

    }

    public void setMinLength(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("Значение не может быть отрицательным или равно нулю");
        } else {
            minLength = value;
        }
    }

    public void setMaxRepeats(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Значение не может быть отрицательным или равно нулю");
        } else {
            maxRepeats = value;
        }
    }

    public boolean verify(String password) {
        if (minLength == 0 || maxRepeats == 0) {
            throw new IllegalStateException("Не заданы начальные параметры проверки");
        } else {
            char[] inputChar = password.toCharArray();
            if (inputChar.length < minLength) {
                return false;
            }
            char lastChar = inputChar[0];
            int repeatsCount = 1;
            for (int i = 1; i < inputChar.length; i++) {
                if (inputChar[i] == lastChar) {
                    repeatsCount++;
                    if (repeatsCount > maxRepeats) {
                        return false;
                    }
                } else {
                    lastChar = inputChar[i];
                    repeatsCount = 1;
                }
            }
        }
        return true;
    }
}
