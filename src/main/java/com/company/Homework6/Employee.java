package com.company.Homework6;

import java.math.BigDecimal;

abstract public class Employee {
    private String lastname;
    private BigDecimal salary;
    protected BigDecimal bonus;

    public String getLastname() {
        return lastname;
    }

    public BigDecimal getSalary() {
        return salary;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    public Employee(String lastname, BigDecimal salary){
        this.lastname = lastname;
        this.salary = salary;
    }
    abstract public void setBonus (BigDecimal bonus);
    public BigDecimal toPay(){
        return salary.add(bonus);
    }
}
