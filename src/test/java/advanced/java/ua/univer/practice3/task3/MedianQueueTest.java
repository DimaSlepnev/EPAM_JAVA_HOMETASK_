package advanced.java.ua.univer.practice3.task3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianQueueTest {
    MedianQueue queue;

    @BeforeEach
    void setUp() {
        queue = new MedianQueue(4);
        System.out.println("Run @Before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run @After");
    }

    @Test
    void offer() {
        queue.offer(2);
        queue.offer(1);
        queue.offer(100);
        queue.offer(37);
        assertEquals(4, queue.size());
    }

    @Test
    void poll() {
        queue.offer(2);
        queue.offer(1);
        queue.offer(100);
        queue.poll();
        queue.poll();
        queue.poll();
        assertEquals(0, queue.size());
    }

    @Test
    void peek() {
        queue.offer(2);
        assertEquals(2,queue.peek());
        queue.offer(1);
        assertEquals(2,queue.peek());
        queue.offer(100);
        assertEquals(2,queue.peek());
    }

    @Test
    void size() {
        assertEquals(0, queue.size());
        queue.offer(2);
        assertEquals(1, queue.size());
        queue.poll();
        assertEquals(0, queue.size());
    }

    @Test
    void median(){
        queue.offer(2);
        queue.offer(1);
        queue.offer(100);
        queue.offer(37);
        assertEquals(2, queue.median());
    }
}