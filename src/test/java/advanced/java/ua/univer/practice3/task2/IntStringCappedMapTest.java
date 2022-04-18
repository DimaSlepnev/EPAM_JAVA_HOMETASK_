package advanced.java.ua.univer.practice3.task2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntStringCappedMapTest {

    IntStringCappedMap map;

    @BeforeEach
    void setUp() {
        map = new IntStringCappedMap(5);
        System.out.println("Run @Before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run @After");
    }

    @Test
    void get() {
        map.put(1, "One");
        assertEquals("One", map.get(1));
    }

    @Test
    void put() {
        map.put(1, "One");
        map.put(10, "Ten");
        assertEquals(2, map.size());
    }

    @Test
    void remove() {
        map.put(1, "One");
        map.put(10, "Ten");
        map.remove(5);
        assertEquals(2, map.size());
        map.remove(1);
        assertEquals(1, map.size());
    }

    @Test
    void size() {
        map.put(1, "One");
        map.put(10, "Ten");
        map.put(6, "Six");
        assertEquals(3, map.size());
        map.remove(10);
        assertEquals(2,map.size());
    }
}