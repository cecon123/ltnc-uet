import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private int value = 0;
    private final ReentrantLock lock = new ReentrantLock();

    public void increment() {
        if (lock.tryLock()) {
            try {
                value++;
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(
                Thread.currentThread().getName() + " could not acquire the lock"
            );
        }
    }

    public int getValue() {
        return value;
    }
}
