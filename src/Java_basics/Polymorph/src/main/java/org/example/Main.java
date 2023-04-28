package org.example;

import org.example.deals.Deal;
import org.example.deals.Expenditure;
import org.example.deals.Sale;
import org.example.taxes.Earn;
import org.example.taxes.EarnMinSp;


public class Main {
    public static void main(String[] args) {

        System.out.println("Задача 1:");

        Company company1 = new Company("Шарага1", new Earn());
        Company company2 = new Company("Шарага2", new EarnMinSp());

        company1.getInfo();
        company2.getInfo();

        company1.shiftMoney(1000);
        company1.getInfo();
        company1.payTaxes();
        company1.setTaxSystem(new EarnMinSp());
        company1.getInfo();
        company1.shiftMoney(2000);
        company1.getInfo();
        company1.payTaxes();
        company1.getInfo();

        System.out.println("Задача 2:");
        company1.shiftMoney(1000);
        Deal[] deals = {new Sale("Бумага", 100), new Expenditure("Вода", 50)};
        System.out.println(company1.applyDeals(deals));
        company1.getInfo();
    }
}