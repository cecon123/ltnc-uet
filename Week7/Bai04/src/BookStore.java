import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BookStore {

    private final Map<String, Integer> stock = new HashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void addBook(String title, int qty) {
        lock.writeLock().lock();
        try {
            int current = stock.getOrDefault(title, 0);
            stock.put(title, current + qty);
            System.out.println(
                Thread.currentThread().getName() +
                    " added " +
                    qty +
                    " copies of " +
                    title +
                    ". New stock: " +
                    stock.get(title)
            );
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void borrow(String title, int qty) {
        lock.writeLock().lock();
        try {
            int current = stock.getOrDefault(title, 0);
            if (current >= qty) {
                stock.put(title, current - qty);
                System.out.println(
                    Thread.currentThread().getName() +
                        " borrowed " +
                        qty +
                        " copies of " +
                        title +
                        ". Remaining stock: " +
                        stock.get(title)
                );
            } else {
                System.out.println(
                    Thread.currentThread().getName() +
                        " failed to borrow " +
                        qty +
                        " copies of " +
                        title +
                        ". Available stock: " +
                        current
                );
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getStock(String title) {
        lock.readLock().lock();
        try {
            int current = stock.getOrDefault(title, 0);
            System.out.println(
                Thread.currentThread().getName() +
                    " checked stock of " +
                    title +
                    ": " +
                    current
            );
            return current;
        } finally {
            lock.readLock().unlock();
        }
    }
}
