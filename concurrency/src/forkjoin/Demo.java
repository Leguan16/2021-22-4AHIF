package forkjoin;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var executor = new ForkJoinPool();
        var collection = IntStream.range(0, 1000)
                .mapToObj(i -> i % 13 == 0 ? null : i)
                .toList();
        var task = new NullCounterTask(collection, 5);
        var forkJoinTask = executor.submit(task);
        System.out.println(forkJoinTask.get());
        executor.shutdown();
    }
}
