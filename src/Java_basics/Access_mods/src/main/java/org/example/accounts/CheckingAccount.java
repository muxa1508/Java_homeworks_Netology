package org.example.accounts;

public class CheckingAccount extends Account {
    public CheckingAccount(String name) {
        super(name);
    }

    @Override
    public boolean pay(long amount) {
        return super.pay(amount);
    }

    @Override
    public boolean add(long amount) {
        return super.add(amount);
    }
}
