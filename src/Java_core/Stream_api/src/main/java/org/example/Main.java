package org.example;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        //1.
        System.out.println("Количество несовершеннолетних:\n" + persons.stream()
                .filter(new Predicate<Person>() {
                    @Override
                    public boolean test(Person person) {
                        if (person.getAge() < 18) {
                            return true;
                        } else return false;
                    }
                }).count());

        //2.
        System.out.println("Список фамилий призывников:\n" + persons.stream()
                .filter(new Predicate<Person>() {
                    @Override
                    public boolean test(Person person) {
                        if (person.getSex().equals(Sex.MAN)) {
                            return true;
                        } else return false;
                    }
                })
                .filter(new Predicate<Person>() {
                    @Override
                    public boolean test(Person person) {
                        if (person.getAge() > 18 && person.getAge() < 27) {
                            return true;
                        } else return false;
                    }
                })
                .map(person -> person.getFamily())
                .collect(Collectors.toList()));

        //3.
        System.out.println("Список потенциально работоспособных людей:\n" + persons.stream()
                .filter(new Predicate<Person>() {
                    @Override
                    public boolean test(Person person) {
                        if (person.getEducation().equals(Education.HIGHER)) {
                            return true;
                        } else return false;
                    }
                })
                .filter(new Predicate<Person>() {
                    @Override
                    public boolean test(Person person) {
                        if (person.getSex().equals(Sex.MAN)) {
                            if (person.getAge() < 65 && person.getAge() > 18) {
                                return true;
                            }
                        } else if (person.getSex().equals(Sex.WOMAN)) {
                            if (person.getAge() < 60 && person.getAge() > 18) {
                                return true;
                            }
                        }
                        return false;
                    }
                }).sorted(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return Integer.compare(o2.getFamily().length(), o1.getFamily().length());
                    }
                }).collect(Collectors.toList()));
    }
}