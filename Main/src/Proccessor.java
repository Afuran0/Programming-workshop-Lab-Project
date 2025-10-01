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
            article.add(sc.nextLine());
            i++;
        }


        //turns stopwords into arrayList
        File stop = new File(stopFile);
        Scanner s = new Scanner(stop);
        i = 0;
        while (sc.hasNextLine()) {
            stopwords.add(s.nextLine());
            i++;
        }


    }

    public void printArticle(){
        for (String j : article) {
            System.out.println(j);
        }
    }

    public void removeStopWords(){
        for(String i: article){
            for (String j: stopwords){
                if (i == j){
                    System.out.println(i);
                }
            }
        }
    }
}
