package advanced.java.ua.univer.practice3.task2;

import java.util.*;

public class IntStringCappedMap extends HashMap<Integer, String> {
    private class Node {
        private int K;
        private String V;

        public Node(int Key, String Value) {
            K = Key;
            V = Value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "K=" + K +
                    ", V='" + V + '\'' +
                    '}';
        }
    }

    private Node[] map;
    private int size;
    private int capacity;

    public IntStringCappedMap(int capacity) {
        map = new Node[capacity];
        this.capacity = capacity;
    }

    public AbstractSet entrySet() {
        return new AbstractSet() {
            int currentIndex = 0;

            @Override
            public Iterator iterator() {
                return new Iterator() {
                    @Override
                    public boolean hasNext() {
                        return map[currentIndex] != null && currentIndex < size;
                    }

                    @Override
                    public Object next() {
                        if (hasNext()) {
                            return map[currentIndex++];
                        }
                        return null;
                    }
                };
            }

            @Override
            public int size() {
                return size;
            }
        };
    }

    public String get(int K) {
        for (int i = 0; i < map.length; i++) {
            if (map[i].K == K) {
                return map[i].V;
            }
        }
        return null;
    }

    public boolean put(int K, String V) {
        Node node = new Node(K, V);
        if(size > capacity){
            throw  new IllegalArgumentException();
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i]!= null && map[i].K == K) {
                map[i].V = V;
                return true;
            }
        }
        if (size == capacity) {
            Node[] Tmap = Arrays.copyOf(map, size + 1);
            Tmap[Tmap.length - 1] = node;
            for (int i = 0; i < map.length; i++) {
                map[i] = Tmap[i + 1];
            }
            return true;
        }
        map[size] = node;
        size++;
        return true;
    }

    public void remove(int K) {
        Node[] Tmap = Arrays.copyOf(map, size);
        for (int i = 0; i < map.length; i ++){
            if(map [i] != null && map[i].K == K){
                map[i] = null;
                for(int j =0; j < map.length; j++){
                    if(map[j] != null){
                        map[j] = Tmap[j];
                    }
                }
                for(int k = map.length - 1; k > 0; k--){
                    if(map[k] != null){
                        map[k] = Tmap[k];
                    }
                }
                size--;
                break;
            }
        }
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        return "IntStringCappedMap{" +
                "map=" + Arrays.toString(map) +
                '}';
    }

    public static void main(String[] args) {
        IntStringCappedMap map = new IntStringCappedMap(5);
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(12, "Twelve");
        map.put(9, "Nine");
        map.put(1, "One");
        System.out.println(map);
    }
}
