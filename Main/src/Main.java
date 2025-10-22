import java.io.*;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args) throws IOException {


        ArrayList<Processor> articleList = new ArrayList<>();
        ArrayList<String> articleFileNames = new ArrayList<>();

        String filename1 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\article1.txt";
        String filename2 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\article1.txt";
        String filename3 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\article1.txt";

        articleFileNames.add(filename1);
        articleFileNames.add(filename2);
        articleFileNames.add(filename3);

        for (int i = 0; i < 3; i++){
            articleList.add(new Processor(("Article" + i), articleFileNames.get(i)));
        }
        ArticleComparison AC = new ArticleComparison(articleList);
    }
}