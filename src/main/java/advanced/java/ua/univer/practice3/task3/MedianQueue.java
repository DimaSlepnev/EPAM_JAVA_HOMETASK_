package advanced.java.ua.univer.practice3.task3;

import java.util.Arrays;
import java.util.Iterator;

public class MedianQueue implements Iterable {
    private Integer[] queue;
    private int elementsCounter;
    private int head;
    private int tail;

    public MedianQueue(int size) {
        queue = new Integer[size];
        elementsCounter = 0;
        head = 0;
        tail = -1;
    }

    public boolean isFull() {
        return (elementsCounter == queue.length);
    }

    public boolean isEmpty() {
        return (elementsCounter == 0);
    }

    public boolean offer(Integer element) {
        if (!isFull()) {
            queue[++tail] = element;
            elementsCounter++;
            return true;
        }
        return false;
    }

    public int poll() {
        if (!(isEmpty())) {
            Integer temp = queue[head];
            Integer[] tQueue = new Integer[queue.length - 1];
            for (int i = 0; i < tQueue.length; i++) {
                tQueue[i] = queue[i + 1];
            }
            queue = new Integer[queue.length];
            for (int i = 0; i < tQueue.length; i++) {
                queue[i] = tQueue[i];
            }
            tail--;
            elementsCounter--;
            return temp;
        }
        return 0;
    }

    public int peek() {
        return queue[head];
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < queue.length && queue[currentIndex] != null;
            }

            @Override
            public Object next() {
                return queue[currentIndex++];
            }
        };
    }

    public int size() {
        return elementsCounter;
    }

    public Integer median() {
        SortByGrowing();
        if (queue.length % 2 == 0) {
            if (queue[queue.length / 2 - 1] > queue[queue.length / 2])
                return queue[queue.length / 2];
            else
                return queue[queue.length / 2 - 1];
        }
        else
            return queue[queue.length / 2];
    }

    private void SortByGrowing() {
        for (int i = queue.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (queue[j] > queue[j + 1]) {
                    int tmp = queue[j];
                    queue[j] = queue[j + 1];
                    queue[j + 1] = tmp;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "MedianQueue{" +
                "queue=" + Arrays.toString(queue) +
                '}';
    }

    public static void main(String[] args) {
        MedianQueue queue = new MedianQueue(5);
        queue.offer(1);
        queue.offer(987);
        queue.offer(4);
        queue.offer(2);
        queue.offer(3);
        queue.SortByGrowing();
        System.out.println(queue);
        System.out.println(queue.elementsCounter);
        System.out.println(queue.median());
    }
}
