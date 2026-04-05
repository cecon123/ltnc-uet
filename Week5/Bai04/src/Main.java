public class Main {

    public static void main(String[] args) {
        String text =
            "Hello world. This is a java program. Hello java, hello world.";
        WordCounter wc = new WordCounter();
        wc.analyze(text);
        wc.displayResult();
    }
}
