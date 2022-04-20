package advanced.java.ua.univer.practice4.task1;

class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++){
            System.out.println(name);
            try {
                Thread.sleep(333);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i =0; i < 6; i++){
            System.out.println(name);
            try {
                Thread.sleep(333);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Part1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("First");
        Thread t2 = new Thread(new MyRunnable("Second"));
        t1.start();
        Thread.sleep(2000);
        t2.start();
    }

}
