import java.util.List;
import java.util.concurrent.Callable;

public class Stage2Task implements Callable<Integer> {

    private final List<Integer> primes;

    public Stage2Task(List<Integer> primes) {
        this.primes = primes;
    }

    @Override
    public Integer call() {
        int sum = 0;

        if (primes.size() % 2 == 0) {
            for (int num : primes) {
                sum += num * num;
            }
        } else {
            for (int num : primes) {
                sum += num * num * num;
            }
        }

        return sum;
    }
}
