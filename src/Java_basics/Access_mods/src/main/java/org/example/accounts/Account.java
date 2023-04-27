package org.example.accounts;

class Account {
    long balance;
    String name;

    Account(String name) {
        this.name = name;
    }

    boolean pay(long amount) {
        balance -= amount;
        if (balance >= 0) {
            return true;
        }
        balance += amount;
        return false;
    }

    boolean add(long amount) {
        balance += amount;
        if (balance >= 0) {
            return true;
        }
        balance -= amount;
        return false;
    }

    public long getBalance() {
        return balance;
    }
}
