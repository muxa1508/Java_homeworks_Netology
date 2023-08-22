package org.example.Task_2;

public class BinOps {
    public String sum(String a, String b) {
        int binA = Integer.parseInt(a, 2);
        int binB = Integer.parseInt(b, 2);
        int sum = binA + binB;
        String binSum = Integer.toBinaryString(sum);
        System.out.println("В двоичной системе: " + a + " + " + b + " = " + binSum +
                "\nВ десятичной системе: " + binA + " + " + binB + " = " + sum);
        return binSum;

    /*Переведите числа из двоичной записи в
      строках в int, сложите и переведите
      обратно в двоичную запись*/
    }

    public String mult(String a, String b) {
        int binA = Integer.parseInt(a, 2);
        int binB = Integer.parseInt(b, 2);
        int mult = binA * binB;
        String binMult = Integer.toBinaryString(mult);
        System.out.println("В двоичной системе: " + a + " * " + b + " = " + binMult +
                "\nВ десятичной системе: " + binA + " * " + binB + " = " + mult);
        return binMult;

    /*Переведите числа из двоичной записи в
      строках в int, перемножьте и переведите
      обратно в двоичную запись*/
    }
}
