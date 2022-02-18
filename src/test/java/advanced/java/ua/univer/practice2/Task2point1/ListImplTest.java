package advanced.java.ua.univer.practice2.Task2point1;

import advanced.java.ua.univer.practice1.task2.ArrayImpl;
import com.sun.security.jgss.GSSUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListImplTest {
    ListImpl<String> list;

    @BeforeEach
    void setUp() {
        list = new ListImpl();
        System.out.println("Run Before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run after");
    }

    @Test
    void clear() {
        list.addFirst("element1");
        list.addLast("element2");
        assertEquals(2, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void size() {
        list.addFirst("element1");
        list.addLast("element2");
        assertEquals(2, list.size());
    }

    @Test
    void addFirst() {
        list.addFirst("element1");
        assertEquals(1, list.size());
    }

    @Test
    void addLast() {
        list.addLast("element1");
        assertEquals(1, list.size());
    }

    @Test
    void removeFirst() {
        list.addFirst("element1");
        list.addLast("element2");
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        assertEquals(1, list.size());
    }

    @Test
    void removeLast() {
        list.addFirst("element1");
        list.addLast("element2");
        System.out.println(list);
        list.removeLast();
        System.out.println(list);
        assertEquals(1, list.size());
    }

    @Test
    void search() {
        list.addLast("element1");
        list.addFirst("element2");
        list.addFirst("element3");
        System.out.println(list);
        assertEquals("element2", list.search("element2"));
    }

    @Test
    void remove() {
        list.addLast("element1");
        list.addFirst("element2");
        list.addFirst("element3");
        System.out.println(list);
        assertEquals(true, list.remove("element3"));
        assertEquals(2, list.size());
    }
}