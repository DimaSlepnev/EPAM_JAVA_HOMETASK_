package com.company.Homework5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayRectanglesTest {
    private ArrayRectangles arr;
    private Rectangle r1;
    private Rectangle r2;
    private Rectangle r3;
    @BeforeEach
    void setUp() {
        System.out.println("Run @Before");
        r1 = new Rectangle(10,5);
        r2 = new Rectangle(5);
        r3 = new Rectangle();
        arr = new ArrayRectangles(r1, r2, r3);
    }

    @Test
    void addRectangle() {
        System.out.println("Run @addRectangle");
        assertEquals(false, arr.addRectangle(r1));
    }

    @Test
    void numberMaxArea() {
        System.out.println("Run @numberMaxArea");
        assertEquals(0, arr.numberMaxArea());

    }

    @Test
    void numberMinPerimetr() {
        System.out.println("Run @numberMinPerimetr");
        assertEquals(2, arr.numberMinPerimetr());
    }

    @Test
    void numberSquare() {
        System.out.println("Run @numberSquare");
        assertEquals(1, arr.numberSquare());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run @After");
    }
}