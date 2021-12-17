package com.company.Homework5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {
   private Rectangle rectangle;
    @BeforeEach
    public void setUp() throws Exception {
        System.out.println("Run @Before");
     rectangle = new Rectangle(10,5);
    }

    @Test
    public void getSideA() {
     System.out.println("Run @getSideA");
        assertEquals(10, rectangle.getSideA(), 0.001 );
    }

    @Test
    void getSideB() {
     System.out.println("Run @getSideB");
     assertEquals(5, rectangle.getSideB(), 0.001 );
    }

    @Test
    void area() {
     System.out.println("Run @area");
     assertEquals(50, rectangle.Area(), 0.001);
    }

    @Test
    void perimetr() {
     System.out.println("Run @perimetr");
     assertEquals(30, rectangle.Perimetr(), 0.001);
    }

    @Test
    void isSquare() {
     System.out.println("Run @isSquare");
     assertEquals(false, rectangle.isSquare());
    }

    @Test
    void replaceSides() {
     System.out.println("Run @replaceSides");
     rectangle.replaceSides();
     assertEquals(5, rectangle.getSideA());

    }

    @AfterEach
    void tearDown() throws Exception {
        System.out.println("Run @After");
    }

}