package advanced.java.ua.univer.practice5.task10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Exchange implements Runnable {
    private List<Broker> brokers;
    private static final Semaphore SEMAPHORE = new Semaphore(3, true);
    private int index;
    private int count = 0;

    public Exchange(List<Broker> brokers) {
        this.brokers = brokers;
    }

    @Override
    public void run() {
        try {
                SEMAPHORE.acquire();
                synchronized (this) {
                    for (int i = 0; i < brokers.size(); i++) {
                        System.out.println(brokers.get(i).getName() + " has backpack: " + brokers.get(i).getBackpack().toString());
                    }
                    while (count < SEMAPHORE.availablePermits()) {
                        if (brokers.get(count).getIndex() < 0) {
                            System.out.println("Index is too low. Stop trading");
                            Thread.sleep(5000);
                            brokers.get(count).setIndex(3);
                        }
                        brokers.get(count).run();
                        count++;
                    }
                    SEMAPHORE.release();
                    for (int i = 0; i < brokers.size(); i++) {
                        System.out.println(brokers.get(i).getName() + " has backpack: " + brokers.get(i).getBackpack().toString());
                    }
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static List<Share> makeShares(Share... shares) {
        List<Share> sharesTemp = new ArrayList<>();
        for (int i = 0; i < shares.length; i++) {
            sharesTemp.add(shares[i]);
        }
        return sharesTemp;
    }

    public static void main(String[] args) {
        List<Broker> brokers = new ArrayList<>();
        Share share1 = new Share("Coca-cola", 200);
        Share share2 = new Share("Apple", 500);
        Share share3 = new Share("Nike", 300);
        Share share4 = new Share("Death Row Records", 700);
        List<Share> sharesTwo = makeShares(share1, share2);
        List<Share> sharesThree = makeShares(share1, share2, share3);
        List<Share> sharesFour = makeShares(share1, share2, share3, share4);
        Broker broker1 = new Broker("Tyler",sharesTwo);
        Broker broker2 = new Broker("Rakim", sharesFour);
        Broker broker3 = new Broker("Josh", sharesTwo);
        Broker broker4 = new Broker("Ann", sharesThree);
        Broker broker5 = new Broker("Kate", sharesThree);
        brokers.add(broker1);
        brokers.add(broker2);
        brokers.add(broker3);
        brokers.add(broker4);
        brokers.add(broker5);
        Exchange exchange = new Exchange(brokers);
        exchange.run();
    }
}
