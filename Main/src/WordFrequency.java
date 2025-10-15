import java.util.*;
public class WordFrequency {
    private ArrayList<String> words;
    private HashMap<String, Integer> frequencyMap;
    public WordFrequency(ArrayList<String> words) {
        this.words = words;
        this.frequencyMap = new HashMap<>();
        calculateFrequencies();
    }
    private void calculateFrequencies() {
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
    }
    public List<Map.Entry<String, Integer>> getRankedWords() {
        List<Map.Entry<String, Integer>> rankedList = new ArrayList<>(frequencyMap.entrySet());
        rankedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        return rankedList;
    }
    public void printTopWords(int n) {
        System.out.println("\n=== Word Frequency Ranking ===");
        List<Map.Entry<String, Integer>> rankedList = getRankedWords();
        for (int i = 0; i < Math.min(n, rankedList.size()); i++) {
            Map.Entry<String, Integer> entry = rankedList.get(i);
            System.out.printf("%-15s : %d%n", entry.getKey(), entry.getValue());
        }
    }
}
