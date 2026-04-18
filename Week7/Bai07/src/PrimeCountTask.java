import java.util.concurrent.Callable;

public class PrimeCountTask implements Callable<Integer> {

    private final int[] arr;

    public PrimeCountTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    public Integer call() {
        int count = 0;
        for (int num : arr) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
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
