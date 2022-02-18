package advanced.java.ua.univer.practice2.Task2point3;

import advanced.java.ua.univer.practice2.Task2point2.QueueImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackImplTest {
    StackImpl<String> stack;

    @BeforeEach
    void setUp() {
        stack = new StackImpl<>();
        System.out.println("Run Before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run after");
    }

    @Test
    void clear() {
        stack.push("element1");
        stack.push("element2");
        assertEquals(2, stack.size());
        stack.clear();
        assertEquals("[]", stack.toString());
        assertEquals(0, stack.size());
    }

    @Test
    void size() {
        stack.push("element1");
        stack.push("element2");
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }

    @Test
    void push() {
        stack.push("element1");
        stack.push("element2");
        System.out.println(stack);
        assertEquals("[element1, element2]", stack.toString());
        assertEquals(2, stack.size());
    }

    @Test
    void pop() {
        stack.push("element1");
        stack.push("element2");
        stack.pop();
        System.out.println(stack);
        assertEquals("[element1]", stack.toString());
        assertEquals(1, stack.size());
    }

    @Test
    void top() {
        stack.push("element1");
        stack.push("element2");
        assertEquals("element2", stack.top());
        assertEquals(2, stack.size());
    }
}