import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

class Processor {
    private ArrayList<String> article;
    private ArrayList<String> stopwords;
    private String STOPFILENAME = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\stopwords.txt";
    private String file;

    public Processor(String file) throws IOException {
        this.file = file;
        article = new ArrayList<>();
        stopwords = new ArrayList<>();

        // from the FiletoList class it takes the articleList to use here
        FileToList fileReader = new FileToList();
        article = fileReader.readFileToList(file);
        stopwords = fileReader.readFileToList(STOPFILENAME);

        // removes stop words from article
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
        System.out.println("Word count: " + wordCount);

        //Prints the amount of uniqueWords
        int uniqueWordCount = uniqueWords.size();
        System.out.println("Count of unique words: " + uniqueWordCount);

        // Prints words ranked by frequency
        System.out.println("Frequency of each word: ");
        for (int i = 0; i < uniqueWords.size(); i++) {
            System.out.println(uniqueWords.get(i) + " -- " + wordCounts.get(i));
        }
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
}
