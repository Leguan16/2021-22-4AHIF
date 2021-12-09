package wiederholung;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Synch {

    private final Lock lock = new ReentrantLock();
    private boolean bool = false;

    public static void main(String[] args) throws InterruptedException {
        var executor = Executors.newFixedThreadPool(2);
        var instance = new Synch();
        executor.submit(() -> instance.setBool(true));
        executor.submit(() -> instance.setBool(false));
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(instance.bool);
    }

    public void setBool(boolean bool) {
        lock.lock();
        try {
            this.bool = bool;
        } finally {
            lock.unlock();
        }
    }

    public void setBoolOld(boolean bool) {
        synchronized (this) {
            this.bool = bool;
        }
    }
}

