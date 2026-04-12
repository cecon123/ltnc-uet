public class Main {

    public static void main(String[] args) {
        Runnable task = () -> {
            AppConfig config = AppConfig.getInstance();
            System.out.println(
                Thread.currentThread().getName() +
                    " - hashCode: " +
                    config.hashCode()
            );
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
