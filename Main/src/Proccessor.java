import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

class Proccessor {
    private ArrayList<String> article;
    private String file;

    public Proccessor(String file) throws IOException{
        String path = file;
        article = new ArrayList<>();
        File text = new File(path);
        Scanner sc = new Scanner(text);

        int i = 0;
        while (sc.hasNextLine()) {
            article.add(sc.nextLine());
            i++;
        }
    }

    public void printArticle(){
        for (String j : article) {
            System.out.println(j);
        }
    }
}
