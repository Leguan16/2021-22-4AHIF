package executors;

import java.util.concurrent.*;

public class Demo {

    public static void main(String[] args) {
        var executor = Executors.newCachedThreadPool();
        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000);
            //throw new RuntimeException();
            return "Hello World";
        });
        future.cancel(true);
        String result = null;
        try {
            System.out.println("waiting for result");
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            result = e.getMessage();
        }
        System.out.println(result);
        executor.shutdown();
        try {
            var success = executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
