package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();

        list.add(new Person("Алексей", "Холодков", 10));
        list.add(new Person("Алексей", "Холодков", 30));
        list.add(new Person("Михаил", "Салтыков-Щедрин", 10));
        list.add(new Person("Михаил", "Салтыков-Щедрин", 40));
        list.add(new Person("Михаил", "Салтыков-Щедрин", 10));
        list.add(new Person("Чингачгук", "Вождь племени краснокожих", 4));
        list.add(new Person("Чингачгук", "Вождь племени краснокожих", 15));
        System.out.println(list);


        list.sort(new Comparator<Person>() {

            int maxSurnameLenght = 2;

            @Override
            public int compare(Person o1, Person o2) {
                int o1SurnameLenght = o1.getSurname().split("(?U)\\W").length;
                int o2SurnameLenght = o2.getSurname().split("(?U)\\W").length;

                if ((o1SurnameLenght & o2SurnameLenght) >= maxSurnameLenght) {
                    if (o1.getAge() < o2.getAge()) {
                        return 1;
                    } else if (o1.getAge() == o2.getAge()) {
                        return 0;
                    }
                } else {
                    if (o1SurnameLenght < o2SurnameLenght) {
                        return 1;
                    } else if (o1SurnameLenght == o2SurnameLenght) {
                        if (o1.getAge() < o2.getAge()) {
                            return 1;
                        } else if (o1.getAge() == o2.getAge()) {
                            return 0;
                        }
                    }
                }
                return -1;
            }
        });

        System.out.println(list);
    }
}