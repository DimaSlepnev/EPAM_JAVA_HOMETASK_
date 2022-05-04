package advanced.java.ua.univer.practice6.iterator;

import java.util.Iterator;

public class NUMBERTimes implements Iterator<Integer> {
    private int[] arr;
    private int position = 0;


    public NUMBERTimes(int manyTimes, int[] array) {
        arr = new int[array.length * manyTimes];
        int index = 0;
            for (int j = 0; j < array.length; j++) {
                for (int i = 0; i < manyTimes; i++) {
                    arr[index++] = array[j];
                }
            }
        }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            result.append(arr[i]);
            if (i != arr.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public boolean hasNext() {
        return position < arr.length;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int element = arr[position++];
            return element;
        } else {
            return null;
        }
    }
}
