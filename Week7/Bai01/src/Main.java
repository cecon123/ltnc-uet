public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Task-1", 2000);
        Task task2 = new Task("Task-2", 3000);

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted");
        }

        System.out.println("All tasks done.");
    }
}