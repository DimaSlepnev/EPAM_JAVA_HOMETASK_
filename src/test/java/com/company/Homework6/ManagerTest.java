package com.company.Homework6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private Manager m1, m2;
    @Test
    void setBonus() {
        System.out.println("Run @setBonus");
        assertEquals(new BigDecimal(1050), m1.bonus);
        assertEquals(new BigDecimal(550), m2.bonus);
    }

    @BeforeEach
    void setUp() {
        System.out.println("Run @Before");
        m1 = new Manager("Heisenberg", new BigDecimal(5000), 175);
        m2 = new Manager("Elsa", new BigDecimal(4000), 105);
        m1.setBonus(new BigDecimal(50));
        m2.setBonus(new BigDecimal(50));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run @After");
    }
}