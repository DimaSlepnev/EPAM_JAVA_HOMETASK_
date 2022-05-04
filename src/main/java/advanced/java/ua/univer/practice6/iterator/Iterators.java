package advanced.java.ua.univer.practice6.iterator;

import java.util.Iterator;

class Iterators {

    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array) {
        return new NUMBERTimes(2, array);
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {
        return new NUMBERTimes(3, array);
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        return new NUMBERTimes(5, array);
    }

    public static Iterable<String> table(String[] columns, int[] rows) {
        return new Table(columns, rows);
    }
}
