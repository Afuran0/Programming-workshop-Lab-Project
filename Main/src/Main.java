import java.util.Scanner;
import java.io.*;
public class Main{

    public static void main(String[] args){

        String path = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\words.txt";


        File wordstext = new File(path);

        Scanner sc = new Scanner(wordstext);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());

        }

    }
}