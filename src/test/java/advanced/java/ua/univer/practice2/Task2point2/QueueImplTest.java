package advanced.java.ua.univer.practice2.Task2point2;

import advanced.java.ua.univer.practice2.Task2point1.ListImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueImplTest {
    Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new QueueImpl<>();
        System.out.println("Run Before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run after");
    }

    @Test
    void clear() {
        queue.enqueue("element1");
        queue.enqueue("element2");
        assertEquals(2, queue.size());
        queue.clear();
        System.out.println(queue);
        assertEquals(0, queue.size());
    }

    @Test
    void size() {
        queue.enqueue("element1");
        queue.enqueue("element2");
        queue.enqueue("element3");
        queue.dequeue();
        assertEquals(2, queue.size());
    }

    @Test
    void enqueue() {
        queue.enqueue("element1");
        queue.enqueue("element2");
        assertEquals(2, queue.size());
        assertEquals("[element1, element2]", queue.toString());
    }

    @Test
    void dequeue() {
        queue.enqueue("element1");
        queue.enqueue("element2");
        queue.dequeue();
        assertEquals(1, queue.size());
        assertEquals("[element2]", queue.toString());
    }

    @Test
    void top() {
        queue.enqueue("element1");
        queue.enqueue("element2");
        queue.enqueue("element3");
        assertEquals(3, queue.size());
        assertEquals("element1", queue.top());
    }
}