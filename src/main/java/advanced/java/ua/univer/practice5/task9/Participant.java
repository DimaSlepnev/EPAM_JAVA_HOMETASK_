package advanced.java.ua.univer.practice5.task9;

import java.util.ArrayList;
import java.util.List;

public class Participant implements Runnable {
    private boolean canPlay = true;
    private List<Lot> boughtLots = new ArrayList<>();
    private boolean wantBuy;
    private Lot lot;
    private int bet;
    private Door door = new Door();

    @Override
    public String toString() {
        return "Participant{" +
                "boughtLots=" + boughtLots +
                '}';
    }

    public List<Lot> getBoughtLots() {
        return boughtLots;
    }

    public void setBet() {
        bet = (int) ((Math.random() * 100) + 1);
    }

    public void setBetUp() {
        bet += 10;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public void setWantBuy() {
        int x = (int) ((Math.random() * 3) + 1);
        if (x % 2 != 0) {
            wantBuy = true;
        } else {
            wantBuy = false;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < lot.getLotLength(); i++) {
            begin();
            mood();

        }
    }

    private synchronized void begin() {
        if (canPlay) {
            setBet();
            try {
                door.look();
            while (!(bet >= lot.getPrice())) {
                setBetUp();
            }
            System.out.println(Thread.currentThread().getName() + " make bet " + bet + " to lot with number " + lot.getNumber());
            door.unlock();
              Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " is banned and can't make bet");
            Thread.currentThread().stop();
        }
    }


    public synchronized void mood() {
        try {
            door.look();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setWantBuy();
        if (lot.isBought()) {
            System.out.println(Thread.currentThread().getName() + " can't buy lot #" + lot.getNumber());
        }
         else if (wantBuy && !lot.isBought()) {
            System.out.println(Thread.currentThread().getName() + " has successfully bought the lot" + lot.getNumber() + " with bet " + bet);
            boughtLots.add(lot);
            lot.setBought(true);
        } else {
            try {
                canPlay = false;
                System.out.println(Thread.currentThread().getName() + " didn't buy a lot and will be banned for a time");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        door.unlock();
    }

    class Door {
        private boolean isLocked = false;

        void look() throws InterruptedException {
            synchronized (this) {
                while (isLocked) {
                    wait();
                }
                isLocked = true;
            }
        }

        void unlock() {
            synchronized (this) {
                isLocked = false;
                notify();
            }
        }
    }
}
