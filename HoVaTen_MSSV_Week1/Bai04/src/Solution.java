public class Solution {

    public long fibonacci(long n) {

        if (n < 0) {
            return -1;
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        long f0 = 0;
        long f1 = 1;
        long fn = 0;

        for (long i = 2; i <= n; i++) {

            if (Long.MAX_VALUE - f1 < f0) {
                return Long.MAX_VALUE;
            }
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.fibonacci(-5));
        System.out.println(solution.fibonacci(0));
        System.out.println(solution.fibonacci(1));
        System.out.println(solution.fibonacci(10));
        System.out.println(solution.fibonacci(50));
        System.out.println(solution.fibonacci(92));
        System.out.println(solution.fibonacci(93));
        System.out.println(solution.fibonacci(100));
    }
}