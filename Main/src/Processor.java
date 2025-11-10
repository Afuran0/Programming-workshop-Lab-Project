import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class Processor {
    private ArrayList<String> article;
    private ArrayList<String> stopwords;
    private HashMap<String, Double> wordScores;
    private String STOPFILENAME = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\stopwords.txt";
    private String SCOREFILE = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\lexicon_scores.txt";
    private String file;
    private String articleName;
    private int wordCount;
    private int uniqueWordCount;
    private ArrayList<String> top10WordFreq;
    private ArrayList<Integer> top10Words;

    //Constructor
    public Processor(String articleName, String file) throws IOException {
        this.articleName = articleName;
        this.file = file;
        article = new ArrayList<>();
        stopwords = new ArrayList<>();
        wordScores = new HashMap<>();


        //From the FiletoList Class it takes the articleList to use here
        FileToList fileReader = new FileToList();
        article = fileReader.readFileToList(file);
        stopwords = fileReader.readFileToList(STOPFILENAME);
        wordScores = fileReader.readFileToHashMap(SCOREFILE);

        //Removes stop words from article
        Iterator<String> iterator = article.iterator();
        while (iterator.hasNext()) {
            String articleWord = iterator.next();
            if (stopwords.contains(articleWord)) {
                iterator.remove();
            }
        }

        statistics(article);
    }



    //Method in processor that outputs word-count, unique word-count, and lists by frequency
    public void statistics (ArrayList<String> wordsInArticle){
        ArrayList<String> uniqueWords = new ArrayList<>();
        ArrayList<Integer> wordCounts = new ArrayList<>();

        // Loop through each word and count its frequency
        for(String word : wordsInArticle) {
            int index = uniqueWords.indexOf(word);
            if (index != -1) {
                wordCounts.set(index, wordCounts.get(index) + 1);
            } else {
                uniqueWords.add(word);
                wordCounts.add(1);
            }
        }
        // Sorts words by frequencies
        for (int i = 0; i < wordCounts.size() - 1; i++) {
            for (int j = 0; j < wordCounts.size() - i - 1; j++) {
                if (wordCounts.get(j) < wordCounts.get(j + 1)) {
                    int tempCount = wordCounts.get(j);
                    wordCounts.set(j, wordCounts.get(j + 1));
                    wordCounts.set(j + 1, tempCount);

                    String tempWord = uniqueWords.get(j);
                    uniqueWords.set(j, uniqueWords.get(j + 1));
                    uniqueWords.set(j + 1, tempWord);
                }
            }
        }

        //Prints the count of words in an article
        int wordCount = article.size();
        this.wordCount = wordCount;
        System.out.println(articleName + ": Word count: " + wordCount);

        //Prints the amount of uniqueWords
        int uniqueWordCount = uniqueWords.size();
        this.uniqueWordCount = uniqueWordCount;
        System.out.println(articleName + ": Count of unique words: " + uniqueWordCount);

        // Prints words ranked by frequency
        System.out.println(articleName + ": Frequency of each word: ");
        this.top10WordFreq = new ArrayList<>();
        this.top10Words = new ArrayList<>();
        for (int i = 0; i < uniqueWords.size(); i++) {
            System.out.println(uniqueWords.get(i) + " -- " + wordCounts.get(i));
            if (i < 10){
                top10WordFreq.add(uniqueWords.get(i));
                top10Words.add(wordCounts.get(i));
            }
        }
    }

    //uses the hashmap of the lexicon scores to assign mood scores to the article
    public int articleScore(){
        int score = 0;
        for (String word: article){
            if (wordScores.containsKey(word)){
                score += wordScores.get(word);
            }
        }
        return score;
    }


    // Print out the current article list
    public void printArticle() {
        int i = 0;
        for (String j : article) {
            System.out.printf(j + " ");
            i++;
            if (i == 10){
                System.out.printf("\n");
                i = 0;
            }
        }
    }

    // Test function to print stopwords
    public void printStopWords() {
        for (String k : stopwords) {
            System.out.println(k);
        }
    }


    //Getter methods
    public int getWordCount(){
        return wordCount;
    }

    public int getUniqueWordCount(){
        return uniqueWordCount;
    }

    public ArrayList<String> get10Freq(){
        return top10WordFreq;
    }

    public ArrayList<Integer> get10Words(){
        return top10Words;
    }
}

