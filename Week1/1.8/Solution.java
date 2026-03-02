public class Solution {
    public boolean isPalindrome(int n) {
        if (n < 0) {
            return false;
        }
        int t = n;
        int rev = 0;
        while (n != 0) {
            int pop = n % 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return false;
            }
            rev = rev * 10 + pop;
            n /= 10;
        }
        return t == rev;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121)); // true
        System.out.println(solution.isPalindrome(-121)); // false
        System.out.println(solution.isPalindrome(10)); // false
        System.out.println(solution.isPalindrome(12321)); // true
        System.out.println(solution.isPalindrome(123)); // false
        System.out.println(solution.isPalindrome(0)); // true
        System.out.println(solution.isPalindrome(1230)); // false
    }
}