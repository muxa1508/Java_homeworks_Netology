### ������� �1. ������������ (������������)

**��������**

� ���� ������� �������������� � �������� `Adapter` (�������). ���� ��� ��� ������� ����� ������������:

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

������ ������������� ����� ������:

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

������������ �� ����� ������ ��������� ��� ������ � �������������:

```java
public interface Ints {
    int sum(int arg0, int arg1);
    int mult(int arg0, int arg1);
    int pow(int a, int b);
}
```

������� �� ���������� � `main`, ��������, ��� ���:

```java
public static void main(String[] args) {
    Ints intsCalc = new IntsCalculator();
    System.out.println(intsCalc.sum(2, 2));
    System.out.println(intsCalc.sum(10, 22));
    System.out.println(intsCalc.pow(2, 10));
}
```

��� ���� �������� ����� `IntsCalculator`, ������� ����� ���������������� ��������� `Ints`, 
���� ������� ����� ���������� ����� ����� `Calculator`.

**����������**

1. �������� ����� `Calculator`, ���������� ��� ������� ��� ����.
2. �������� ��������� `Ints`, ���������� ��� ������� ��� ����.
3. �������� ����� `IntsCalculator`, ������� ��� �� �������������� ��������� `Ints`, ���������� 
��� ������ ����� ��������� � ������� ������ `Calculator`:

```java
public class IntsCalculator implements Ints {
    protected final Calculator target;

    public IntsCalculator() { this.target = new Calculator(); }

    @Override
    public int sum(int arg0, int arg1) {
    //������� ����� target
    }

    @Override
    public int mult(int arg0, int arg1) {
    //������� ����� target
    }

    @Override
    public int pow(int a, int b) {
    //������� ����� target
    }
}
```

4. �������� ����� `Main`, ����������������� ������������� � ����������� ������ ������ 
(��������, ��� ���� � �������), ����������� � ���� ��� � ������� ���������� `Ints`.

```java
public class Main {
    public static void main(String[] args) {
        Ints calc = new IntsCalculator();
        //������������
    }
}
```

5. ������������� ������ ���������. �� ��������� ��� ������� �������������� ���� (��� ����������� 
������ �������� ��� � ���� � ������ `Ctrl+Alt+L`).


### ������� �2. ��������� ����� (�������������� � ����������)

���� �� ������ �������� �������������� ������� �����, �������� �� ���� ��� ����� ��������� �������.

**��������**

� ���� ������� �������������� � �������� `Facade` (�����). �� ��� ������, ��� ����� 
��� ��� ����� ������������ ��� ����������, � ��� ����� ��� �������� ����� 
�� ������������ ������ ��������� � �������, ������������ �������������� �������� � 
��� �����. ��� �� ���� �������� ������� �����-����� � ������ ����������� ������� 
�����, ������� ����� ����� ����� ��� ����: ���������� � ����������� ����� � �������� ������� ���������:

```java
public class BinOps {
    public String sum(String a, String b) {
    /*���������� ����� �� �������� ������ �
    ������� � int, ������� � ����������
    ������� � �������� ������*/
    }

    public String mult(String a, String b) {
    /*���������� ����� �� �������� ������ �
    ������� � int, ����������� � ����������
    ������� � �������� ������*/
    }
}
```

� ����� ������������ ������ ��������� ��� ��� �������� ����� ���� ����� ���� ����� 
������ ������ ������, � �� ����� ��������������� ����� ���������� ����������� ��� 
����� �������. ����������������� ����������������� � ������ `Main`.

**����������**

1. �������� ����� `BinOps`, ���������� ��� ��������� �� ���� ����.
2. ���������� ��� ������. ��� �������� �� �������� ������ ����������� `Integer.parseInt(binStr, 2)`, 
��� ����������� ������� - `Integer.toBinaryString`.
3. �������� ����� `Main`, ����������������� ����������������� ����������� ���� ������:

```java
public class Main {
    public static void main(String[] args) {
        BinOps bins = new BinOps();
        //������������
    }
}
```

4. ������������� ������ ���������. �� ��������� ��� ������� �������������� ���� 
(��� ����������� ������ �������� ��� � ���� � ������ `Ctrl+Alt+L`).