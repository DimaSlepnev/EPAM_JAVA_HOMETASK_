package advanced.java.ua.univer.practice2.Task2point2;

import java.util.Iterator;

public class QueueImpl<T> implements Queue {

    private Node head = null;
    private Node tail = null;
    private int elementCount = 0;

    @Override
    public void clear() {
        head = null;
        tail = null;
        elementCount = 0;
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
    public void enqueue(Object element) {
        Node tNode = new Node(element);
        if(head == null){
            head = tNode;
        }else if(tail == null){
            tail = tNode;
            Node tempNode = head;
            while(tempNode.next != null){
                tempNode = tempNode.next;
            }
            tNode.previous = tempNode;
            tempNode.next = tNode;
        }else {
            tail.next = tNode;
            tNode.previous = tail;
            tail = tNode;
        }
        elementCount++;
    }

    @Override
    public T dequeue() {
        if(head != null){
            head = head.next;
            head.previous = null;
            if(head.equals(tail)){
                tail = null;
            }
            elementCount--;
            return (T) head;
        }
        return null;
    }

    @Override
    public T top() {
        if(head != null){
            return (T) head.data;
        }
        return null;
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
    private class IteratorImpl implements java.util.Iterator {

        @Override
        public boolean hasNext() {
            if(head != null && head.next != null){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return head.next;
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
        QueueImpl<String> queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Queue looks like: " + queue + "\nSize: " + queue.elementCount);
        System.out.println("Top element: " + queue.top());
        queue.dequeue();
        System.out.println("After deleting first element: " + queue + "\nSize: " + queue.elementCount);
        queue.dequeue();
        System.out.println("After deleting first element: " + queue + "\nSize: " + queue.elementCount);
        queue.clear();
        System.out.println("After clearing: "+ queue + "\nSize: " + queue.elementCount);
    }
}
