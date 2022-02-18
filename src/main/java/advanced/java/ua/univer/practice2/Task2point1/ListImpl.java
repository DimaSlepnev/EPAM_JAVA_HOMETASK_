package advanced.java.ua.univer.practice2.Task2point1;

import java.io.Serializable;
import java.util.Iterator;

public class ListImpl<T> implements List, Serializable {
    private Node head = null;
    private Node tail = null;
    private int elementCount = 0;

    @Override
    public void clear() {
        elementCount = 0;
        head = null;
        tail = null;
    }

    @Override
    public int size() {
        return elementCount;
    }

    @Override
    public Iterator iterator() {
        return new IteratorImpl();
    }

    @Override
    public void addFirst(Object element) {
        Node tNode = new Node(element);
        tNode.next = head;
        head = tNode;
        elementCount++;
    }

    @Override
    public void addLast(Object element) {
        Node tNode = new Node(element);
        if (head == null) {
            head = tNode;
        } else if (tail == null) {
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = tNode;
            tNode.previous = tempNode;
            tail = tNode;
        } else {
            tail.next = tNode;
            tNode.previous = tail;
            tail = tNode;
        }
        elementCount++;
    }

    @Override
    public void removeFirst() {
        head = head.next;
        elementCount--;
    }

    @Override
    public void removeLast() {
        if (elementCount < 2) {
            head = null;
            if (elementCount == 1)
                elementCount--;
            return;
        }
        Node tNode = tail;
        tail = tNode.previous;
        tail.next = null;
        elementCount--;
    }

    @Override
    public T getFirst() {
        if (elementCount != 0) {
            return (T) head.data;
        }
        return null;
    }

    @Override
    public T getLast() {
        if (elementCount != 0) {
            return (T) tail.data;
        }
        return null;
    }

    @Override
    public Object search(Object element) {
        Node tNode = head;
        while (tNode != null) {
            if (tNode.data.equals(element)) {
                return tNode.data;
            }
            tNode = tNode.next;
        }
        return null;
    }

    @Override
    public boolean remove(Object element) {
        Node tNode = head;
        while (tNode != null) {
            if (tNode.data.equals(element)) {
                tNode.next.previous = tNode.previous;
                if(tNode.previous != null) {
                    tNode.previous.next = tNode.next;
                }
                elementCount--;
                return true;
            }
            tNode = tNode.next;
        }
        return false;
    }

    static class Node {
        Object data;
        Node next;
        Node previous;

        public Node(Object data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    private class IteratorImpl implements java.util.Iterator<T> {

        @Override
        public boolean hasNext() {
            if (head != null && head.next != null) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            return (T) head.next;
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
        ListImpl<String> list = new ListImpl<>();
        list.addFirst("c");
        list.addFirst("b");
        list.addFirst("a");
        System.out.println("List looks like: " + list + "\nSize of list: " + list.elementCount);
        list.addLast("d");
        list.addLast("e");
        System.out.println("After adding to end: " + list + "\nSize of list: " + list.elementCount);
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
        System.out.println("Search letter c: " + list.search("c"));
        list.removeFirst();
        System.out.println("After removing first letter:\n" + list + "\nSize of list: " + list.elementCount);
        list.removeLast();
        System.out.println("After removing last letter:\n" + list + "\nSize of list: " + list.elementCount);
        list.clear();
        System.out.println("After removing all list: " + list + "\nSize of list: " + list.elementCount);
    }
}

