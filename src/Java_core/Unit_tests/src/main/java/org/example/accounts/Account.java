package org.example.accounts;

public class Account {

    protected String name;
    protected long balance;

    protected Account(String name) {
        this.name = name;
    }

    public boolean pay(long amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean add(long amount) {
        if (balance + amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }
}
