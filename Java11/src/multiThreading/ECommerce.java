package multiThreading;

import java.util.EmptyStackException;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ECommerce {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService= Executors.newFixedThreadPool(2);
//        IntStream.range(0,5).forEach(i->{
//            Future<Integer> integerFuture1=executorService.submit(new SelectOrder());
//            Integer orderNumber1= null;
//            try {
//                orderNumber1 = integerFuture1.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//            System.out.println(String.format("%s->product selected:product id: %s",Thread.currentThread().getName(),orderNumber1.toString()));
//            Future<Integer> integerFuture2=executorService.submit(new MakePayment(orderNumber1));
//            Integer orderNumber2= null;
//            try {
//                orderNumber2 = integerFuture2.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//            System.out.println(String.format("%s->payment done:for product id: %s",Thread.currentThread().getName(),orderNumber2.toString()));
//            Future<Integer> integerFuture3=executorService.submit(new GetEmailNotification(orderNumber2));
//            Integer orderNumber3= null;
//            try {
//                orderNumber3 = integerFuture1.get();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
//            System.out.println(String.format("%s->payment invoice triggered:for product id: %s",Thread.currentThread().getName(),orderNumber3.toString()));
//
//        });

        IntStream.range(0,3).forEach(i->{
            CompletableFuture.supplyAsync(SelectOrder::selectProduct,executorService)
                    .thenApply(order->new MakePayment((Integer) order).makePayment())
                    .thenApply(order->new GetEmailNotification((Integer) order).notifyUser())
                    .thenAccept((order)-> System.out.println(Thread.currentThread().getName()+"---closing"));
        });


        executorService.shutdown();

    }
}

class SelectOrder{

    public static Object selectProduct() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Integer orderNumber=new Random().nextInt();
        orderNumber=orderNumber>0?orderNumber:-orderNumber;
        System.out.println(String.format("%s->Product Selected:Product id: %s",Thread.currentThread().getName(),orderNumber));
        return orderNumber;
    }
}

class MakePayment{
    Integer order;

    public MakePayment(Integer order) {
        this.order = order;
    }

    public Object makePayment(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%s->Payment Successfully Done:Product id: %s",Thread.currentThread().getName(),order));
        return order;
    }
}

class GetEmailNotification{
    Integer order;

    public GetEmailNotification(Integer order) {
        this.order = order;
    }


    public Object notifyUser(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.format("%s->Payment Invoice Notified:Product id: %s",Thread.currentThread().getName(),order));
        return order;
    }
}

