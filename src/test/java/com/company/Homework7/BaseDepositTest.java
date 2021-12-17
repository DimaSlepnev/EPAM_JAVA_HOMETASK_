package com.company.Homework7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BaseDepositTest {
    BaseDeposit bd;

    @BeforeEach
    void setUp() {
        System.out.println("Run @Before");
        bd = new BaseDeposit(new BigDecimal(1000), 6);
        bd.income();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run @After");
    }

    @Test
    void income() {
        System.out.println("Run @income");
        assertEquals(new BigDecimal(340.10).setScale(2,BigDecimal.ROUND_HALF_UP), bd.income());
    }
}