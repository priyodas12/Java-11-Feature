package multiThreading;

import java.util.Random;
import java.util.concurrent.Callable;

public class CallableTask implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(4000);
        return new Random().nextInt();
    }
}
