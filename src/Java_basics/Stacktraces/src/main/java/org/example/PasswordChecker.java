package org.example;

public class PasswordChecker {
    private int minLength;
    private int maxRepeats;

    public PasswordChecker() {

    }

    public void setMinLength(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("Значение не может быть отрицательным");
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
        }

    }
}
