package org.example.account;

public class CreditAccount extends Account{

    private long creditLimit;

    public CreditAccount(long creditLimit) {

        this.creditLimit = creditLimit;
        balance = 0;
    }

    @Override
    public boolean add(long amount) {
        balance += amount;
        if (balance <= 0) {
            return true;
        } else {
            balance -= amount;
            return false;
        }
    }

    @Override
    public boolean pay(long amount) {
        balance -= amount;
        if (balance <= 0 && balance >= creditLimit) {
            return true;
        } else {
            balance += amount;
            return false;
        }
    }
}
