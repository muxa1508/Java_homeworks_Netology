package org.example.account;

public class Account {
    protected int balance;

    public Account() {
    }

    public boolean add(long amount) {
        balance += amount;
        if (balance >= 0) {
            return true;
        } else {
            balance -= amount;
            return false;
        }
    }

    public boolean pay(long amount) {
        balance -= amount;
        if (balance >= 0) {
            return true;
        } else {
            balance += amount;
            return false;
        }
    }

    public boolean transfer(Account account, long amount) {
        if (pay(amount)) {
            if (account.add(amount)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public long getBalance() {
        return balance;
    }
}
