package com.company.Homework7;

import java.math.BigDecimal;

public class Client {
    private Deposit [] deposits;
    public Client (){
        deposits = new Deposit[10];
    }
    public boolean addDeposit (Deposit deposit){
        for (int i = 0; i < deposits.length; i++){
            if (deposits[i] == null){
                deposits[i] = deposit;
                return true;
            }
        }
        return false;
    }
    public BigDecimal totalIncome(){
        BigDecimal total = new BigDecimal(0);
        for (int i = 0; i <deposits.length; i++ ){
            if (deposits[i] != null) {
                total = total.add(deposits[i].income());
            }
        }
        total = total.setScale(2,BigDecimal.ROUND_HALF_UP);
        return total;
    }
    public BigDecimal maxIncome(){
        BigDecimal max = deposits[0].income();
        for (int i = 0; i < deposits.length; i++){
            if (deposits [i+1] != null) {
                if (deposits[i + 1].income().compareTo(max) == 1) {
                    max = deposits[i + 1].income();
                }
            }
            else {
                break;
            }
        }
        max = max.setScale(2,BigDecimal.ROUND_HALF_UP);
        return max;
    }
    public BigDecimal getIncomeByNumber(int number){
        if (deposits[number - 1] != null){
            return deposits[number - 1].income();
        }
        return new BigDecimal(0);
    }
}
