package advanced.java.ua.univer.practice5.task10;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Broker implements Runnable {
    List<Share> backpack;
    String name;
    private static final Object monitor = new Object();
    private int index = 3;
    private static final Semaphore SEMAPHORE = new Semaphore(3, true);

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Broker(String name, List<Share> backpack) {
        this.name = name;
        this.backpack = backpack;
    }

    public List<Share> getBackpack() {
        return backpack;
    }

    public void setBackpack(List<Share> backpack) {
        this.backpack = backpack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void whatWillDo() {
        synchronized (monitor) {
            int x = new Random().nextInt(2) + 1;
            if (x % 2 == 0) {
                System.out.println(name + " decided to sell");
                sell();
                return;
            } else {
                System.out.println(name + " want to buy");
                buy();
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Broker: " +
                "backpack: " + backpack +
                ", name: " + name;
    }

    @Override
    public void run() {
        int x = 5;
        while (x > 0) {
            try {
                SEMAPHORE.acquire();
                whatWillDo();
                SEMAPHORE.release();
                x--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sell() {
        synchronized (monitor) {
            Share temp = backpack.get(backpack.size() - 1);
            backpack.remove(backpack.size() - 1);
            temp.changeCostToHeight();
            System.out.println(name + " successfully sell his share named " + temp.getName());
            index--;
        }
    }

    public void buy() {
        synchronized (monitor) {
            backpack.add(new Share("NewCompany", 100));
            backpack.get(backpack.size() - 1).changeCostToLow();
            System.out.println(name + " has bought new share named " + backpack.get(backpack.size() - 1).getName());
            index++;
        }
    }
}
