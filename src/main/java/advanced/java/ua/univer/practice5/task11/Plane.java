package advanced.java.ua.univer.practice5.task11;

import java.util.Random;

enum Size{
    small(10), medium(25), big(50);

    int amountOfPeople;

   Size(int amount){
        amountOfPeople = amount;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }
}

enum Range{
    low, middle, high;              // low: 0 - 20km | middle: 0 - 70km | high: 0 - 100km
}

public class Plane {
    private Size size;
    private Range range;
    private int whereWantFly;

    public Plane (){
        this.size = setRandomSize();
        this.range = setRandomRange();
        whereWantFly = setRandomWhereWantFly();
        System.out.println("Create plane: " + this);
    }

    public int getWhereWantFly() {
        return whereWantFly;
    }

    public int setRandomWhereWantFly() {
        return new Random().nextInt(100) + 1;
    }

    public void setWhereWantFly(int whereWantFly) {
        this.whereWantFly = whereWantFly;
    }

    public Size getSize() {
        return size;
    }

    public Range getRange() {
        return range;
    }
    private Range setRandomRange() {
        Random random = new Random();
        return Range.values()[random.nextInt(Range.values().length)];
    }

    private Size setRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }

    @Override
    public String toString() {
        return "size: " + size + ", range: " + range;
    }
}
