public class Main {

    public static void main(String[] args) {
        BookStore store = new BookStore();

        store.addBook("Java", 10);
        store.addBook("OOP", 5);
        store.addBook("Database", 7);

        Thread reader1 = new Thread(
            () -> {
                for (int i = 0; i < 3; i++) {
                    store.getStock("Java");
                    sleep(300);
                }
            },
            "Reader-1"
        );

        Thread reader2 = new Thread(
            () -> {
                for (int i = 0; i < 3; i++) {
                    store.getStock("OOP");
                    sleep(300);
                }
            },
            "Reader-2"
        );

        Thread reader3 = new Thread(
            () -> {
                for (int i = 0; i < 3; i++) {
                    store.getStock("Database");
                    sleep(300);
                }
            },
            "Reader-3"
        );

        Thread writer1 = new Thread(
            () -> {
                store.borrow("Java", 3);
                sleep(500);
                store.borrow("OOP", 2);
            },
            "Writer-1"
        );

        Thread writer2 = new Thread(
            () -> {
                sleep(200);
                store.addBook("Database", 4);
                sleep(500);
                store.addBook("Java", 2);
            },
            "Writer-2"
        );

        reader1.start();
        reader2.start();
        reader3.start();
        writer1.start();
        writer2.start();

        try {
            reader1.join();
            reader2.join();
            reader3.join();
            writer1.join();
            writer2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted");
        }

        System.out.println("Final stock:");
        System.out.println("Java: " + store.getStock("Java"));
        System.out.println("OOP: " + store.getStock("OOP"));
        System.out.println("Database: " + store.getStock("Database"));
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
