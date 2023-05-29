### Задание №1. “Калькулятор” (обязательное)

**Описание**

В этом задании попрактикуемся с шаблоном `Adapter` (Адаптер). Ниже вам дан готовый класс калькулятора:

```java
public class Calculator {
public Formula newFormula() {
return new Formula();
}

public static enum Operation {
SUM, SUB, MULT, DIV, POW;
}

public static class Formula {
protected Double a, b, result;

    protected Formula() {}

    public Formula addOperand(double operand) {
      if (a == null) {
        a = operand;
      } else if (b == null) {
        b = operand;
      } else {
        throw new IllegalStateException("Formula is full of operands");
      }
      return this;
    }

    public Formula calculate(Operation op) {
      if (a == null || b == null)
        throw new IllegalStateException("Not enough operands!");
      switch (op) {
        case SUM:
          result = a + b;
          break;
        case SUB:
          result = a - b;
          break;
        case MULT:
          result = a * b;
          break;
        case DIV:
          result = a / b;
          break;
        case POW:
          result = Math.pow(a, b);
          break;
      }
      return this;
    }

    public double result() {
      if (result == null)
        throw new IllegalStateException("Formula is not computed!");
      return result;
    }
}
}
```

Пример использования этого класса:

```java
Calculator calc = new Calculator();
System.out.println(
    calc.newFormula()
        .addOperand(5)
        .addOperand(15)
        .calculate(Calculator.Operation.MULT)
        .result()
);
```

Пользователю же нужен другой интерфейс для работы с калькулятором:

```java
public interface Ints {
    int sum(int arg0, int arg1);
    int mult(int arg0, int arg1);
    int pow(int a, int b);
}
```

который он использует в `main`, например, вот так:

```java
public static void main(String[] args) {
    Ints intsCalc = new IntsCalculator();
    System.out.println(intsCalc.sum(2, 2));
    System.out.println(intsCalc.sum(10, 22));
    System.out.println(intsCalc.pow(2, 10));
}
```

Вам надо написать класс `IntsCalculator`, который будет имплементировать интерфейс `Ints`, 
“под капотом” делая вычисления через класс `Calculator`.

**Реализация**

1. Создайте класс `Calculator`, скопируйте его готовый код выше.
2. Создайте интерфейс `Ints`, скопируйте его готовый код выше.
3. Создайте класс `IntsCalculator`, укажите что он имплементирует интерфейс `Ints`, реализуйте 
его методы через обращение к объекту класса `Calculator`:

```java
public class IntsCalculator implements Ints {
    protected final Calculator target;

    public IntsCalculator() { this.target = new Calculator(); }

    @Override
    public int sum(int arg0, int arg1) {
    //считаем через target
    }

    @Override
    public int mult(int arg0, int arg1) {
    //считаем через target
    }

    @Override
    public int pow(int a, int b) {
    //считаем через target
    }
}
```

4. Создайте класс `Main`, продемонстрируйте использование и возможности вашего класса 
(например, как выше в условии), обращайтесь к нему как к объекту интерфейса `Ints`.

```java
public class Main {
    public static void main(String[] args) {
        Ints calc = new IntsCalculator();
        //демонстрация
    }
}
```

5. Протестируйте работу программы. Не забывайте про правила форматирования кода (для автоформата 
можете выделить код в идее и нажать `Ctrl+Alt+L`).


### Задание №2. “Двоичный фасад” (необязательное к выполнению)

Если вы хотите прислать дополнительное задание позже, напишите об этом при сдаче домашнего задания.

**Описание**

В этом задании попрактикуемся с шаблоном `Facade` (Фасад). Вы уже знаете, что джава 
даёт нам много возможностей для вычислений, в том числе для парсинга чисел 
из произвольных систем счисления и обратно, произведения математических операций и 
так далее. Вам же надо написать простой класс-фасад к набору стандартных классов 
джавы, который будет уметь всего две вещи: складывать и перемножать числа в двоичной системе счисления:

```java
public class BinOps {
    public String sum(String a, String b) {
    /*Переведите числа из двоичной записи в
    строках в int, сложите и переведите
    обратно в двоичную запись*/
    }

    public String mult(String a, String b) {
    /*Переведите числа из двоичной записи в
    строках в int, перемножьте и переведите
    обратно в двоичную запись*/
    }
}
```

В итоге пользователь сможет выполнять эти две операции всего лишь через один вызов 
метода вашего класса, а не через самостоятельный вызов комбинации стандартных для 
джавы методов. Продемонстрируйте работоспособность в классе `Main`.

**Реализация**

1. Создайте класс `BinOps`, скопируйте его заготовку из кода выше.
2. Реализуйте оба метода. Для парсинга из двоичной записи используйте `Integer.parseInt(binStr, 2)`, 
для конвертации обратно - `Integer.toBinaryString`.
3. Создайте класс `Main`, продемонстрируйте работоспособность написанного вами класса:

```java
public class Main {
    public static void main(String[] args) {
        BinOps bins = new BinOps();
        //демонстрация
    }
}
```

4. Протестируйте работу программы. Не забывайте про правила форматирования кода 
(для автоформата можете выделить код в идее и нажать `Ctrl+Alt+L`).