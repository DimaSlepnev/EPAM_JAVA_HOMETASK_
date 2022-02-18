package advanced.java.ua.univer.practice1.task2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayImplTest {
    ArrayImpl arr;

    @BeforeEach
    void setUp() {
        arr = new ArrayImpl();
        System.out.println("Run Before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run after");
    }

    @Test
    void add() {
        arr.add("element");
        assertEquals(1, arr.size());
    }


    @Test
    void indexOf() {
        arr.add("element1");
        arr.add("element2");
        assertEquals(1, arr.indexOf("element2"));
    }

    @Test
    void remove() {
        arr.add("element1");
        arr.add("element2");
        arr.add("element3");
        arr.remove(1);
        assertEquals(2, arr.size());
        assertEquals(1, arr.indexOf("element3"));
    }

    @Test
    void clear() {
        arr.add("element1");
        arr.add("element2");
        arr.add("element3");
        assertEquals(3, arr.size());
        arr.clear();
        assertEquals(0, arr.size());
    }

    @Test
    void size() {
        assertEquals(0, arr.size());
        arr.add("element1");
        assertEquals(1, arr.size());
    }
}