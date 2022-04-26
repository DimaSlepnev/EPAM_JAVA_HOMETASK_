package advanced.java.ua.univer.practice5.task9;


public class Lot {
    private int price;
    private int number;
    private boolean isBought = false;
    private int lotLength;

    @Override
    public String toString() {
        return "number=" + number;
    }

    public int getLotLength() {
        return lotLength;
    }

    public void setLotLength(int lotLength) {
        this.lotLength = lotLength;
    }

    public int getPrice(){
        return price;
    }

    public int getNumber() {
        return number;
    }


    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public Lot(){
        price = (int)((Math.random() * (100)) + 1);
    }
}
