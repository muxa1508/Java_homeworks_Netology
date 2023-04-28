package org.example;

import org.example.deals.Deal;
import org.example.taxes.TaxSystem;

public class Company {

    private String title;
    private int debit;
    private int credit;
    private TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
        this.debit = 0;
        this.credit = 0;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        } else if (amount < 0) {
            credit += Math.abs(amount);
        }
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void payTaxes() {
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.println("Компания " + title + " уплатила налог в размере: " + tax + " руб.");
        debit = 0;
        credit = 0;
    }

    public void getInfo() {

        System.out.println(title + " " + debit + " " + credit + " " + taxSystem);
    }

    public int applyDeals(Deal[] deals) {
        for (Deal deal: deals) {
            credit += deal.getCreditChange();
            debit += deal.getDebitChange();

            System.out.println(title + " " + debit + " " + credit);
        }
        payTaxes();
        return debit - credit;
    }
}
