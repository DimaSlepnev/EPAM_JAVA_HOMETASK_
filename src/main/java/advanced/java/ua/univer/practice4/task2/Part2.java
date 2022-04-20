package advanced.java.ua.univer.practice4.task2;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicBoolean;


class MyInputStream extends InputStream{

    private boolean firstTime = true;
    int answer = "\n".getBytes(StandardCharsets.UTF_8)[0];

    @Override
    public int read() throws IOException {
        if (firstTime){
            firstTime = false;
            try {
                Thread.sleep(2000);
                return 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return answer;
        }
        return -1;
    }
}

public class Part2 {
    public static void main(String[] args) throws InterruptedException {
        boolean isWork = true;
        while (isWork) {
            InputStream INPUT_STREAM = new MyInputStream();
            InputStream CACHED_VALUE_OF_SYSTEM_IN = System.in;
            System.setIn(INPUT_STREAM);
            Thread t = new Thread(() -> {
                try {
                    Spam.main(null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            t.start();
            t.join();
            System.setIn(CACHED_VALUE_OF_SYSTEM_IN);
        }
    }
}
