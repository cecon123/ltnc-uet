
public class Main {

    public static double calculateDiscount(double price, String memberType) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be >= 0");
        }

        if (memberType.equals("GUEST")) {
            return 0;
        }

        if (memberType.equals("MEMBER")) {
            if (price < 100) {
                return price * 0.05;
            }

            return price * 0.10;
        }

        if (memberType.equals("VIP")) {
            if (price < 100) {
                return price * 0.15;
            }

            return price * 0.20;
        }

        throw new IllegalArgumentException("Invalid member type: " + memberType);
    }

    private static void runTest(String testId, double price, String memberType, String expected) {
        try {
            double actual = calculateDiscount(price, memberType);
            System.out.println(testId
                    + " | price = " + price
                    + " | memberType = " + memberType
                    + " | expected = " + expected
                    + " | actual = " + actual);
        } catch (IllegalArgumentException e) {
            System.out.println(testId
                    + " | price = " + price
                    + " | memberType = " + memberType
                    + " | expected = " + expected
                    + " | actual = IllegalArgumentException");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== EQUIVALENCE PARTITIONING TEST CASES ===");
        runTest("TC01", -10, "GUEST", "IllegalArgumentException");
        runTest("TC02", 50, "GUEST", "0.0");
        runTest("TC03", 50, "MEMBER", "2.5");
        runTest("TC04", 150, "MEMBER", "15.0");
        runTest("TC05", 50, "VIP", "7.5");
        runTest("TC06", 150, "VIP", "30.0");
        runTest("TC07", 50, "ADMIN", "IllegalArgumentException");

        System.out.println();
        System.out.println("=== BOUNDARY VALUE ANALYSIS TEST CASES ===");
        runTest("BVA01", -1, "MEMBER", "IllegalArgumentException");
        runTest("BVA02", 0, "MEMBER", "0.0");
        runTest("BVA03", 1, "MEMBER", "0.05");
        runTest("BVA04", 99, "MEMBER", "4.95");
        runTest("BVA05", 100, "MEMBER", "10.0");
        runTest("BVA06", 101, "MEMBER", "10.1");

        System.out.println();
        System.out.println("=== 2-WAY COMBINATORIAL TEST CASES ===");
        runTest("2W01", -1, "GUEST", "IllegalArgumentException");
        runTest("2W02", -1, "MEMBER", "IllegalArgumentException");
        runTest("2W03", -1, "VIP", "IllegalArgumentException");
        runTest("2W04", -1, "ADMIN", "IllegalArgumentException");

        runTest("2W05", 50, "GUEST", "0.0");
        runTest("2W06", 50, "MEMBER", "2.5");
        runTest("2W07", 50, "VIP", "7.5");
        runTest("2W08", 50, "ADMIN", "IllegalArgumentException");

        runTest("2W09", 100, "GUEST", "0.0");
        runTest("2W10", 100, "MEMBER", "10.0");
        runTest("2W11", 100, "VIP", "20.0");
        runTest("2W12", 100, "ADMIN", "IllegalArgumentException");

        runTest("2W13", 150, "GUEST", "0.0");
        runTest("2W14", 150, "MEMBER", "15.0");
        runTest("2W15", 150, "VIP", "30.0");
        runTest("2W16", 150, "ADMIN", "IllegalArgumentException");
    }
}
