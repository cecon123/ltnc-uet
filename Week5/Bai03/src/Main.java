import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        String text =
            "Java is great. Java is powerful, and Java is popular! " +
            "Programming in Java is fun. Learning Java helps students program better.";
        text = text.toLowerCase();
        text = text.replaceAll("[^a-zA-Z\\s]", "");
        String[] words = text.split("\\s+");
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Find the word that appears most often.
        String mostFrequentWord = "";
        int maxCount = 0;
        for (Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequentWord = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        System.out.println(
            "Most frequent word: " +
                mostFrequentWord +
                " (count: " +
                maxCount +
                ")"
        );

        // List the words that appear exactly once (Unique words).
        System.out.println("Unique words:");
        for (Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}
