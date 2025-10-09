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
    }

// Print out the current article list
public void printArticle() {
    for (String j : article) {
        System.out.printf(j + " ");
    }
}

public ArrayList<String> getArticleWords() {
    return article;
}

    // Test function to print stopwords
    public void printStopWords() {
        for (String k : stopwords) {
            System.out.println(k);
        }
    }
}
