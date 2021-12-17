package com.company.Homework3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task_4Test {

    @Test
    void sumGeometricElements() {
        double actual = Task_4.SumGeometricElements(100, 0.5, 20);
        assertEquals(175, actual);
    }
}