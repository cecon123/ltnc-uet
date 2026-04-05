public class Solution {

    public int reverse(int n) {
        int rev = 0;

        while (n != 0) {
            int pop = n % 10;
            n /= 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;

            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;

            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reverse(123));
        System.out.println(solution.reverse(-123));
        System.out.println(solution.reverse(120));
        System.out.println(solution.reverse(0));
        System.out.println(solution.reverse(123450));
        System.out.println(solution.reverse(1534236469));
    }
}