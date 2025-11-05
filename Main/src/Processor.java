import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Processor {
    private ArrayList<String> article;
    private ArrayList<String> stopwords;
    private String STOPFILENAME = "C:\\Users\\danny\\OneDrive\\Desktop\\bluejprojects\\labproject\\stopwords.txt";
    private String LEXICONFILE = "C:\\Users\\danny\\OneDrive\\Desktop\\bluejprojects\\labproject\\lexicon_scores.txt";
    private String file;
    private String articleName;
    private double vocabRichness;

    public Processor(String articleName, String file) throws IOException {
        this.articleName = articleName;
        this.file = file;
        this.article = new ArrayList<>();
        this.stopwords = new ArrayList<>();

        FileToList fileReader = new FileToList();
        article = fileReader.readFileToList(file);
        stopwords = fileReader.readFileToList(STOPFILENAME);

        // Remove stopwords
        article.removeIf(stopwords::contains);

        // Compute richness
        this.vocabRichness = computeVocabularyRichness(article);

        // Print summary
        printTopThree(article);
    }

    private void printTopThree(ArrayList<String> wordsInArticle) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : wordsInArticle) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sorted = freqMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());

        int totalWords = wordsInArticle.size();
        int uniqueWords = freqMap.size();

        System.out.println("───────────────────────────────────────────────");
        System.out.println("📄 " + articleName);
        System.out.println("Total words (after stopword removal): " + totalWords);
        System.out.println("Unique words: " + uniqueWords);
        System.out.printf("Vocabulary richness score: %.2f%n", vocabRichness);
        System.out.println("Top 3 most frequent words:");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < Math.min(3, sorted.size()); i++) {
            Map.Entry<String, Integer> entry = sorted.get(i);
            System.out.printf("%-15s → %d occurrences%n", entry.getKey(), entry.getValue());
        }
        System.out.println("───────────────────────────────────────────────\n");
    }

    private double computeVocabularyRichness(ArrayList<String> words) throws IOException {
        Map<String, Double> lexiconScores = new HashMap<>();

        try (Scanner sc = new Scanner(new File(LEXICONFILE))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split("\\s+");
                    if (parts.length == 2) {
                        String word = parts[0].toLowerCase();
                        try {
                            double score = Double.parseDouble(parts[1]);
                            lexiconScores.put(word, score);
                        } catch (NumberFormatException e) {
                            // skip invalid entries
                        }
                    }
                }
            }
        }

        double totalScore = 0.0;
        int count = 0;
        for (String w : words) {
            if (lexiconScores.containsKey(w)) {
                totalScore += lexiconScores.get(w);
                count++;
            }
        }
        return count == 0 ? 0.0 : totalScore / count; // average score
    }

    public double getVocabRichness() {
        return vocabRichness;
    }

    public String getArticleName() {
        return articleName;
    }
}
