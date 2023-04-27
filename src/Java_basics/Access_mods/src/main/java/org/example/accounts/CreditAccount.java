package org.example.accounts;

public class CreditAccount extends Account {

    public CreditAccount(String name) {
        super(name);
    }

    @Override
    public boolean add(long amount) {
        balance += amount;
        if (balance <= 0) {
            return true;
        }
        balance -= amount;
        return false;
    }

    @Override
    public boolean pay(long amount) {
        balance -= amount;
        if (balance <= 0) {
            return true;
        }
        balance += amount;
        return false;
    }
}
