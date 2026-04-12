import java.util.Arrays;

public class MainAdapter {

    public static void main(String[] args) {
        int[] arr = { 5, 2, 9, 1, 7 };

        Sorter sorter = new SorterAdapter();
        int[] sorted = sorter.sort(arr);

        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));
        System.out.println("Mảng sau sắp xếp: " + Arrays.toString(sorted));
    }
}
