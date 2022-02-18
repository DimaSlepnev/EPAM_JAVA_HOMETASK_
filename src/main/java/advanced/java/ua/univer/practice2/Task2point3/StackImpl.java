package advanced.java.ua.univer.practice2.Task2point3;

import advanced.java.ua.univer.practice2.Task2point2.QueueImpl;

import java.util.Iterator;

public class StackImpl<T> implements Stack {
    private Node head = null;
    private Node tail = null;
    private int elementCounter = 0;

    @Override
    public void clear() {
        head = null;
        tail = null;
        elementCounter = 0;
    }

    @Override
    public int size() {
        return elementCounter;
    }

    @Override
    public Iterator iterator() {
        return new IteratorImpl();
    }

    @Override
    public void push(Object element) {
        Node tNode = new Node(element);
        if (head == null) {
            head = tNode;
        } else if (tail == null) {
            tail = tNode;
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tNode.previous = tempNode;
            tempNode.next = tNode;
        } else {
            tail.next = tNode;
            tNode.previous = tail;
            tail = tNode;
        }
        elementCounter++;
    }

    @Override
    public T pop() {
        if (head != null) {
            tail = tail.previous;
            tail.next = null;
            if (head.equals(tail)) {
                tail = null;
            }
            elementCounter--;
            return (T) tail;
        }
        return null;
    }

    @Override
    public T top() {
        if (head != null) {
            return (T) tail.data;
        }
        return null;
    }

    static class Node {
        private Object data;
        private Node next;
        private Node previous;

        public Node(Object data) {
            this.data = data;
            next = null;
            previous = null;
        }
    }

    private class IteratorImpl implements java.util.Iterator {

        @Override
        public boolean hasNext() {
            if (head != null && head.next != null) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return tail.previous;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        Node tNode = head;
        while (tNode != null) {
            str.append(tNode.data.toString());
            tNode = tNode.next;
            if (tNode != null) {
                str.append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }

    public static void main() {
        StackImpl<String> stack = new StackImpl<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Stack looks like: " + stack + "\nSize:" + stack.elementCounter);
        System.out.println("Top of it is: " + stack.top());
        stack.pop();
        System.out.println("After deleting top of stack: " + stack + "\nSize:" + stack.elementCounter);
        stack.clear();
        System.out.println("After clearing all stack: " + stack + "\nSize:" + stack.elementCounter);
    }
}
