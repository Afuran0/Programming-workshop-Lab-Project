import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class Main{

    public static void main(String[] args) throws IOException {

        //String path = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\stopwords.txt";
        //String path = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\article1.txt";

        Proccessor p1 = new Proccessor("C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\Main\\stopwords.txt");
        p1.printArticle();


    }
}