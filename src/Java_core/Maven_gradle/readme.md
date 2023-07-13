### ������� 1
��� ����������� ����������� ��������� �������������� � ���, ��� ��������� �������.

����������� �������������� ������ ����� ������������ �� �����������:

* `db` - ������ ������ � ����� ������; 
* `api` - ������ ������ � web; 
* `service` - ���� ��������.
��� ������ �������� ������������� ������ - ��� ��� ���� �������� �� �������.

����� ���������� ���������� packaging � pom

```java
<packaging>pom</packaging>
```
����� ������� 3 ����� � ���������� �������: `db`, `api`, `service`.

� ������ �� ���������� ������� `pom.xml` c ����������:

```java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>App</artifactId>
        <groupId>ru.netology</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
    <artifactId>db</artifactId>
    <packaging>jar</packaging>
</project>
```
��� ����������� ��������� `parent` - � �������� ������������� ������ 
� ��� ������� � �������� `artifactId` �������� ������ (`db`, `api`, `service`)

����� ���������� ����� ������ � �������, ��������� � ����� ������� � ���� pom.xml ����� ��������� ������:

```java
<modules>
    <module>db</module>
    <module>api</module>
    <module>service</module>
</modules>
```
����� �������� ��������������� �������, ��������� ��������� ������ ����� �����.

��� ����������� ������ `db` � ������ `service` ������� �����������:

```java
<dependencies>
    <dependency>
        <groupId>ru.netology</groupId>
        <artifactId>db</artifactId>
        <version>1.0-SNAPSHOT</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```
��� ����������� ������ `service` � ������ `api` ������� �����������:

```java
<dependencies>
    <dependency>
        <groupId>ru.netology</groupId>
        <artifactId>service</artifactId>
        <version>1.0-SNAPSHOT</version>
        <scope>compile</scope>
    </dependency>
</dependencies>
```
������ ����� ������� ������, �������� �������:

```java
mvn clean install
```
��� ����������� ������ ����������� � ������� `db` �������� ������:

```java
public class DbSetting {

    private String name;
    private String password;

    public DbSetting(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
```
```java
public class MyEntity {

    private UUID id;
    private String name;

    public MyEntity(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("MyEntity{").append("id=").append(id).append(", name='").append(name).append('\'').append('}').toString();
    }
}
```
```java
public class Db {

    private DbSetting dbSetting;
    private MyEntity myEntity;

    public Db(DbSetting dbSetting) {
        this.dbSetting = dbSetting;
        myEntity = new MyEntity("first");
        myEntity.setId(UUID.randomUUID());
    }

    public DbSetting getDbSetting() {
        return dbSetting;
    }

    public MyEntity getMyEntity() {
        return myEntity;
    }

    public void setMyEntity(MyEntity myEntity) {
        this.myEntity = myEntity;
    }
}
```
� ������� `Service` �������� �����:

```java
public class MyService {

    private DbSetting dbSetting = new DbSetting("name", "password");
    private String name = "myService";
    private Db db = new Db(dbSetting);

    public String getName() {
        return name;
    }

    public MyEntity setMyEntity(MyEntity myEntity) {
        myEntity.setId(UUID.randomUUID());
        db.setMyEntity(myEntity);
        return myEntity;
    }

    public MyEntity getMyEntity() {
        return db.getMyEntity();
    }
}
```
� ������� `api` �������� �����:

```java
public class Main {

    public static void main(String[] args) {
        MyService myService = new MyService();
        System.out.println(myService.getMyEntity());
        System.out.println(myService.setMyEntity(new MyEntity("second")));
        System.out.println(myService.getMyEntity());
    }
}
```
����� �������� ������ ������� ����� ��������� ������ ���.

� ���������� ���������� ������� ������� �� �������� ��������� ������ � ����������� �� ����������������

### ������� 2

��� ����������� ����������� ��������� ��������������, ��� ��������� �������.

����������� �������������� ������ ����� ������������ �� �����������:

* `db` - ������ ������ � ����� ������; 
* `api` - ������ ������ � web; 
* `service` - ���� ��������.
��� ������ �������� ������������� ������ - ��� ��� ������ �� �������.

����� ������� 3 ����� � ���������� �������: `db`, `api`, `service`.

� ������ �� ���������� ������� `build.gradle` c ����������:

```java
plugins {
    id 'java'
}

group 'ru.netology'
version '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {

}
```
����� ���������� ����� ������ � �������, ��������� � ����� ������� � `settings.gradle` ����� ��������� ������:

```java
include 'db'
include 'service'
include 'api'
```
����� �������� ��������������� ������� ��������� ��������� ������ ����� �����.

��� ����������� ������ `db` � ������ `service` ������� �����������:

```java
dependencies {
    implementation project(":db")
}
```
��� ����������� ������ `service` � ������ `api` ������� �����������:

```java
dependencies {
    implementation project(":db")
    implementation project(":service")
}
```
������ ����� ������� ������, �������� �������:

```java
gradle build
```
��� ����������� ������ ����������� � ������� `db` �������� ������.

```java
public class DbSetting {

    private String name;
    private String password;

    public DbSetting(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
```
```java
public class MyEntity {

    private UUID id;
    private String name;

    public MyEntity(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("MyEntity{").append("id=").append(id).append(", name='").append(name).append('\'').append('}').toString();
    }
}
```

```java
public class Db {

    private DbSetting dbSetting;
    private MyEntity myEntity;

    public Db(DbSetting dbSetting) {
        this.dbSetting = dbSetting;
        myEntity = new MyEntity("first");
        myEntity.setId(UUID.randomUUID());
    }

    public DbSetting getDbSetting() {
        return dbSetting;
    }

    public MyEntity getMyEntity() {
        return myEntity;
    }

    public void setMyEntity(MyEntity myEntity) {
        this.myEntity = myEntity;
    }
}
```

� ������� `Service` �������� �����:

```java
public class MyService {

    private DbSetting dbSetting = new DbSetting("name", "password");
    private String name = "myService";
    private Db db = new Db(dbSetting);

    public String getName() {
        return name;
    }

    public MyEntity setMyEntity(MyEntity myEntity) {
        myEntity.setId(UUID.randomUUID());
        db.setMyEntity(myEntity);
        return myEntity;
    }

    public MyEntity getMyEntity() {
        return db.getMyEntity();
    }
}
```
� ������� `api` �������� �����:

```java
public class Main {

    public static void main(String[] args) {
        MyService myService = new MyService();
        System.out.println(myService.getMyEntity());
        System.out.println(myService.setMyEntity(new MyEntity("second")));
        System.out.println(myService.getMyEntity());
    }
}
```
����� �������� ������ ������� ����� ��������� ������ ���.

� ���������� ���������� ������� ������� �� �������� ��������� ������ � ����������� �� ����������������