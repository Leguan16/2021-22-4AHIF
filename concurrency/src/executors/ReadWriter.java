package executors;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriter {

    public static void main(String[] args) {
        var readWriteLock = new ReentrantReadWriteLock();
        var readLock = readWriteLock.readLock();
        readLock.lock();
        try {
            // read
        }
        finally {
            readLock.unlock();
        }
    }
}
