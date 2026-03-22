public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("Tuổi", 20);
        Pair<String, String> pair2 = new Pair<>("Mã SV", "SV001");
        Pair<Integer, Double> pair3 = new Pair<>(105, 21.5);

        System.out.println(pair1);
        System.out.println(pair2);
        System.out.println(pair3);

        // pair1.setValue("abc");
    }
}
