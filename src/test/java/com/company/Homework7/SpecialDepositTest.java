package com.company.Homework7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SpecialDepositTest {
    SpecialDeposit sp;

    @BeforeEach
    void setUp() {
        System.out.println("Run @Before");
        sp = new SpecialDeposit(new BigDecimal(1000), 3);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run @After");
    }

    @Test
    void income() {
      assertEquals(new BigDecimal(61.11).setScale(2,BigDecimal.ROUND_HALF_UP), sp.income());
    }
}