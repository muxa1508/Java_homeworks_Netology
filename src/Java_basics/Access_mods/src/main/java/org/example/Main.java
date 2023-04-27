package org.example;

import org.example.accounts.CheckingAccount;
import org.example.accounts.CreditAccount;
import org.example.accounts.SavingAccount;

public class Main {
    public static void main(String[] args) {

        SavingAccount savingAccount = new SavingAccount(1000, "saving");
        CheckingAccount checkingAccount = new CheckingAccount("checking");
        CreditAccount creditAccount = new CreditAccount("credit");


        System.out.println(savingAccount.add(1000));
        System.out.println(savingAccount.getBalance());

        System.out.println(checkingAccount.add(1000));
        System.out.println(checkingAccount.getBalance());

        System.out.println(creditAccount.add(1000));
        System.out.println(creditAccount.getBalance());

        System.out.println();

        System.out.println(savingAccount.pay(1000));
        System.out.println(savingAccount.getBalance());

        System.out.println(checkingAccount.pay(1000));
        System.out.println(checkingAccount.getBalance());

        System.out.println(creditAccount.pay(1000));
        System.out.println(creditAccount.getBalance());

    }
}