package advanced.java.ua.univer.practice4.task3;

public class Part3 {
    private int steps;
    private int counter;
    private int counter2;

    public void compare() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < steps; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < steps; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void compareSync() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                for (int i = 0; i < steps; i++) {
                    incrementSync();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public synchronized void  run() {
                for (int i = 0; i < steps; i++) {
                    incrementSync();
                }
            }
        });

        t1.start();
        t2.start();
    }


    public Part3(int steps) {
        this.steps = steps;
    }


    public void increment() {
        System.out.println(Thread.currentThread().getName() + "\tCounter1: " + counter + "\tCounter2: " + counter2);
        counter++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter2++;
    }

    public synchronized void incrementSync() {
        increment();
    }


    public static void main(String[] args) {
        Part3 task = new Part3(5);
        System.out.println("Compare");
        task.compare();
        System.out.println("Synchronized Compare");
        task.compareSync();

    }
}
