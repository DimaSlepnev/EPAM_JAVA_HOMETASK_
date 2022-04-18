package advanced.java.ua.univer.practice3.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RangedOpsIntegerSetTest {
    RangedOpsIntegerSet set;

    @BeforeEach
    void setUp() {
        set = new RangedOpsIntegerSet();
        System.out.println("Run @Before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run @After");
    }

    @Test
    void add() {
        set.add(1, 15);
        assertEquals(14, set.getSize());
    }

    @Test
    void remove() {
        set.add(1, 15);
        set.remove(3, 12);
        assertEquals(5, set.getSize());
    }

    @Test
    void testAdd() {
        set.add(10);
        assertEquals(1, set.getSize());
    }

    @Test
    void testRemove() {
        set.add(1, 10);
        set.remove(5);
        assertEquals(8, set.getSize());
    }

    @Test
    void getSize() {
        assertEquals(0, set.getSize());
        set.add(1, 5);
        assertEquals(4, set.getSize());
    }
}