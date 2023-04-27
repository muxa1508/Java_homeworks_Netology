package org.example;

import java.util.Random;

public class Main {

    protected static int SIZE = 8;
    protected static int DEGREES = 180;
    protected static int[][] colors = new int[SIZE][SIZE];
    protected static Random random = new Random();

    public static void main(String[] args) {
        generateMatrix();
        System.out.println();
        rotatedMatrix(DEGREES);
    }

    protected static void generateMatrix() {
        System.out.println("Случайная матрица:");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }
    }

    protected static void rotatedMatrix(int degrees) {
        System.out.println("Матрица повернута на " + DEGREES + " градусов:");
        int[][] rotatedColors = new int[SIZE][SIZE];
        if (DEGREES == 90 || DEGREES == -90 || DEGREES == 180 || DEGREES == -180 || DEGREES == 270 || DEGREES == -270) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (degrees == 90 || degrees == -270) {
                        rotatedColors[i][j] = colors[SIZE - 1 - j][i];
                    } else if (degrees == 180 || degrees == -180) {
                        rotatedColors[i][j] = colors[SIZE - 1 - i][SIZE - 1 - j];
                    } else if (degrees == 270 || degrees == -90) {
                        rotatedColors[i][j] = colors[j][SIZE - 1 - i];
                    }
                    System.out.format("%4d", rotatedColors[i][j]);
                }
                System.out.println();
            }
        } else {
            System.out.println("Такой угол не поддерживается");
        }
    }
}