### �������
� ������ ������ ������������ ���������������� ������ ������ � ���������� � ����� � �������������� 
������� �� ���������� `Stream API`.

��� ������ ���������� ����������� ��������� �������, � ������:

`Sex`, ���������� ���� �����:

```java
public enum Sex {
    MAN,
    WOMAN
}
```

`Education`, ���������� ���� �����������:


```java
public enum Education {
    ELEMENTARY,
    SECONDARY,
    FURTHER,
    HIGHER
}
```

`Person`, ���������� ���������� �� �����, ��������, ���� � ����������� ��������:

```java
class Person {
private String name;
private String family;
private Integer age;
private Sex sex;
private Education education;

    public Person(String name, String family, int age, Sex sex, Education education) {
        this.name = name;
        this.family = family;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", education=" + education +
                '}';
    }
}
```
�� �������� �������� `Person` ����������:

1. ����� ���������� ������������������ (�.�. ����� ������ 18 ���). 
2. �������� ������ ������� ����������� (�.�. ������ �� 18 � �� 27 ���). 
3. �������� ��������������� �� ������� ������ ������������ ��������������� ����� � ������ ������������ � ������� 
(�.�. ����� � ������ ������������ �� 18 �� 60 ��� ��� ������ � �� 65 ��� ��� ������).
� ������ `Main` � ������� `main()` ���������� ������� ��������� ����������� ������ `Person`. 
��� ����������� ������������� ������� ���������� ������. ��� ������� ����� �������, 
��� �� ����������� �������� ��������� ������ ������ � ���������� � 10 ��������� �������. 
��� ��������� �������� ������ ������������� ��������� ��������:

```java
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
```
**���������**

�� ��������� ��������� `persons` ��� ������� ������� ���������� ����� ����� ������� `stream()` � 
����� ���������� � ���� ��� ������������� �������� � ���� ������������:

1. ��� ������ ������������������ ����������� ������������� ����� `filter()` � ������������ ����� `count()`.
2. ��� ��������� ������ ����������� ����������� ��������� ��������� ������������� ������� `filter()`, 
� ����� ��� �������������� ������ �� `Person` � `String` (��� ��� ����� ������ �������) ����������� ����� `map()`. 
��� ��� ��������� �������� ������ `List<String>` ������������ ������� ����� `collect(Collectors.toList())`.
3. ��� ��������� ���������������� �� ������� ������ ������������ ��������������� ����� � 
������ ������������ ���������� ��������� ��� ������������� ������� `filter()`, ����� `sorted()` � 
������� ����� ����� �������� ���������� �� �������� `Comparator.comparing()`. ��������� ����� ���������� ������� `collect()`.