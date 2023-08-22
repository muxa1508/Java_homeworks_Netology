package org.example.Task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");
        logger.log("Введите размер и максимально значение через пробел");

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int M = Integer.parseInt(input.split(" ")[1]);

        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            list.add(random.nextInt(M));
        }
        System.out.println("Случайный список: " + list);

        logger.log("Введите порог для фильтра");
        String inputF = scanner.nextLine();
        int F = Integer.parseInt(inputF);
        Filter filter = new Filter(F);
        List<Integer> filtered = filter.filterOut(list);

        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + filtered);
        logger.log("Завершаем программу");
    }
}
