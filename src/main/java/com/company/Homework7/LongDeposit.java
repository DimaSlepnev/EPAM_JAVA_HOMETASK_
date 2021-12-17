package com.company.Homework7;

import java.math.BigDecimal;

public class LongDeposit extends Deposit{
    public LongDeposit(BigDecimal depositAmount, int depositPeriod) {
        super(depositAmount, depositPeriod);
    }

    @Override
    public BigDecimal income() {
        BigDecimal res = this.getAmount();
        BigDecimal incomeAmount = new BigDecimal(0);
        if(this.getPeriod() > 6){
            int temp = this.getPeriod() - 6;
            for (int i = 0; i < temp; i++){
                res = res.add(res.multiply(new BigDecimal (0.15)));
            }
            incomeAmount = res.subtract(this.getAmount());
            incomeAmount = incomeAmount.setScale(2,BigDecimal.ROUND_CEILING);
        }
        return incomeAmount;
    }
}
