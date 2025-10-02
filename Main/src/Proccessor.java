import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

class Proccessor {
    private ArrayList<String> article;
    private ArrayList<String> stopwords;
    private String stopFile = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\stopwords.txt";
    private String file;

    public Proccessor(String file) throws IOException{
        this.file = file;
        article = new ArrayList<>();
        stopwords = new ArrayList<>();

        //turns file into arrayList
        File text = new File(file);
        Scanner sc = new Scanner(text);
        int i = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] words = line.split("\\s+");
            for (String word : words) {
                article.add(word.toLowerCase());
            }
        }
        sc.close();


        //turns stopwords into arrayList
        File stop = new File(stopFile);
        Scanner s = new Scanner(stop);

        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] words = line.split("\\s+");
            for (String word : words) {
                stopwords.add(word.toLowerCase());
            }
        }
        s.close();

        int index = 0;
        while(index < article.size()){
            String articleWord = article.get(index);
            if(articleWord.equals(stopwords.get(1))){
                System.out.println(articleWord);

            }
            index ++;
        }

        /*
        //this works but idk if he wants it done this way
        for (String articleWord : article) {
            if (stopwords.contains(articleWord)) {
                System.out.println(articleWord);
            }

        }

*/



    }

    public void printArticle(){
        for (String j : article) {
            System.out.println(j);
        }
    }
    public void printStopwords(){
        for (String k : stopwords) {
            System.out.println(k);
        }
    }

}
