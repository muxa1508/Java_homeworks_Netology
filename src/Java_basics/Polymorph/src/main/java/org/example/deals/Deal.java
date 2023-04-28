package org.example.deals;

public class Deal {
    protected String comment;
    protected int creditChange;
    protected int debitChange;

    public Deal(int creditChange, int debitChange, String comment) {
        this.comment = comment;
        this.creditChange = creditChange;
        this.debitChange = debitChange;

    }
    protected Deal() {
    }

    public int getCreditChange() {
        return creditChange;
    }

    public int getDebitChange() {
        return debitChange;
    }
}

