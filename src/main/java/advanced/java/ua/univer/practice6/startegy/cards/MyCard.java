package advanced.java.ua.univer.practice6.startegy.cards;

public class MyCard implements Card {

    private String name;

     MyCard(final String name) {
        this.name = name;
    }

    MyCard(final int name) {
        this(Integer.toString(name));
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
