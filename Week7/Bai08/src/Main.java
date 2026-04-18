import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorCompletionService;
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

        ExecutorService stage1Pool = Executors.newFixedThreadPool(
            Math.max(1, n)
        );
        ExecutorService stage2Pool = Executors.newFixedThreadPool(
            Math.max(1, n)
        );

        ExecutorCompletionService<Stage1Result> stage1Completion =
            new ExecutorCompletionService<>(stage1Pool);
        ExecutorCompletionService<Stage2Result> stage2Completion =
            new ExecutorCompletionService<>(stage2Pool);

        for (int i = 0; i < arrays.size(); i++) {
            final int index = i;
            final int[] arr = arrays.get(i);

            stage1Completion.submit(() -> {
                List<Integer> primes = new Stage1Task(arr).call();
                return new Stage1Result(index, primes);
            });
        }

        int total = 0;

        try {
            for (int i = 0; i < n; i++) {
                Future<Stage1Result> future = stage1Completion.take();
                Stage1Result stage1Result = future.get();

                System.out.println(
                    "Stage 1 - Array " +
                        stage1Result.index +
                        ": " +
                        stage1Result.primes
                );

                final int index = stage1Result.index;
                final List<Integer> primes = stage1Result.primes;

                stage2Completion.submit(() -> {
                    int sum = new Stage2Task(primes).call();
                    boolean evenCount = primes.size() % 2 == 0;
                    return new Stage2Result(index, sum, evenCount);
                });
            }

            for (int i = 0; i < n; i++) {
                Future<Stage2Result> future = stage2Completion.take();
                Stage2Result stage2Result = future.get();

                if (stage2Result.evenCount) {
                    System.out.println(
                        "Stage 2 - Array " +
                            stage2Result.index +
                            ": sum of squares = " +
                            stage2Result.sum
                    );
                } else {
                    System.out.println(
                        "Stage 2 - Array " +
                            stage2Result.index +
                            ": sum of cubes = " +
                            stage2Result.sum
                    );
                }

                total += stage2Result.sum;
            }

            System.out.println("Total = " + total);
        } catch (Exception e) {
            System.out.println("An error occurred while processing arrays.");
        } finally {
            stage1Pool.shutdown();
            stage2Pool.shutdown();
            scanner.close();
        }
    }

    private static class Stage1Result {

        int index;
        List<Integer> primes;

        Stage1Result(int index, List<Integer> primes) {
            this.index = index;
            this.primes = primes;
        }
    }

    private static class Stage2Result {

        int index;
        int sum;
        boolean evenCount;

        Stage2Result(int index, int sum, boolean evenCount) {
            this.index = index;
            this.sum = sum;
            this.evenCount = evenCount;
        }
    }
}
