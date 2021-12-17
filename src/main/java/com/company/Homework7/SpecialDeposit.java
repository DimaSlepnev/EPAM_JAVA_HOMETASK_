package com.company.Homework7;

import java.math.BigDecimal;

public class SpecialDeposit extends Deposit {
    public SpecialDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal res = this.getAmount();
        for (int i = 1; i <= this.getPeriod(); i++){
            res = res.add(res.multiply(new BigDecimal(((double)i)/100)));
        }
        BigDecimal incomeAmount = res.subtract(this.getAmount());
        incomeAmount = incomeAmount.setScale(2,BigDecimal.ROUND_HALF_UP);
        return incomeAmount;
    }
}
