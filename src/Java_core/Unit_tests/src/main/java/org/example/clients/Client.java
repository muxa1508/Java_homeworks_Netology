package org.example.clients;

import org.example.accounts.Account;

public class Client {

    protected String name;
    protected Account[] accounts;

    public Client(String name, int maxAccountNumber) {
        this.name = name;
        this.accounts = new Account[maxAccountNumber];
    }


    public void addNewAccount(Account accountType) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = accountType;
                return;
            }
        }
        System.out.println("Мест для добавления нового счета нет!");
    }

    public boolean pay(long amount) {

        for (int i = 0; i < accounts.length; i++) {
            if ((accounts[i].pay(amount) == true) && (accounts[i] != null)) {
                return true;
            }
        }
        return false;
    }
}