import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("n must be greater than 0.");
            scanner.close();
            return;
        }

        int[] arr = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int k = 4;
        int chunkSize = (n + k - 1) / k;

        ExecutorService executorService = Executors.newFixedThreadPool(k);
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < n; i += chunkSize) {
            int start = i;
            int end = Math.min(i + chunkSize, n);
            futures.add(executorService.submit(new SumTask(arr, start, end)));
        }

        int totalSum = 0;

        try {
            for (Future<Integer> future : futures) {
                totalSum += future.get();
            }
            System.out.println("Total sum: " + totalSum);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("The main thread was interrupted.");
        } catch (ExecutionException e) {
            System.out.println("An error occurred while computing the sum.");
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
    }
}
