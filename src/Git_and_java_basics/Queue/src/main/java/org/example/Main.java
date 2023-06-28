package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Deque<Person> queue = new ArrayDeque<>(generateClients());

        while (true) {
            Person user = (Person) queue.pollFirst();
            if (user != null && user.getTickets() > 0) {
                System.out.println(user.getName() + " " +
                        user.getSurname() + " прокатился на аттракционе \n" +
                        "Осталось билетов " + (user.getTickets() - 1));
                queue.addLast(new Person(user.getName(), user.getSurname(), user.getTickets() - 1));
            }
        }
    }

    protected static List<Person> generateClients() {
        List<Person> person = new ArrayList<>();
        person.add(new Person("Алексей", "Холодков", 3));
        person.add(new Person("Иван", "Пикунов", 5));
        person.add(new Person("Павел", "Кочергин", 2));
        person.add(new Person("Михаил", "Шурлепов", 8));
        person.add(new Person("Анна", "Федорова", 7));

        return person;
    }
}