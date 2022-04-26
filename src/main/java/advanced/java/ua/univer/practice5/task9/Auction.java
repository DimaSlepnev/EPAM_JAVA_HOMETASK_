package advanced.java.ua.univer.practice5.task9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Auction implements Runnable {
    private List<Lot> lots = new ArrayList<>();
    private List<Participant> participants = new ArrayList<>();

    public Auction(int lotsAmount, int participantAmount) {
        for (int i = 0; i < lotsAmount; i++) {
            lots.add(new Lot());
            lots.get(i).setNumber(i);
        }
        for (int i = 0; i < participantAmount; i++) {
            participants.add(new Participant());
        }
    }

    public List<Lot> getLots() {
        return lots;
    }

    @Override
    public void run() {
        ExecutorService service = Executors.newFixedThreadPool(participants.size());
        for (int j = 0; j < lots.size(); j++) {
            for (int i = 0; i < participants.size(); i++) {
                lots.get(i).setLotLength(lots.size());
                participants.get(i).setLot(lots.get(j));
                int finalI = i;
                Future future  = service.submit(new Runnable() {
                    @Override
                    public void run() {
                        service.execute(participants.get(finalI));
                    }
                });
                try {
                    future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                //service.execute(participants.get(i));
            }
        }
        service.shutdown();
    }

    public static void main(String[] args) {
        final int LOTS_AMOUNT = 3;
        final int PARTICIPANTS_AMOUNT = 3;
        Auction auction = new Auction(LOTS_AMOUNT, PARTICIPANTS_AMOUNT);
        for (int i = 0; i < auction.getLots().size(); i++) {
            System.out.println("Loot #" + auction.getLots().get(i).getNumber() + " has price " + auction.getLots().get(i).getPrice() + "$");
        }
        auction.run();
    }

}
