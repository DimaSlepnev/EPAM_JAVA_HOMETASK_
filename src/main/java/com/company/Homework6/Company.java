package com.company.Homework6;

import java.math.BigDecimal;

public class Company {
    private Employee [] employees;
    public Company(Employee ... employees){
        this.employees = new Employee[employees.length];
        for (int i = 0; i < employees.length; i++){
            this.employees[i] = employees[i];
        }
    }
    public void giveEverybodyBonus(BigDecimal companyBonus){
        for (int i = 0; i < employees.length; i++){
            employees[i].setBonus(companyBonus);
        }
    }
    public BigDecimal totalTOPay(){
        BigDecimal total = new BigDecimal(0);
        for (var item :employees
             ) {
            total = total.add(item.toPay());
        }
        return total;
    }
    public String nameMaxSalary(){
        BigDecimal temp = new BigDecimal(0);
        int index = 0;
        for (int i =0; i < employees.length - 1; i++){
            if (temp.compareTo(employees[i].toPay()) == -1 ){
                  temp = employees[i].toPay();
                  index = i;
            }
        }
        return employees[index].getLastname();
    }
}
