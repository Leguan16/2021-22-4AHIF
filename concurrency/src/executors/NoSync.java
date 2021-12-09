package executors;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NoSync {

    private static int count = 0;
    private static Lock incrementLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10_000; i++)
            executor.submit(NoSync::increment);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(count);
    }


    static void increment() {
        incrementLock.lock();
        try {
            count++;
        } finally {
            incrementLock.unlock();
        }
    }
}
