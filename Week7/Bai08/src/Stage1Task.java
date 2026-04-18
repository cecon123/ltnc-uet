import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Stage1Task implements Callable<List<Integer>> {

    private final int[] arr;

    public Stage1Task(int[] arr) {
        this.arr = arr;
    }

    @Override
    public List<Integer> call() {
        List<Integer> primes = new ArrayList<>();

        for (int num : arr) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }

        return primes;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
