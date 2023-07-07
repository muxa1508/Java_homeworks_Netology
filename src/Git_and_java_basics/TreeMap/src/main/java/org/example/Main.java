package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();

        list.add(new Person("Алексей","Холодков",10));
        list.add(new Person("Алексей","Холодков",30));
        list.add(new Person("Михаил", "Салтыков-Щедрин", 10));
        list.add(new Person("Михаил", "Салтыков-Щедрин", 40));
        list.add(new Person("Михаил", "Салтыков-Щедрин", 10));
        list.add(new Person("Чингачгук", "Вождь племени краснокожих", 4));
        list.add(new Person("Чингачгук", "Вождь племени краснокожих", 15));
        System.out.println(list);


        Collections.sort(list, new PersonComparator(2));

        System.out.println(list);
    }
}