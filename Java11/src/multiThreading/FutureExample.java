package multiThreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class FutureExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService= Executors.newFixedThreadPool(4);

        IntStream.range(0,5).forEach((i)->{
            Future<Integer> integerFuture=executorService.submit(new CallableTask());

            System.out.println(Thread.currentThread().getName()+" prints "+integerFuture);

            Integer value= null;
            try {
                value = integerFuture.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+" prints "+value);
            System.out.println(Thread.currentThread().getName()+" prints "+integerFuture);
        });


        executorService.shutdown();

    }
}
