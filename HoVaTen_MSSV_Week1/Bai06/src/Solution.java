public class Solution {

    public boolean isPrime(int n) {

        if (n <= 1) {
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

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPrime(1));
        System.out.println(solution.isPrime(0));
        System.out.println(solution.isPrime(-10));
        System.out.println(solution.isPrime(17));
        System.out.println(solution.isPrime(15));
        System.out.println(solution.isPrime(Integer.MAX_VALUE));
    }
}