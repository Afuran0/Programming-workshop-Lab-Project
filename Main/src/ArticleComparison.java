import java.util.*;
import java.util.ArrayList;

class ArticleComparison {
    private ArrayList<Processor> articleList;

    //Constructor
    public ArticleComparison (ArrayList<Processor> articleList){
        this.articleList = articleList;
    }

    //Prints the article that has the highest amount of unique words
    public void richestVocab(){
        Processor highest = articleList.get(0);
        for (Processor article: articleList){
            int temp = article.getUniqueWordCount();
            if (temp > highest.getUniqueWordCount()) {
                highest = article;
            }
        }
        System.out.println("Article " + (articleList.indexOf(highest) + 1) + " has the richest vocab with " + highest.getUniqueWordCount() + " unique words");
    }

    //Prints the Top 10 most repeated words of each article and their frequency
    public void repeatedWord () {
        int i = 0;
        for (Processor article: articleList){
            for (String s : article.get10Freq()){
                System.out.println("Article " + (articleList.indexOf(article) + 1) + " " + s + " - " + article.get10Words().get(i));
                i++;
            }
            i = 0;
        }
    }
}
