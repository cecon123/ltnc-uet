import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of orders: ");
        int m = scanner.nextInt();
        scanner.nextLine();

        List<OrderInfo> orders = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            System.out.print("Enter order id: ");
            String id = scanner.nextLine();

            System.out.print("Enter process time (ms): ");
            long processMs = scanner.nextLong();
            scanner.nextLine();

            orders.add(new OrderInfo(id, processMs));
        }

        List<String> logs = Collections.synchronizedList(new ArrayList<>());
        AtomicInteger successCount = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<Boolean>> futures = new ArrayList<>();

        for (OrderInfo order : orders) {
            OrderTask task = new OrderTask(
                order.getId(),
                order.getProcessMs(),
                logs,
                successCount
            );
            futures.add(executorService.submit(task));
        }

        try {
            for (Future<Boolean> future : futures) {
                future.get();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread was interrupted");
        } catch (ExecutionException e) {
            System.out.println("An error occurred while processing an order");
        } finally {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
            scanner.close();
        }

        System.out.println("Success = " + successCount.get());
        System.out.println("Logs:");
        synchronized (logs) {
            for (String log : logs) {
                System.out.println(log);
            }
        }
    }
}
