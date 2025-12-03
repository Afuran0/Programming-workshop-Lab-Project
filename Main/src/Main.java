import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Main class that will handle user inputs and articles to put into other classes
    public static void main(String[] args) throws IOException {

        boolean running = true;
        int choice = 0;
        int choice1 = 0;
        int num;
        String fileAnswer = " ";
        int topicAnswer = 0;

        ArrayList<Processor> topic1_articleList = new ArrayList<>();
        ArrayList<Processor> topic2_articleList = new ArrayList<>();
        ArrayList<Processor> topic3_articleList = new ArrayList<>();
        ArrayList<ArticleComparison> acList = new ArrayList<>();

        ArrayList<ArrayList<Processor>> topicList = new ArrayList<>();
        topicList.add(topic1_articleList);
        topicList.add(topic2_articleList);
        topicList.add(topic3_articleList);


        ArrayList<String> articleFileNames = new ArrayList<>();

        //File names
        String filename1 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\files\\article1.txt";
        String filename2 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\files\\article2.txt";
        String filename3 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\files\\article3.txt";

        String filename4 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\files\\Politics1.txt";
        String filename5 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\files\\Politics2.txt";
        String filename6 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\files\\Politics3.txt";

        String filename7 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\files\\Sports1.txt";
        String filename8 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\files\\Sports2.txt";
        String filename9 = "C:\\Users\\Bally\\OneDrive\\Desktop\\Programming\\JavaWorkshop\\JavaIDEA\\Programming-workshop-Lab-Project\\files\\Sports3.txt";

        //Adds filenames to list
        articleFileNames.add(filename1);
        articleFileNames.add(filename2);
        articleFileNames.add(filename3);
        articleFileNames.add(filename4);
        articleFileNames.add(filename5);
        articleFileNames.add(filename6);
        articleFileNames.add(filename7);
        articleFileNames.add(filename8);
        articleFileNames.add(filename9);

        //Creates a list of Processor objects
        for (int i = 0; i < 9; i++) {
            if (i < 3){
                topic1_articleList.add(new Processor(("Article" + (i + 1)), articleFileNames.get(i)));
            }
            else if (i < 6){
                topic2_articleList.add(new Processor(("Article" + (i + 1)), articleFileNames.get(i)));
            }
            else if (i < 9){
                topic3_articleList.add(new Processor(("Article" + (i + 1)), articleFileNames.get(i)));
            }
        }


        //Creates Comparison Classes for each of the three topics and adds them to one AC List
        ArticleComparison AC1 = new ArticleComparison(topic1_articleList);
        ArticleComparison AC2 = new ArticleComparison(topic2_articleList);
        ArticleComparison AC3 = new ArticleComparison(topic3_articleList);
        acList.add(AC1);
        acList.add(AC2);
        acList.add(AC3);


        Scanner sc = new Scanner(System.in);
        int topicChoice = 0;
        while (running) {
            System.out.println("\n\n-----------------------------------------------\n");
            System.out.println("        Welcome to the Article Manager");
            if (topicChoice != 0) {
                System.out.println("       You are currently look at topic " + topicChoice + ".");
            } else {
                System.out.println("\n------------------FileManager------------------");
                System.out.print("1. Select Topic\n2. Add File\n3. Add Topic \n");
                System.out.println("-----------------------------------------------");
                System.out.print("Enter your choice: ");
                choice1 = sc.nextInt();

                switch (choice1) {
                    case 1:
                        System.out.print("Which Topic Do You Want?: ");
                        topicChoice = sc.nextInt();
                        break;
                    case 2:
                        System.out.print("What topic do you want to add this file to?: ");
                        topicAnswer = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter the path of your file: ");
                        fileAnswer = sc.nextLine();

                        FileManager.AddFile(fileAnswer, "files");


                        int index = topicAnswer - 1;

                        while (index >= topicList.size()) {
                            topicList.add(new ArrayList<Processor>());
                            acList.add(new ArticleComparison(topicList.get(topicList.size() - 1)));
                            System.out.println("Automatically created new topic: " + topicList.size());
                        }

                        String newName = "Article" + (topicList.get(index).size() + 1);
                        topicList.get(index).add(new Processor(newName, fileAnswer));
                        System.out.println("File added to topic " + topicAnswer + ".");
                        break;
                    case 3:
                        topicList.add(new ArrayList<Processor>());
                        System.out.println("Topic " + topicList.size() + " added successfully.");
                        break;
                }
            }
            if (topicChoice != 0) {

                System.out.println("-----------------------------------------------");
                System.out.println("Article Options:");
                for (int i = 0; i < topicList.get(topicChoice - 1).size(); i++) {
                    System.out.println((i + 1) + " - " + topicList.get(topicChoice - 1).get(i).getName());
                }

                System.out.println("-----------------------------------------------");
                System.out.println("What do you want to look at?");
                System.out.print("1. Article Statistics \n2. Word Frequencies \n3. Richest Vocab\n4. Most Repeated\n5. Article Attitudes\n6. Back to File Manager\n7. Exit\n");
                System.out.println("-----------------------------------------------");
                System.out.print("Enter Your choice: ");

                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Which Articles Stats Do You Want: ");
                        num = sc.nextInt();
                        System.out.print("\n\n");
                        int max = topicList.get(topicChoice - 1).size();
                        if (num >= 1 && num <= max) {
                            topicList.get(topicChoice - 1).get(num - 1).statistics(true, false);
                        } else {
                            System.out.println("Please enter a valid article number (1-" + max + ").");
                        }

                        break;
                    case 2:
                        System.out.print("Which Articles Frequencies Do You Want: ");
                        num = sc.nextInt();
                        int max1 = topicList.get(topicChoice - 1).size();
                        if (num >= 1 && num <= max1) {
                            topicList.get(topicChoice - 1).get(num - 1).statistics(false, true);
                        } else {
                            System.out.println("Please enter a valid article number (1-" + max1 + ").");
                        }
                        break;
                    case 3:
                        acList.get(topicChoice - 1).richestVocab();
                        break;
                    case 4:
                        acList.get(topicChoice - 1).repeatedWord();
                        break;
                    case 5:
                        acList.get(topicChoice - 1).articleAttitude();
                        break;
                    case 6:
                        System.out.println("Returning to FileManager");
                        topicChoice = 0;
                        break;
                    case 7:
                        System.out.println("Exiting.");
                        running = false;
                        break;
                    default:
                        System.out.println("Please Enter a Valid Option (1-7).");
                        break;
                }
            }
        }
    }
}