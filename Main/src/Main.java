import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
    
        String directoryPath = ".";  

        List<String> articleFiles = Arrays.asList("article1.txt", "article2.txt", "article3.txt");

        // stopwords
        Set<String> stopwords = Files.lines(Paths.get(directoryPath, "stopwords.txt"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toSet());

        // lexicon scores
        Map<String, Double> lexiconScores = loadLexiconScores(Paths.get(directoryPath, "lexicon_scores.txt"));

        // vocabulary richness for each article
        Map<String, Double> vocabRichness = new LinkedHashMap<>();

        System.out.println("\n───────────────────────────────────────────────────────────────");
        for (String fileName : articleFiles) {
            Path filePath = Paths.get(directoryPath, fileName);
            String content = Files.readString(filePath).toLowerCase();

            // tokenize
            List<String> words = Arrays.stream(content.split("\\W+"))
                    .filter(w -> !w.isEmpty() && !stopwords.contains(w))
                    .collect(Collectors.toList());

            // word frequency 
            Map<String, Long> freqMap = words.stream()
                    .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

            int totalWords = words.size();
            int uniqueWords = freqMap.size();

            // lexicon-based richness
            double lexiconSum = words.stream()
                    .mapToDouble(w -> lexiconScores.getOrDefault(w, 1.0))
                    .sum();
            double richnessScore = uniqueWords == 0 ? 0 : lexiconSum / uniqueWords;

            vocabRichness.put(fileName, richnessScore);

            // top 10 frequent words
            List<Map.Entry<String, Long>> topWords = freqMap.entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(10)
                    .toList();

            System.out.println(formatTitle(fileName));
            System.out.println("Total words (after stopword removal): " + totalWords);
            System.out.println("Unique words: " + uniqueWords);
            System.out.printf("Vocabulary richness score: %.2f%n", richnessScore);
            System.out.println("Top 10 most frequent words:");
            System.out.println("-----------------------------------------------");
            for (Map.Entry<String, Long> e : topWords) {
                System.out.printf("%-15s %d occurrences%n", e.getKey(), e.getValue());
            }
            System.out.println("───────────────────────────────────────────────");
        }

        //  richest vocabulary article
        String richestArticle = vocabRichness.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");

        double richestScore = vocabRichness.getOrDefault(richestArticle, 0.0);

        System.out.println("\nAll articles processed successfully!");
        System.out.println("\nArticle with the richest vocabulary:");
        System.out.printf("%s (Average Lexicon Score: %.2f)%n",
                formatTitle(richestArticle), richestScore);
    }

    private static Map<String, Double> loadLexiconScores(Path filePath) throws IOException {
        Map<String, Double> lexicon = new HashMap<>();
        if (!Files.exists(filePath)) return lexicon;

        for (String line : Files.readAllLines(filePath)) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length >= 2) {
                try {
                    lexicon.put(parts[0].toLowerCase(), Double.parseDouble(parts[1]));
                } catch (NumberFormatException ignored) {}
            }
        }
        return lexicon;
    }

    private static String formatTitle(String fileName) {
        return "Article " + fileName.replaceAll("\\D+", "");
    }
}
