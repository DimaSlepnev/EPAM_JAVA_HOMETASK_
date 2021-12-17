package com.company.Homework9;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    Matrix m1;
    Matrix m2;

    @BeforeEach
    void setUp() {
        m1 = new Matrix(2,2);
        m2 = new Matrix(2,2);
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m1.getColumns(); j++) {
            m1.setByIndex(i,j, 10 - i + j);
            }
        }
        for (int i = 0; i < m2.getRows(); i++) {
            for (int j = 0; j < m2.getColumns(); j++) {
                m2.setByIndex(i,j, 50 - i - j);
            }
        }
        System.out.println("@Run Before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@Run After");
    }


    @Test
    void getByIndex() throws MatrixException {
        assertEquals(11, m1.getByIndex(0,1));
        assertEquals(49, m2.getByIndex(1,0));
    }


    @Test
    void addMatrix() throws MatrixException{
        String str ="60.0\t\t60.0\t\t\n58.0\t\t58.0\t\t\n";
        assertEquals(str, m1.addMatrix(m2).toString());
    }

    @Test
    void subMatrix() throws MatrixException {
        String str = "40.0\t\t38.0\t\t\n40.0\t\t38.0\t\t\n";
        assertEquals(str,m2.subMatrix(m1).toString());
    }

    @Test
    void multMatrix() throws MatrixException {
        String str = "1039.0\t\t1018.0\t\t\n940.0\t\t921.0\t\t\n";
        assertEquals(str,m1.multMatrix(m2).toString());
    }
}