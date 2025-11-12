import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{

    //Main class that will handle user inputs and articles to put into other classes
    public static void main(String[] args) throws IOException {

        boolean running = true;
        int choice = 0;
        int num;

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

        Scanner sc = new Scanner(System.in);
        while (running){
            System.out.println("\n\nWelcome to the File Manager");
            System.out.println("--------------------------------");
            System.out.print("1. Article Statistics \n2. Word Frequencies \n3. Article Attitudes\n4. Exit\n");
            System.out.println("Enter Your choice: ");

            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Which Articles Stats Do You Want: ");
                    num = sc.nextInt();
                    articleList.get(num - 1).statistics(true, false);
                    break;
                case 2:
                    System.out.println("Which Articles Frequencies Do You Want: ");
                    num = sc.nextInt();
                    articleList.get(num - 1).statistics(false, true);
                    break;
                case 3:
                    AC.articleAttitude();
                    break;
                case 4:
                    System.out.println("Exiting.");
                    running = false;
                default:
                    break;
            }
        }

    }
}