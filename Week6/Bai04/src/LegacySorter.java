import java.util.Arrays;

public class LegacySorter {
    public int[] quickSort(int[] arr) {
        int[] copy = arr.clone();
        Arrays.sort(copy);
        return copy;
    }
}