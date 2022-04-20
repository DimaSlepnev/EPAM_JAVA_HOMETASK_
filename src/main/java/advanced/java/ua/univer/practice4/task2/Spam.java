package advanced.java.ua.univer.practice4.task2;


import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;


public class Spam {
    private Thread[] threads;
    int size;

    public Spam(String[] msg, int[] intervalMS) {
        if (msg.length > intervalMS.length) {
            msg = Arrays.copyOf(msg, intervalMS.length);
        }
        if (intervalMS.length > msg.length) {
            intervalMS = Arrays.copyOf(intervalMS, msg.length);
        }
        threads = new Worker[msg.length];
        size = msg.length;
        for (int i = 0; i < msg.length; i++) {
            threads[i] = new Worker(msg[i], intervalMS[i]);
        }

    }

    public void start() {
        for (int i = 0; i < size; i++) {
            threads[i].start();
        }
    }

    public void stop() {
        for (int i = 0; i < size; i++) {
            threads[i].interrupt();
        }
    }

    private static class Worker extends Thread {
        private String msg;
        private int intervalMS;

        public Worker(String msg, int intervalMS) {
            this.msg = msg;
            this.intervalMS = intervalMS;
        }

        @Override
        public void run() {
            System.out.println(msg);
            try {
                Thread.sleep(intervalMS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        String[] messages = new String[]{"@@@", "bbbbbbb"};
        int[] times = new int[]{333, 222};
        Spam sp = new Spam(messages, times);
        sp.start();
        System.out.println("Press Enter to stop");
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        if (answer.equals("\n")) {
            sp.stop();
        }
    }
}
