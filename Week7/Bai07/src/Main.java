import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<int[]> arrays = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int[] arr = new int[m];

            for (int j = 0; j < m; j++) {
                arr[j] = scanner.nextInt();
            }

            arrays.add(arr);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(
            Math.max(1, n)
        );
        List<Future<Integer>> futures = new ArrayList<>();

        for (int[] arr : arrays) {
            futures.add(executorService.submit(new PrimeCountTask(arr)));
        }

        List<Integer> results = new ArrayList<>();
        int maxCount = -1;

        try {
            for (int i = 0; i < futures.size(); i++) {
                int count = futures.get(i).get();
                results.add(count);
                System.out.println("Array " + i + ": " + count);

                if (count > maxCount) {
                    maxCount = count;
                }
            }

            List<Integer> maxIndexes = new ArrayList<>();
            for (int i = 0; i < results.size(); i++) {
                if (results.get(i) == maxCount) {
                    maxIndexes.add(i);
                }
            }

            if (maxIndexes.size() == 1) {
                System.out.println(
                    "Most primes: Array " +
                        maxIndexes.get(0) +
                        " with " +
                        maxCount +
                        " primes"
                );
            } else {
                System.out.print("Most primes: ");
                for (int i = 0; i < maxIndexes.size(); i++) {
                    if (i > 0) {
                        System.out.print(", ");
                    }
                    System.out.print("Array " + maxIndexes.get(i));
                }
                System.out.println(" with " + maxCount + " primes");
            }
        } catch (Exception e) {
            System.out.println("An error occurred while processing arrays.");
        } finally {
            executorService.shutdown();
            scanner.close();
        }
    }
}
