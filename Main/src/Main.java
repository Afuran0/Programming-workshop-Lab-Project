import java.io.*;
import java.util.ArrayList;

public class Main{

    //Main class that will handle user inputs and articles to put into other classes
    public static void main(String[] args) throws IOException {

        ArrayList<Processor> articleList = new ArrayList<>();
        ArrayList<String> articleFileNames = new ArrayList<>();

        //File names
        String filename1 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\article1.txt";
        String filename2 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\article2.txt";
        String filename3 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\article3.txt";

        //Adds filenames to list
        articleFileNames.add(filename1);
        articleFileNames.add(filename2);
        articleFileNames.add(filename3);

        //Creates a list of Processor objects
        for (int i = 0; i < 3; i++){
            articleList.add(new Processor(("Article" + i), articleFileNames.get(i)));
        }

        //Objects and Inputs
        ArticleComparison AC = new ArticleComparison(articleList);
        AC.repeatedWord();
    }
}