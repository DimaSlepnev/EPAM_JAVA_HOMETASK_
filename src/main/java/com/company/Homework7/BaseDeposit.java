package com.company.Homework7;

import java.math.BigDecimal;

public class BaseDeposit extends Deposit{

    public BaseDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal res = this.getAmount();
        for (int i = 0; i < this.getPeriod(); i++) {
             res = res.add(res.multiply(new BigDecimal(0.05)));
        }
        BigDecimal incomeAmount = res.subtract(this.getAmount());
        incomeAmount = incomeAmount.setScale(2,BigDecimal.ROUND_HALF_UP);
        return incomeAmount;
    }
}
