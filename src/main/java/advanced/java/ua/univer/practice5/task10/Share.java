package advanced.java.ua.univer.practice5.task10;

public class Share {
    private String name;
    private int cost;

    public Share(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public void changeCostToLow() {
        cost -= 5;
    }

    public void changeCostToHeight(){
        cost += 5;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Share: " +
                "name: " + name  +
                ", cost: $" + cost;
    }

    public int getCost() {
        return cost;
    }
}
