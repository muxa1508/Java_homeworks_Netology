package org.example.taxes;

public class Earn extends  TaxSystem{
    @Override
    public int calcTaxFor(int debit, int credit) {
        int tax = debit / 100 * 6;
        if (tax > 0) {
            return tax;
        }
        return 0;
    }
}
