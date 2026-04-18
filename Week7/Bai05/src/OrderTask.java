import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderTask implements Callable<Boolean> {

    private final String id;
    private final long processMs;
    private final List<String> logs;
    private final AtomicInteger successCount;

    public OrderTask(
        String id,
        long processMs,
        List<String> logs,
        AtomicInteger successCount
    ) {
        this.id = id;
        this.processMs = processMs;
        this.logs = logs;
        this.successCount = successCount;
    }

    @Override
    public Boolean call() {
        System.out.println("Start " + id);

        try {
            Thread.sleep(processMs);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            synchronized (logs) {
                logs.add("FAIL " + id);
            }
            return false;
        }

        boolean success = processMs <= 1500;

        synchronized (logs) {
            logs.add((success ? "DONE " : "FAIL ") + id);
        }

        if (success) {
            successCount.incrementAndGet();
        }

        return success;
    }
}
