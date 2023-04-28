package org.example.taxes;

public class EarnMinSp extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        int tax = (debit - credit) / 100 * 15;
        if (tax > 0) {
            return tax;
        }
        return 0;
    }
}
