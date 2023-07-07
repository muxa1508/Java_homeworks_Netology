package org.example;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    protected int maxSurnameLenght;

    public PersonComparator(int maxSurnameLenght) {
        this.maxSurnameLenght = maxSurnameLenght;
    }

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

}
