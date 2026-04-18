import java.util.concurrent.Callable;

public class SecondLargestTask implements Callable<Integer> {

    private final int[] arr;

    public SecondLargestTask(int[] arr) {
        this.arr = arr;
    }

    @Override
    public Integer call() {
        if (arr == null || arr.length < 2) {
            return null;
        }

        Integer largest = null;
        Integer secondLargest = null;

        for (int num : arr) {
            if (largest == null || num > largest) {
                if (largest != null && num != largest) {
                    secondLargest = largest;
                }
                largest = num;
            } else if (
                num != largest && (secondLargest == null || num > secondLargest)
            ) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}
