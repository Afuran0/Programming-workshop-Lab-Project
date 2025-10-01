import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class Main{

    public static void main(String[] args) throws IOException {

        //String path = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\stopwords.txt";
        String path = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\stopwords.txt";
        File text = new File(path);

        Scanner sc = new Scanner(text);
        ArrayList<String> article;
        article = new ArrayList<>();

        int i = 0;
        while (sc.hasNextLine()) {
            article.add(sc.nextLine());
            i++;
        }
        for (String j : article) {
            System.out.println(j);
        }

    }
}