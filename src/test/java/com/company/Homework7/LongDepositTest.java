package com.company.Homework7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class LongDepositTest {
    LongDeposit ld;

    @BeforeEach
    void setUp() {
        System.out.println("Run @Before");
        ld = new LongDeposit(new BigDecimal(1000),9);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run @After");
    }

    @Test
    void income() {
     assertEquals(new BigDecimal(520.88).setScale(2,BigDecimal.ROUND_CEILING), ld.income());
    }
}