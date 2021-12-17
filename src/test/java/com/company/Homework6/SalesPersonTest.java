package com.company.Homework6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SalesPersonTest {
    private SalesPerson sp1,sp2 ,sp3,sp4;
    private Company arr;

    @Test
    void setBonus() {
        System.out.println("Run @setBonus");
        assertEquals(new BigDecimal(200), sp1.bonus);
        assertEquals(new BigDecimal(300), sp2.bonus);
        assertEquals(new BigDecimal(100), sp3.bonus);
        assertEquals(new BigDecimal(100), sp4.bonus);
    }

    @BeforeEach
    void setUp() {
        System.out.println("Run @Before");
        sp1 = new SalesPerson("Mark", new BigDecimal(1000), 120);
        sp2 = new SalesPerson("Lisa", new BigDecimal(1000), 220);
        sp3 = new SalesPerson("Tyler", new BigDecimal(500), 80);
        sp4 = new SalesPerson("Kate", new BigDecimal(600), 95);
        arr = new Company(sp1, sp2, sp3, sp4);
        arr.giveEverybodyBonus(new BigDecimal(100));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run @After");
    }
}