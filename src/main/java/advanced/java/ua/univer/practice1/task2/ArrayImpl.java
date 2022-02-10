package advanced.java.ua.univer.practice1.task2;


import java.sql.SQLOutput;
import java.util.Iterator;


public class ArrayImpl<T> implements Array {

    private T[] arr;
    private int currentIndex = 0;

    public ArrayImpl() {
        arr = (T[]) new Object[0];
    }

    @Override
    public void add(Object element) {
        T[] tArr = arr;
        arr = (T[]) new Object[arr.length + 1];
        for (int i = 0; i < tArr.length; i++) {
            arr[i] = tArr[i];
        }
        arr[arr.length - 1] = (T) element;
    }

    @Override
    public void set(int index, Object element) {
        if (index >= 0 && index < arr.length) {
            arr[index] = (T) element;
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < arr.length) {
            return arr[index];
        } else throw new IndexOutOfBoundsException();
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < arr.length) {
            T[] tArr = (T[]) new Object[arr.length - 1];
            for (int i = index; i >= 0; i--) {
                tArr[i] = arr[i];
            }
            for (int i = index + 1; i < arr.length; i++) {
                tArr[i - 1] = arr[i];
            }
            arr = (T[]) new Object[tArr.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = tArr[i];
            }
        }
    }

    @Override
    public void clear() {
        arr = (T[]) new Object[0];
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < arr.length - 1; i++) {
            str.append(arr[i] + ", ");
        }
        if(arr.length > 0) str.append(arr[arr.length - 1]);
        str.append("]");
        return str.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements java.util.Iterator<T> {


        @Override
        public boolean hasNext() {
            return arr.length > currentIndex;
        }

        @Override
        public T next() {
            if (hasNext()) {
                currentIndex++;
            }
            return arr[currentIndex];
        }
    }

    public static void main(String[] args) {
        ArrayImpl<String> arr = new ArrayImpl<>();

        arr.add("A");
        arr.add("B");
        arr.add("C");
        System.out.println(arr);

        for (int i = 1; i < arr.size(); i++) {
            System.out.println("Is it something after " + i + " element?");
            System.out.println(arr.iterator().hasNext());
            System.out.println("This is: " + arr.iterator().next());
        }

        System.out.println("Size of array is equals " + arr.size());
        arr.set(1, "D");
        System.out.println("Set by index 1 another letter: " + arr);
        System.out.println("Get letter by index 0: " + arr.get(0));
        System.out.println("Search by element C: " + arr.indexOf("C"));
        System.out.println("Search by element U: " + arr.indexOf("U"));
        arr.remove(1);
        System.out.println("Remove element with index 1: "+ arr);
        arr.clear();
        System.out.println("Clean all array: " + arr);
    }
}

