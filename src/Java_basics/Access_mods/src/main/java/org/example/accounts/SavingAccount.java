package org.example.accounts;

public class SavingAccount extends Account {

    private long minBalance;

    public SavingAccount(long minBalance, String name) {
        super(name);
        this.minBalance = minBalance;
        balance = minBalance;
    }

    @Override
    public boolean pay(long amount) {
        balance -= amount;
        if ((balance - minBalance) >= 0) {
            return true;
        }
        balance += amount;
        return false;
    }

    @Override
    public boolean add(long amount) {
        return super.add(amount);
    }
}
