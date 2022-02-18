package advanced.java.ua.univer.practice2.Task2point2;

import advanced.java.ua.univer.practice1.Container;

public interface Queue<T> extends Container {

    // Appends the specified element to the end.
    void enqueue(T element);

    // Removes the head.
    T dequeue();

    // Returns the head.
    T top();

}
