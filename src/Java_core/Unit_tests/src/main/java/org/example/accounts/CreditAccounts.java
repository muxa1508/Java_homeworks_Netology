package org.example.accounts;

public class CreditAccounts extends Account {

    public CreditAccounts(String name) {
        super(name);
        this.balance = 0;
    }

    @Override
    public boolean add(long amount) {
        if (balance + amount <= 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean pay(long amount) {
        balance -= amount;
        return true;
    }
}
