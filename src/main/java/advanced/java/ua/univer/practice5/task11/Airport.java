package advanced.java.ua.univer.practice5.task11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Airport implements Runnable {
    private Terminal[] terminals;
    List<Plane> planes;
    private int planeAmount;
    private int indexOfTerminal;

    public Airport() {
        terminals = new Terminal[]{new Terminal(true), new Terminal(true), new Terminal(true)};
        planes = new ArrayList<>();
        planeAmount = -1;
    }

    public synchronized boolean takePlane(Plane plane) {
        for (int i = 0; i < terminals.length; i++) {
            if (terminals[i].getIsAvailable()) {
                planes.add(plane);
                terminals[i].setIsAvailable(false);
                planeAmount++;
                indexOfTerminal = i;
                System.out.println("Plane " + plane + " successfully arrive to terminal " + i);
                return true;
            }
        }
        System.out.println("Plane " + plane + " can't land in airport");
        return false;
    }

    public synchronized boolean sendPlane() {
        if (planeAmount >= 0) {
            checkAndChangeCondition();
            Plane tempPlane = planes.get(planeAmount);
            planes.remove(planeAmount);
            terminals[indexOfTerminal].setIsAvailable(true);
            planeAmount--;
            System.out.println("Plane " + tempPlane + " successfully land off from terminal " + indexOfTerminal + " to " + tempPlane.getWhereWantFly() + " distance");
            indexOfTerminal--;
            return true;
        }
        System.out.println("Airport is empty");
        return false;
    }

    public synchronized void checkAndChangeCondition() {
        Range range = planes.get(planeAmount).getRange();
        int flyTo = planes.get(planeAmount).getWhereWantFly();
        if (range.equals(Range.low) && flyTo > 20) {
            while (flyTo > 20) {
                flyTo = planes.get(planeAmount).setRandomWhereWantFly();
            }
            planes.get(planeAmount).setWhereWantFly(flyTo);
            System.out.println(planes.get(planeAmount).toString() + " change his destination to " + planes.get(planeAmount).getWhereWantFly());
        }
        if (range.equals(Range.middle) && flyTo > 70) {
            while (flyTo > 70) {
                flyTo = planes.get(planeAmount).setRandomWhereWantFly();
            }
            planes.get(planeAmount).setWhereWantFly(flyTo);
        }

    }

    @Override
    public void run() {
        while(true){
        synchronized (this) {
            takePlane(new Plane());
            takePlane(new Plane());
            sendPlane();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
    }

    public static void main(String[] args) {
        Airport airport = new Airport();
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        service.execute(airport);
        service.shutdown();
    }

}
