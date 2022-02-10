package advanced.java.ua.univer.practice1;

import java.util.Iterator;

public interface Container<T> extends Iterable<T> {

        // Removes all of the elements.
        void clear();

        // Returns the number of elements.
        int size();

        // Returns a string representation of this container.
        String toString();

        // Returns an iterator over elements.
        // Iterator must implements the remove method.
        Iterator<T> iterator();

    }
