package com.company.Homework7;

import java.math.BigDecimal;

public abstract class Deposit {
    private BigDecimal amount;
    private int period;

    public BigDecimal getAmount() {
        return amount;
    }

    public int getPeriod() {
        return period;
    }

    public Deposit(BigDecimal depositAmount, int depositPeriod) {
        this.amount = depositAmount;
        this.period = depositPeriod;
    }
    public abstract BigDecimal income();
}
