import java.util.HashMap;
import java.util.Map;

public class WordCounter {

    private HashMap<String, Integer> wordMap;

    public WordCounter() {
        this.wordMap = new HashMap<>();
    }

    public void analyze(String text) {
        text = text.toLowerCase();
        text = text.replaceAll("[^a-zA-Z\\s]", "");

        String[] words = text.split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }
    }

    public void displayResult() {
        System.out.println("Frequency of occurrence of words:");
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        // Get the most frequent word
        String mostFrequent = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequent = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        System.out.println(
            "Most frequent word: " + mostFrequent + " (" + maxCount + " times)"
        );
    }
}
