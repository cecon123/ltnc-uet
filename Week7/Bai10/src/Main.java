public class Main {

    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread thread = new Thread(worker);

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted");
        }

        worker.stop();

        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted while waiting");
        }
    }
}
