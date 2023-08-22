package org.example.Task_1;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String city;

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age++;
        }
    }

    public boolean hasAge() {
        if (age > 0) {
            return true;
        }
        return false;
    }

    public void setAddress() {
        if (!hasAddress()) {
            this.city = city + 1;
        }
    }

    public boolean hasAddress() {
        if (city != null) {
            return true;
        }
        return false;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(getSurname()).setAge(getAge()).setAddress(getCity());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}
