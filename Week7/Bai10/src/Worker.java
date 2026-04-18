public class Worker implements Runnable {

    // volatile ensures that changes made by one thread
    // are immediately visible to other threads.
    // Without volatile, the worker thread may keep using
    // a cached value of running and never stop.
    private volatile boolean running = true;

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            System.out.println("Working...");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Worker thread was interrupted");
                break;
            }
        }
        System.out.println("Worker stopped.");
    }
}
