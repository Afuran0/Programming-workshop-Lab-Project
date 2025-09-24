import java.util.Scanner;
import java.io.*;
public class Main{

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\stopwords.txt";
        File text = new File(path);

        Scanner sc = new Scanner(text);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());

        }

    }
}