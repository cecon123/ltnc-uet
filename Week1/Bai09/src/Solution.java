public class Solution {

    public int sumOfDigits(int n) {
        int sum = 0;

        while (n != 0) {
            int pop = n % 10;

            if (pop < 0) {
                pop = -pop;
            }

            sum += pop;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.sumOfDigits(123));
        System.out.println(solution.sumOfDigits(456));
        System.out.println(solution.sumOfDigits(-789));
        System.out.println(solution.sumOfDigits(0));
        System.out.println(solution.sumOfDigits(999999999));
        System.out.println(solution.sumOfDigits(-123456789));
        System.out.println(solution.sumOfDigits(1000002000));
    }
}