package org.example.Task_1;

public class PersonBuilder {
    public String name;
    public String surname;
    public int age;
    public String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 | age > 150) {
            throw new IllegalArgumentException("Введенный возраст некорректен");
        } else {
            this.age = age;
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person = new Person(name, surname, age, address);
        if (name == null | surname == null) {
            throw new IllegalStateException("Не заполнены обязательные параметры: имя и фамилия");
        }

        return person;
    }

}
