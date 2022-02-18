package advanced.java.ua.univer.practice2.Task2point3;

import advanced.java.ua.univer.practice1.Container;

public interface Stack<T> extends Container {
    // Pushes the specified element onto the top.
    void push(T element);

    // Removes and returns the top element.
    T pop();

    // Returns the top element.
    T top();
}
