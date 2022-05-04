package advanced.java.ua.univer.practice6.iterator;

import java.util.Arrays;
import java.util.Iterator;

public class Table implements Iterable {
    private String [] table;

    public Table(String [] columns, int [] rows){
        table = new String[columns.length * rows.length];
        int columnsIndex = 0;
        int rowsIndex = 0;
        for(int i = 0; i < table.length; i++){
            table[i] = columns[columnsIndex] + rows[rowsIndex++];
            if(rowsIndex == rows.length){
                columnsIndex++;
                rowsIndex = 0;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < table.length; i++) {
            result.append(table[i]);
            if (i != table.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int position = 0;
            @Override
            public boolean hasNext() {
                return position < table.length;
            }

            @Override
            public Object next() {
                if(hasNext()){
                    String element = table[position++];
                    return element;
                }
                else {
                    return null;
                }
            }
        };
    }
}
