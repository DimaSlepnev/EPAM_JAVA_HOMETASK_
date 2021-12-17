package com.company.Homework7;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    BaseDeposit bd;
    SpecialDeposit sd;
    LongDeposit ld;
    Client client;
    LongDeposit ld2;

    @BeforeEach
    void setUp() {
        bd = new BaseDeposit(new BigDecimal(1000) ,6);
        sd = new SpecialDeposit(new BigDecimal(1000), 3);
        ld = new LongDeposit(new BigDecimal(1000), 9);
        ld2 = new LongDeposit(new BigDecimal(1000), 11);
        client = new Client();
        client.addDeposit(bd);
        client.addDeposit(ld2);
        client.addDeposit(sd);
        client.addDeposit(ld);
        System.out.println("Run @Before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run @After");
    }

    @Test
    void addDeposit() {
        assertEquals(true, client.addDeposit(new BaseDeposit(new BigDecimal(1000), 3)));
    }

    @Test
    void totalIncome() {
        assertEquals(new BigDecimal(1933.45).setScale(2,BigDecimal.ROUND_HALF_UP),client.totalIncome());
    }

    @Test
    void maxIncome() {
        assertEquals(new BigDecimal(1011.36).setScale(2, BigDecimal.ROUND_HALF_UP),client.maxIncome());
    }

    @Test
    void getIncomeByNumber() {
        assertEquals( new BigDecimal(61.11).setScale(2,BigDecimal.ROUND_HALF_UP), client.getIncomeByNumber(3));
    }
}