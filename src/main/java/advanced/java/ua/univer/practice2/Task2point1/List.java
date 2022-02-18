package advanced.java.ua.univer.practice2.Task2point1;

import advanced.java.ua.univer.practice1.Container;

public interface List<T> extends Container {
    // Inserts the specified element at the beginning.
    void addFirst(T element);

    // Appends the specified element to the end.
    void addLast(T element);

    // Removes the first element.
    void removeFirst();

    // Removes the last element.
    void removeLast();

    // Returns the first element.
    T getFirst();

    // Returns the last element.
    T getLast();

    // Returns the first occurrence of the specified element.
    // Returns null if no such element.
    // (use 'equals' method to check an occurrence)
    Object search(Object element);

    // Removes the first occurrence of the specified element.
    // Returns true if this list contained the specified element.
    // (use 'equals' method to check an occurrence)
    boolean remove(Object element);
}
