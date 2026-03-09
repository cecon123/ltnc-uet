public class Solution {

    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.gcd(48, 18));
        System.out.println(solution.gcd(56, 98));
        System.out.println(solution.gcd(101, 10));
        System.out.println(solution.gcd(0, 5));
        System.out.println(solution.gcd(5, 0));
        System.out.println(solution.gcd(1, 10));
        System.out.println(solution.gcd(-48, 18));
    }
}