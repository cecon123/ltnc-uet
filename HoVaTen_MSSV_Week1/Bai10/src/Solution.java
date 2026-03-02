public class Solution {

    public int secondLargest(int[] arr) {

        if (arr == null || arr.length < 2) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > max) {
                second = max;
                max = num;
            } else if (num > second && num != max) {
                second = num;
            }
        }

        if (second == Integer.MIN_VALUE) {
            return -1;
        }

        return second;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = { 1, 5, 3, 9, 7 };
        int[] arr2 = { 4, 4, 4, 4 };
        int[] arr3 = { 10 };
        int[] arr4 = { 2, 8, 8, 5 };

        System.out.println(sol.secondLargest(arr1));
        System.out.println(sol.secondLargest(arr2));
        System.out.println(sol.secondLargest(arr3));
        System.out.println(sol.secondLargest(arr4));
    }
}