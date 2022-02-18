package advanced.java.ua.univer.practice2;

import advanced.java.ua.univer.practice2.Task2point1.ListImpl;

import java.io.IOException;
import java.io.Serializable;

public class City implements Serializable {
    private String name;
    private int uniqueID;

    public City(String name){
        this.name = name;
        uniqueID = (int) (Math.random() * 101);
    }

    @Override
    public String toString() {
        return  "{ City: " + name +
                "uniqueID: " + uniqueID +
                '}';
    }

    public static void main(String[] args) throws IOException {
        ListImpl<City> cities = new ListImpl<>();
        cities.addFirst(new City("London"));
        cities.addFirst(new City("Berlin"));
        cities.addLast(new City("Paris"));
        System.out.println(cities);
        JSONWriter writer = new JSONWriter();
        writer.WriteToJSON(cities);
    }
}
