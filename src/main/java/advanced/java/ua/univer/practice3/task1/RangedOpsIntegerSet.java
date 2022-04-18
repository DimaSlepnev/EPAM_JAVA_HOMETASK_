package advanced.java.ua.univer.practice3.task1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RangedOpsIntegerSet {
    private List<Integer> list;
    private int size;
    private int currentIndex = 0;

    public RangedOpsIntegerSet(){
        list = new ArrayList<>();
    }

    public boolean add(int fromInclusive, int toExclusive){
        for(int i = fromInclusive; i < toExclusive; i++){
            if(!(list.contains(i))){
                list.add(i);
                size++;
            }
            else {
                list.remove((Integer) i);
                list.add(i);
                size++;
            }
        }
        return true;
    }

    public boolean remove (int fromInclusive, int toExclusive){
        for(int i = fromInclusive; i < toExclusive; i++){
            if(list.contains(i)){
                list.remove((Integer) i);
                size--;
            }
        }
        return true;
    }

    public void add (int value){
        if(!(list.contains(value))){
            list.add(value);
            size++;
        }
    }

    public void remove(int value){
        if(list.contains(value)){
            list.remove(value);
            size--;
        }
    }

    public int getSize(){
        return size;
    }

    public Iterator iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator {


        @Override
        public boolean hasNext() {
            if(currentIndex < size){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(hasNext()){
                currentIndex++;
                return list.get(currentIndex);
            }
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        for (int i =0; i < list.size(); i++) {
            str.append(list.get(i) + "\n");
        }
        return str.toString();
    }

    public static void main(String[] args) {
        RangedOpsIntegerSet set = new RangedOpsIntegerSet();
        set.add(1,5);
        set.add(9,11);
        System.out.println(set);
        set.add(1,15);
        System.out.println(set);
        set.remove(3,12);
        System.out.println(set);
    }
}
