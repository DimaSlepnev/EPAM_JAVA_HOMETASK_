package com.company.Homework6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
private Company arr;
private SalesPerson sp1, sp2, sp3, sp4;
private Manager m1, m2;

    @BeforeEach
        void setUp() {
        System.out.println("Run @Before");
        sp1 = new SalesPerson("Mark", new BigDecimal(1000), 120);
        sp2 = new SalesPerson("Lisa", new BigDecimal(1000),220);
        sp3 = new SalesPerson("Tyler", new BigDecimal(500), 80);
        sp4 = new SalesPerson("Kate", new BigDecimal(600), 95);
        m1 = new Manager("Heisenberg", new BigDecimal(5000), 175);
        m2 = new Manager("Elsa", new BigDecimal(4000), 105);
        arr = new Company(sp1, sp2, sp3, sp4, m1, m2);
        arr.giveEverybodyBonus(new BigDecimal(50));
    }
    @Test
    void giveEverybodyBonus() {
        System.out.println("Run @giveEverybodyBonus");
        assertEquals(0,(sp1.toPay().subtract(sp1.getSalary()).compareTo(sp1.bonus)));
        assertEquals(0,(sp2.toPay().subtract(sp2.getSalary()).compareTo(sp2.bonus)));
        assertEquals(0,(sp3.toPay().subtract(sp3.getSalary()).compareTo(sp3.bonus)));
        assertEquals(0,(sp4.toPay().subtract(sp4.getSalary()).compareTo(sp4.bonus)));
        assertEquals(0,(m1.toPay().subtract(m1.getSalary()).compareTo(m1.bonus)));
        assertEquals(0,(m2.toPay().subtract(m2.getSalary()).compareTo(m2.bonus)));
    }

    @Test
    void totalTOPay() {
        System.out.println("Run @totalToPay");
      assertEquals(new BigDecimal(14050), arr.totalTOPay());
    }

    @Test
    void nameMaxSalary() {
        assertEquals("Heisenberg", arr.nameMaxSalary());
    }
    @AfterEach
    void tearDown() {
        System.out.println("Run @After");
    }
}