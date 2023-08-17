package org.example.accounts;

public class SavingsAccount extends Account {
    protected long minBalance;

    public SavingsAccount(String name, long balance, long minBalance) {
        super(name);
        this.balance = balance;
        this.minBalance = minBalance;

    }

    @Override
    public boolean add(long amount) {
        return super.add(amount);
    }

    @Override
    public boolean pay(long amount) {
        if (balance - amount <= minBalance) {
            return false;
        }
        return super.pay(amount);
    }
}

