package com.company.Homework6;

import java.math.BigDecimal;

public class Manager extends Employee{
    private int quantity;
    public Manager(String name, BigDecimal salary, int clientAmount){
        super (name, salary);
        quantity = clientAmount;
    }
    @Override
    public void setBonus(BigDecimal bonus) {
        if (quantity > 150){
            this.bonus = bonus.add(new BigDecimal(1000));
        }
        else if (quantity > 100){
            this.bonus = bonus.add(new BigDecimal(500));
        }
        else {
            this.bonus = bonus;
        }
    }
}
